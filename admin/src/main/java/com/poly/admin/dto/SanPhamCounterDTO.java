package com.poly.admin.dto;
import com.poly.admin.entity.SanPhamChiTietEntity;
import com.poly.admin.entity.SanPhamEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SanPhamCounterDTO extends SuperDTO{

    private String tenSanPham;

    private List<SanPhamChiTietDTO> productDetailDtos;

    public static SanPhamCounterDTO toDTO(SanPhamEntity sanPhamEntity) {
        SanPhamCounterDTO sanPhamDTO = new SanPhamCounterDTO();
        sanPhamDTO.setId(sanPhamEntity.getId());
        sanPhamDTO.setTenSanPham(sanPhamEntity.getTenSanPham());
        List<SanPhamChiTietDTO> sanPhamChiTietList = new ArrayList<>();
        for (SanPhamChiTietEntity sanPhamChiTietEntity: sanPhamEntity.getSanPhamChiTiets()) {
            if (sanPhamChiTietEntity.getSoLuong() > 0) {
                sanPhamChiTietList.add(SanPhamChiTietDTO.toDTO(sanPhamChiTietEntity));
            }
        }
        sanPhamDTO.setProductDetailDtos(sanPhamChiTietList);
        return sanPhamDTO;
    }

}
