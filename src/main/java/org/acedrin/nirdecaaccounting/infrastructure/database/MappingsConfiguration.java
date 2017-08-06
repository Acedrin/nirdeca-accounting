package org.acedrin.nirdecaaccounting.infrastructure.database;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;

@Configuration
public class MappingsConfiguration extends HibernateJpaAutoConfiguration{

    public MappingsConfiguration(DataSource dataSource, JpaProperties jpaProperties, ObjectProvider<JtaTransactionManager> jtaTransactionManager, ObjectProvider<TransactionManagerCustomizers> transactionManagerCustomizers) {
        super(dataSource, jpaProperties, jtaTransactionManager, transactionManagerCustomizers);
    }

    @Override
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder factoryBuilder) {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = getSuperEntityManagerFactory(factoryBuilder);
        localContainerEntityManagerFactoryBean.setMappingResources(
                "db/mappings/user.xml",
                "db/mappings/expense.xml"
        );
        return localContainerEntityManagerFactoryBean;
    }

    LocalContainerEntityManagerFactoryBean getSuperEntityManagerFactory(EntityManagerFactoryBuilder factoryBuilder) {
        return super.entityManagerFactory(factoryBuilder);
    }
}