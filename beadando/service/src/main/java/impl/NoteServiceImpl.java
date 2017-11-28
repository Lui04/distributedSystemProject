package impl;

import dao.NoteDAO;
import model.Note;
import service.NoteService;

import java.util.Collection;

public class NoteServiceImpl implements NoteService{
    private NoteDAO noteDao;

    public NoteServiceImpl(NoteDAO noteDao){
        this.noteDao = noteDao;
    }

    public void addNote(Note note) {
        noteDao.addNote(note);
    }

    public void editNote(String noteName, String content){
        noteDao.editNote(noteName, content);
    }

    public Collection<Note> listAllNotes() {
        return noteDao.listAllNotes();
    }

    public void deleteNote(String noteName){
        noteDao.deleteNote(noteName);
    }
}
