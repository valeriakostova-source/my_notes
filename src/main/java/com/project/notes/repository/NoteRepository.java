package com.project.notes.repository;

import com.project.notes.model.Note;
import com.project.notes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findAllByUser(User user);

}
