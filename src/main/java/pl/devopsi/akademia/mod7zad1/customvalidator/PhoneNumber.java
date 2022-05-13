package pl.devopsi.akademia.mod7zad1.customvalidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = PhoneNumberValidator.class)
public @interface PhoneNumber {
    String message() default "Nieprawidłowy format numeru telefonu dla lokalizacji '{localization}'.";
    String localization() default "PL";//domyślny kod lokalizacji potrzebny do ustalenia struktury numeru telefonu
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
