package com.poly.admin.repository.impl.hoadon.Server;

import com.poly.admin.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Long> {
    @Query(value ="SELECT MONTH(o.ngay_tao) as month, YEAR(o.ngay_tao) as year, " +
            "SUM(o.tong_tien) as totalRevenue FROM hoa_don o GROUP BY MONTH(o.ngay_tao), YEAR(o.ngay_tao) ORDER BY MONTH(o.ngay_tao)", nativeQuery = true)
    List<Object[]> calculateMonthlyRevenue();

}
