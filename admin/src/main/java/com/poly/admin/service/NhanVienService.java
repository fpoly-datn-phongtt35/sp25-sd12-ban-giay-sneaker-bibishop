package com.poly.admin.service;
import com.poly.admin.dto.admin.CreateNhanVienRequest;
import com.poly.admin.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface NhanVienService{

    List<NhanVien> getAllEmployees();
    Page<NhanVien> adminListUserPages(String fullName, String phone, String email, Integer page);
    NhanVien getEmployeeById(Long id);

    NhanVien saveEmployee(CreateNhanVienRequest nhanVien);
    NhanVien updateNhanVien(CreateNhanVienRequest nhanVien);

    void deleteEmployee(Long id);
}
