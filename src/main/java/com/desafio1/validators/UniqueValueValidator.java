package com.desafio1.validators;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * Essa anotação deve ser aplicada somente no contexto do Springboot, ou seja, nas classes DTO's,
 * pois se for feita direto no DAO(contexto do Hibernate) tomaremos um Nullpointer, pois o entity manager não será injetado.
 */
public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

    private String domainAttribute;
    private Class<?> klass;
    @PersistenceContext
    private EntityManager manager;

    // Metodo chamado na criacao do objeto que faz a validacao
    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        domainAttribute = constraintAnnotation.fieldName();
        klass = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = manager.createQuery("select 1 from " + klass.getName() + " where "
                + domainAttribute + "=:value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();
        // Se existir mais de um valor(que e o maximo possivel), sera lancada uma excessao pq o estado do sistema esta corrompido
        Assert.state(
                list.size() <= 1, " Foi encontrado mais de um " + klass + "com o atributo "
        + domainAttribute + " = " + value);
        return list.isEmpty();
    }

}
