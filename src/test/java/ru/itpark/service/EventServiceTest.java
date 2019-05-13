package ru.itpark.service;

import org.junit.jupiter.api.Test;
import ru.itpark.domain.Event;
import ru.itpark.repository.EventRepository;

import static org.junit.jupiter.api.Assertions.*;

class EventServiceTest {
    @Test
    public void create() {
        // Arrange
        EventRepository repository = new EventRepository();
        EventService service = new EventService(repository);

        // Act
        service.create("", 0, "", "");
        service.create("", 0, "", "");

        // Assert
        Event[] events = repository.getAll();
        assertNotEquals(0, events[0].getId()); // == - проверка на равенство, != неравенство
        assertNotEquals(0, events[1].getId());
        assertNotEquals(events[0].getId(), events[1].getId());
    }

    @Test
    public void searchByName() {
        EventRepository repository = new EventRepository();
        EventService service = new EventService(repository);
        service.create("Программирование на Python", 0, "", "");
        service.create("Программирование на Java", 0, "", "");
        service.create("Разработка на JavaScript", 0, "", "");
        service.create("Разработка на Python", 0, "", "");

        Event[] events = service.search("Java", null);

        // TODO: а если объекты вернутся в другом порядке?
        assertEquals("Программирование на Java", events[0].getName());
        assertEquals("Разработка на JavaScript", events[1].getName());
    }

    @Test
    public void getFutureEvents() {
        EventRepository repository = new EventRepository();
        EventService service = new EventService(repository);
        service.create("Программирование на Python", 1000, "", "");
        service.create("Программирование на Java", 2000, "", "");
        service.create("Разработка на JavaScript", 3000, "", "");
        service.create("Разработка на Python", 500, "", "");

        Event[] events = service.getFutureEvents(1500);

        // TODO: а если объекты вернутся в другом порядке?
        assertEquals("Программирование на Java", events[0].getName());
        assertEquals("Разработка на JavaScript", events[1].getName());
    }
}