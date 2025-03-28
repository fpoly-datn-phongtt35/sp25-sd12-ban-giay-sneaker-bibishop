package com.poly.admin.dto.dashboard;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class RevenueData {
    private LocalDate date;
    private double revenue;

    public RevenueData(LocalDate date, double revenue) {
        this.date = date;
        this.revenue = revenue;
    }

    public LocalDate getDate() { return date; }
    public double getRevenue() { return revenue; }
}