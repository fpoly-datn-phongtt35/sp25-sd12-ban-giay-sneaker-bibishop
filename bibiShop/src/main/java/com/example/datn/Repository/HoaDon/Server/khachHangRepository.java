package com.example.datn.Repository.HoaDon.Server;

import com.example.datn.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface khachHangRepository extends JpaRepository<KhachHang,Long> {

}
