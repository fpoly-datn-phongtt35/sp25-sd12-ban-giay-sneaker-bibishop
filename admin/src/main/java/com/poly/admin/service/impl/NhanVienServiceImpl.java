package com.poly.admin.service.impl;

import com.poly.admin.constant.Constant;
import com.poly.admin.dto.admin.CreateKhachHangRequest;
import com.poly.admin.dto.admin.CreateNhanVienRequest;
import com.poly.admin.repository.impl.NhanVienRepository;
import com.poly.admin.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.poly.admin.entity.NhanVien;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
//import org.springframework.security.crypto.password.PasswordEncoder;
@Service
@RequiredArgsConstructor
public class NhanVienServiceImpl implements NhanVienService {

    private final NhanVienRepository nhanVienRepository;
    private final PasswordEncoder passwordEncoder;

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
        nhanVien.setNgaySua(LocalDateTime.now());
        nhanVien.setNgayTao(LocalDateTime.now());
        nhanVien.setMatKhau(passwordEncoder.encode(request.getPassword()));
        return getNhanVien(request, nhanVien);
    }

    private NhanVien getNhanVien(CreateNhanVienRequest request, NhanVien nhanVien) {
        nhanVien.setNgaySinh(request.getDob().toInstant());
        nhanVien.setSdt(request.getSdt());
        nhanVien.setTaiKhoan(request.getAccount());
        nhanVien.setTen(request.getName());
        nhanVien.setHo(request.getFirstName());
        nhanVien.setTenDem(request.getMidName());
        nhanVien.setTrangThai(request.getStatus());
        nhanVien.setVaiTro(request.getRole());
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
        NhanVien nhanVien = nhanVienRepository.findById(request.getId()).orElseThrow();
        nhanVien.setMaNhanVien(UUID.randomUUID().toString());
        nhanVien.setGioiTinh(request.getGender());
        nhanVien.setEmail(request.getEmail());
        nhanVien.setNgaySua(LocalDateTime.now());
        return getNhanVien(request, nhanVien);
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
    private void validateCustomer(CreateNhanVienRequest request) {
        if (request.getId() != null) {
            // validate update
            if (nhanVienRepository.existsByTaiKhoanAndIdIsNot(request.getAccount(), request.getId())) {
                throw new RuntimeException("Tài khoản đã tồn tại!");
            }
            if (nhanVienRepository.existsByEmailAndIdNot(request.getEmail(), request.getId())) {
                throw new RuntimeException("Email đã tồn tại!");
            }
            if (nhanVienRepository.existsBySdtAndIdNot(request.getSdt(), request.getId()))
                throw new RuntimeException("Số điện thoại đã tồn tại!");
        }else{
            // validate create
            if(nhanVienRepository.existsByTaiKhoan(request.getAccount())){
                throw new RuntimeException("Tài khoản đã tồn tại!");
            }
            if(nhanVienRepository.existsByEmail(request.getEmail())){
                throw new RuntimeException("Email đã tồn tại!");
            }
            if(nhanVienRepository.existsBySdt(request.getSdt())){
                throw new RuntimeException("Số điện thoại đã tồn tại!");
            }
        }
    }

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        NhanVien user = nhanVienRepository.findNhanVienByEmail(email);
//
//        return new org.springframework.security.core.userdetails.User(
//                user.getEmail(),
//                user.getPassword(),
//                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
//        );
//    }
}