package com.example.datn.Repository.HoaDon.Server;

import com.example.datn.entity.SanPham;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Long> {

}