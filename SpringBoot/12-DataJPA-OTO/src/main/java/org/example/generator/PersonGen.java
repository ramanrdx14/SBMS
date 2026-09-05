package org.example.generator;

import org.hibernate.annotations.IdGeneratorType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@IdGeneratorType(PersonGenerator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface PersonGen {
}
