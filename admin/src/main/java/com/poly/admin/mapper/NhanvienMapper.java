//package com.poly.admin.mapper;
//
//import com.poly.admin.dto.admin.CreateNhanVienRequest;
//import com.poly.admin.entity.NhanVien;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.factory.Mappers;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.UUID;
//
//@Mapper(componentModel = "spring", uses = {})
//public interface NhanvienMapper {
//
//    NhanvienMapper INSTANCE = Mappers.getMapper(NhanvienMapper.class);
//
//
//    @Mapping(target = "maNhanVien", expression = "(java(genMNV())")
//    @Mapping(target = "gioiTinh", source = "gender")
//    @Mapping(target = "email", source = "email")
//    @Mapping(target = "passwordRaw", source = "password")
//    @Mapping(target = "matKhau", source = "java(genPassword(request.password))")
//    @Mapping(target = "ngaySinh", source = "java(getDob(request))")
//    @Mapping(target = "sdt", source = "sdt")
//    @Mapping(target = "taiKhoan", source = "account")
//    @Mapping(target = "ten", source = "name")
//    @Mapping(target = "ho", source = "firstName")
//    @Mapping(target = "tenDem", source = "midName")
//    @Mapping(target = "trangThai", source = "status")
//    @Mapping(target = "vaiTro", source = "role")
//    NhanVien DtoToEntity(CreateNhanVienRequest request);
//
//    public default String genMNV(){
//        return UUID.randomUUID().toString();
//    }
//    default String genPassword(String rawPassword){
//        return
//    }
//}
