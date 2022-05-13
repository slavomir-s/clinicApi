package pl.devopsi.akademia.mod7zad1;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientGetDto map(Patient patient);
    Patient map(PatientPutDto patientPutDto,String pesel);
}
