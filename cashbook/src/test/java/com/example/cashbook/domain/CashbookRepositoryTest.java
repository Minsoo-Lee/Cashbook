package com.example.cashbook.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CashbookRepositoryTest {

    private final CashbookRepository repository = new CashbookRepository();

    @AfterEach
    void clear() {
        repository.clearStore();
    }

    @Test
    void save() {
        // given
        Cashbook cashbook = new Cashbook("2004-11-01", "식비", "햄버거", 10000, null, 200);

        // when
        Cashbook save = repository.save(cashbook);

        // then
        System.out.println("save = " + save);
        System.out.println("cashbook = " + cashbook);
        assertThat(cashbook).isEqualTo(save);
    }

    @Test
    void findByAll() {
        // given
        Cashbook cashbook1 = new Cashbook("2004-11-01", "식비", "햄버거", 10000, null, 200);
        Cashbook cashbook2 = new Cashbook("2004-11-02", "식비", "햄버거", 10000, null, 200);
        Cashbook cashbook3 = new Cashbook("2004-11-03", "식비", "햄버거", 10000, null, 200);
        Cashbook cashbook4 = new Cashbook("2004-11-04", "식비", "햄버거", 10000, null, 200);

        // when
        repository.save(cashbook1);
        repository.save(cashbook2);
        repository.save(cashbook3);
        repository.save(cashbook4);

        // then
        assertThat(repository.findByAll().size()).isEqualTo(4);
    }

    @Test
    void update() {
        // given
        Cashbook cashbook = new Cashbook("2004-11-01", "식비", "햄버거", 10000, null, 200);

        // when
        repository.save(cashbook);

        // then
        repository.update(1L, new Cashbook("2004-11-02", "식비", "햄버거", 10000, null, 200));
        assertThat(repository.findById(1L).getDate()).isEqualTo("2004-11-02");
    }
}