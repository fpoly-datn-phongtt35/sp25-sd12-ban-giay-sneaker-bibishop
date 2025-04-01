package com.poly.client.dto.hoadonchitiet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HDCTSearchResponse {
    private String productName;
    private String link;
    private String nameSize;
    private String color;
    private String categoryName;
    private Long numOfSale;
    private Double revenue;
}
