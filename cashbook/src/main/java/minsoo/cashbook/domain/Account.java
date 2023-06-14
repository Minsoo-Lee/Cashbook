package minsoo.cashbook.domain;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Account {

    private Long id;
    private String date;
    private String type;
    private String content;
    private Integer expend;
    private Integer income;
    private Integer balance;

    public Account(String date, String type, String content, Integer expend, Integer income, Integer balance) {
        this.date = date;
        this.type = type;
        this.content = content;
        this.expend = expend;
        this.income = income;
        this.balance = balance;
    }
}
