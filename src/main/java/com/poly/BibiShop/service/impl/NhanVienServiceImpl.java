package com.poly.BibiShop.service.impl;

import com.poly.BibiShop.constant.Constant;
import com.poly.BibiShop.dto.admin.CreateNhanVienRequest;
import com.poly.BibiShop.repository.impl.NhanVienRepository;
import com.poly.BibiShop.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.poly.BibiShop.entity.NhanVien;
import java.util.List;
import java.util.UUID;
//import org.springframework.security.crypto.password.PasswordEncoder;
@Service
@RequiredArgsConstructor
public class NhanVienServiceImpl implements NhanVienService {

    private final NhanVienRepository nhanVienRepository;
//    private final PasswordEncoder passwordEncoder;

    @Override
    public List<NhanVien> getAllEmployees() {
        return nhanVienRepository.findAll();
    }

    @Override
    public NhanVien getEmployeeById(Long id) {
        return nhanVienRepository.findById(id).orElse(null);
    }

    @Override
    public NhanVien saveEmployee(CreateNhanVienRequest request) {
        if (nhanVienRepository.findNhanVienByEmail(request.getEmail()) != null) {
            throw new RuntimeException("Email đã tồn tại");
        }
        if (nhanVienRepository.findNhanVienByTaiKhoan(request.getLoginName()) != null) {
            throw new RuntimeException("Tên đăng nhập đã tồn tại");
        }
        NhanVien nhanVien = new NhanVien();
        nhanVien.setId(request.getId());
        nhanVien.setMaNhanVien(UUID.randomUUID().toString());
        nhanVien.setGioiTinh(request.getGender());
        nhanVien.setEmail(request.getEmail());
        nhanVien.setPasswordRaw(request.getPassword());
//        nhanVien.setMatKhau(passwordEncoder.encode(request.getPassword()));
        nhanVien.setNgaySinh(request.getDob().toInstant());
        nhanVien.setSdt(request.getSdt());
        nhanVien.setTaiKhoan(request.getAccount());
        nhanVien.setTen(request.getName());
        nhanVien.setTenDem(request.getMidName());
        nhanVien.setTrangThai(request.getStatus());
        nhanVien.setVaiTro(request.getRole());
//        nhanVien.set(false);
        nhanVienRepository.save(nhanVien);
        return nhanVien;
    }

    @Override
    public NhanVien updateNhanVien(CreateNhanVienRequest request) {
        if (nhanVienRepository.findNhanVienByIdAndTaiKhoan(request.getId(), request.getEmail()) != null) {
            throw new RuntimeException("Email đã tồn tại");
        }
        if (nhanVienRepository.findNhanVienByIdAndEmail(request.getId(),request.getLoginName()) != null) {
            throw new RuntimeException("Tên đăng nhập đã tồn tại");
        }
        NhanVien nhanVien = new NhanVien();
        nhanVien.setId(request.getId());
        nhanVien.setMaNhanVien(UUID.randomUUID().toString());
        nhanVien.setGioiTinh(request.getGender());
        nhanVien.setEmail(request.getEmail());
        nhanVien.setPasswordRaw(request.getPassword());
//        nhanVien.setMatKhau(passwordEncoder.encode(request.getPassword()));
        nhanVien.setNgaySinh(request.getDob().toInstant());
        nhanVien.setSdt(request.getSdt());
        nhanVien.setTaiKhoan(request.getAccount());
        nhanVien.setTen(request.getName());
        nhanVien.setTenDem(request.getMidName());
        nhanVien.setTrangThai(request.getStatus());
        nhanVien.setVaiTro(request.getRole());
//        nhanVien.set(false);
        nhanVienRepository.save(nhanVien);
        return nhanVien;
    }

    @Override
    public void deleteEmployee(Long id) {
        nhanVienRepository.deleteById(id);
    }
    @Override
    public Page<NhanVien> adminListUserPages(String account, String fullName, String phone, String email, Integer page) {
        page--;
        if (page < 0) {
            page = 0;
        }
        Pageable pageable = PageRequest.of(page, Constant.LIMIT_SIZE, Sort.by("ngay_tao").descending());
        return nhanVienRepository.adminListUserPages(account!=null? account.trim():null , fullName!=null?fullName.trim():null,
                phone!=null?phone.trim():null, email!=null?email.trim():null, pageable);
    }
}