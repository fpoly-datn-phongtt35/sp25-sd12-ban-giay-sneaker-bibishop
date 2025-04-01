package com.poly.client.service.impl;

import com.poly.client.dto.ChangePasswordRequest;
import com.poly.client.dto.admin.CreateKhachHangRequest;
import com.poly.client.entity.KhachHang;
import com.poly.client.exception.BadRequestException;
import com.poly.client.repository.KhachHangRepository;
import com.poly.client.service.KhachHangService;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    private final KhachHangRepository khachHangRepository;

    public KhachHangServiceImpl(KhachHangRepository khachHangRepository) {
        this.khachHangRepository = khachHangRepository;
    }

    @Override
    public List<KhachHang> getAllCustomers() {
        return khachHangRepository.findAll();
    }

    @Override
    public KhachHang getCustomerById(Long id) {
        return khachHangRepository.findById(id).orElse(null);
    }

    @Override
    public KhachHang register(CreateKhachHangRequest request) {
        validateCustomer(request);
        KhachHang khachHang = new KhachHang();
        khachHang.setEmail(request.getEmail());
        khachHang.setSdt(request.getPhone());
        khachHang.setMatKhau(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt(12)));
        khachHang.setTrangThai(1);
        khachHang.setVaiTro(3);
        khachHang.setNgaySua(LocalDateTime.now());
        khachHang.setNgayTao(LocalDateTime.now());
        return khachHangRepository.save(khachHang);
    }
    @Override
    public void updateProfile(CreateKhachHangRequest request) {
        validateCustomer(request);
        KhachHang khachHang = khachHangRepository.findById(request.getId()).orElse(new KhachHang());
        khachHang.setTen(request.getFullName());
        khachHang.setHo(request.getFirstName());
        khachHang.setTenDem(request.getMidName());
        khachHang.setSdt(request.getPhone());
        khachHang.setAddress(request.getAddress());
        khachHang.setVaiTro(3);
        khachHang.setNgaySua(LocalDateTime.now());
        khachHangRepository.save(khachHang);
    }
    private void validateCustomer(CreateKhachHangRequest request) {
        if (request.getId() != null) {
            if (khachHangRepository.existsBySdtAndIdNot(request.getPhone(), request.getId()))
                throw new RuntimeException("Số điện thoại đã tồn tại!");
        }else{
            // validate create
            if(khachHangRepository.existsByEmail(request.getEmail())){
                throw new RuntimeException("Email đã tồn tại!");
            }
            if(khachHangRepository.existsBySdt(request.getPhone())){
                throw new RuntimeException("Số điện thoại đã tồn tại!");
            }
        }
    }

    @Override
    public void changePassword(KhachHang user, ChangePasswordRequest changePasswordRequest) {
        if (!BCrypt.checkpw(changePasswordRequest.getOldPassword(), user.getMatKhau())) {
            throw new BadRequestException("Mật khẩu cũ không chính xác");
        }

        String hash = BCrypt.hashpw(changePasswordRequest.getNewPassword(), BCrypt.gensalt(12));
        user.setMatKhau(hash);
        khachHangRepository.save(user);
    }
}

