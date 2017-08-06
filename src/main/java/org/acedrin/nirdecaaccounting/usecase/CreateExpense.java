package org.acedrin.nirdecaaccounting.usecase;

import org.acedrin.nirdecaaccounting.domain.Expense;
import org.acedrin.nirdecaaccounting.domain.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateExpense {

    private ExpenseRepository expenseRepository;

    @Autowired
    public CreateExpense(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense create(Expense expense) {
        expense.prepareToSave();
        return expenseRepository.save(expense);
    }
}
