package org.acedrin.nirdecaaccounting.infrastructure.database.repositories;

import org.acedrin.nirdecaaccounting.domain.Operation;
import org.acedrin.nirdecaaccounting.domain.OperationRepository;
import org.acedrin.nirdecaaccounting.infrastructure.database.MappingsConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(MappingsConfiguration.class)
public class OperationJpaRepositoryIntTest {

    @Autowired
    private OperationRepository operationRepository;

    private Operation operation;

    @Before
    public void setUp() throws Exception {
        operation = new Operation(1L, 2L, 3L, LocalDate.now(), 100, "Description" );

    }

    @Test
    public void save_shouldPersistOperation_withAutoIncrementedId() throws Exception {
        // Given
        Operation firstPersist = operationRepository.save(operation);
        Operation secondOperation = new Operation(4L, 5L, 6L, LocalDate.now(), 1000, "Description second operation" );;

        // When
        Operation secondPersit = operationRepository.save(secondOperation);

        // Then
        assertThat(secondPersit.getId()).isEqualTo(firstPersist.getId() + 1);
    }

    @Test
    public void save_shouldThrowDataIntegrityViolationException_whenUserIdIsNull() {
        // Given
        operation.setUserId(null);

        // When
        Throwable throwable = catchThrowable(() -> operationRepository.save(operation));

        // Then
        assertThat(throwable).isInstanceOf(DataIntegrityViolationException.class);
        assertThat(throwable).hasStackTraceContaining("user_id");
    }

    @Test
    public void save_shouldThrowDataIntegrityViolationException_whenCategoryIdIsNull() {
        // Given
        operation.setCategoryId(null);

        // When
        Throwable throwable = catchThrowable(() -> operationRepository.save(operation));

        // Then
        assertThat(throwable).isInstanceOf(DataIntegrityViolationException.class);
        assertThat(throwable).hasStackTraceContaining("category_id");
    }

    @Test
    public void save_shouldThrowDataIntegrityViolationException_whenDateIsNull() {
        // Given
        operation.setDate(null);

        // When
        Throwable throwable = catchThrowable(() -> operationRepository.save(operation));

        // Then
        assertThat(throwable).isInstanceOf(DataIntegrityViolationException.class);
        assertThat(throwable).hasStackTraceContaining("date");
    }

    @Test
    public void save_shouldThrowDataIntegrityViolationException_whenAmountIsNull() {
        // Given
        operation.setAmount(null);

        // When
        Throwable throwable = catchThrowable(() -> operationRepository.save(operation));

        // Then
        assertThat(throwable).isInstanceOf(DataIntegrityViolationException.class);
        assertThat(throwable).hasStackTraceContaining("amount");
    }
}