package com.poly.client.service;

import com.poly.client.dto.ChangePasswordRequest;
import com.poly.client.dto.admin.CreateKhachHangRequest;
import com.poly.client.entity.KhachHang;
import com.poly.client.entity.NhanVien;
import org.springframework.data.domain.Page;

import java.util.List;

public interface KhachHangService {

    List<KhachHang> getAllCustomers();

    KhachHang getCustomerById(Long id);

    void saveCustomer(CreateKhachHangRequest khachHang);
    KhachHang register(CreateKhachHangRequest khachHang);
    void updateProfile(CreateKhachHangRequest khachHang);
    void updateCustomer(CreateKhachHangRequest khachHang);
    void changePassword(KhachHang user, ChangePasswordRequest changePasswordRequest);
    void deleteCustomer(Long id);
    Page<KhachHang> adminListUserPages(String account, String fullName, String phone, String email, Integer page);
}