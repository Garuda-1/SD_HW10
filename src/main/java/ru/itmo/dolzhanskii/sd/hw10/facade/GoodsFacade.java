package ru.itmo.dolzhanskii.sd.hw10.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.itmo.dolzhanskii.sd.hw10.model.dto.GoodDto;
import ru.itmo.dolzhanskii.sd.hw10.service.GoodsService;
import ru.itmo.dolzhanskii.sd.hw10.service.UserService;

@Service
@RequiredArgsConstructor
public class GoodsFacade {

    private final GoodsService goodsService;
    private final UserService userService;

    public Flux<GoodDto> getAllGoodsForUser(Long userId) {
        return userService
            .findById(userId)
            .flatMapMany(user -> goodsService.findAllGoodsInCurrency(user.getPreferredCurrency()));
    }

    public Mono<Long> addGood(GoodDto goodDto) {
        return goodsService.addGood(goodDto);
    }
}
