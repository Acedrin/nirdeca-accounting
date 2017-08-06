package org.acedrin.nirdecaaccounting.infrastructure.endpoints;

import org.acedrin.nirdecaaccounting.domain.Expense;
import org.acedrin.nirdecaaccounting.infrastructure.endpoints.forms.CreateExpenseForm;
import org.acedrin.nirdecaaccounting.usecase.CreateExpense;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ExpenseEndpointUTest {

    @Mock
    private CreateExpense createExpense;

    private ExpenseEndpoint expenseEndpoint;
    private CreateExpenseForm createExpenseForm;

    @Before
    public void setUp() throws Exception {
        expenseEndpoint = new ExpenseEndpoint(createExpense);
        createExpenseForm = new CreateExpenseForm();
    }

    @Test
    public void createExpense_shouldReturnSavedExpense() throws Exception {
        // Given
        Expense expectedSavedExpense = new Expense();
        when(createExpense.create(any(Expense.class))).thenReturn(expectedSavedExpense);

        // When
        Expense result = expenseEndpoint.createExpense(createExpenseForm);

        // Then
        assertThat(result).isSameAs(expectedSavedExpense);
    }
}