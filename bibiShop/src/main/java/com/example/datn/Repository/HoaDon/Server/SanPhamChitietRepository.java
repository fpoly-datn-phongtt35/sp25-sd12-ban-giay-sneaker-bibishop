package com.example.datn.Repository.HoaDon.Server;

import com.example.datn.entity.SanPhamChiTiet;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SanPhamChitietRepository  extends JpaRepository<SanPhamChiTiet, Long> {

}
