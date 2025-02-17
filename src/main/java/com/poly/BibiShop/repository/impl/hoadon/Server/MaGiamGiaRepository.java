package com.poly.BibiShop.repository.impl.hoadon.Server;

import com.poly.BibiShop.entity.MaGiamGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MaGiamGiaRepository extends JpaRepository<MaGiamGia, Long> {

  Optional<MaGiamGia> findByMa(String ma);
}