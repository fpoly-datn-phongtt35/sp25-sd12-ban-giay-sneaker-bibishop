package com.poly.admin.controller.DotGiamGia;

import com.poly.admin.entity.DotGiamGia;
import com.poly.admin.service.DotGiamGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DotGiamGiaRestController {

    @Autowired
    private DotGiamGiaService dotGiamGiaService;

    @ResponseBody
    @GetMapping("/discounts")
    public List<DotGiamGia> getAllValidDiscountCodes() {
        return dotGiamGiaService.findAll();
    }

}
