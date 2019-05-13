package ru.itpark.repository;

import org.junit.jupiter.api.Test;
import ru.itpark.domain.Event;

import static org.junit.jupiter.api.Assertions.*;

class EventRepositoryTest {
    @Test
    public void addOneEvent() {
        // Arrange
        EventRepository repository = new EventRepository();
        Event event = new Event(1, "", 0, "", "");

        // Act
        repository.add(event);

        // Assert
        Event[] events = repository.getAll();// ctrl + alt + v
        // TODO: что event есть в events
        assertEquals(event, events[0]); // смотрим, что в массиве оно первое
    }

    @Test
    public void addTwoEvents() {
        // Arrange
        EventRepository repository = new EventRepository();
        Event first = new Event(1, "", 0, "", "");
        Event second = new Event(2, "", 0, "", "");

        // Act
        repository.add(first);
        repository.add(second);

        // Assert
        Event[] events = repository.getAll();// ctrl + alt + v
        // TODO: что first и second есть в events
        assertEquals(first, events[0]); // смотрим, что в массиве оно первое
        assertEquals(second, events[1]); // смотрим, что в массиве оно первое
    }
}