package user.authentication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import user.authentication.ExceptionGlobal.AuthenticationException;
import user.authentication.entity.User;
import user.authentication.repository.UserRepository;


@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    public User authenticate(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new AuthenticationException("Senha incorreta"));

        if (!user.getPassword().equals(password)) {
            throw new AuthenticationException("Senha incorreta");
        }
        return user;
    }
}
