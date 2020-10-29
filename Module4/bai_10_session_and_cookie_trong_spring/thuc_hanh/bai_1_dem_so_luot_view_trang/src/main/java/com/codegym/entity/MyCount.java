package com.codegym.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyCount {
    @Id
    private int count;

    public MyCount() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increment(){
        this.count++;
    }
}
