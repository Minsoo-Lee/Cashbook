package minsoo.cashbook.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@AllArgsConstructor
public class Account {
    private Long id;
    private String date;
    private String type;
    private String content;
    private Integer expend;
    private Integer income;
    private Integer balance;


}
