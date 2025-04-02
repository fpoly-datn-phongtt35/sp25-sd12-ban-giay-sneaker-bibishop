package com.poly.client.service;


import com.poly.client.dto.SanPhamChiTietDTO;
import com.poly.client.dto.SanPhamDTO;
import com.poly.client.entity.SanPhamChiTietEntity;
import com.poly.client.entity.SanPhamEntity;
import com.poly.client.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    public List<SanPhamDTO> searchSanPham(String tenSanPham) {
        List<SanPhamDTO> sanPhamDTOList = new ArrayList<>();
        List<SanPhamEntity> sanPhamEntities = sanPhamRepository.filterByTenSanPham(tenSanPham);
        for (SanPhamEntity sanPhamEntity : sanPhamEntities) {
            sanPhamDTOList.add(SanPhamDTO.toDTO(sanPhamEntity));
        }
        return sanPhamDTOList;
    }

    public Page<SanPhamDTO> filterProducts(Integer gender, Integer category, Integer color, Integer material, Integer minPrice, Integer maxPrice, String search, Pageable pageable) {
        List<SanPhamChiTietEntity> sanPhamChiTiets = sanPhamRepository.findFilteredProducts(gender, category, color, material, minPrice, maxPrice, search, pageable)
            .getContent();

        List<SanPhamDTO> sanPhamDTOList = new ArrayList<>();
        for (SanPhamChiTietEntity sanPhamChiTiet : sanPhamChiTiets) {
            SanPhamDTO sanPhamDTO = new SanPhamDTO();
            sanPhamDTO.setId(sanPhamChiTiet.getSanPham().getId());
            sanPhamDTO.setTenSanPham(sanPhamChiTiet.getSanPham().getTenSanPham());
            SanPhamChiTietDTO sanPhamChiTietDTO = new SanPhamChiTietDTO();
            sanPhamChiTietDTO.setId(sanPhamChiTiet.getId());
            sanPhamChiTietDTO.setGiaSanPham(sanPhamChiTiet.getGiaSanPham());
            sanPhamDTO.setProductDetailDtos(Arrays.asList(
                sanPhamChiTietDTO
            ));
            sanPhamDTOList.add(sanPhamDTO);
        }

        return new PageImpl<>(sanPhamDTOList);
    }

    public SanPhamEntity findById(Integer id) {
        return sanPhamRepository.findById(id).get();
    }

}
