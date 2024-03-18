package com.github.copilot;

import java.util.ArrayList;


/**
 * The TodoApp class represents a simple todo application.
 * It allows users to add, update, remove, and fetch todo items.
 */
public class TodoApp {
    private ArrayList<Todo> todoItems;

    /**
     * Constructs a new TodoApp object.
     * Initializes the todoItems list.
     */
    public TodoApp() {
        todoItems = new ArrayList<>();
    }

    /**
     * Adds a todo item to the todoItems list.
     *
     * @param todo the todo item to be added
     */
    public void add(Todo todo) {
        todoItems.add(todo);
    }

    /**
     * Updates a todo item at the specified index in the todoItems list.
     *
     * @param index the index of the todo item to be updated
     * @param todo  the updated todo item
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public void update(int index, Todo todo) {
        if (index < 0 || index >= todoItems.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        todoItems.set(index, todo);
    }

    /**
     * Removes a todo item with the specified name from the todoItems list.
     *
     * @param name the name of the todo item to be removed
     */
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

    /**
     * Removes all todo items from the todoItems list.
     */
    public void removeAll() {
        todoItems.clear();
    }

    /**
     * Fetches all todo items from the todoItems list.
     *
     * @return the list of todo items
     */
    public ArrayList<Todo> fetchTodo() {
        return todoItems;
    }
}
