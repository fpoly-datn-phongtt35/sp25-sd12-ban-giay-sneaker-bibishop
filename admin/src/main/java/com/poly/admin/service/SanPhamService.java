package com.poly.admin.service;


import com.poly.admin.dto.SanPhamDTO;
import com.poly.admin.dto.SanPhamFiterDTO;
import org.springframework.data.domain.Page;

public interface SanPhamService {
    Page<SanPhamDTO> getAllSanPham(Integer totalPage, Integer totalItem, SanPhamFiterDTO form);
    SanPhamDTO addSanPham(SanPhamDTO sanPhamDTO);
    SanPhamDTO upDateSanPham(SanPhamDTO sanPhamDTO);
    boolean checkProductName(String name);


}
