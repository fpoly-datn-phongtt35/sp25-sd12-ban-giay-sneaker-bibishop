package com.poly.BibiShop.service.impl;

import com.poly.BibiShop.constant.Constant;
import com.poly.BibiShop.dto.admin.CreateKhachHangRequest;
import com.poly.BibiShop.entity.KhachHang;
import com.poly.BibiShop.entity.NhanVien;
import com.poly.BibiShop.repository.impl.KhachHangRepository;
import com.poly.BibiShop.service.KhachHangService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Service;
import com.poly.BibiShop.entity.KhachHang;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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
    public void register(CreateKhachHangRequest request) {
        KhachHang khachHang = new KhachHang();
        khachHang.setEmail(request.getEmail());
        khachHang.setTen(request.getFullName());
        khachHang.setSdt(request.getPhone());
        khachHang.setPassword(request.getPassword());
        khachHang.setTrangThai(1);
        khachHangRepository.save(khachHang);
    }
    @Override
    public void updateProfile(CreateKhachHangRequest request) {
        KhachHang khachHang = new KhachHang();
        khachHang.setId(request.getId());
        khachHang.setTen(request.getFullName());
        khachHang.setSdt(request.getPhone());
        khachHang.setAddress(request.getAddress());
        khachHangRepository.save(khachHang);
    }
    @Override
    public void deleteCustomer(Long id) {
        khachHangRepository.deleteById(id);
    }
    @Override
    public Page<KhachHang> adminListUserPages(String account, String fullName, String phone, String email, Integer page) {
        page--;
        if (page < 0) {
            page = 0;
        }
        Pageable pageable = PageRequest.of(page, Constant.LIMIT_SIZE, Sort.by("ngay_tao").descending());
        return khachHangRepository.adminListUserPages(account!=null? account.trim() : null, fullName!=null? fullName.trim():null, phone!=null ? phone.trim():null, email!=null?email.trim():null, pageable);
    }
    @Override
    public void saveCustomer(CreateKhachHangRequest request) {
        KhachHang khachHang = new KhachHang();
        khachHang.setEmail(request.getEmail());
        khachHang.setTen(request.getFullName());
        khachHang.setTenDem(request.getMidName());
        khachHang.setSdt(request.getPhone());
        khachHang.setPassword(request.getPassword());
        khachHang.setTrangThai(1);
        khachHang.setGioiTinh(request.getGender());
        khachHang.setNgayTao(LocalDateTime.now());
        khachHang.setNgayTao(LocalDateTime.now());
        khachHang.setTaiKhoan(request.getAccount());
        khachHang.setVaiTro(3);
        khachHangRepository.save(khachHang);
    }

    @Override
    public void updateCustomer(CreateKhachHangRequest request) {
        KhachHang khachHang = new KhachHang();
        khachHang.setId(request.getId());
        khachHang.setEmail(request.getEmail());
        khachHang.setTaiKhoan(request.getLoginName());
        khachHang.setNgaySinh(request.getDob().toInstant());
        khachHang.setSdt(request.getPhone());
        khachHang.setTen(request.getFullName());
        khachHang.setTenDem(request.getMidName());
        khachHang.setTrangThai(request.getStatus());
        // 3: KHACH HANG
        khachHang.setVaiTro(3);
        khachHang.setGioiTinh(request.getGender());
        khachHang.setNgayTao(LocalDateTime.now());
        khachHangRepository.save(khachHang);
    }
}

