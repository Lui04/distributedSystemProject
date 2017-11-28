package controller;

import model.Note;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.NoteService;

import java.util.Collection;
import java.util.Date;

@Controller
public class NoteController {
    private NoteService noteService;


    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }


    @RequestMapping(value = {"/all"})
    @ResponseBody
    public Collection<Note> listAllNotes(){
        return noteService.listAllNotes();
    }


    @RequestMapping(value = "/add")
    @ResponseBody
    public void add(@RequestParam("notename") String noteName, @RequestParam(value = "content") String content,
                    @RequestParam("date") @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm") Date date){

        Note note = new Note(noteName, content, date);
        noteService.addNote(note);
    }

    @RequestMapping(value = {"/delete"})
    @ResponseBody
    public void delete(@RequestParam("notename") String noteName){
        noteService.deleteNote(noteName);
    }

    @RequestMapping(value = {"/edit"})
    @ResponseBody
    public void edit(@RequestParam("notename") String noteName, @RequestParam("content") String content){
        noteService.editNote(noteName, content);
    }
}
