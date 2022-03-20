package ru.itmo.dolzhanskii.sd.hw10.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.itmo.dolzhanskii.sd.hw10.model.enums.Currency;
import ru.itmo.dolzhanskii.sd.hw10.service.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public Mono<Long> registerUser(@RequestParam String login, @RequestParam Currency currency) {
        return userService.registerUser(login, currency);
    }
}
