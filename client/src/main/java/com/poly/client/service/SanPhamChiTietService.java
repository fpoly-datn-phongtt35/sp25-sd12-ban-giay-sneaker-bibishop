package com.poly.client.service;

import com.poly.client.entity.SanPhamChiTietEntity;
import com.poly.client.repository.SanPhamChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SanPhamChiTietService {

    @Autowired
    SanPhamChiTietRepository sanPhamChiTietRepository;

    public Optional<SanPhamChiTietEntity> findById(Integer id) {
        return sanPhamChiTietRepository.findById(id);
    }

}
