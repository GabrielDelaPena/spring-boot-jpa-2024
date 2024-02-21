package be.ordina.springdatajpa.school;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/schools")
    public ResponseEntity<SchoolDto> create(
            @RequestBody SchoolDto schoolDto
    ) {
        return ResponseEntity.ok(schoolService.createSchool(schoolDto));
    }

    @GetMapping("/schools")
    public ResponseEntity<List<SchoolDto>> findAll() {
        return ResponseEntity.ok(schoolService.findAllSchool());
    }
}
