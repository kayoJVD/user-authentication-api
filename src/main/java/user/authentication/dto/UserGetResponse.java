package user.authentication.dto;

public record UserGetResponse(
        Long id,
        String name,
        String email
){ }
