package dao;

import model.Note;

import java.util.Collection;

public interface NoteDAO {
    void addNote(Note note);
    void deleteNote(String noteName);
    void editNote(String noteName, String content);
    Collection<Note> listAllNotes();
}
