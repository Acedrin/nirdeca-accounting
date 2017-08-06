package org.acedrin.nirdecaaccounting.infrastructure.endpoints;

import org.acedrin.nirdecaaccounting.domain.Expense;
import org.acedrin.nirdecaaccounting.infrastructure.endpoints.forms.CreateExpenseForm;
import org.acedrin.nirdecaaccounting.usecase.CreateExpense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseEndpoint {
    private final CreateExpense createExpense;

    @Autowired
    public ExpenseEndpoint(CreateExpense createExpense) {
        this.createExpense = createExpense;
    }

    @PostMapping(value = "/api/expenses", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Expense createExpense(@RequestBody CreateExpenseForm createExpenseForm) {
        return createExpense.create(createExpenseForm.toExpense());
    }
}
