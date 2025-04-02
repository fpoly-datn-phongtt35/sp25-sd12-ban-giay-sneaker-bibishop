package com.poly.client.service;



import com.poly.client.dto.MauSacDTO;
import com.poly.client.entity.MauSacEntity;
import com.poly.client.repository.MauSacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MauSacService {

    @Autowired
    MauSacRepository mauSacRepository;

    public List<MauSacDTO> getAllMauSac() {
        List<MauSacEntity> mauSacEntities = mauSacRepository.findAll();
        return mauSacEntities.stream().map(x -> {
            MauSacDTO dto = new MauSacDTO();
            dto.setId(x.getId());
            dto.setTen(x.getTen());
            dto.setTrangThai(x.getTrangThai());
            return dto;
        }).toList();
    }

}
