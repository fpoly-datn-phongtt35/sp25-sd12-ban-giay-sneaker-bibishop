package com.poly.admin.repository.hoadon.Server;

import com.poly.admin.entity.MaGiamGia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MaGiamGiaRepository extends JpaRepository<MaGiamGia, Long> {
  @Query("SELECT m FROM MaGiamGia m")
  Page<MaGiamGia> findAllMaGiamGia(Pageable pageable);
  Optional<MaGiamGia> findByMa(String ma);
}