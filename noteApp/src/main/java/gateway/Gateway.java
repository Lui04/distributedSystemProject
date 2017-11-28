package gateway;

import org.springframework.messaging.handler.annotation.*;
import app.Note;
import app.User;

import java.util.Collection;

public interface Gateway {

    @Payload("new java.util.Date()")
    Collection<Note> listAllNotes();

    void addNote(@Payload Note note);

    void deleteNote(@Payload String noteName);

    @Payload("#args")
    void editNote(String noteName, String content);

    @Payload("#args")
    void createUser(String userName, String password);

    @Payload("#args")
    void deleteUser(String userName);

    @Payload("#args")
    boolean validateUser(String userName, String password);

    @Payload("new java.util.Date()")
    Collection<User> listAllUser();
}
