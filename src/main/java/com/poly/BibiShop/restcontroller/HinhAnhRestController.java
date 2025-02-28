package com.poly.BibiShop.restcontroller;


import com.poly.BibiShop.dto.HinhAnhDTO;
import com.poly.BibiShop.service.HinhAnhService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api/hinhanh")
@RequiredArgsConstructor
public class HinhAnhRestController {
    private final HinhAnhService hinhAnhService;
    @GetMapping("/hinh-anh")
    public ModelAndView home() {
        return new ModelAndView("admin/adminWeb/Hinhanh");
    }
    @GetMapping("/getAll")
    public List<HinhAnhDTO> getAllDanhMuc() {
        return hinhAnhService.getAllHinhAnh();
    }

    @PostMapping("/add")
    public HinhAnhDTO addHinhANh (@RequestBody HinhAnhDTO hinhAnhDTO){
        return hinhAnhService.addHinhAnh(hinhAnhDTO);
    }
    @PutMapping("/update")
    public HinhAnhDTO updateHinhAnh (@RequestBody HinhAnhDTO hinhAnhDTO){
        return hinhAnhService.UpdateHinhAnh(hinhAnhDTO);
    }
}
