package org.example.generator;

import org.hibernate.annotations.IdGeneratorType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IdGeneratorType(PassportGenerator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface PassportGen {
}
