package com.poly.BibiShop.restcontroller;


import com.poly.BibiShop.dto.KichCoDTO;
import com.poly.BibiShop.service.KichCoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api/kichco")
@RequiredArgsConstructor
public class KichCoResController {
    private final KichCoService kichCoService;
    @GetMapping("/kich-co")
    public ModelAndView home() {
        return new ModelAndView("admin/adminWeb/Kichco");
    }
    @GetMapping("/getAll")
    public List<KichCoDTO> getAllMauSac() {
        return kichCoService.getAllKichCo();
    }

    @PostMapping("/add")
    public KichCoDTO addKichCo(@RequestBody KichCoDTO dto){
        return kichCoService.addKichCo(dto);
    }
    @PutMapping("/update")
    public KichCoDTO updateKichCo(@RequestBody KichCoDTO dto){
        return kichCoService.updateKichCo( dto);
    }

}
