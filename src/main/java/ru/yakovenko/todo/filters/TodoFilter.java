package ru.yakovenko.todo.filters;

/**
 * Created by yakovenko-va on 10.01.2022
 */
public class TodoFilter {

    private String text;
    private Boolean completed;
    private String color;

    public TodoFilter(String text, Boolean completed, String color) {
        this.text = text;
        this.completed = completed;
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
