package com.backend.demonotesapp.controller;


import com.backend.demonotesapp.dto.CreateNoteRequestDTO;
import com.backend.demonotesapp.dto.NoteResponseDTO;
import com.backend.demonotesapp.dto.UpdateNoteRequestDTO;
import com.backend.demonotesapp.usecase.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {

    private final CreateNoteUsecase createNoteUsecase;
    private final GetNoteUsecase getNoteUsecase;
    private final GetAllNoteUsecase getAllNotesUsecase;
    private final UpdateNoteUsecase updateNoteUsecase;
    private final DeleteNoteUsecase deleteNoteUsecase;

    @PostMapping
    public ResponseEntity<NoteResponseDTO> create(@RequestBody @Validated CreateNoteRequestDTO request) {
        return ResponseEntity.ok(createNoteUsecase.execute(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getNoteUsecase.execute(id));
    }

    @GetMapping
    public ResponseEntity<List<NoteResponseDTO>> getAll() {
        return ResponseEntity.ok(getAllNotesUsecase.execute());
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoteResponseDTO> update(@PathVariable Long id, @RequestBody @Validated UpdateNoteRequestDTO request) {
        return ResponseEntity.ok(updateNoteUsecase.execute(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteNoteUsecase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
