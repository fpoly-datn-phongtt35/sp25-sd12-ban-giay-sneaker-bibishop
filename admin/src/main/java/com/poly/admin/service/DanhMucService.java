package com.poly.admin.service;

import com.poly.admin.dto.DanhMucDTO;
import java.util.List;

public interface DanhMucService {
    List<DanhMucDTO> getAllDanhMuc();
     DanhMucDTO addDanhMuc(DanhMucDTO dto);
     DanhMucDTO upDateDanhMuc(DanhMucDTO dto);
}
