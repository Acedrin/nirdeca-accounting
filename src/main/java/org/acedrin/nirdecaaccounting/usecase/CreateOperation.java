package org.acedrin.nirdecaaccounting.usecase;

import org.acedrin.nirdecaaccounting.domain.Operation;
import org.acedrin.nirdecaaccounting.domain.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateOperation {

    private OperationRepository operationRepository;

    @Autowired
    public CreateOperation(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public Operation create(Operation operation) {
        operation.prepareToSave();
        return operationRepository.save(operation);
    }
}
