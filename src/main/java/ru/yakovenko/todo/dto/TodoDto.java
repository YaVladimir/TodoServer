package ru.yakovenko.todo.dto;

/**
 * Created by yakovenko-va on 10.01.2022
 */
public class TodoDto {
    private Long id;
    private String text;
    private Boolean completed;
    private String color;

    public TodoDto(Long id, String text, Boolean completed, String color) {
        this.id = id;
        this.text = text;
        this.completed = completed;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public TodoDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getText() {
        return text;
    }

    public TodoDto setText(String text) {
        this.text = text;
        return this;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public TodoDto setCompleted(Boolean completed) {
        this.completed = completed;
        return this;
    }

    public String getColor() {
        return color;
    }

    public TodoDto setColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public String toString() {
        return "TodoDto{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", completed=" + completed +
                ", color='" + color + '\'' +
                '}';
    }
}
