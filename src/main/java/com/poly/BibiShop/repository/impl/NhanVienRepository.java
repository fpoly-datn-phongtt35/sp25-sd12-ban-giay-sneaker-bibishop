package com.poly.BibiShop.repository.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.poly.BibiShop.entity.NhanVien;
import org.springframework.data.jpa.repository.Query;

public interface NhanVienRepository extends JpaRepository<NhanVien, Long> {
    NhanVien findNhanVienByEmail(String email);
    NhanVien findNhanVienByTaiKhoan(String taiKhoan);
    @Query(value = "SELECT nv from NhanVien nv where nv.id !=:id and nv.taiKhoan LIKE CONCAT('%',:taiKhoan,'%') ")
    NhanVien findNhanVienByIdAndTaiKhoan(Integer id, String taiKhoan);
    @Query(value = "SELECT nv from NhanVien nv where nv.id !=:id and nv.email LIKE CONCAT('%',:email,'%') ")
    NhanVien findNhanVienByIdAndEmail(Integer id, String email);
    @Query(value = "SELECT * " +
            "FROM nhan_vien u WHERE u.ten LIKE CONCAT('%',?1,'%') " +
            "AND u.sdt LIKE CONCAT('%',?2,'%') " +
            "AND u.email LIKE CONCAT('%',?3,'%') ",nativeQuery = true)
    Page<NhanVien> adminListUserPages(String fullName, String phone, String email, Pageable pageable);
}