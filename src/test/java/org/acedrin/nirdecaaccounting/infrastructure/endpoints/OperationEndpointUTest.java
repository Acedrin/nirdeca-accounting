package org.acedrin.nirdecaaccounting.infrastructure.endpoints;

import org.acedrin.nirdecaaccounting.domain.Operation;
import org.acedrin.nirdecaaccounting.infrastructure.endpoints.forms.CreateOperationForm;
import org.acedrin.nirdecaaccounting.usecase.CreateOperation;
import org.acedrin.nirdecaaccounting.usecase.GetAllOperations;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OperationEndpointUTest {

    @Mock
    private CreateOperation createOperation;

    @Mock
    private GetAllOperations getAllOperations;

    private OperationEndpoint operationEndpoint;
    private CreateOperationForm createOperationForm;

    @Before
    public void setUp() throws Exception {
        operationEndpoint = new OperationEndpoint(createOperation, getAllOperations);
        createOperationForm = new CreateOperationForm();
    }

    @Test
    public void createOperation_shouldReturnSavedOperation() throws Exception {
        // Given
        Operation expectedSavedOperation = new Operation();
        when(createOperation.create(any(Operation.class))).thenReturn(expectedSavedOperation);

        // When
        Operation result = operationEndpoint.createOperation(createOperationForm);

        // Then
        assertThat(result).isSameAs(expectedSavedOperation);
    }

    @Test
    public void getAllOperations_shouldReturnAllOperations() throws Exception {
        // Given
        List<Operation> operationList = new ArrayList<>();
        when(getAllOperations.findAllOperations()).thenReturn(operationList);

        // When
        List<Operation> result = operationEndpoint.getAllOperations();

        // Then
        assertThat(result).isSameAs(operationList);
    }
}