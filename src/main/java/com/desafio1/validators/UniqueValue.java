package com.desafio1.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Essa anotação deve ser aplicada somente no contexto do Springboot, ou seja, nas classes DTO's,
 * pois se for feita direto no DAO(contexto do Hibernate) tomaremos um Nullpointer, pois o entity manager não será injetado.
 */
@Documented
@Constraint(validatedBy = {UniqueValueValidator.class}) // Classe que executara a validacao
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {

    final String DEFAULT_MESSAGE = "O valor informado já foi utilizado.";

    // Os atributos message, default e groups sao obrigatorios
    // Menssagem default quando a validacao falhar
    String message() default DEFAULT_MESSAGE;

    // Serve para aplicar uma validacao para um grupo especifico
    Class<?>[] groups () default {};

    Class<? extends Payload>[] payload() default {};

    String fieldName();

    Class<?> domainClass();

}
