package fr.m2i.database;

import fr.m2i.models.Todo;
import fr.m2i.models.Urgence;

import java.util.ArrayList;

public class Database {
    static Todo[] data = {
            new Todo(1, "Aspirer", "passer l'aspriteur", Urgence.NORMALE),
            new Todo(2, "Poubelle", "sortir la poubelle", Urgence.FAIBLE),
            new Todo(3, "Chat", "nourir le chat", Urgence.HAUTE)
    };

    public static Todo[] getTodoList() {
        return data;
    }

    public static Todo getTodoById (int id) {
        for (Todo task : data) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}
