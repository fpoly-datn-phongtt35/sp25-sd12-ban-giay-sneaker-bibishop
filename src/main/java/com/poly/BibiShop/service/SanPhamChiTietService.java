package com.poly.BibiShop.service;


import com.poly.BibiShop.dto.SanPhamChiTietCrud;
import com.poly.BibiShop.dto.SanPhamChiTietDTO;
import com.poly.BibiShop.dto.SanPhamChiTietFiterDTO;
import com.poly.BibiShop.dto.SanPhamCtFiterDTO;
import com.poly.BibiShop.entity.SanPhamChiTietEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SanPhamChiTietService {
    Page<SanPhamChiTietDTO> getAllSanPhamChiTiet(Integer totalPage, Integer totalItem, SanPhamChiTietFiterDTO form);
    Page<SanPhamChiTietDTO> getAllSanPhamChiTietBYidSP(UUID idSP, Integer totalPage, Integer totalItem, SanPhamCtFiterDTO fiterDTO);
    SanPhamChiTietCrud addSanPhamChiTiet(SanPhamChiTietCrud sanPhamChiTietCrud);
    SanPhamChiTietCrud upDateSanPhamChiTiet(SanPhamChiTietCrud sanPhamChiTietCrud);
    SanPhamChiTietDTO findById(UUID id);
    List<SanPhamChiTietDTO> GetForSP(Pageable pageable);
    List<SanPhamChiTietDTO> AllSanPhamChiTietByidSP(UUID idSP);


    Optional<SanPhamChiTietEntity> checkExistingSanPhamCT(
            BigDecimal giaSanPham,
            UUID sanPhamId,
            int gioiTinh,
            String trongLuong,
            UUID danhMucId,
            UUID hinhAnhId,
            UUID kichCoId,
            UUID mauSacId,
            UUID chatLieuId);
}
