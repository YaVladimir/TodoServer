package ru.yakovenko.todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by yakovenko-va on 22.11.2021
 */
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String text;
    private Boolean completed;
    private String color;

    public Todo() {
    }

    public Todo(Long id, String text, Boolean completed, String color) {
        this.id = id;
        this.text = text;
        this.completed = completed;
        this.color = color;
    }

    public Todo(String text, Boolean completed, String color) {
        this.text = text;
        this.completed = completed;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", completed=" + completed +
                ", color='" + color + '\'' +
                '}';
    }
}
