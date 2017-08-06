package org.acedrin.nirdecaaccounting.infrastructure.database.repositories;

import org.acedrin.nirdecaaccounting.domain.Expense;
import org.acedrin.nirdecaaccounting.domain.ExpenseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseJpaRepository extends JpaRepository<Expense, Long>, ExpenseRepository {
}
