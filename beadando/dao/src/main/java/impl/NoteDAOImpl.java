package impl;

import dao.NoteDAO;
import model.Note;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

public class NoteDAOImpl implements NoteDAO {
    private Collection<Note> notes;

    public NoteDAOImpl(){
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        notes = new ArrayList<Note>();
        try {
            notes.add(new Note("test", "tartalom", df.parse("2017.11.12 18:10")));
        } catch (ParseException e){
            e.printStackTrace();
        }
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public void deleteNote(String noteName){
        for (Note note : notes){
            if (note.getName().equals(noteName)){
                notes.remove(note);
                break;
            }
        }
    }

    public void editNote(String noteName, String content){
        for (Note note : notes){
            if (note.getName().equals(noteName)){
                note.setContent(content);
                break;
            }
        }
    }

    public Collection<Note> listAllNotes() {
        return notes;
    }
}
