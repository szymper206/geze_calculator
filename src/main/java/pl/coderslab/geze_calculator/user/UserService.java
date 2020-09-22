package pl.coderslab.geze_calculator.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;


    public void saveUser(User user) {
        userRepository.save(user);
    }

    public Optional<User> findUserById(long id) {
        return userRepository.findById(id);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
