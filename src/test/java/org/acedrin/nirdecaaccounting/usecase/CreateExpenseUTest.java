package org.acedrin.nirdecaaccounting.usecase;

import org.acedrin.nirdecaaccounting.domain.Expense;
import org.acedrin.nirdecaaccounting.domain.ExpenseRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateExpenseUTest {

    @Mock
    private ExpenseRepository expenseRepository;

    private CreateExpense createExpense;
    private Expense expense;

    @Before
    public void setUp() throws Exception {
        createExpense = new CreateExpense(expenseRepository);
        expense = new Expense(1L, 2L, 3L, LocalDate.now(), 100, "Description" );
    }

    @Test
    public void create_shouldPrepareToSaveExpense() throws Exception {
        // Given
        expense = mock(Expense.class);

        // When
        createExpense.create(expense);

        // Then
        verify(expense).prepareToSave();
    }

    @Test
    public void create_shouldSaveExpense() throws Exception {
        // When
        createExpense.create(expense);

        // Then
        verify(expenseRepository).save(expense);
    }

    @Test
    public void create_shouldReturnSavedExpense() throws Exception {
        // Given
        Expense expectedExpense = new Expense();
        when(expenseRepository.save(expense)).thenReturn(expectedExpense);

        // When
        Expense savedExpense = createExpense.create(expense);

        // Then
        assertThat(savedExpense).isSameAs(expectedExpense);
    }
}