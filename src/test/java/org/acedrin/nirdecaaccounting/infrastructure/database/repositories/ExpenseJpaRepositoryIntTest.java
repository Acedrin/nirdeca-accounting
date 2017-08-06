package org.acedrin.nirdecaaccounting.infrastructure.database.repositories;

import org.acedrin.nirdecaaccounting.domain.Expense;
import org.acedrin.nirdecaaccounting.domain.ExpenseRepository;
import org.acedrin.nirdecaaccounting.infrastructure.database.MappingsConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(MappingsConfiguration.class)
public class ExpenseJpaRepositoryIntTest {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    private Expense expense;

    @Before
    public void setUp() throws Exception {
        expense = new Expense(1L, 2L, 3L, LocalDate.now(), 100, "Description" );

    }

    @Test
    public void save_shouldPersistExpense_withAutoIncrementedId() throws Exception {
        // Given
        Expense firstPersist = expenseRepository.save(expense);
        Expense secondExpense = new Expense(4L, 5L, 6L, LocalDate.now(), 1000, "Description second expense" );;

        // When
        Expense secondPersit = expenseRepository.save(secondExpense);

        // Then
        assertThat(secondPersit.getId()).isEqualTo(firstPersist.getId() + 1);
    }

    @Test
    public void save_shouldThrowDataIntegrityViolationException_whenUserIdIsNull() {
        // Given
        expense.setUserId(null);

        // When
        Throwable throwable = catchThrowable(() -> expenseRepository.save(expense));

        // Then
        assertThat(throwable).isInstanceOf(DataIntegrityViolationException.class);
        assertThat(throwable).hasStackTraceContaining("user_id");
    }

    @Test
    public void save_shouldThrowDataIntegrityViolationException_whenCategoryIdIsNull() {
        // Given
        expense.setCategoryId(null);

        // When
        Throwable throwable = catchThrowable(() -> expenseRepository.save(expense));

        // Then
        assertThat(throwable).isInstanceOf(DataIntegrityViolationException.class);
        assertThat(throwable).hasStackTraceContaining("category_id");
    }

    @Test
    public void save_shouldThrowDataIntegrityViolationException_whenDateIsNull() {
        // Given
        expense.setDate(null);

        // When
        Throwable throwable = catchThrowable(() -> expenseRepository.save(expense));

        // Then
        assertThat(throwable).isInstanceOf(DataIntegrityViolationException.class);
        assertThat(throwable).hasStackTraceContaining("date");
    }

    @Test
    public void save_shouldThrowDataIntegrityViolationException_whenAmountIsNull() {
        // Given
        expense.setAmount(null);

        // When
        Throwable throwable = catchThrowable(() -> expenseRepository.save(expense));

        // Then
        assertThat(throwable).isInstanceOf(DataIntegrityViolationException.class);
        assertThat(throwable).hasStackTraceContaining("amount");
    }
}