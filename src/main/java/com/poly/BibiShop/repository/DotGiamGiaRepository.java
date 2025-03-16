package com.poly.BibiShop.repository;

import com.poly.BibiShop.entity.DotGiamGia;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DotGiamGiaRepository extends JpaRepository<DotGiamGia, Long> {
  List<DotGiamGia> findByNgayBatDauLessThanEqualAndNgayKetThucGreaterThanEqual(Date todayStart, Date todayEnd);
}