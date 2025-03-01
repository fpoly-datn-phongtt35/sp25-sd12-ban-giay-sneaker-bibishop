package com.poly.admin.service;
import com.poly.admin.dto.HinhAnhDTO;


import java.util.List;

public interface HinhAnhService {
    List<HinhAnhDTO> getAllHinhAnh();
    HinhAnhDTO addHinhAnh(HinhAnhDTO hinhAnhDTO);
    HinhAnhDTO UpdateHinhAnh(HinhAnhDTO hinhAnhDTO);
}
