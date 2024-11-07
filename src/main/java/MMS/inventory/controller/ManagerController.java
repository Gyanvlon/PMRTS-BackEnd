package MMS.inventory.controller;
import MMS.inventory.DTO.ManagerDto;
import MMS.inventory.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/managers")
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @PostMapping
    public ResponseEntity<ManagerDto> createManager(@RequestBody ManagerDto manager) {
        return new ResponseEntity<>(managerService.createManager(manager), HttpStatus.CREATED);
    }
    @GetMapping("/{managerId}")
    public ResponseEntity<ManagerDto> getManager(@RequestParam  Long managerId) {
        return new ResponseEntity<>(managerService.getManager(managerId), HttpStatus.OK);
    }
    @GetMapping("/{email}")
    public ResponseEntity<ManagerDto> getManagerByEmail(String email) {
        return new ResponseEntity<>(managerService.getManagerByEmail(email), HttpStatus.OK);
    }
    @PutMapping("/{managerId}")
    public ResponseEntity<ManagerDto> updateManagerById(@PathVariable Long managerId, @RequestBody ManagerDto manager) {
        return new ResponseEntity<>(managerService.updateManagerById(managerId, manager), HttpStatus.OK);
    }
    @DeleteMapping("/{managerId}")
    public ResponseEntity<String> deleteManagerById(@PathVariable Long managerId) {
        managerService.deleteManagerById(managerId);
        return new ResponseEntity<>("Manager with id " + managerId + " deleted successfully", HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<ManagerDto>> getAllManagers() {
        return new ResponseEntity<>(managerService.getAllManagers(), HttpStatus.OK);
    }
}
