package com.poly.client.repository;

import com.poly.client.entity.HoaDonChiTiet;
import com.poly.client.repository.custom.HoadonRepoCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, Long>, HoadonRepoCustom {

  @Query("SELECT hdct FROM HoaDonChiTiet hdct where hdct.hoaDon.id =:hoadonId")
  List<HoaDonChiTiet> findByHoaDonId(@Param("hoadonId") Long hoadonId);

}
