package com.poly.BibiShop.service;



import com.poly.BibiShop.dto.KichCoDTO;
import java.util.List;

public interface KichCoService {
    List<KichCoDTO> getAllKichCo();
    KichCoDTO addKichCo(KichCoDTO kichCoDTO);
    KichCoDTO updateKichCo(KichCoDTO kichCoDTO);
}
