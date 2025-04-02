package com.poly.client.service;

import com.poly.client.dto.hoadon.HoaDonDTO;
import com.poly.client.dto.hoadonchitiet.HDCTSearchRequest;
import com.poly.client.dto.hoadonchitiet.HDCTSearchResponse;
import com.poly.client.entity.HoaDon;
import com.poly.client.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HoadonService {
    Page<HDCTSearchResponse> hdctSerchResponse(HDCTSearchRequest request, Pageable pageable);
    Page<HoaDon> orderByCustomer(KhachHang request, Pageable pageable);
    HoaDonDTO findById(Integer orderId);
}
