package pl.devopsi.akademia.mod7zad1;

import lombok.Data;

@Data
public class PatientGetDto {
    private String name;
    private String surname;
    private String pesel;
}
