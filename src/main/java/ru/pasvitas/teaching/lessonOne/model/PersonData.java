package ru.pasvitas.teaching.lessonOne.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data //Ломбок - кодогенерирует геттеры, сеттеры, переопределяет equals, hashCode, toString
@RequiredArgsConstructor //Ломбок - кодогенерирует конструктор для final полей
public class PersonData {

    private final String name;
    private final String surname;
}
