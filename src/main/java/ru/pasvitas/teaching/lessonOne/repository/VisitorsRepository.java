package ru.pasvitas.teaching.lessonOne.repository;

import java.util.Collection;
import ru.pasvitas.teaching.lessonOne.model.PersonData;

//Интерфейс для репозитория.
public interface VisitorsRepository {

    void addVisitor(PersonData visitor);

    Collection<PersonData> getVisitors();

}
