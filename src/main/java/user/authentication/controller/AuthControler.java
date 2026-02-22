package user.authentication.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import user.authentication.Mapper.AuthMapper;
import user.authentication.dto.request.LoginRequest;
import user.authentication.dto.response.LoginResponse;
import user.authentication.entity.User;
import user.authentication.repository.UserRepository;
import user.authentication.service.AuthService;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthControler {
    private final AuthService service;
    private final AuthMapper mapper;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest){
        User user =  service.authenticate(loginRequest.email(),  loginRequest.password());

        return ResponseEntity.ok(mapper.toUserLoginResponse(user));
    }


}
