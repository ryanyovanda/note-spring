package com.backend.demonotesapp.usecase.impl;

import com.backend.demonotesapp.repository.NoteRepository;
import com.backend.demonotesapp.domain.entity.Note;
import com.backend.demonotesapp.dto.NoteResponseDTO;
import com.backend.demonotesapp.dto.UpdateNoteRequestDTO;
import com.backend.demonotesapp.usecase.UpdateNoteUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateNoteUsecaseImpl implements UpdateNoteUsecase {

    private final NoteRepository noteRepository;

    @Override
    public NoteResponseDTO execute(Long id, UpdateNoteRequestDTO request) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));

        note.setTitle(request.getTitle());
        note.setContent(request.getContent());

        Note updatedNote = noteRepository.save(note);

        return NoteResponseDTO.builder()
                .id(updatedNote.getId())
                .title(updatedNote.getTitle())
                .content(updatedNote.getContent())
                .createdAt(updatedNote.getCreatedAt())
                .updatedAt(updatedNote.getUpdatedAt())
                .build();
    }


}
