package org.acedrin.nirdecaaccounting.infrastructure.endpoints;

import org.acedrin.nirdecaaccounting.domain.Operation;
import org.acedrin.nirdecaaccounting.infrastructure.endpoints.forms.CreateOperationForm;
import org.acedrin.nirdecaaccounting.usecase.CreateOperation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OperationEndpointUTest {

    @Mock
    private CreateOperation createOperation;

    private OperationEndpoint operationEndpoint;
    private CreateOperationForm createOperationForm;

    @Before
    public void setUp() throws Exception {
        operationEndpoint = new OperationEndpoint(createOperation);
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
}