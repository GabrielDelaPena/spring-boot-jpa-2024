package be.ordina.springdatajpa.school;

import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {

    public SchoolDto toSchoolDto(School school) {
        return new SchoolDto(school.getName());
    }

    public School toSchool(SchoolDto dto) {
        return School.builder()
                .name(dto.name())
                .build();
    }
}
