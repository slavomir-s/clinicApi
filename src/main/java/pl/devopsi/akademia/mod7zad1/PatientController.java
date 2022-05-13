package pl.devopsi.akademia.mod7zad1;

import org.hibernate.validator.constraints.pl.PESEL;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/patients")
public class PatientController {
    private PatientService patientService;


    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<Void> addPatient(@RequestBody @Valid Patient patient){
        if(patientService.registerPatient(patient))
            return ResponseEntity.status(HttpStatus.CREATED).build();
        else
            return ResponseEntity.status(HttpStatus.CONFLICT).build();

    }
    @GetMapping
    public ResponseEntity<List<PatientGetDto>> getPatients(){
        List<PatientGetDto> patients = patientService.getPatients();
        return ResponseEntity.status(HttpStatus.OK).body(patients);
    }
    @GetMapping("/{pesel}")
    public ResponseEntity<Patient> getPatient(@PathVariable @PESEL String pesel){
        Patient patient = patientService.getPatient(pesel);
        if(patient==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).body(patient);
    }
    @PutMapping("/{pesel}")
    public ResponseEntity<Patient> updatePatient(@PathVariable @PESEL String pesel,@RequestBody PatientPutDto patientData){
        Patient patient = patientService.updatePatient(pesel,patientData);
        if(patient==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).body(patient);
    }
    @DeleteMapping("/{pesel}")
    public ResponseEntity<Void> deletePatient(@PathVariable @PESEL String pesel){
        if (patientService.deletePatient(pesel)!=null)
            return ResponseEntity.status(HttpStatus.OK).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
