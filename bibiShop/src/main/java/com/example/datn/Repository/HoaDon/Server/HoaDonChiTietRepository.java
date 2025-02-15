package com.example.datn.Repository.HoaDon.Server;

import com.example.datn.entity.HoaDonChiTiet;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, Long> {

  @Query("SELECT hdct FROM HoaDonChiTiet hdct where hdct.hoaDon.id =:hoadonId")
  List<HoaDonChiTiet> findByHoaDonId(@Param("hoadonId") Long hoadonId);

}
