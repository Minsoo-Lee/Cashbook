package minsoo.cashbook.controller;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AccountForm {

    private String date;
    private String type;
    private String content;
    private Integer expend;
    private Integer income;
    private Integer balance;
}
