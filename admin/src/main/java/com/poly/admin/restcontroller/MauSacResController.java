package com.poly.admin.restcontroller;


import com.poly.admin.dto.MauSacDTO;
import com.poly.admin.service.MauSacService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api/mausac")
@RequiredArgsConstructor
public class MauSacResController {
    private final MauSacService mauSacService;
    @GetMapping("/mau-sac")
    public ModelAndView home() {
        return new ModelAndView("admin/adminWeb/Mausac");
    }
    @GetMapping("/getAll")
    public List<MauSacDTO> getAllMauSac() {
        return mauSacService.getAllMauSac();
    }
    @PostMapping("/add")
    public MauSacDTO addDanhMuc(@RequestBody MauSacDTO dto){
        return mauSacService.addMauSac(dto);
    }
    @PutMapping("/update")
    public MauSacDTO updateDanhMuc(@RequestBody MauSacDTO dto){
        return mauSacService.updateMauSac(dto);
    }
}
