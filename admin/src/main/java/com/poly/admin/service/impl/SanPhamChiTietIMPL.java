package com.poly.admin.service.impl;


import com.poly.admin.dto.SanPhamChiTietCrud;
import com.poly.admin.dto.SanPhamChiTietDTO;
import com.poly.admin.dto.SanPhamChiTietFiterDTO;
import com.poly.admin.dto.SanPhamCtFiterDTO;
import com.poly.admin.entity.ChatLieuEntity;
import com.poly.admin.entity.DanhMucEntity;
import com.poly.admin.entity.HinhAnhEntity;
import com.poly.admin.entity.KichCoEntity;
import com.poly.admin.entity.MauSacEntity;
import com.poly.admin.entity.SanPhamChiTietEntity;
import com.poly.admin.entity.SanPhamEntity;
import com.poly.admin.repository.ChatLieuRepository;
import com.poly.admin.repository.DanhMucRepository;
import com.poly.admin.repository.HinhAnhRepository;
import com.poly.admin.repository.KichCoRepository;
import com.poly.admin.repository.MauSacRepository;
import com.poly.admin.repository.SanPhamChiTietRepository;
import com.poly.admin.repository.SanPhamRepository;
import com.poly.admin.service.SanPhamChiTietService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Builder
public class SanPhamChiTietIMPL implements SanPhamChiTietService {
    private final SanPhamChiTietRepository sanPhamChiTietRepository;
    private final ChatLieuRepository chatLieuRepository;
    private final SanPhamRepository sanPhamRepository;
    private final HinhAnhRepository hinhAnhRepository;
    private final KichCoRepository kichCoRepository;
    private final MauSacRepository mauSacRepository;
    private final DanhMucRepository danhMucRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<SanPhamChiTietDTO> getAllSanPhamChiTiet(Integer totalPage, Integer totalItem, SanPhamChiTietFiterDTO form) {
        Pageable pageable = PageRequest.of(totalPage, totalItem);

        // Xây dựng Specification từ form (SanPhamChiTietFiterDTO)
        Specification<SanPhamChiTietEntity> specification = SpecificationProduct.buildWhere(form);

        // Kiểm tra nếu không có Specification hoặc Specification là null
        if (specification == null) {
            List<SanPhamChiTietDTO> emptyList = Collections.emptyList();
            return new PageImpl<>(emptyList, pageable, 0);
        }

        // Sử dụng Specification trong phương thức findByProductName
        Page<SanPhamChiTietEntity> entityPage = sanPhamChiTietRepository.findAll(specification, pageable);

        // Convert Page<SanPhamChiTietEntity> sang Page<SanPhamChiTietDTO>
        List<SanPhamChiTietDTO> dtos = entityPage.getContent().stream()
                .map(entity -> modelMapper.map(entity, SanPhamChiTietDTO.class))
                .collect(Collectors.toList());

        return new PageImpl<>(dtos, pageable, entityPage.getTotalElements());
    }

