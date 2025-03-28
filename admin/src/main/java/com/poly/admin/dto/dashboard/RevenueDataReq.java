package com.poly.admin.dto.dashboard;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RevenueDataReq {
   private String fromDate;
   private String toDate;
}