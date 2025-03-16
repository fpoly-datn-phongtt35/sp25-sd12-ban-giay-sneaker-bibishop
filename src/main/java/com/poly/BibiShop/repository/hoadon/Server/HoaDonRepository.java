package com.poly.BibiShop.repositoryy.impl.hoadon.Server;

import com.poly.BibiShop.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Long> {

}
