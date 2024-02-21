package be.ordina.springdatajpa.student;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student")
    public ResponseEntity<StudentResponseDto> post(
            @Valid @RequestBody StudentDto studentDto
    ) {
        return ResponseEntity.ok(studentService.saveStudent(studentDto));
    }

    @GetMapping("/student")
    public ResponseEntity<List<StudentResponseDto>> findAllStudents() {
        return ResponseEntity.ok(studentService.findAllStudents());
    }

    @GetMapping("/student/{student-id}")
    public ResponseEntity<StudentResponseDto> findStudentById(
            @PathVariable("student-id") Integer id
    ) {
        return ResponseEntity.ok(studentService.findStudentById(id));
    }

    @GetMapping("/student/search/{student-name}")
    public ResponseEntity<List<StudentResponseDto>> findStudentByName(
            @PathVariable("student-name") String name
    ) {
        return ResponseEntity.ok(studentService.findStudentByName(name));
    }

    @DeleteMapping("/student/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("student-id") Integer id
    ) {
        studentService.deleteStudent(id);
    }

    /**
     * Each time the application throws a MethodArgumentNotValidException, we return this.
     **/
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp
    ) {
        var errors = new HashMap<String, String>();
        exp.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
