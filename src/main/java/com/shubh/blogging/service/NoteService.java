package com.shubh.blogging.service;

import org.springframework.stereotype.Service;

import com.shubh.blogging.model.Note;
import com.shubh.blogging.model.User;
import com.shubh.blogging.repository.NoteRepository;
import com.shubh.blogging.repository.UserRepository;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public NoteService(NoteRepository noteRepository, UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    public Note createNote(NoteDto noteDto) {
        User user = userRepository.findById(noteDto.getCreatedBy())
                .orElseThrow(() -> new RuntimeException("User not Found."));

        Note note = new Note();
        note.setNote(noteDto.getNote());
        note.setCreatedOn(noteDto.getCreatedOn());
        note.setUser(user);
        note.setTags(noteDto.getTags());
        return noteRepository.save(note);
    }

    public Note getNoteById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note Not Found"));
    }

    public Note updateNote(Long id, NoteDto noteDto) {
        Note note = getNoteById(id);
        note.setNote(noteDto.getNote());
        note.setTags(noteDto.getTags());
        return noteRepository.save(note);
    }

    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }

}
