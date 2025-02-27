package com.hduong25.shopapp.dtos.user;

import com.hduong25.shopapp.utils.query.Searchable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: hduong25
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchUserDTO extends Searchable {
    private String name;
}
