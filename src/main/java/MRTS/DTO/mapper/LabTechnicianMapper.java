package MRTS.DTO.mapper;

import MRTS.DTO.LabTechnicianDto;
import MRTS.domain.LabTechnician;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class LabTechnicianMapper {
    private final AddressMapper addressMapper;
    public LabTechnicianDto toLabTechnicianDto(LabTechnician labTechnician) {
        LabTechnicianDto labTechnicianDto = new LabTechnicianDto();
        labTechnicianDto.setLabTechnicianId(labTechnician.getLabTechnicianId());
        labTechnicianDto.setLabTechnicianName(labTechnician.getGeneralDetail().getName());
        labTechnicianDto.setLabTechnicianEmail(labTechnician.getGeneralDetail().getEmail());
        labTechnicianDto.setLabTechnicianPhone(labTechnician.getGeneralDetail().getPhone());
        labTechnicianDto.setLabTechnicianGender(labTechnician.getGeneralDetail().getGender());
        labTechnicianDto.setLabTechnicianQualification(labTechnician.getLabTechnicianQualification());
        labTechnicianDto.setLabTechnicianExperience(labTechnician.getLabTechnicianExperience());
        labTechnicianDto.setLabTechnicianLicense(labTechnician.getLabTechnicianLicense());
        labTechnicianDto.setLabTechnicianId(labTechnician.getLabTechnicianId());
        labTechnicianDto.setLabTechnicianAddress(addressMapper.toAddressDto(labTechnician.getAddress()));
        return labTechnicianDto;
    }
    public LabTechnician toLabTechnician(LabTechnicianDto labTechnicianDto) {
        LabTechnician labTechnician = new LabTechnician();
        labTechnician.getGeneralDetail().setName(labTechnicianDto.getLabTechnicianName());
        labTechnician.getGeneralDetail().setEmail(labTechnicianDto.getLabTechnicianEmail());
        labTechnician.getGeneralDetail().setPhone(labTechnicianDto.getLabTechnicianPhone());
        labTechnician.getGeneralDetail().setGender(labTechnicianDto.getLabTechnicianGender());
        labTechnician.setLabTechnicianQualification(labTechnicianDto.getLabTechnicianQualification());
        labTechnician.setLabTechnicianExperience(labTechnicianDto.getLabTechnicianExperience());
        labTechnician.setLabTechnicianLicense(labTechnicianDto.getLabTechnicianLicense());
        labTechnician.setLabTechnicianId(labTechnicianDto.getLabTechnicianId());
        labTechnician.setAddress(addressMapper.toAddress(labTechnicianDto.getLabTechnicianAddress()));
        return labTechnician;
    }
}
