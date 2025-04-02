package com.poly.client.service;


import com.poly.client.dto.KichCoDTO;

import java.util.List;

public interface KichCoService {
    List<KichCoDTO> getAllKichCo();
    KichCoDTO addKichCo(KichCoDTO kichCoDTO);
    KichCoDTO updateKichCo(KichCoDTO kichCoDTO);
}
