package ru.itpark;

import ru.itpark.repository.EventRepository;
import ru.itpark.service.EventService;

public class Main {
    public static void main(String[] args) {
        EventRepository repository = new EventRepository(); // <- зависимость
        EventService service = new EventService(repository); // <- подстановка зависимости

        service.create(
                "Моделирование 3D-ручкой",
                1552734000,
                "Москва",
                "Моделирование 3D-ручкой"
        );
        System.out.println("demo");
    }
}
