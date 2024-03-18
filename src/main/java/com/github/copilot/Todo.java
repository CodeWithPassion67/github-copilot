package com.github.copilot;

public class Todo {
    private int id;
    private String title;
    private String desc;
    private String dueDate;

    // Constructor
    public Todo(int id, String title, String desc, String dueDate) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.dueDate = dueDate;
    }

    public Todo() {
        //TODO Auto-generated constructor stub
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    // toString method
    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", dueDate='" + dueDate + '\'' +
                '}';
    }
}
