package com.poly.client.repository;

import com.poly.client.entity.DotGiamGia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface DotGiamGiaRepository extends JpaRepository<DotGiamGia, Long> {
  List<DotGiamGia> findByNgayBatDauLessThanEqualAndNgayKetThucGreaterThanEqual(Date todayStart, Date todayEnd);
}