    @Override
    public Page<SanPhamChiTietDTO> getAllSanPhamChiTietBYidSP(Integer idSP, Integer totalPage,
                                                              Integer totalItem, SanPhamCtFiterDTO fiterDTO) {
        // Tạo Specification để lọc theo idSP
        Specification<SanPhamChiTietEntity> specByIdSP = (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("sanPham").get("id"), idSP);


        Specification<SanPhamChiTietEntity> specByFilter = SpectificationSpct.buildWhereCT(fiterDTO);

        // Kết hợp các Specifications
        Specification<SanPhamChiTietEntity> combinedSpec = Specification.where(specByIdSP).and(specByFilter);

        Pageable pageable = PageRequest.of(totalPage, totalItem);

        // Truy vấn với combined Specification và Pageable
        Page<SanPhamChiTietEntity> entityPage = sanPhamChiTietRepository.findAll(combinedSpec, pageable);

        // Chuyển đổi từ entity sang DTO
        List<SanPhamChiTietDTO> dtos = entityPage.getContent().stream()
                .map(entity -> modelMapper.map(entity, SanPhamChiTietDTO.class))
                .collect(Collectors.toList());

        return new PageImpl<>(dtos, pageable, entityPage.getTotalElements());
    }

//    @Override
//    public SanPhamChiTietCrud addSanPhamChiTiet(SanPhamChiTietCrud sanPhamChiTietCrud) {
//        Optional<DanhMucEntity> danhMuc =danhMucRepository.findById(sanPhamChiTietCrud.getDanhMuc());
//        Optional<ChatLieuEntity>chatLieu =chatLieuRepository.findById(sanPhamChiTietCrud.getChatLieu());
//
//        Optional<HinhAnhEntity>hinhAnh =hinhAnhRepository.findById(sanPhamChiTietCrud.getHinhAnh());
//        Optional<KichCoEntity>kichCo =kichCoRepository.findById(sanPhamChiTietCrud.getKichCo());
//        Optional<MauSacEntity>mauSac =mauSacRepository.findById(sanPhamChiTietCrud.getMauSac());
//        Optional<SanPhamEntity>sanPham =sanPhamRepository.findById(sanPhamChiTietCrud.getSanPham());
//        SanPhamChiTietEntity sanPhamChiTiet = SanPhamChiTietEntity.builder()
//                .sanPham(sanPham.get())
//                .soLuong(sanPhamChiTietCrud.getSoLuong())
//                .kichCo(kichCo.get())
//                .mauSac(mauSac.get())
//                .chatLieu(chatLieu.get())
//                .danhMuc(danhMuc.get())
//                .hinhAnh(hinhAnh.get())
//                .giaSanPham(sanPhamChiTietCrud.getGiaSanPham())
//                .moTa(sanPhamChiTietCrud.getMoTa())
//                .gioiTinh(sanPhamChiTietCrud.getGioiTinh())
//                .trongLuong(sanPhamChiTietCrud.getTrongLuong())
//                .trangThai(sanPhamChiTietCrud.getTrangThai())
//                .build();
//        sanPhamChiTiet.setCreateDate(LocalDate.now());
//        sanPhamChiTiet.setUpdateDate(LocalDate.now().atStartOfDay());
//        SanPhamChiTietEntity sanPhamChiTietSave = sanPhamChiTietRepository.save(sanPhamChiTiet);
//        return modelMapper.map(sanPhamChiTietSave, SanPhamChiTietCrud.class);
//    }




    @Override
    public SanPhamChiTietCrud addSanPhamChiTiet(SanPhamChiTietCrud dto) {
        // Lấy các id từ DTO
        Integer danhMucId = dto.getDanhMuc();
        Integer chatLieuId = dto.getChatLieu();
        Integer hinhAnhId = dto.getHinhAnh();
        Integer kichCoId = dto.getKichCo();
        Integer mauSacId = dto.getMauSac();
        Integer sanPhamId = dto.getSanPham();

        // Debug: in ra các giá trị id
        System.out.println("DanhMucId: " + danhMucId);
        System.out.println("ChatLieuId: " + chatLieuId);
        System.out.println("HinhAnhId: " + hinhAnhId);
        System.out.println("KichCoId: " + kichCoId);
        System.out.println("MauSacId: " + mauSacId);
        System.out.println("SanPhamId: " + sanPhamId);

        // Kiểm tra xem sản phẩm chi tiết với các tiêu chí giống nhau đã tồn tại chưa
        Optional<SanPhamChiTietEntity> optExisting = sanPhamChiTietRepository.findExistingProductDetail(
                dto.getGiaSanPham(),
                sanPhamId,
                dto.getGioiTinh(),
                dto.getTrongLuong(),
                danhMucId,
                hinhAnhId,
                kichCoId,
                mauSacId,
                chatLieuId
        );

        SanPhamChiTietEntity entity;
        if (optExisting.isPresent()) {
            // Nếu tồn tại, cộng dồn số lượng
            entity = optExisting.get();
            int updatedQuantity = entity.getSoLuong() + dto.getSoLuong();
            entity.setSoLuong(updatedQuantity);
            entity.setUpdateDate(LocalDate.now().atStartOfDay());
        } else {
            // Nếu chưa tồn tại, lấy các entity liên quan từ DB
            DanhMucEntity danhMuc = danhMucRepository.findById(danhMucId)
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy Danh Mục với ID: " + danhMucId));
            ChatLieuEntity chatLieu = chatLieuRepository.findById(chatLieuId)
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy Chat Lieu với ID: " + chatLieuId));
            HinhAnhEntity hinhAnh = hinhAnhRepository.findById(hinhAnhId)
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy Hình Ảnh với ID: " + hinhAnhId));
            KichCoEntity kichCo = kichCoRepository.findById(kichCoId)
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy Kích Cỡ với ID: " + kichCoId));
            MauSacEntity mauSac = mauSacRepository.findById(mauSacId)
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy Màu Sắc với ID: " + mauSacId));
            SanPhamEntity sanPham = sanPhamRepository.findById(sanPhamId)
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy Sản Phẩm với ID: " + sanPhamId));

            // Xây dựng entity mới
            entity = SanPhamChiTietEntity.builder()
                    .sanPham(sanPham)
                    .soLuong(dto.getSoLuong())
                    .kichCo(kichCo)
                    .mauSac(mauSac)
                    .chatLieu(chatLieu)
                    .danhMuc(danhMuc)
                    .hinhAnh(hinhAnh)
                    .giaSanPham(dto.getGiaSanPham())
                    .moTa(dto.getMoTa())
                    .gioiTinh(dto.getGioiTinh())
                    .trongLuong(dto.getTrongLuong())
                    .trangThai(dto.getTrangThai())
                    .build();
            entity.setCreateDate(LocalDate.now());
            entity.setUpdateDate(LocalDate.now().atStartOfDay());
        }

        // Lưu entity (cập nhật hoặc mới)
        SanPhamChiTietEntity savedEntity = sanPhamChiTietRepository.save(entity);
        // Map entity đã lưu sang DTO trả về
        return modelMapper.map(savedEntity, SanPhamChiTietCrud.class);
    }
// test


