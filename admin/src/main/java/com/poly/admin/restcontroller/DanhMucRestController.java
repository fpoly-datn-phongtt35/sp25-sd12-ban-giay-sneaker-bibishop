package com.poly.admin.restcontroller;


import com.poly.admin.dto.DanhMucDTO;
import com.poly.admin.service.DanhMucService;
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
