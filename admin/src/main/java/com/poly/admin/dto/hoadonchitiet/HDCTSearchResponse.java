package com.poly.admin.dto.hoadonchitiet;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

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
