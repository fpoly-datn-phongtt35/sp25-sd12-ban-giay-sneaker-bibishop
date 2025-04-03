package com.poly.admin.service;


import com.poly.admin.dto.SanPhamChiTietCrud;
import com.poly.admin.dto.SanPhamChiTietDTO;
import com.poly.admin.dto.SanPhamChiTietFiterDTO;
import com.poly.admin.dto.SanPhamCtFiterDTO;
import com.poly.admin.entity.SanPhamChiTietEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface SanPhamChiTietService {
    Page<SanPhamChiTietDTO> getAllSanPhamChiTiet(Integer totalPage, Integer totalItem, SanPhamChiTietFiterDTO form);
    Page<SanPhamChiTietDTO> getAllSanPhamChiTietBYidSP(Integer idSP, Integer totalPage, Integer totalItem, SanPhamCtFiterDTO fiterDTO);
    SanPhamChiTietCrud addSanPhamChiTiet(SanPhamChiTietCrud sanPhamChiTietCrud);
    SanPhamChiTietCrud upDateSanPhamChiTiet(SanPhamChiTietCrud sanPhamChiTietCrud);
    SanPhamChiTietDTO findById(Integer id);
    List<SanPhamChiTietDTO> GetForSP(Pageable pageable);
    List<SanPhamChiTietDTO> AllSanPhamChiTietByidSP(Integer idSP);


    Optional<SanPhamChiTietEntity> checkExistingSanPhamCT(
            BigDecimal giaSanPham,
            Integer sanPhamId,
            int gioiTinh,
            String trongLuong,
            Integer danhMucId,
            Integer hinhAnhId,
            Integer kichCoId,
            Integer mauSacId,
            Integer chatLieuId);
}
