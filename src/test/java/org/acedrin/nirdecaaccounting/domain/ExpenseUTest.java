package org.acedrin.nirdecaaccounting.domain;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class ExpenseUTest {
    private Expense expense;

    @Before
    public void setUp() throws Exception {
        expense = new Expense(1L, 2L, 3L, LocalDate.now(), 100, "Description" );
    }

    @Test
    public void prepareToSave_shouldThrowInvalidExpenseException_whenUserIdIsNull() throws Exception {
        // Given
        expense.setUserId(null);

        // When
        Throwable throwable = catchThrowable(() -> expense.prepareToSave());

        // Then
        assertThat(throwable).isInstanceOf(InvalidExpenseException.class);
        assertThat(throwable.getMessage()).isEqualTo("Missing userId");
    }

    @Test
    public void prepareToSave_shouldThrowInvalidExpenseException_whenCategoryIdIsNull() throws Exception {
        // Given
        expense.setCategoryId(null);

        // When
        Throwable throwable = catchThrowable(() -> expense.prepareToSave());

        // Then
        assertThat(throwable).isInstanceOf(InvalidExpenseException.class);
        assertThat(throwable.getMessage()).isEqualTo("Missing categoryId");
    }

    @Test
    public void prepareToSave_shouldThrowInvalidExpenseException_whenDateIsNull() throws Exception {
        // Given
        expense.setDate(null);

        // When
        Throwable throwable = catchThrowable(() -> expense.prepareToSave());

        // Then
        assertThat(throwable).isInstanceOf(InvalidExpenseException.class);
        assertThat(throwable.getMessage()).isEqualTo("Missing date");
    }

    @Test
    public void prepareToSave_shouldThrowInvalidExpenseException_whenAmountIsNull() throws Exception {
        // Given
        expense.setAmount(null);

        // When
        Throwable throwable = catchThrowable(() -> expense.prepareToSave());

        // Then
        assertThat(throwable).isInstanceOf(InvalidExpenseException.class);
        assertThat(throwable.getMessage()).isEqualTo("Missing amount");
    }
}