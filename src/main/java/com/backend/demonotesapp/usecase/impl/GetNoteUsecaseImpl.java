package com.backend.demonotesapp.usecase.impl;

import com.backend.demonotesapp.repository.NoteRepository;
import com.backend.demonotesapp.domain.entity.Note;
import com.backend.demonotesapp.dto.NoteResponseDTO;
import com.backend.demonotesapp.usecase.GetNoteUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetNoteUsecaseImpl implements GetNoteUsecase {

    private final NoteRepository noteRepository;

    @Override
    public NoteResponseDTO execute(Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));

        return NoteResponseDTO.builder()
                .id(note.getId())
                .title(note.getTitle())
                .content(note.getContent())
                .createdAt(note.getCreatedAt())
                .updatedAt(note.getUpdatedAt())
                .build();
    }
}
