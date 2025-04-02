package com.poly.admin.service;

import com.poly.admin.entity.DotGiamGia;
import com.poly.admin.repository.hoadon.Server.DotGiamGiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DotGiamGiaService {

    @Autowired
    private DotGiamGiaRepository dotGiamGiaRepository;

    public List<DotGiamGia> findAll() {
        return dotGiamGiaRepository.findAll();
    }

}
