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

    KhachHang register(CreateKhachHangRequest khachHang);
    void updateProfile(CreateKhachHangRequest khachHang);
    void changePassword(KhachHang user, ChangePasswordRequest changePasswordRequest);
}