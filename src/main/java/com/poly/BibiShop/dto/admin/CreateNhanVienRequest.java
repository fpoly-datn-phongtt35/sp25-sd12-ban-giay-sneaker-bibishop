package com.poly.BibiShop.dto.admin;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateNhanVienRequest {
    private Integer id;
    private String email;
    private String sdt;
    private String name;
    private String loginName;
    private String position;
    private String department;
    private String cccd;
    private String gender;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @JsonProperty("dob")
    private Timestamp dob;




//    private String gender;
    private String password;
//    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
//    @JsonProperty("dob")
//    private Timestamp dob;
//    private String sdt;
    private String account;
//    private String name;
    private String midName;
    private Integer status;
    private Integer address;
//    private String email;
    private String role;
//    private Integer id;
}
