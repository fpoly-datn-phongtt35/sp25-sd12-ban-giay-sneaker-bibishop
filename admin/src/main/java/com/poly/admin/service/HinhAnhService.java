package com.poly.BibiShop.service;
import com.poly.BibiShop.dto.HinhAnhDTO;


import java.util.List;

public interface HinhAnhService {
    List<HinhAnhDTO> getAllHinhAnh();
    HinhAnhDTO addHinhAnh(HinhAnhDTO hinhAnhDTO);
    HinhAnhDTO UpdateHinhAnh(HinhAnhDTO hinhAnhDTO);
}
