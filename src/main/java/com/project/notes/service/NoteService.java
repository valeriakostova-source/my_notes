package com.project.notes.service;

import com.project.notes.model.Note;
import com.project.notes.model.User;
import com.project.notes.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note saveNote(String noteText, User user){
        if (noteText == null || noteText.isBlank()){
            System.out.println("Note is empty. You have to write something before saving.");
            return null;
        }
        else{
            Note note = new Note(user, noteText);
            return noteRepository.save(note);
        }

    }
    public void updateNote(Note note){
        noteRepository.save(note);
    }

    public void deleteNote(Note note){
        noteRepository.delete(note);
    }



    public List<Note> findAllNotes(User user){

        if (user.isAdmin()){
            return noteRepository.findAll();
        }
        else {
            return noteRepository.findAllByUser(user);
        }

    }



}
