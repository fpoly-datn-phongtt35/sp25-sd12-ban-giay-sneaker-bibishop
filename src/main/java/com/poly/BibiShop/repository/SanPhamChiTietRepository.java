package com.poly.BibiShop.repository;

import com.poly.BibiShop.entity.SanPhamChiTietEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SanPhamChiTietRepository extends JpaRepository<SanPhamChiTietEntity, Long>, JpaSpecificationExecutor<SanPhamChiTietEntity> {

    @Query("SELECT s FROM SanPhamChiTietEntity s WHERE s.sanPham.id = :idSP")
    List<SanPhamChiTietEntity> findByIdSP(@Param("idSP") Long idSP);
    @Query("SELECT spct FROM SanPhamChiTietEntity spct " +
            "WHERE spct.giaSanPham = :giaSanPham " +
            "AND spct.sanPham.id = :sanPhamId " +
            "AND spct.gioiTinh = :gioiTinh " +
            "AND spct.trongLuong = :trongLuong " +
            "AND spct.danhMuc.id = :danhMucId " +
            "AND spct.hinhAnh.id = :hinhAnhId " +
            "AND spct.kichCo.id = :kichCoId " +
            "AND spct.mauSac.id = :mauSacId " +
            "AND spct.chatLieu.id = :chatLieuId")
    Optional<SanPhamChiTietEntity> findExistingProductDetail(
            @Param("giaSanPham") BigDecimal giaSanPham,
            @Param("sanPhamId") Long sanPhamId,
            @Param("gioiTinh") int gioiTinh,
            @Param("trongLuong") String trongLuong,
            @Param("danhMucId") Long danhMucId,
            @Param("hinhAnhId") Long hinhAnhId,
            @Param("kichCoId") Long kichCoId,
            @Param("mauSacId") Long mauSacId,
            @Param("chatLieuId") Long chatLieuId);
}
//    @Query("SELECT spct FROM SanPhamChiTietEntity spct LEFT JOIN spct.sanPham sp WHERE sp.tenSanPham LIKE %:nameProduct% OR :nameProduct IS NULL")
//    Page<SanPhamChiTietEntity> findByProductName(@Param("nameProduct") String nameProduct, Pageable pageable);
//    ;
//    @Query("SELECT s FROM SanPhamChiTietEntity s ORDER BY function('RAND')")
//    List<SanPhamChiTietEntity> findTop4SanPhamChiTiet(Pageable pageable);
//
//List<Object[]> findByTenSanPhamAndNotIdWithSoLuong(@Param("tenSanPham") String tenSanPham, @Param("idSanPham") UUID idSanPham);


//    @Modifying
//    @Transactional
//    @Query("UPDATE SanPhamChiTietEntity sp SET sp.soLuong = sp.soLuong - :soLuong WHERE sp.id = :id")
//    void updateSoLuong(UUID id, int soLuong);
//    @Modifying
//    @Transactional
//    @Query("UPDATE SanPhamChiTietEntity sp SET sp.soLuong = sp.soLuong + :soLuong WHERE sp.id = :id")
//    void updateSoLuongCong(UUID id, int soLuong);
//    @Query("SELECT spct FROM SanPhamChiTietEntity spct LEFT JOIN spct.sanPham sp WHERE sp.id = :idSp AND spct.trangThai = :trangThai")
//    Page<SanPhamChiTietEntity> findAllSpChiTietById(@Param("idSp") UUID idSp, @Param("trangThai") Integer trangThai, Pageable pageable);
//