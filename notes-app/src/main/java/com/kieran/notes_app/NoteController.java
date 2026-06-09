package com.kieran.notes_app;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteRepo repo;

    @GetMapping
    public List<Note> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Note create(@RequestBody Note note) {
        note.setCreatedAt(LocalDateTime.now());
        return repo.save(note);
    }

    @PutMapping("/{id}")
    public Note update(@PathVariable Long id, @RequestBody Note updated) {
        updated.setId(id);
        return repo.save(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}