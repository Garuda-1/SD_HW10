package ru.itmo.dolzhanskii.sd.hw10.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ru.itmo.dolzhanskii.sd.hw10.model.entity.Good;

public interface GoodsRepository extends ReactiveCrudRepository<Good, Long> {
}
