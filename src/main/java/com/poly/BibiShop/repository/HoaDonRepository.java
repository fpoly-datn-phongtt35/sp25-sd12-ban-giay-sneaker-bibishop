package com.poly.BibiShop.repository;

import com.poly.BibiShop.entity.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Long> {
  @Query(value = "SELECT * FROM hoa_don", nativeQuery = true)
  Page<HoaDon> findAll(Pageable pageable);
}
