package be.ordina.springdatajpa.student;

public record StudentResponseDto(
        String firstname,
        String lastname,
        String email
) {
}
