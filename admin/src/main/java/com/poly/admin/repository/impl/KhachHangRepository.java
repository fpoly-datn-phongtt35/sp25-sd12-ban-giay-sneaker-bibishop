package com.poly.admin.repository.impl;

import com.poly.admin.entity.KhachHang;
import com.poly.admin.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {
    Page<KhachHang> findAll(Pageable pageable);
    @Query(value = "SELECT * " +
            "FROM khach_hang as k WHERE ((?1 is null or  k.ten LIKE CONCAT('%',?1,'%') or k.ho LIKE CONCAT('%',?1,'%') or  k.ten_dem LIKE CONCAT('%',?1,'%') ))" +
            "AND (?2 is null or  k.sdt LIKE CONCAT('%',?2,'%') )" +
            "AND (?3 is null or k.email LIKE CONCAT('%',?3,'%') ) ",nativeQuery = true)
    Page<KhachHang> adminListUserPages(String fullName, String phone, String email, Pageable pageable);
    boolean existsByEmailAndIdNot(String email, Long id);
    boolean existsBySdtAndIdNot(String sdt, Long id);
    boolean existsByEmail(String email);
    boolean existsBySdt(String email);


}