package com.teksystems.formbeans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class ProductFormBean {

    private Integer id;
    private String name;
    private String description;
    private Double price;
    private String productType;

    private MultipartFile picture;
    private String imageUrl;
}
