package com.poly.admin.repository.hoadon.Client;

import com.poly.admin.entity.GioHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, Integer> {}
