package com.example.datn.Repository.HoaDon.Server;

import com.example.datn.entity.GiamGiaSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiamGiaSanPhamRepository extends JpaRepository<GiamGiaSanPham, Long> {}
