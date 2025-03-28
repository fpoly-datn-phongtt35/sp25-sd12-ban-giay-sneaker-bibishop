package com.poly.admin.dto.test;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

public class OrderReceived {

    @Column
    private int orderReceived;

    @Column
    private String dateReceived;

    public int getOrderReceived() {
        return orderReceived;
    }

    public void setOrderReceived(int orderReceived) {
        this.orderReceived = orderReceived;
    }

    public String getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(String dateReceived) {
        this.dateReceived = dateReceived;
    }
}
