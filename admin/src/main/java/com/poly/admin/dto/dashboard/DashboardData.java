package com.poly.admin.dto.dashboard;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class DashboardData {
    private int registeredCustomers;
    private int warehouseManagement;
    private int complaints;
    private int customerCare;
    private int warehouseInput;
    private int coordination;
    private int updates;
    private String startDate;
    private String endDate;
    private List<Integer> revenueData;

    // Getters and Setters
}