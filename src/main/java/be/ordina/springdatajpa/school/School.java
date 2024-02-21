package be.ordina.springdatajpa.school;

import be.ordina.springdatajpa.student.Student;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class School {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @OneToMany(
            mappedBy = "school"
    )
    @JsonManagedReference
    private List<Student> students;
}
