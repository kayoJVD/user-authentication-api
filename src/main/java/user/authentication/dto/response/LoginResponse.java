package user.authentication.dto.response;

public record LoginResponse(
        Long id,
        String name,
        String email
) {
}
