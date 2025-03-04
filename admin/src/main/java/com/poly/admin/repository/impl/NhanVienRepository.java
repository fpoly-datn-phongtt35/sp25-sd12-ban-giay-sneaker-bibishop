package com.poly.admin.repository.impl;

import com.poly.admin.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface NhanVienRepository extends JpaRepository<NhanVien, Long> {
    NhanVien findNhanVienByEmail(String email);
//    Optional<NhanVien> findNhanVienByEmailOrTaiKhoan(String email, String taiKhoan);
//    NhanVien findNhanVienByTaiKhoan(String taiKhoan);
    @Query(value = "SELECT nv from NhanVien nv where nv.id !=:id and nv.email LIKE CONCAT('%',:email,'%') ")
    NhanVien findNhanVienByIdAndEmail(Long id, String email);
    @Query(value = "SELECT * " +
            "FROM nhan_vien u WHERE ((?1 is null or  u.ten LIKE CONCAT('%',?1,'%') or u.ho LIKE CONCAT('%',?1,'%') or  u.ten_dem LIKE CONCAT('%',?1,'%') ))" +
            "AND (?2 is null or  u.sdt LIKE CONCAT('%',?2,'%') )" +
            "AND (?3 is null or u.email LIKE CONCAT('%',?3,'%') ) ",nativeQuery = true)
    Page<NhanVien> adminListUserPages(String fullName, String phone, String email, Pageable pageable);

//    boolean existsByTaiKhoanAndIdIsNot(String taiKhoan, long id);
    boolean existsByEmailAndIdNot(String email, long id);
    boolean existsBySdtAndIdNot(String sdt, long id);
//    boolean existsByTaiKhoan(String taiKhoan);
    boolean existsByEmail(String email);
    boolean existsBySdt(String email);
}