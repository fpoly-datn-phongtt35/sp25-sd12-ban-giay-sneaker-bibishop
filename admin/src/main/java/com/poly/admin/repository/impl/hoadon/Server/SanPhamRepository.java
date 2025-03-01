package com.poly.BibiShop.repository.impl.hoadon.Server;

import com.poly.BibiShop.entity.SanPhamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SanPhamRepository extends JpaRepository<SanPhamEntity, Long> {

}