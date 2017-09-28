package org.acedrin.nirdecaaccounting.usecase;

import org.acedrin.nirdecaaccounting.domain.Operation;
import org.acedrin.nirdecaaccounting.domain.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllOperations {

    private OperationRepository operationRepository;

    @Autowired
    public GetAllOperations(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public List<Operation> findAllOperations() {
        return operationRepository.findAll();
    }
}
