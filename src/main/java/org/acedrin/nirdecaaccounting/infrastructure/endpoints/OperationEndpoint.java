package org.acedrin.nirdecaaccounting.infrastructure.endpoints;

import org.acedrin.nirdecaaccounting.domain.Operation;
import org.acedrin.nirdecaaccounting.infrastructure.endpoints.forms.CreateOperationForm;
import org.acedrin.nirdecaaccounting.usecase.CreateOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationEndpoint {
    private final CreateOperation createOperation;

    @Autowired
    public OperationEndpoint(CreateOperation createOperation) {
        this.createOperation = createOperation;
    }

    @PostMapping(value = "/api/operations", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Operation createOperation(@RequestBody CreateOperationForm createOperationForm) {
        return createOperation.create(createOperationForm.toOperation());
    }
}
