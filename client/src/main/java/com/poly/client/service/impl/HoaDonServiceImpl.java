package com.poly.client.service.impl;

import com.poly.client.dto.hoadon.HoaDonChiTietDTO;
import com.poly.client.dto.hoadon.HoaDonDTO;
import com.poly.client.dto.hoadon.SanPhamDTO;
import com.poly.client.dto.hoadonchitiet.HDCTSearchRequest;
import com.poly.client.dto.hoadonchitiet.HDCTSearchResponse;
import com.poly.client.entity.HoaDon;
import com.poly.client.entity.KhachHang;
import com.poly.client.repository.HoaDonChiTietRepository;
import com.poly.client.repository.HoaDonRepository;
import com.poly.client.service.HoadonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HoaDonServiceImpl implements HoadonService {
    private final HoaDonChiTietRepository hoaDonChiTietRepository;
    private final HoaDonRepository hoaDonRepository;

    @Override
    public Page<HoaDon> orderByCustomer(KhachHang request, Pageable pageable) {
        Page<HoaDon> hoaDons = hoaDonRepository.findHoaDonByKhachHang(request, pageable);
        return hoaDons;
    }

    @Override
    public Page<HDCTSearchResponse>
    hdctSerchResponse(HDCTSearchRequest request, Pageable pageable) {
        long count = hoaDonChiTietRepository.countSearch(request);
        List<HDCTSearchResponse> content = new ArrayList<>();
        if (count > 0) {
            content = hoaDonChiTietRepository.search(request, pageable);
        }
        return new PageImpl<>(content, pageable, count);
    }

    @Override
    public HoaDonDTO findById(Integer orderId) {
        HoaDon hoaDon = hoaDonRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Hóa đơn không tồn tại với id: " + orderId));
        HoaDonDTO dto = new HoaDonDTO();

        // Ánh xạ các thông tin cơ bản của hóa đơn
        dto.setId(hoaDon.getId());
        dto.setMaHoaDon(hoaDon.getMaHoaDon());
        dto.setNgayTao(hoaDon.getNgayTao());
        dto.setTongTien(hoaDon.getTongTien());
        dto.setTrangThai(hoaDon.getTrangThai());

        // Ánh xạ danh sách chi tiết hóa đơn
        List<HoaDonChiTietDTO> chiTietDTOs = hoaDon.getChiTietHoaDon().stream()
                .map(chiTiet -> {
                    HoaDonChiTietDTO chiTietDTO = new HoaDonChiTietDTO();
                    chiTietDTO.setSoLuong(chiTiet.getSoLuong());
                    chiTietDTO.setGia(chiTiet.getGia());
                    BigDecimal thanhTien = chiTiet.getGia().multiply(new BigDecimal(chiTiet.getSoLuong()));
                    chiTietDTO.setThanhTien(thanhTien);

                    // Ánh xạ thông tin sản phẩm
                    if (chiTiet.getSanPham() != null) {
                        SanPhamDTO sanPhamDTO = new SanPhamDTO();
                        sanPhamDTO.setTenSanPham(chiTiet.getSanPham().getTenSanPham());

                        chiTietDTO.setSanPham(sanPhamDTO);
                    }

                    return chiTietDTO;
                })
                .collect(Collectors.toList());

        dto.setChiTietHoaDon(chiTietDTOs);

        // Tính toán lại tổng tiền từ các chi tiết (nếu cần)


        return dto;
    }
}
