package com.poly.admin.service.impl;

import com.poly.admin.dto.test.*;
import com.poly.admin.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.*;

@Service
public class DashboardServiceImpl implements DashboardService {




    @Override
    public HashMap<String, Object> getTodayRevenueDash() {
        HashMap<String, Object> companyRevenueMap = new HashMap<>();
        Locale locale = new Locale("en", "US");
        NumberFormat CurrencyFormatter = NumberFormat.getCurrencyInstance(locale);
        CompanyRevenue companyRevenue = new CompanyRevenue();
        companyRevenue.setRevenue(80000000);
        companyRevenue.setExpense(3000000);
        companyRevenue.setMargins(234324);
        companyRevenue.setMonth("[Jan, Feb, Mar, Apr, May, Jun]");

        companyRevenueMap.put("crLabels", companyRevenue.getMonth());
        companyRevenueMap.put("crRevenue", "[75000.0, 80000.0, 85000.0, 84000.0, 80000.0, 90000.0]");
        companyRevenueMap.put("totalExpense", CurrencyFormatter.format(companyRevenue.getExpense()));
        companyRevenueMap.put("totalMargin", CurrencyFormatter.format(companyRevenue.getMargins()));
        companyRevenueMap.put("totalRevenue", CurrencyFormatter.format(companyRevenue.getRevenue()));

        return companyRevenueMap;
    }

    @Override
    public HashMap<String, Object> getBestCategory() {
        HashMap<String, Object> bestProductMap = new HashMap<>();
        bestProductMap.put("bcLabels", "[Electronics, Phone/Ipad, Purses, Jwellery]");
        bestProductMap.put("bcPercents", "[30, 40, 20, 10]");
        return bestProductMap;
    }

    @Override
    public HashMap<String, Object> getAllOrderReceived() {
        HashMap<String, Object> orderReceivedMap = new HashMap<>();
        orderReceivedMap.put("orLabels", "[Mar 1, Mar 2, Mar 3, Mar 4, Mar 5, Mar 6, Mar 7, Mar 8, Mar 9, Mar 10, Mar 11, Mar 12, Mar 13, Mar 14, Mar 15]");
        orderReceivedMap.put("orOrders", "[100, 125, 180, 170, 160, 175, 400, 195, 190, 210, 120, 110, 100, 140, 170]");
        return orderReceivedMap;
    }

    @Override
    public HashMap<String, Object> getOrderCollection() {
        HashMap<String, Object> orderStatusMap = new HashMap<>();

        int totalNewOrders = 21;
        double totalRevenue = 8000;
        int totalShippedOrders = 21;
        int totalReturnInitiatedOrders = 44;

        Locale locale = new Locale("en", "US");
        NumberFormat CurrencyFormatter = NumberFormat.getCurrencyInstance(locale);

        orderStatusMap.put("totalNewOrders", totalNewOrders);
        orderStatusMap.put("totalRevenue", CurrencyFormatter.format(totalRevenue));
        orderStatusMap.put("totalShippedOrders", totalShippedOrders);
        orderStatusMap.put("totalReturnInitiatedOrders", totalReturnInitiatedOrders);

        return orderStatusMap;
    }

    @Override
    public List<EmployeeInformation> getAllEmployee() {
        EmployeeInformation employeeInformation = EmployeeInformation.builder()
                .name("Cuong")
                .position("Admin")
                .age(25)
                .salary(1000)
                .startDate(new Date())
                .build();
        return Arrays.asList(employeeInformation);
    }
}
