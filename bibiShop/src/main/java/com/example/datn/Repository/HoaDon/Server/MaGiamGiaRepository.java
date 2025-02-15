package com.example.datn.Repository.HoaDon.Server;

import com.example.datn.entity.MaGiamGia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaGiamGiaRepository extends JpaRepository<MaGiamGia, Long> {

  Optional<MaGiamGia> findByMa(String ma);
}