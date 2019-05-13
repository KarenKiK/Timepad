package ru.itpark.repository;

import ru.itpark.domain.Event;

public class EventRepository {
    private Event[] events = new Event[50]; // инициализация поля
    private int nextIndex = 0;

    public void add(Event event) {
        events[nextIndex] = event;
        nextIndex++; // увеличиваем на 1
    }

    public Event[] getAll() {
        return events;
    }
}
