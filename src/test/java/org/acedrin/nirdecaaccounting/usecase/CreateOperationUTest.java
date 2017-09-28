package org.acedrin.nirdecaaccounting.usecase;

import org.acedrin.nirdecaaccounting.domain.Operation;
import org.acedrin.nirdecaaccounting.domain.OperationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateOperationUTest {

    @Mock
    private OperationRepository operationRepository;

    private CreateOperation createOperation;
    private Operation operation;

    @Before
    public void setUp() throws Exception {
        createOperation = new CreateOperation(operationRepository);
        operation = new Operation(1L, 2L, 3L, LocalDate.now(), 100, "Description" );
    }

    @Test
    public void create_shouldPrepareToSaveOperation() throws Exception {
        // Given
        operation = mock(Operation.class);

        // When
        createOperation.create(operation);

        // Then
        verify(operation).prepareToSave();
    }

    @Test
    public void create_shouldSaveOperation() throws Exception {
        // When
        createOperation.create(operation);

        // Then
        verify(operationRepository).save(operation);
    }

    @Test
    public void create_shouldReturnSavedOperation() throws Exception {
        // Given
        Operation expectedOperation = new Operation();
        when(operationRepository.save(operation)).thenReturn(expectedOperation);

        // When
        Operation savedOperation = createOperation.create(operation);

        // Then
        assertThat(savedOperation).isSameAs(expectedOperation);
    }
}