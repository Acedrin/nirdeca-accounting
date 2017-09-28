package org.acedrin.nirdecaaccounting.infrastructure.endpoints.forms;

import org.acedrin.nirdecaaccounting.domain.Operation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CreateOperationForm {
    public Long userId;
    public Long categoryId;
    public Long tagId;
    public String date;
    public Integer amount;
    public String description;

    public Operation toOperation() {
        Operation operation = new Operation();
        operation.setUserId(userId);
        operation.setCategoryId(categoryId);
        operation.setTagId(tagId);
        operation.setAmount(amount);
        operation.setDescription(description);

        if (date != null )
            operation.setDate(LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        return operation;
    }
}
