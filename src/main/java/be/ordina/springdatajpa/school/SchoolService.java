package be.ordina.springdatajpa.school;

import be.ordina.springdatajpa.school.SchoolDto;
import be.ordina.springdatajpa.school.SchoolMapper;
import be.ordina.springdatajpa.school.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private final SchoolMapper schoolMapper;
    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolMapper schoolMapper, SchoolRepository schoolRepository) {
        this.schoolMapper = schoolMapper;
        this.schoolRepository = schoolRepository;
    }

    public SchoolDto createSchool(SchoolDto schoolDto) {
        var school = schoolMapper.toSchool(schoolDto);
        schoolRepository.save(school);
        return schoolDto;
    }

    /**
     * findAll() will return the list of school.
     * Transform the list of school to Stream of School.
     * Map each School on the Stream and call toSchoolDto() to transfer each School to SchoolDto and return the Stream of SchoolDto. (this => current Class)
     * Transform the Stream of SchoolDto to a list and return it.
     **/

    public List<SchoolDto> findAllSchool() {
        return schoolRepository.findAll()
                .stream()
                .map(schoolMapper::toSchoolDto)
                .collect(Collectors.toList()
                );
    }
}
