package user.authentication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import user.authentication.ExceptionGlobal.ResourceNotFoundException;
import user.authentication.entity.User;
import user.authentication.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public List<User> findAll(String name) {
        return name == null ? repository.findAll() : repository.findByName(name);
    }

    public List<User> findByEmail(String email) {
        return email == null ? repository.findAll() : repository.findAllByEmail(email);
    }

    public User save(User user) {
        return repository.save(user);
    }

    public User findByIdOrThrowNotFound(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not Found"));
    }

    public void delete(Long id) {
        User user = findByIdOrThrowNotFound(id);
        repository.delete(user);
    }

    public void update(User user) {
        assertUser(user.getId());
        repository.save(user);
    }
    public void assertUser(Long id) {
        findByIdOrThrowNotFound(id);
    }
}
