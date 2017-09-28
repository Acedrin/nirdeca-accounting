package org.acedrin.nirdecaaccounting.usecase;

import org.acedrin.nirdecaaccounting.domain.Operation;
import org.acedrin.nirdecaaccounting.domain.OperationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetAllOperationsUTest {

    @Mock
    private OperationRepository operationRepository;

    private GetAllOperations getAllOperations;

    @Before
    public void setUp() throws Exception {
        getAllOperations = new GetAllOperations(operationRepository);
    }

    @Test
    public void findAllOperations_shouldReturnAllOperations() throws Exception {
        // Given
        List<Operation> operationList = new ArrayList<>();
        when(operationRepository.findAll()).thenReturn(operationList);

        // When
        List<Operation> result = getAllOperations.findAllOperations();

        // Then
        assertThat(result).isSameAs(operationList);
    }
}