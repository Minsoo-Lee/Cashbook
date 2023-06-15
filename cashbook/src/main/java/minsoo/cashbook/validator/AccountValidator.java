package minsoo.cashbook.validator;

import minsoo.cashbook.domain.Account;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AccountValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Account.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Account account = (Account) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "expend", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "income", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "balance", "required");
    }
}
