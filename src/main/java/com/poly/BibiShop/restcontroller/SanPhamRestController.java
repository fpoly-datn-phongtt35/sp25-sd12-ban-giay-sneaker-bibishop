package com.poly.BibiShop.restcontroller;


import com.poly.BibiShop.common.Appcontants;
import com.poly.BibiShop.dto.SanPhamDTO;
import com.poly.BibiShop.dto.SanPhamFiterDTO;
import com.poly.BibiShop.service.SanPhamService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sp")
public class SanPhamRestController {
    private final SanPhamService service;
    @GetMapping("/check-name")
    public ResponseEntity<?> checkName(@RequestParam String name) {
        // Thực hiện kiểm tra tên sản phẩm trong database
        boolean exists = service.checkProductName(name);
        return ResponseEntity.ok(Collections.singletonMap("exists", exists));
    }
    @GetMapping()
    public Page<SanPhamDTO> getAllProducts(
            @RequestParam(value = "pageNo", defaultValue = Appcontants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = Appcontants.DEFAULT_TOTAL_NUMBER, required = false) int pageSize,
            @Valid SanPhamFiterDTO filterForm
    ) {

        return service.getAllSanPham(pageNo, pageSize,filterForm);
    }
    @PostMapping()
    public SanPhamDTO addSanPham(@RequestBody SanPhamDTO sanPhamDTO){
    return service.addSanPham(sanPhamDTO);

    }




    @PutMapping()
    public SanPhamDTO upDateSanPham(@RequestBody SanPhamDTO sanPhamDTO){
        return service.upDateSanPham(sanPhamDTO);

    }
}
