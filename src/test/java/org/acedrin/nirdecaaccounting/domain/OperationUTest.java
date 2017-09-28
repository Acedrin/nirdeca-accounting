package org.acedrin.nirdecaaccounting.domain;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class OperationUTest {
    private Operation operation;

    @Before
    public void setUp() throws Exception {
        operation = new Operation(1L, 2L, 3L, LocalDate.now(), 100, "Description" );
    }

    @Test
    public void prepareToSave_shouldThrowInvalidOperationException_whenUserIdIsNull() throws Exception {
        // Given
        operation.setUserId(null);

        // When
        Throwable throwable = catchThrowable(() -> operation.prepareToSave());

        // Then
        assertThat(throwable).isInstanceOf(InvalidOperationException.class);
        assertThat(throwable.getMessage()).isEqualTo("Missing userId");
    }

    @Test
    public void prepareToSave_shouldThrowInvalidOperationException_whenCategoryIdIsNull() throws Exception {
        // Given
        operation.setCategoryId(null);

        // When
        Throwable throwable = catchThrowable(() -> operation.prepareToSave());

        // Then
        assertThat(throwable).isInstanceOf(InvalidOperationException.class);
        assertThat(throwable.getMessage()).isEqualTo("Missing categoryId");
    }

    @Test
    public void prepareToSave_shouldThrowInvalidOperationException_whenDateIsNull() throws Exception {
        // Given
        operation.setDate(null);

        // When
        Throwable throwable = catchThrowable(() -> operation.prepareToSave());

        // Then
        assertThat(throwable).isInstanceOf(InvalidOperationException.class);
        assertThat(throwable.getMessage()).isEqualTo("Missing date");
    }

    @Test
    public void prepareToSave_shouldThrowInvalidOperationException_whenAmountIsNull() throws Exception {
        // Given
        operation.setAmount(null);

        // When
        Throwable throwable = catchThrowable(() -> operation.prepareToSave());

        // Then
        assertThat(throwable).isInstanceOf(InvalidOperationException.class);
        assertThat(throwable.getMessage()).isEqualTo("Missing amount");
    }
}