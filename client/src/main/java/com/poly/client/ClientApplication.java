package com.poly.client;

import com.poly.client.entity.KhachHang;
import com.poly.client.repository.impl.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.Date;

@SpringBootApplication
public class ClientApplication {
    @Autowired
    private KhachHangRepository userRepo;
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }
    @PostConstruct
    public void createUser(){
        String hash = BCrypt.hashpw("123456aA@", BCrypt.gensalt(12));
        KhachHang createUserRequest = new KhachHang();
        createUserRequest.setTen("vinh");
        createUserRequest.setEmail("vinhtq26@gmail.com");
        createUserRequest.setSdt("0866965502");
        createUserRequest.setPassword("123456aA@");
        createUserRequest.setMatKhau(hash);
        userRepo.save(createUserRequest);
        System.out.println(hash);

    }
}
