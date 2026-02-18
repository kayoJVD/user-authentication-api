package user.authentication.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record UserPutRequest(
        String name,
        @Email(message = "Email inválido")
        String email,
        @Size(min = 8, message = "Senha deve ter no mínimo 8 caracteres")
        String password
){}
