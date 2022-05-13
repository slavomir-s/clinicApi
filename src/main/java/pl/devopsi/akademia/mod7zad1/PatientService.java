package pl.devopsi.akademia.mod7zad1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PatientService {
    private final Map<String,Patient> patientList;
    private final PatientMapper patientMapper;

    public PatientService(PatientMapper patientMapper) {

        this.patientList = new HashMap<String,Patient>();
        this.patientMapper = patientMapper;
    }

    public Boolean registerPatient(Patient patient){
        if(!patientList.containsKey(patient.getPesel())){
            patientList.put(patient.getPesel(),patient);
            System.out.println("Dodano pacjenta \n" + patient.toString() );
            return true;

        }
        return false;
    }
    public Patient deletePatient(String pesel){
        Patient deletedPatient = patientList.remove(pesel);
        if(deletedPatient!=null) {
            System.out.println("Usunieto pacjenta: \n" + deletedPatient.toString());
            return deletedPatient;
        }
        return null;
    }
    public Patient updatePatient(String pesel,PatientPutDto patientPutDto){
        //if(patientList.containsKey(pesel)){
            return patientList.put(pesel,patientMapper.map(patientPutDto,pesel));
        //}else return null;
    }
    public List<PatientGetDto> getPatients(){
        List<Patient> patients = new ArrayList<>(patientList.values());
        List<PatientGetDto> patientsDto = new ArrayList<PatientGetDto>();
        for(int i =0;i<patients.size();i++)
            patientsDto.add(patientMapper.map(patients.get(i)));
        return patientsDto;
    }

    public Patient getPatient(String pesel) {
        if(patientList.containsKey(pesel))
            return patientList.get(pesel);
        else
            return null;
    }

}
