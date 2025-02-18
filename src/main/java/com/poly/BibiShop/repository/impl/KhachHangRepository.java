package com.poly.BibiShop.repository.impl;

import com.poly.BibiShop.entity.KhachHang;
import com.poly.BibiShop.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {
  Page<KhachHang> findAll(Pageable pageable);
  @Query(value = "SELECT * " +
          "FROM khach_hang u WHERE (?1 is null or u.ten LIKE CONCAT('%',?1,'%')) " +
          "AND (?2 is null or  u.sdt LIKE CONCAT('%',?2,'%') )" +
          "AND (?3 is null or u.email LIKE CONCAT('%',?3,'%') ) ",nativeQuery = true)
  Page<KhachHang> adminListUserPages(String fullName, String phone, String email, Pageable pageable);
}
