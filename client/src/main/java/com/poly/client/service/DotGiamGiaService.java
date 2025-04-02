package com.poly.client.service;

import com.poly.client.entity.DotGiamGia;
import com.poly.client.repository.DotGiamGiaRepository;
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
