package com.poly.BibiShop.service;

import com.poly.BibiShop.dto.DanhMucDTO;
import java.util.List;

public interface DanhMucService {
    List<DanhMucDTO> getAllDanhMuc();
     DanhMucDTO addDanhMuc(DanhMucDTO dto);
     DanhMucDTO upDateDanhMuc(DanhMucDTO dto);
}
