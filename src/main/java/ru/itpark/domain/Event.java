package ru.itpark.domain;

public class Event {
    private int id;
    private String name;
    private int date; // <- в секундах (до "2039"), 2000x -> 98, 64
    private String city; // "Онлайн"
    private String description;

    public Event(int id, String name, int date, String city, String description) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.city = city;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
