package ru.itpark.service;

import ru.itpark.domain.Event;
import ru.itpark.repository.EventRepository;

public class EventService {
    private EventRepository repository;
    private int nextId = 1;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public void create(String name, int date, String city, String description) {
        // TODO: выполнить проверки
        Event event = new Event(nextId, name, date, city, description);
        repository.add(event);
        nextId++;
    }

    public Event[] search(String name, String city) {
        // 1. Когда пользователь не ввёл название -> null
        // 2. Когда выбрал "все города" -> null
        // 3. Без города -> "Онлайн"
        Event[] result = new Event[10]; // <- ограничить кол-во выдаваемых элементов
        int resultIndex = 0;

        Event[] events = repository.getAll(); // ctrl + alt + v
        for (Event event : events) {
            if (event == null) {
                continue; // <- дальше этот элемент не обрабатываем, переходим к следующему
            }

            if (name != null) {
                if (!event.getName().contains(name)) {
                    continue;
                }
            }

            if (city != null) {
                if (!event.getCity().equals(city)) { // <- города сравниваются по точному совпадению
                    continue; // продолжаем цикл со следующего элемента
                }
            }

            if (resultIndex == result.length) {
                // выйти из цикла
                break; // <- выходит из цикла (сразу на 55 строку)
            }

            result[resultIndex] = event;
            resultIndex++;
        }

        return result; // лучше возвращать пустой массив, а не null
    }

    public Event[] getFutureEvents(int date) {
        Event[] result = new Event[10]; // <- ограничить кол-во выдаваемых элементов
        int resultIndex = 0;

        Event[] events = repository.getAll(); // ctrl + alt + v
        for (Event event : events) {
            if (event == null) {
                continue; // <- дальше этот элемент не обрабатываем, переходим к следующему
            }

            if (event.getDate() < date) {
                continue;
            }

            if (resultIndex == result.length) {
                // выйти из цикла
                break; // <- выходит из цикла (сразу на 81 строку)
            }

            result[resultIndex] = event;
            resultIndex++;
        }

        return result;
    }
}
