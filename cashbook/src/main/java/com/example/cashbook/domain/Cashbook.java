package com.example.cashbook.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Cashbook {
    private Long id;
    private String date;
    private String type;
    private String content;
    private Integer expense;
    private Integer income;
    private int balance;

    public Cashbook(String date, String type, String content, Integer expense, Integer income, int balance) {
        this.date = date;
        this.type = type;
        this.content = content;
        this.expense = expense;
        this.income = income;
        this.balance = balance;
    }
}
