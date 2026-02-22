    package user.authentication.repository;

    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;
    import user.authentication.entity.User;

    import java.util.List;
    import java.util.Optional;

    @Repository
    public interface UserRepository extends JpaRepository<User, Long> {
        List<User> findAllByEmail(String email);

        Optional<User> findByEmail(String email);

        List<User> findByName(String name);
    }
