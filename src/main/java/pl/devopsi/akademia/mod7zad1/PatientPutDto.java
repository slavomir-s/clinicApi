package pl.devopsi.akademia.mod7zad1;

import lombok.Data;
import org.hibernate.validator.constraints.pl.PESEL;
import pl.devopsi.akademia.mod7zad1.customvalidator.PhoneNumber;

import javax.validation.constraints.NotEmpty;
@Data
public class PatientPutDto {
    @NotEmpty(message = "Pole imię nie może być puste.")
    private String name;
    @NotEmpty(message = "Pole nazwisko nie może być puste.")
    private String surname;
    private String notes;
    @PhoneNumber(localization = "PL")
    private String phoneNumber;
}
