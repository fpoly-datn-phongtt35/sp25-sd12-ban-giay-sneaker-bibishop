package com.poly.BibiShop.restcontroller;


import com.poly.BibiShop.dto.DanhMucDTO;
import com.poly.BibiShop.service.DanhMucService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api/danhmuc")
@RequiredArgsConstructor
public class DanhMucRestController {


    private final DanhMucService danhMucService;
    @GetMapping("/danh-muc")
    public ModelAndView home() {
        return new ModelAndView("admin/adminWeb/Danhmuc");
    }
    @GetMapping("/getAll")
    public List<DanhMucDTO> getAllDanhMuc() {
        return danhMucService.getAllDanhMuc();
    }

    @PostMapping("/add")
   public DanhMucDTO addDanhMuc(@RequestBody DanhMucDTO dto){
        return danhMucService.addDanhMuc(dto);
    }
    @PutMapping("/update")
    public DanhMucDTO updateDanhMuc(@RequestBody DanhMucDTO dto){
        return danhMucService.upDateDanhMuc(dto);
    }
}
