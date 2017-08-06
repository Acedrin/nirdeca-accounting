package org.acedrin.nirdecaaccounting.infrastructure.endpoints.forms;

import org.acedrin.nirdecaaccounting.domain.Expense;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CreateExpenseForm {
    public Long userId;
    public Long categoryId;
    public Long tagId;
    public String date;
    public Integer amount;
    public String description;

    public Expense toExpense() {
        Expense expense = new Expense();
        expense.setUserId(userId);
        expense.setCategoryId(categoryId);
        expense.setTagId(tagId);
        expense.setAmount(amount);
        expense.setDescription(description);

        if (date != null )
            expense.setDate(LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        return expense;
    }
}
