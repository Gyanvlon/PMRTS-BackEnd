package MMS.inventory.repository;

import MMS.inventory.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
//    Optional<Doctor> findByEmail(String email);
}
