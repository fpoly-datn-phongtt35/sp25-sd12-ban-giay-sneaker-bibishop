package com.poly.BibiShop.repository.impl.hoadon.Server;

import com.poly.BibiShop.entity.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, Long> {

  @Query("SELECT hdct FROM HoaDonChiTiet hdct where hdct.hoaDon.id =:hoadonId")
  List<HoaDonChiTiet> findByHoaDonId(@Param("hoadonId") Long hoadonId);

}
