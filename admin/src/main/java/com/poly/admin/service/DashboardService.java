package com.poly.admin.service;

import com.poly.admin.dto.hoadonchitiet.HDCTSearchRequest;
import com.poly.admin.dto.hoadonchitiet.HDCTSearchResponse;
import com.poly.admin.dto.test.EmployeeInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.HashMap;
import java.util.List;

public interface DashboardService {

    HashMap<String, Object> getTodayRevenueDash();


    HashMap<String, Object> getBestCategory();

    HashMap<String, Object> getAllOrderReceived();


    HashMap<String, Object> getOrderCollection();

    List<EmployeeInformation> getAllEmployee();
    Page<HDCTSearchResponse> hdctSerchResponse(HDCTSearchRequest request, Pageable pageable);
}
