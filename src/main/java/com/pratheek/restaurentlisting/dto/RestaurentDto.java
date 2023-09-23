package com.pratheek.restaurentlisting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RestaurentDto {

    private int id;
    private String name;
    private String address;
    private String city;
    private String restaurentDescription;
}
