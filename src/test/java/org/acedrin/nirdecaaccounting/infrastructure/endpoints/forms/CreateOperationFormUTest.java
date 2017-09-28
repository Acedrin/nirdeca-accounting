package org.acedrin.nirdecaaccounting.infrastructure.endpoints.forms;

import org.acedrin.nirdecaaccounting.domain.Operation;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateOperationFormUTest {

    private static final Long USER_ID = 1L;
    private static final Long CATEGORY_ID = 2L;
    private static final Long TAG_ID = 3L;
    private static final String DATE = "10/10/2015";
    private static final Integer AMOUNT = 100;
    private static final String DESCRIPTION = "Operation description";

    @Test
    public void toOperation_shouldConvertFormToOperation() throws Exception {
        // Given
        CreateOperationForm createOperationForm = new CreateOperationForm();
        createOperationForm.userId = USER_ID;
        createOperationForm.categoryId = CATEGORY_ID;
        createOperationForm.tagId = TAG_ID;
        createOperationForm.date = DATE;
        createOperationForm.amount = AMOUNT;
        createOperationForm.description = DESCRIPTION;

        // When
        Operation operation = createOperationForm.toOperation();

        // Then
        assertThat(operation.getUserId()).isEqualTo(USER_ID);
        assertThat(operation.getCategoryId()).isEqualTo(CATEGORY_ID);
        assertThat(operation.getTagId()).isEqualTo(TAG_ID);
        assertThat(operation.getDate()).isEqualTo(LocalDate.parse(DATE, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        assertThat(operation.getAmount()).isEqualTo(AMOUNT);
        assertThat(operation.getDescription()).isEqualTo(DESCRIPTION);
    }
}