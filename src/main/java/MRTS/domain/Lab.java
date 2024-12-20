package MRTS.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="labs")
@Data
public class Lab extends AuditData{
    @Id
    @UuidGenerator
    private UUID labId;
    @Embedded
    private CommonDetails commonDetails;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
    private Address address;
}
