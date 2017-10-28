package ru.geekbrains.traineeship.group2.search_person_popularity_mai.Database;

/**
 * Created by skubatko on 28/10/17.
 */

class Person {
    private int id;
    private String name;

    Person(int id, String name) {
        this.id = id;
        this.name = name;
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
}
