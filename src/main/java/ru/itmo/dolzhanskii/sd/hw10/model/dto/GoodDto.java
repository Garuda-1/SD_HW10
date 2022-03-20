package ru.itmo.dolzhanskii.sd.hw10.model.dto;

import lombok.Value;
import ru.itmo.dolzhanskii.sd.hw10.model.enums.Currency;

@Value
public class GoodDto {

    String name;
    Double price;
    Currency currency;
}
