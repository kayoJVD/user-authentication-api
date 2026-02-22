package user.authentication.dto.response;

public record UserGetResponse(
        Long id,
        String name,
        String email
){ }
