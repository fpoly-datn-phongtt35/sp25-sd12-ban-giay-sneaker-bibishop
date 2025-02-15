package com.example.datn.Repository.HoaDon.Client;

import com.example.datn.entity.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GioHangRepository extends JpaRepository<GioHang, Integer> {}