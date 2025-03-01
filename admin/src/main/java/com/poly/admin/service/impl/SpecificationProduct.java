package com.poly.admin.service.impl;


import com.poly.admin.dto.SanPhamChiTietFiterDTO;
import com.poly.admin.entity.SanPhamChiTietEntity;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class SpecificationProduct {
    public static Specification<SanPhamChiTietEntity> buildWhere(SanPhamChiTietFiterDTO form) {
        Specification<SanPhamChiTietEntity> where = Specification.where(null); // Khởi tạo là một Specification trống

        if (form != null) {
            if (form.getMoTa() != null && !StringUtils.isEmpty(form.getMoTa().trim())) {
                String search = form.getMoTa().trim();
                CustomSpecification productNameSpec = new CustomSpecification("moTa", search);
                where = where.and(productNameSpec); // Thêm điều kiện tìm kiếm vào Specification
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
            if(field.equals("moTa")){
                return  criteriaBuilder.like(root.get("moTa"), "%" + value.toString() + "%");
            }

            return null;

        }

    }
}

