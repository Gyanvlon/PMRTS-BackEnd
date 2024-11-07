package MMS.inventory.DTO;

import MMS.inventory.model.Address;
import jakarta.persistence.Embedded;
import lombok.Data;

import java.util.Date;
@Data
public class PatientDto {
    private String patientName;
    private String patientEmail;
    private String patientPhone;
    private String patientGender;
    private Date patientDob;
    @Embedded
    private Address address;
}