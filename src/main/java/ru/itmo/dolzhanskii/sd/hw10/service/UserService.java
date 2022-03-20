package ru.itmo.dolzhanskii.sd.hw10.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.itmo.dolzhanskii.sd.hw10.model.entity.User;
import ru.itmo.dolzhanskii.sd.hw10.model.enums.Currency;
import ru.itmo.dolzhanskii.sd.hw10.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Mono<Long> registerUser(String login, Currency preferredCurrency) {
        User user = new User();
        user.setLogin(login);
        user.setPreferredCurrency(preferredCurrency);
        return userRepository.save(user).map(User::getId);
    }

    public Mono<User> findById(Long userId) {
        return userRepository.findById(userId);
    }
}
