package com.poly.client.repository;

import com.poly.client.entity.GioHang;
import com.poly.client.entity.TrangThaiGioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GioHangRepository extends JpaRepository<GioHang, Long> {
  @Query("SELECT g FROM GioHang g WHERE g.idKhachHang = :idKhachHang AND g.trangThai = :trangThai")
  Optional<GioHang> findByIdKhachHangAndTrangThai(@Param("idKhachHang") Integer idKhachHang, @Param("trangThai") TrangThaiGioHang trangThai);
}