package com.poly.admin.dto.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

public class CompanyRevenue {

    @Column(nullable = false)
    private String month;

    @Column(nullable = false)
    private double revenue;

    @Column
    private double expense;

    @Column
    private double margins;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    public double getMargins() {
        return margins;
    }

    public void setMargins(double margins) {
        this.margins = margins;
    }
}
