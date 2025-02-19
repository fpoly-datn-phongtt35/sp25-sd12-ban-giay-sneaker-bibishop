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
            "FROM nhan_vien u WHERE (?1 is null or u.tai_khoan LIKE CONCAT('%',?1,'%')) " +
            "AND (?2 is null or  u.ten LIKE CONCAT('%',?2,'%') )" +
            "AND (?3 is null or  u.sdt LIKE CONCAT('%',?3,'%') )" +
            "AND (?4 is null or u.email LIKE CONCAT('%',?4,'%') ) ",nativeQuery = true)
    Page<NhanVien> adminListUserPages(String account, String fullName, String phone, String email, Pageable pageable);
}