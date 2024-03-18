package com.github.copilot;

import java.util.ArrayList;


public class TodoApp {
    private ArrayList<Todo> todoItems;

    public TodoApp() {
        todoItems = new ArrayList<>();
    }

    public void add(Todo todo) {
        todoItems.add(todo);
    }

    public void update(int index, Todo todo) {
        if (index < 0 || index >= todoItems.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        todoItems.set(index, todo);
    }

    public void remove(String name) {
        Todo todoToRemove = null;
        for (Todo todo : todoItems) {
            if (todo.getTitle().equals(name)) {
                todoToRemove = todo;
                break;
            }
        }
        if (todoToRemove != null) {
            todoItems.remove(todoToRemove);
        }
    }

    public void removeAll() {
        todoItems.clear();
    }

    public ArrayList<Todo> fetchTodo() {
        return todoItems;
    }
    
}
