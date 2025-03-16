package com.poly.BibiShop.repositoryy.impl.hoadon.Server;

import com.poly.BibiShop.entity.DotGiamGia;
import com.poly.BibiShop.entity.MaGiamGia;
import java.sql.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MaGiamGiaRepository extends JpaRepository<MaGiamGia, Long> {

  @Query("SELECT m FROM MaGiamGia m")
  Page<MaGiamGia> findAllMaGiamGia(Pageable pageable);

  @Query(value = "SELECT * FROM ma_giam_gia WHERE ma = :ma", nativeQuery = true)
  Optional<MaGiamGia> findByMa(@Param("ma") String ma);
}
