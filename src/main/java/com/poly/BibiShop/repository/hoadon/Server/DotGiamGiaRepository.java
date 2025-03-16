package com.poly.BibiShop.repositoryy.impl.hoadon.Server;

import com.poly.BibiShop.entity.DotGiamGia;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DotGiamGiaRepository extends JpaRepository<DotGiamGia, Long> {
  List<DotGiamGia> findByNgayBatDauLessThanEqualAndNgayKetThucGreaterThanEqual(Date todayStart, Date todayEnd);
}