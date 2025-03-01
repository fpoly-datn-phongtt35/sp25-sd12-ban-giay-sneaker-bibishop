package com.poly.BibiShop.repository.impl;


import com.poly.BibiShop.entity.MaGiamGia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface MaGiamGiaRepository extends CrudRepository<MaGiamGia,Integer> {
  @Query("SELECT m FROM MaGiamGia m")
  Page<MaGiamGia> findAllMaGiamGia(Pageable pageable);
}
