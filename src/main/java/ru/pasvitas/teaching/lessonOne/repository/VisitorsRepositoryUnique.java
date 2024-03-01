package ru.pasvitas.teaching.lessonOne.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.pasvitas.teaching.lessonOne.model.PersonData;

@Repository //Помещаем класс в контекст Spring
@Primary //Primary - если у нас будет несколько бинов такого типа(интерфейса) - он в первую очередь возьмет этот.
public class VisitorsRepositoryUnique implements VisitorsRepository {

    private final Set<PersonData> visitors = new HashSet<>();

    public void addVisitor(PersonData visitor) {
        visitors.add(visitor);
    }

    public Set<PersonData> getVisitors() {
        return visitors;
    }

}
