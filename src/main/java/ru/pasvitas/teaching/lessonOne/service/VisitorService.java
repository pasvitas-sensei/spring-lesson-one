package ru.pasvitas.teaching.lessonOne.service;

import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pasvitas.teaching.lessonOne.model.PersonData;
import ru.pasvitas.teaching.lessonOne.repository.VisitorsRepository;

@RequiredArgsConstructor //Lombok аннотация - генерирует конструкторы со всеми final-параметрами
@Service //Помещает класс в контекст Spring Boot
public class VisitorService {

    private final VisitorsRepository repositoryUnique; //Объявляем зависимость данного класса от VisitorsRepository. Spring сам найдет и вставит этот класс

    public void processVisitor(PersonData personData) {
        repositoryUnique.addVisitor(personData);
    }

    public Collection<PersonData> getVisitors() {
        return repositoryUnique.getVisitors();
    }
}
