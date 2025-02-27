package com.poly.client.service;

import com.poly.client.dto.admin.CreateKhachHangRequest;
import com.poly.client.entity.KhachHang;
import com.poly.client.entity.NhanVien;
import org.springframework.data.domain.Page;

import java.util.List;

public interface KhachHangService {

    List<KhachHang> getAllCustomers();

    KhachHang getCustomerById(Long id);

    void saveCustomer(CreateKhachHangRequest khachHang);
    void register(CreateKhachHangRequest khachHang);
    void updateProfile(CreateKhachHangRequest khachHang);
    void updateCustomer(CreateKhachHangRequest khachHang);

    void deleteCustomer(Long id);
    Page<KhachHang> adminListUserPages(String account, String fullName, String phone, String email, Integer page);
}