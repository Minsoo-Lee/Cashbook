package minsoo.cashbook.cashbook.repository;

import minsoo.cashbook.cashbook.domain.Cashbook;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.context.transaction.BeforeTransaction;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemoryCashbookRepositoryTest {

    private static final CashbookRepository cashbookRepository = new MemoryCashbookRepository();

    @BeforeAll
    static void set() {
        cashbookRepository.save(new Cashbook("23-01-02", "식비", "편의점", 0, 5000, 15000));
        cashbookRepository.save(new Cashbook("23-01-03", "식비", "돈까스", 0, 5000, 10000));
        cashbookRepository.save(new Cashbook("23-02-01", "식비", "국수", 0, 5000, 5000));
        cashbookRepository.save(new Cashbook("23-02-02", "교통비", "티머니", 0, 5000, 0));
    }
//    @AfterEach
//    public void clear() {
//        cashbookRepository.clearAll();
//    }

    @Test
    void save() {
        assertThat(cashbookRepository.getSize()).isEqualTo(4);
    }

    @Test
    void findById() {
        assertThat(cashbookRepository.findById(1L).toString()).isEqualTo("Optional[1 | 23-01-02 | 식비 | 편의점 | 0 | 5000 | 15000]");
    }

    @Test
    void findByMonth() {
        for (Cashbook cashbook : cashbookRepository.findByMonth("01")) {
            System.out.println(cashbook);
        }
        System.out.println();
    }

    @Test
    void findAll() {
        for (Cashbook cashbook : cashbookRepository.findAll()) {
            System.out.println(cashbook);
        }
        System.out.println();
    }
}