package org.acedrin.nirdecaaccounting.infrastructure.endpoints.forms;

import org.acedrin.nirdecaaccounting.domain.Expense;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateExpenseFormUTest {

    private static final Long USER_ID = 1L;
    private static final Long CATEGORY_ID = 2L;
    private static final Long TAG_ID = 3L;
    private static final String DATE = "10/10/2015";
    private static final Integer AMOUNT = 100;
    private static final String DESCRIPTION = "Expense description";

    @Test
    public void toExpense_shouldConvertFormToExpense() throws Exception {
        // Given
        CreateExpenseForm createExpenseForm = new CreateExpenseForm();
        createExpenseForm.userId = USER_ID;
        createExpenseForm.categoryId = CATEGORY_ID;
        createExpenseForm.tagId = TAG_ID;
        createExpenseForm.date = DATE;
        createExpenseForm.amount = AMOUNT;
        createExpenseForm.description = DESCRIPTION;

        // When
        Expense expense = createExpenseForm.toExpense();

        // Then
        assertThat(expense.getUserId()).isEqualTo(USER_ID);
        assertThat(expense.getCategoryId()).isEqualTo(CATEGORY_ID);
        assertThat(expense.getTagId()).isEqualTo(TAG_ID);
        assertThat(expense.getDate()).isEqualTo(LocalDate.parse(DATE, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        assertThat(expense.getAmount()).isEqualTo(AMOUNT);
        assertThat(expense.getDescription()).isEqualTo(DESCRIPTION);
    }
}