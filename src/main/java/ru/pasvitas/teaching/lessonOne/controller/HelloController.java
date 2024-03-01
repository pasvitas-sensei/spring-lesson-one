package ru.pasvitas.teaching.lessonOne.controller;

import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.pasvitas.teaching.lessonOne.model.PersonData;
import ru.pasvitas.teaching.lessonOne.service.VisitorService;

@RequiredArgsConstructor //Ломбок - кодогенерирует конструктор для final полей
@RestController //Помечаем бин как RestController для работы с Http
public class HelloController {

    @Value("${helloWord}") //Вставляем из конфига параметр helloWorld в бин
    private String helloWord;

    private final VisitorService service; //Объявляем зависимость VisitorService для данного класса. Spring сам найдет и вставит нужный вам ббин

    @PostMapping("/hello") //Метод будет реагировать на POST по пути /hello
    //Возвращает ResponseEntity - для кастомиации внутреннего ответа Spring по правилам HTTP
    public ResponseEntity<String> answerHello(
            //Принимает PersonData как JSON в Body запроса
            @RequestBody PersonData personData) {
        //Если имени нет - возвращаем 400-ый код, плохой синтаксис
        if (personData.getName() == null) {
            return ResponseEntity.badRequest().body("Not name");
        }
        service.processVisitor(personData);
        //Если все пршло успешно - возвращаем 200 ОК с телом helloWord Name Surname
        return ResponseEntity.ok(helloWord + " " + personData.getName() + " " + personData.getSurname());
    }

    @GetMapping("/visitors") //Метод будет реагировать на GET по пути /visitors
    public ResponseEntity<Collection<PersonData>> getAllVisitors() {
        return ResponseEntity.ok(service.getVisitors());
    }
}