    public class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }

    @Override
    public SanPhamChiTietCrud upDateSanPhamChiTiet(SanPhamChiTietCrud sanPhamChiTietCrud) {
        // Kiểm tra ID sản phẩm chi tiết
        if (sanPhamChiTietCrud.getId() == null) {
            throw new IllegalArgumentException("ID của sản phẩm chi tiết không được để trống.");
        }

        // Lấy entity sản phẩm chi tiết hiện có từ DB
        SanPhamChiTietEntity existingEntity = sanPhamChiTietRepository.findById(sanPhamChiTietCrud.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy sản phẩm chi tiết với id: " + sanPhamChiTietCrud.getId()));

        // Cập nhật các entity liên quan nếu có dữ liệu mới (kiểm tra null và chuỗi rỗng)
        if (sanPhamChiTietCrud.getDanhMuc() != null && !sanPhamChiTietCrud.getDanhMuc().toString().trim().isEmpty()) {
            DanhMucEntity danhMucEntity = danhMucRepository.findById(sanPhamChiTietCrud.getDanhMuc())
                    .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy Danh Mục với id: " + sanPhamChiTietCrud.getDanhMuc()));
            existingEntity.setDanhMuc(danhMucEntity);
        }

        if (sanPhamChiTietCrud.getChatLieu() != null && !sanPhamChiTietCrud.getChatLieu().toString().trim().isEmpty()) {
            ChatLieuEntity chatLieuEntity = chatLieuRepository.findById(sanPhamChiTietCrud.getChatLieu())
                    .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy Chất Liệu với id: " + sanPhamChiTietCrud.getChatLieu()));
            existingEntity.setChatLieu(chatLieuEntity);
        }

        if (sanPhamChiTietCrud.getHinhAnh() != null && !sanPhamChiTietCrud.getHinhAnh().toString().trim().isEmpty()) {
            HinhAnhEntity hinhAnhEntity = hinhAnhRepository.findById(sanPhamChiTietCrud.getHinhAnh())
                    .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy Hình Ảnh với id: " + sanPhamChiTietCrud.getHinhAnh()));
            existingEntity.setHinhAnh(hinhAnhEntity);
        }

        if (sanPhamChiTietCrud.getKichCo() != null && !sanPhamChiTietCrud.getKichCo().toString().trim().isEmpty()) {
            KichCoEntity kichCoEntity = kichCoRepository.findById(sanPhamChiTietCrud.getKichCo())
                    .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy Kích Cỡ với id: " + sanPhamChiTietCrud.getKichCo()));
            existingEntity.setKichCo(kichCoEntity);
        }

        if (sanPhamChiTietCrud.getMauSac() != null && !sanPhamChiTietCrud.getMauSac().toString().trim().isEmpty()) {
            MauSacEntity mauSacEntity = mauSacRepository.findById(sanPhamChiTietCrud.getMauSac())
                    .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy Màu Sắc với id: " + sanPhamChiTietCrud.getMauSac()));
            existingEntity.setMauSac(mauSacEntity);
        }

        if (sanPhamChiTietCrud.getSanPham() != null && !sanPhamChiTietCrud.getSanPham().toString().trim().isEmpty()) {
            SanPhamEntity sanPhamEntity = sanPhamRepository.findById(sanPhamChiTietCrud.getSanPham())
                    .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy Sản Phẩm với id: " + sanPhamChiTietCrud.getSanPham()));
            existingEntity.setSanPham(sanPhamEntity);
        }

        // Cập nhật các thuộc tính khác
        existingEntity.setSoLuong(sanPhamChiTietCrud.getSoLuong());
        existingEntity.setGiaSanPham(sanPhamChiTietCrud.getGiaSanPham());
        existingEntity.setMoTa(sanPhamChiTietCrud.getMoTa());
        existingEntity.setGioiTinh(sanPhamChiTietCrud.getGioiTinh());
        existingEntity.setTrongLuong(sanPhamChiTietCrud.getTrongLuong());
        existingEntity.setTrangThai(sanPhamChiTietCrud.getTrangThai());

        // Cập nhật ngày cập nhật (giữ nguyên ngày tạo nếu cần)
        existingEntity.setUpdateDate(LocalDate.now().atStartOfDay());

        // Lưu lại entity đã cập nhật
        SanPhamChiTietEntity savedEntity = sanPhamChiTietRepository.save(existingEntity);

        return modelMapper.map(savedEntity, SanPhamChiTietCrud.class);
    }




//    @Override
//    public SanPhamChiTietCrud upDateSanPhamChiTiet(SanPhamChiTietCrud sanPhamChiTietCrud) {
//        Optional<DanhMucEntity> danhMuc =danhMucRepository.findById(sanPhamChiTietCrud.getDanhMuc());
//        Optional<ChatLieuEntity>chatLieu =chatLieuRepository.findById(sanPhamChiTietCrud.getChatLieu());
//        Optional<HinhAnhEntity>hinhAnh =hinhAnhRepository.findById(sanPhamChiTietCrud.getHinhAnh());
//        Optional<KichCoEntity>kichCo =kichCoRepository.findById(sanPhamChiTietCrud.getKichCo());
//        Optional<MauSacEntity>mauSac =mauSacRepository.findById(sanPhamChiTietCrud.getMauSac());
//        Optional<SanPhamEntity>sanPham =sanPhamRepository.findById(sanPhamChiTietCrud.getSanPham());
//        SanPhamChiTietEntity sanPhamChiTiet = SanPhamChiTietEntity.builder()
//                .sanPham(sanPham.get())
//                .soLuong(sanPhamChiTietCrud.getSoLuong())
//                .kichCo(kichCo.get())
//                .mauSac(mauSac.get())
//                .chatLieu(chatLieu.get())
//                .danhMuc(danhMuc.get())
//                .hinhAnh(hinhAnh.get())
//                .giaSanPham(sanPhamChiTietCrud.getGiaSanPham())
//                .moTa(sanPhamChiTietCrud.getMoTa())
//                .gioiTinh(sanPhamChiTietCrud.getGioiTinh())
//                .trongLuong(sanPhamChiTietCrud.getTrongLuong())
//                .trangThai(sanPhamChiTietCrud.getTrangThai())
//                .build();
//        sanPhamChiTiet.setCreateDate(LocalDate.now());
//        sanPhamChiTiet.setUpdateDate(LocalDate.now().atStartOfDay());
//        sanPhamChiTiet.setId(sanPhamChiTietCrud.getId());
//        SanPhamChiTietEntity sanPhamChiTietSave = sanPhamChiTietRepository.save(sanPhamChiTiet);
//        return modelMapper.map(sanPhamChiTietSave, SanPhamChiTietCrud.class);
//    }
//

    @Override
    public SanPhamChiTietDTO findById(Integer id) {
        SanPhamChiTietEntity sanPhamChiTietEntity = sanPhamChiTietRepository.findById(id).orElseThrow();

        return modelMapper.map(sanPhamChiTietEntity, SanPhamChiTietDTO.class);
    }

    @Override
    public List<SanPhamChiTietDTO> GetForSP(Pageable pageable) {
//        List<SanPhamChiTietEntity> entities = sanPhamChiTietRepository.findTop4SanPhamChiTiet(pageable);
//        return entities.stream()
//                .map(entity -> modelMapper.map(entity, SanPhamChiTietDTO.class))
//                .collect(Collectors.toList());
        return null;
    }

    @Override
    public List<SanPhamChiTietDTO> AllSanPhamChiTietByidSP(Integer idSP) {
        List<SanPhamChiTietEntity> entities = sanPhamChiTietRepository.findByIdSP(idSP);
        return entities.stream()
                .map(entity -> modelMapper.map(entity, SanPhamChiTietDTO.class))
                .collect(Collectors.toList());
    }




    @Override
    public Optional<SanPhamChiTietEntity> checkExistingSanPhamCT(BigDecimal giaSanPham, Integer sanPhamId, int gioiTinh, String trongLuong, Integer danhMucId, Integer hinhAnhId, Integer kichCoId, Integer mauSacId, Integer chatLieuId) {
        return sanPhamChiTietRepository.findExistingProductDetail(
                giaSanPham,
                sanPhamId,
                gioiTinh,
                trongLuong,
                danhMucId,
                hinhAnhId,
                kichCoId,
                mauSacId,
                chatLieuId
        );
    }
}
