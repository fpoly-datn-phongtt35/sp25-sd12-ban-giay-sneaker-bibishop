package com.poly.admin.service.impl;


import com.poly.admin.dto.SanPhamCtFiterDTO;
import com.poly.admin.entity.SanPhamChiTietEntity;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

public class SpectificationSpct {
    public static Specification<SanPhamChiTietEntity> buildWhereCT(SanPhamCtFiterDTO form) {
        Specification<SanPhamChiTietEntity> where = Specification.where(null); // Khởi tạo là một Specification trống

        if (form != null) {
            if (form.getTrangThai() != null) {
                CustomSpecification trangThaiSpec = new CustomSpecification("trangThai", form.getTrangThai());
                where = where.and(trangThaiSpec); // Thêm điều kiện tìm kiếm vào Specification
            }
        }

        return where;
    }

    @RequiredArgsConstructor
    static class CustomSpecification implements Specification<SanPhamChiTietEntity> {
        @NonNull
        private String field;
        @NonNull
        private Object value;

        @Override
        public Predicate toPredicate(
                Root<SanPhamChiTietEntity> root,
                CriteriaQuery<?> query,
                CriteriaBuilder criteriaBuilder
        ){
            if (field.equals("trangThai") && value instanceof String) {
                return criteriaBuilder.equal(root.get(field), value);
            }

            return null;
        }
    }
}
