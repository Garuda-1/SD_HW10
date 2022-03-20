package ru.itmo.dolzhanskii.sd.hw10.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.itmo.dolzhanskii.sd.hw10.facade.GoodsFacade;
import ru.itmo.dolzhanskii.sd.hw10.model.dto.GoodDto;

@RestController
@RequestMapping("/goods")
@RequiredArgsConstructor
public class GoodsController {

    private final GoodsFacade goodsFacade;

    @GetMapping
    public Flux<GoodDto> getAllGoodsForUser(@RequestParam Long userId) {
        return goodsFacade.getAllGoodsForUser(userId);
    }

    @PostMapping
    public Mono<Long> addGood(@ModelAttribute GoodDto goodDto) {
        return goodsFacade.addGood(goodDto);
    }
}
