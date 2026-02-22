package user.authentication.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import user.authentication.Mapper.UserMapper;
import user.authentication.dto.response.UserGetResponse;
import user.authentication.dto.request.UserPostRequest;
import user.authentication.dto.response.UserPostResponse;
import user.authentication.dto.request.UserPutRequest;
import user.authentication.entity.User;
import user.authentication.service.UserService;

import java.util.List;

@RestController
@RequestMapping("v1/users")
@Slf4j
@RequiredArgsConstructor
public class UserControler {
    private final UserMapper mapper;
    private final UserService service;

    @GetMapping
    public ResponseEntity<List<UserGetResponse>> findAllByEmail(@RequestParam(required = false) String email) {
        log.debug("Request receveid to list all users, param email: {}", email);

        List<User> users = service.findByEmail(email);

        List<UserGetResponse> userGetResponseList = mapper.toUserGetResponseList(users);

        return ResponseEntity.ok(userGetResponseList);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<UserGetResponse> findById(@PathVariable long id) {
        log.debug("Request receveid to find user by id {}", id);

        User users = service.findByIdOrThrowNotFound(id);

        UserGetResponse userGetResponse = mapper.toUserGetResponse(users);

        return ResponseEntity.ok((userGetResponse));
    }

    @PostMapping()
    public ResponseEntity<UserPostResponse> registerUser(@RequestBody @Valid UserPostRequest userPostRequest) {
        log.debug("Request receveid to save user {}", userPostRequest);
        User user = mapper.toUser(userPostRequest);

        User userSave = service.save(user);

        UserPostResponse response = mapper.toUserPostResponse(userSave);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.debug("Request receveid to delete user by id {}", id);

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid UserPutRequest userPutRequest) {
        log.debug("Request receveid to update user {}", userPutRequest);

        User request = mapper.toUser(userPutRequest);

        service.update(request);

        return ResponseEntity.noContent().build();
    }
}
