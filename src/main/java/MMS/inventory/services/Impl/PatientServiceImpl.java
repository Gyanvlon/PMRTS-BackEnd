package MMS.inventory.services.Impl;

import MMS.inventory.DTO.PatientDto;
import MMS.inventory.DTO.mapper.PatientMapper;
import MMS.inventory.Exception.ResourceNotFoundException;
import MMS.inventory.domain.Patient;
import MMS.inventory.repository.PatientRepository;
import MMS.inventory.services.PatientService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Override
    public PatientDto getPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + patientId));
        return patientMapper.toPatientDto(patient);
    }

//    @Override
//    public PatientDto getPatientByEmail(String email) {
//       Patient patient = patientRepository.findByEmail(email);
//         if(patient == null) {
//              throw new ResourceNotFoundException("Patient not found with email: " + email);
//         }
//        return patientMapper.toPatientDto(patient);
//    }

    @Override
    public PatientDto createPatient(PatientDto patient) {
        if(patient == null) {
            throw new ResourceNotFoundException("Patient cannot be null");
        }
        Patient patientToSave = patientMapper.toPatient(patient);
        return patientMapper.toPatientDto(patientRepository.save(patientToSave));
    }

    @Override
    public PatientDto updatePatientById(Long patientId, PatientDto patientDto) {
        Patient patientToUpdate = patientRepository.findById(patientId).orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + patientId));
        PatientDto patient = patientMapper.toPatientDto(patientToUpdate);
        patientToUpdate.getGeneralDetail().setName(patient.getPatientName());
        patientToUpdate.getGeneralDetail().setGender(patient.getPatientGender());
        patientToUpdate.getGeneralDetail().setEmail(patient.getPatientEmail());
        patientToUpdate.getGeneralDetail().setPhone(patient.getPatientPhone());
        patientToUpdate.setDob(patient.getPatientDob());
        return patientMapper.toPatientDto(patientRepository.save(patientToUpdate));
    }

    @Override
    public PatientDto patchPatientById(Long patientId, PatientDto patient) {
        Patient patientToUpdate = patientRepository.findById(patientId).orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + patientId));
        patientToUpdate.getGeneralDetail().setName(patient.getPatientName());
        patientToUpdate.getGeneralDetail().setGender(patient.getPatientGender());
        patientToUpdate.getGeneralDetail().setEmail(patient.getPatientEmail());
        patientToUpdate.getGeneralDetail().setPhone(patient.getPatientPhone());
        patientToUpdate.setDob(patient.getPatientDob());
        return patientMapper.toPatientDto(patientRepository.save(patientToUpdate));
    }

    @Override
    public void deletePatientById(Long patientId) {
        if(!patientRepository.existsById(patientId)) {
            throw new ResourceNotFoundException("Patient not found with id: " + patientId);
        }
        patientRepository.deleteById(patientId);
    }

    @Override
    public List<PatientDto> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(patientMapper::toPatientDto).toList();
    }
}
