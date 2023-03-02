package fr.m2i.models;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Todo")
public class Todo {
    private int id;
    private String title;
    private String description;
    private Urgence urgence;

    public Todo() {
        this(0, "", "", Urgence.NORMALE);
    }

    public Todo(String title, String description, Urgence urgence) {
        this(0, title, description, urgence);
    }

    public Todo(int id, String title, String description, Urgence urgence) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.urgence = urgence;
    }
    @XmlElement(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @XmlElement(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @XmlElement(name="description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @XmlElement(name="urgence")
    public Urgence getUrgence() {
        return urgence;
    }

    public void setUrgence(Urgence urgence) {
        this.urgence = urgence;
    }
}
