package ru.itmo.dolzhanskii.sd.hw10.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import ru.itmo.dolzhanskii.sd.hw10.model.entity.User;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {

    Mono<User> findByLogin(String login);
}
