package com.poly.admin.service;

import com.poly.admin.dto.test.EmployeeInformation;

import java.util.HashMap;
import java.util.List;

public interface DashboardService {

    HashMap<String, Object> getTodayRevenueDash();


    HashMap<String, Object> getBestCategory();

    HashMap<String, Object> getAllOrderReceived();


    HashMap<String, Object> getOrderCollection();

    List<EmployeeInformation> getAllEmployee();
}
