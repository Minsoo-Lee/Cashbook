package minsoo.cashbook.cashbook.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class Cashbook {

    private Long id;

    private String date;
    private String type;
    private String content;
    private int income;
    private int expense;
    private int balance;

}
