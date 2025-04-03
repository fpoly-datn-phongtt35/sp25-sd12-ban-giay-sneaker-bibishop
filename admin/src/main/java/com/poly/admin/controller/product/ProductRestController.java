package com.poly.admin.controller.product;

import com.poly.admin.dto.SanPhamCounterDTO;
import com.poly.admin.dto.SanPhamDTO;
import com.poly.admin.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("/api/products/filter")
    @ResponseBody // Đảm bảo rõ ràng@ResponseBody // Đảm bảo rõ ràng
    public List<SanPhamCounterDTO> filterProducts(@RequestParam("keyword") String keyword) {
        return sanPhamService.searchSanPham(keyword);
    }

}
