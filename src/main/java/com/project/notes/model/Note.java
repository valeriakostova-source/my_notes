package com.project.notes.model;

import jakarta.persistence.*;

@Entity
@Table(name= "notes")
public class Note {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String note;

    @ManyToOne
    @JoinColumn(name="user_id", updatable = false)

    private User user;

    public Note(User user, String note) {
        this.user = user;
        this.note = note;
    }
   public Note(){

   }



    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
