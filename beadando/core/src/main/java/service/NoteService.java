package service;

import model.Note;

import java.util.Collection;

public interface NoteService {
    void addNote(Note note);
    Collection<Note> listAllNotes();
    void editNote(String noteName, String content);
    void deleteNote(String noteName);
}
