package com.poly.client.rest;

import com.poly.client.dto.hoadon.HoaDonDTO;
import com.poly.client.entity.HoaDon;
import com.poly.client.service.HoadonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/v2") // Thêm version để tránh xung đột
@RequiredArgsConstructor
public class OrderHistoryV2Controller {

    private final HoadonService hoadonService;

    @GetMapping("/orders/{id}")
    @ResponseBody // Đảm bảo rõ ràng
    public HoaDonDTO getOrderDetails(@PathVariable long id) {
        return hoadonService.findById(id);
    }
}