package com.poly.BibiShop.service;
import com.poly.BibiShop.dto.admin.CreateNhanVienRequest;
import com.poly.BibiShop.entity.NhanVien;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NhanVienService {

    List<NhanVien> getAllEmployees();
    Page<NhanVien> adminListUserPages(String account, String fullName, String phone, String email, Integer page);
    NhanVien getEmployeeById(Long id);

    NhanVien saveEmployee(CreateNhanVienRequest nhanVien);
    NhanVien updateNhanVien(CreateNhanVienRequest nhanVien);

    void deleteEmployee(Long id);
}
