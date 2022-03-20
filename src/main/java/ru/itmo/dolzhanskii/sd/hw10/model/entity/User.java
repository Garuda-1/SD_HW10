package ru.itmo.dolzhanskii.sd.hw10.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import ru.itmo.dolzhanskii.sd.hw10.model.enums.Currency;

@Getter
@Setter
@NoArgsConstructor
@Table("users")
public class User {

    @Id
    Long id;

    String login;

    @Column("preferred_currency")
    Currency preferredCurrency;
}
