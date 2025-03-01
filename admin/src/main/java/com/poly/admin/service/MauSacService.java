package com.poly.admin.service;



import com.poly.admin.dto.MauSacDTO;
import java.util.List;

public interface MauSacService {
    List<MauSacDTO> getAllMauSac();
    MauSacDTO addMauSac(MauSacDTO mauSacDTO);
    MauSacDTO updateMauSac(MauSacDTO mauSacDTO);
}
