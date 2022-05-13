package pl.devopsi.akademia.mod7zad1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.PESEL;
import pl.devopsi.akademia.mod7zad1.customvalidator.PhoneNumber;

import javax.validation.constraints.NotEmpty;


@Setter
@Getter
@AllArgsConstructor

public class Patient {
    @NotEmpty(message = "Pole imię nie może być puste.")
    private String name;
    @NotEmpty(message = "Pole nazwisko nie może być puste.")
    private String surname;
    private String notes;
    @PhoneNumber(localization = "PL")
    private String phoneNumber;
    @PESEL(message = "Wprowadzony numer PESEL jest nieprawidłowy.")
    private String pesel;

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", notes='" + notes + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }
}
