package org.acedrin.nirdecaaccounting.infrastructure.endpoints;

import org.acedrin.nirdecaaccounting.domain.Operation;
import org.acedrin.nirdecaaccounting.infrastructure.endpoints.forms.CreateOperationForm;
import org.acedrin.nirdecaaccounting.usecase.CreateOperation;
import org.acedrin.nirdecaaccounting.usecase.GetAllOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OperationEndpoint {

    private final CreateOperation createOperation;
    private final GetAllOperations getAllOperations;

    @Autowired
    public OperationEndpoint(CreateOperation createOperation, GetAllOperations getAllOperations) {
        this.createOperation = createOperation;
        this.getAllOperations = getAllOperations;
    }

    @PostMapping(value = "/api/operations", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Operation createOperation(@RequestBody CreateOperationForm createOperationForm) {
        return createOperation.create(createOperationForm.toOperation());
    }

    @RequestMapping(value = "/api/operations", produces = "application/json")
    public List<Operation> getAllOperations() {
        return getAllOperations.findAllOperations();
    }
}
