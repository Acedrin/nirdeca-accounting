package org.acedrin.nirdecaaccounting.domain;

import java.util.List;

public interface OperationRepository {

    Operation save(Operation operation);

    List<Operation> findAll();

}
