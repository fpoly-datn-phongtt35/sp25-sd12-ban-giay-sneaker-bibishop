package com.poly.admin;

import com.poly.admin.entity.NhanVien;
import com.poly.admin.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class AdminApplication {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private NhanVienRepository userRepo;

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
    @PostConstruct
    public void inti(){
        String password = "2342342";
        String decrypt = passwordEncoder.encode(password);
        System.out.println(decrypt);
    }

        @PostConstruct
    public void createUser(){
        if(userRepo.existsByEmail("vinhtq26@gmail.com")) return;
        String hash = passwordEncoder.encode("123123");
        NhanVien createUserRequest = new NhanVien();
        createUserRequest.setTen("vinh");
        createUserRequest.setEmail("vinhtq26@gmail.com");
        createUserRequest.setSdt("0866965002");
        createUserRequest.setMatKhau(hash);
        userRepo.save(createUserRequest);
        System.out.println(hash);

    }
}
