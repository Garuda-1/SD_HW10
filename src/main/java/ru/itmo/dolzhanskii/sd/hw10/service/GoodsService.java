package ru.itmo.dolzhanskii.sd.hw10.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.itmo.dolzhanskii.sd.hw10.model.dto.GoodDto;
import ru.itmo.dolzhanskii.sd.hw10.model.entity.Good;
import ru.itmo.dolzhanskii.sd.hw10.model.enums.Currency;
import ru.itmo.dolzhanskii.sd.hw10.repository.GoodsRepository;

@Service
@RequiredArgsConstructor
public class GoodsService {

    private static final double USD_TO_RUB = 107.50;
    private static final double USD_TO_EUR = 0.90;

    private final GoodsRepository goodsRepository;

    public Flux<GoodDto> findAllGoodsInCurrency(Currency preferredCurrency) {
        return goodsRepository.findAll().map(good -> {
            double usdPrice = priceToUsd(good.getPrice(), good.getCurrency());
            double preferredPrice = usdPriceToPreferred(usdPrice, preferredCurrency);
            return new GoodDto(
                good.getName(),
                preferredPrice,
                preferredCurrency
            );
        });
    }

    public Mono<Long> addGood(GoodDto goodDto) {
        Good good = new Good();
        good.setName(goodDto.getName());
        good.setPrice(goodDto.getPrice());
        good.setCurrency(goodDto.getCurrency());
        return goodsRepository.save(good).map(Good::getId);
    }

    private double priceToUsd(double price, Currency currency) {
        switch (currency) {
            case USD:
                return price;
            case EUR:
                return price / USD_TO_EUR;
            case RUB:
                return price / USD_TO_RUB;
            default:
                throw new IllegalStateException("Unexpected value: " + currency);
        }
    }

    private double usdPriceToPreferred(double price, Currency currency) {
        switch (currency) {
            case USD:
                return price;
            case EUR:
                return price * USD_TO_EUR;
            case RUB:
                return price * USD_TO_RUB;
            default:
                throw new IllegalStateException("Unexpected value: " + currency);
        }
    }
}
