package com.poly.BibiShop.service;



import com.poly.BibiShop.dto.MauSacDTO;
import java.util.List;

public interface MauSacService {
    List<MauSacDTO> getAllMauSac();
    MauSacDTO addMauSac(MauSacDTO mauSacDTO);
    MauSacDTO updateMauSac(MauSacDTO mauSacDTO);
}
