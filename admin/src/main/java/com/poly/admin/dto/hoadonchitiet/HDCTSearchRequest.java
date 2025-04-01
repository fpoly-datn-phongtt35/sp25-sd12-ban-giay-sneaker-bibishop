package com.poly.admin.dto.hoadonchitiet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HDCTSearchRequest {
    private String productName;
    private int productId;
    private String productDetailId;
    private String imageId;
    private String sizeId;
    private String colorId;
    private String color;
    private String size;
    private String categoryId;
    public HDCTSearchRequest(String name, String color, String size){
        this.productName = name;
        this.color = color;
        this.size = size;
    }
}
