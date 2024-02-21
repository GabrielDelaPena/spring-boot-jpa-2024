package be.ordina.springdatajpa.studentprofile;

import be.ordina.springdatajpa.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfile {
    @Id
    @GeneratedValue
    private Integer id;
    private String bio;
    @OneToOne
    @JoinColumn(
            name = "student_id"
    )
    private Student student;
}
