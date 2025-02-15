package com.example.datn.Repository.HoaDon.Client;

import com.example.datn.entity.GioHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, Integer> {}
