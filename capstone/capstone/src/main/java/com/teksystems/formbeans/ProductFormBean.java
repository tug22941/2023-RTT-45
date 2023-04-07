package com.teksystems.formbeans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductFormBean {

    private Integer id;
    private String name;
    private String description;
    private String imageUrl;
    private Double price;
    private String productType;
}
