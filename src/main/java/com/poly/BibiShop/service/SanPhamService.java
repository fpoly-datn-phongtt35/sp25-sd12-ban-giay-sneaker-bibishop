package com.poly.BibiShop.service;


import com.poly.BibiShop.dto.SanPhamDTO;
import com.poly.BibiShop.dto.SanPhamFiterDTO;
import org.springframework.data.domain.Page;

public interface SanPhamService {
    Page<SanPhamDTO> getAllSanPham(Integer totalPage, Integer totalItem, SanPhamFiterDTO form);
    SanPhamDTO addSanPham(SanPhamDTO sanPhamDTO);
    SanPhamDTO upDateSanPham(SanPhamDTO sanPhamDTO);
    boolean checkProductName(String name);


}
