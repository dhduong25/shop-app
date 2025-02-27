package com.hduong25.shopapp.utils;

import lombok.Getter;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.*;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hduong25
 */

@Slf4j
@UtilityClass
public class ModelMapperUtils {

    /**
     * GETTER
     * Trả về instance của ModelMapper để sử dụng trong trường hợp cần cấu hình đặc biệt.
     */
    @Getter
    private static final ModelMapper modelMapper = new ModelMapper();

    // Chi tiết cấu hình
    static {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT) // Cấu hình map dữ liệu chuẩn, chặt chẽ
                .setSkipNullEnabled(true) // Bỏ qua trường null
                .setSourceNameTokenizer(NameTokenizers.UNDERSCORE) // Quy ước đặt tên cho thuộc tính ở source (Object dùng để map)
                .setDestinationNameTokenizer(NameTokenizers.UNDERSCORE); // Quy ước đặt tên cho thuộc tính ở đích (Object map ra)
        // -> Việc đặt NameTokenizers.UNDERSCORE nhằm mục đích để ModelMapper tự nhận biết quy ước đặt tên
        // -> Model mapper sẽ phân tích chuỗi dựa trên dấu gạch dưới và tự chuyển đổi sang format phù hợp
    }

    /**
     * Ánh xạ một đối tượng sang một lớp đích.
     *
     * @param source đối tượng nguồn cần ánh xạ.
     * @param target lớp đích cần ánh xạ tới.
     * @param <T>    kiểu dữ liệu của lớp đích.
     * @return một instance mới của lớp đích với dữ liệu đã ánh xạ, hoặc null nếu source là null.
     *
     * <p>Ví dụ:</p>
     * <pre>{@code
     * UserEntity userEntity = new UserEntity(1, "Đỗ", "Hồng Dương");
     * UserDTO userDTO = ModelMapperUtils.map(userEntity, UserDTO.class);
     * }</pre>
     */
    public static <T> T map(Object source, Class<T> target) {
        return source == null ? null : modelMapper.map(source, target);
    }

    /**
     * Ánh xạ dữ liệu từ đối tượng nguồn vào một instance đích đã tồn tại.
     *
     * @param source đối tượng nguồn cần ánh xạ.
     * @param target instance đích đã tồn tại để cập nhật dữ liệu.
     * @param <T>    kiểu dữ liệu của instance đích.
     * @return instance đích với dữ liệu được ánh xạ, hoặc null nếu source là null.
     *
     * <p>Ví dụ:</p>
     * <pre>{@code
     * UserEntity userEntity = new UserEntity(1, "Đỗ", "Hồng Dương");
     * UserDTO userDTO = new UserDTO();
     * ModelMapperUtils.map(userEntity, userDTO);
     * }</pre>
     */
    public static <T> T map(Object source, T target) {
        if (source == null) return null;

        modelMapper.map(source, target);
        return target;
    }

    /**
     * Ánh xạ một danh sách (List) các đối tượng sang danh sách các đối tượng của một lớp đích.
     *
     * @param source danh sách nguồn cần ánh xạ.
     * @param target lớp đích cần ánh xạ tới.
     * @param <T>    kiểu dữ liệu của lớp đích.
     * @return danh sách các đối tượng đã ánh xạ, hoặc null nếu danh sách nguồn rỗng hoặc null.
     *
     * <p>Ví dụ:</p>
     * <pre>{@code
     * List<UserEntity> userEntities = List.of(
     *     new UserEntity(1, "Đỗ", "Hồng Dương"),
     *     new UserEntity(2, "Hồng", "Dương")
     * );
     * List<UserDTO> userDTOs = ModelMapperUtils.map(userEntities, UserDTO.class);
     * }</pre>
     */
    public static <T> List<T> map(List<?> source, Class<T> target) {
        return source != null && !source.isEmpty()
                ? source.stream().map(s -> modelMapper.map(s, target)).toList()
                : null;
    }

    /**
     * Ánh xạ một tập hợp (Iterable) các đối tượng sang danh sách (List) các đối tượng của một lớp đích.
     *
     * <p>`Iterable` là một interface trong Java đại diện cho các tập hợp có thể duyệt qua
     * (ví dụ: `List`, `Set`, hoặc bất kỳ cấu trúc dữ liệu nào hỗ trợ vòng lặp `for-each`).
     * Điều này giúp phương thức hoạt động linh hoạt với nhiều kiểu dữ liệu khác nhau, không chỉ giới hạn trong `List`.</p>
     *
     * @param source tập hợp nguồn cần ánh xạ. Có thể là bất kỳ kiểu nào triển khai interface `Iterable`.
     * @param target lớp đích cần ánh xạ tới.
     * @param <T>    kiểu dữ liệu của lớp đích.
     * @return danh sách các đối tượng đã ánh xạ, hoặc danh sách rỗng nếu tập hợp nguồn là null.
     *
     * <p>Ví dụ:</p>
     * <pre>{@code
     * // Lấy tất cả user từ cơ sở dữ liệu dưới dạng Iterable
     * Iterable<UserEntity> userEntities = userRepository.findAll();
     *
     * // Ánh xạ sang danh sách các UserDTO
     * List<UserDTO> userDTOs = ModelMapperUtils.map(userEntities, UserDTO.class);
     * }</pre>
     */
    public static <T> List<T> map(Iterable<?> source, Class<T> target) {
        if (source == null) return new ArrayList<>();

        List<T> resultList = new ArrayList<>();
        source.forEach(s ->
                resultList.add(modelMapper.map(s, target))
        );

        return resultList;
    }

    /**
     * Ánh xạ một trang (Page) các đối tượng sang một trang các đối tượng của một lớp đích.
     *
     * @param source trang nguồn cần ánh xạ.
     * @param target lớp đích cần ánh xạ tới.
     * @param <T>    kiểu dữ liệu của lớp đích.
     * @return trang các đối tượng đã ánh xạ, hoặc null nếu trang nguồn rỗng hoặc null.
     *
     * <p>Ví dụ:</p>
     * <pre>{@code
     * Page<UserEntity> userEntityPage = userRepository.findAll(PageRequest.of(0, 10));
     * Page<UserDTO> userDTOPage = ModelMapperUtils.map(userEntityPage, UserDTO.class);
     * }</pre>
     */
    public static <T> Page<T> map(Page<?> source, Class<T> target) {
        return source != null && !source.isEmpty()
                ? source.map(s -> modelMapper.map(s, target))
                : null;
    }
}
