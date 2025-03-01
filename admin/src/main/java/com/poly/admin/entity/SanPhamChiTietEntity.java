    package com.poly.BibiShop.entity;

    import com.fasterxml.jackson.annotation.JsonIgnore;
    import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.math.BigDecimal;
    import java.util.ArrayList;
    import java.util.List;

    @Data
    @Entity
    @Table(name = "SanPhamChiTiet")
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class SanPhamChiTietEntity extends SuperEntity {

        @Column(name = "giaSanPham", length = 150, nullable = false)
        private BigDecimal giaSanPham;
        @Column(name = "soLuong", length = 50, nullable = false)
        private int soLuong;

        @Column(name = "trongLuong", length = 150, nullable = false, columnDefinition = "NVARCHAR(255)")
        private String trongLuong;
        @Column(name = "gioiTinh", length = 10, nullable = false, columnDefinition = "NVARCHAR(255)")
        private int gioiTinh;
        @Column(name = "moTa", length = 150, nullable = false, columnDefinition = "NVARCHAR(255)")
        private String moTa;
        @Transient
        private boolean daDoi = false;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "sanpham_id")
        private SanPhamEntity sanPham;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "mauSac_id")
        private MauSacEntity mauSac;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "kichCo_id")
        private KichCoEntity kichCo;
        @ManyToOne
        @JoinColumn(name = "chatLieu_id")
        private ChatLieuEntity chatLieu;
        @ManyToOne
        @JoinColumn(name = "hinhAnh_id")
        private HinhAnhEntity hinhAnh;
        @ManyToOne
        @JoinColumn(name = "danhMuc_id")
        private DanhMucEntity danhMuc;
        @Column(name = "trangThai", length = 10, nullable = true)
        private int trangThai;
        @Override
        public String toString() {
            return "SanPhamChiTietEntity{" +
                    "giaSanPham=" + giaSanPham +
                    ", soLuong=" + soLuong +
                    ", trongLuong='" + trongLuong + '\'' +
                    ", gioiTinh=" + gioiTinh +
                    ", moTa='" + moTa + '\'' +
                    ", sanPham=" + sanPham +
                    ", mauSac=" + mauSac +
                    ", kichCo=" + kichCo +
                    ", chatLieu=" + chatLieu +
                    ", hinhAnh=" + hinhAnh +
                    ", danhMuc=" + danhMuc +
                    ", trangThai=" + trangThai +
                    '}';
        }
    }
