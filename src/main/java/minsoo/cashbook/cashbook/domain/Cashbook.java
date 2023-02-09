package minsoo.cashbook.cashbook.domain;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class Cashbook {

    private Long id;

    @NonNull private String date;
    @NonNull private String type;
    @NonNull private String content;
    @NonNull private int income;
    @NonNull private int expense;
    @NonNull private int balance;

    @Override
    public String toString() {
        return id + " | "  + date + " | "  + type + " | "  + content + " | "  + income + " | "  + expense + " | "  + balance;
    }
}
