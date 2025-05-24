package com.backend.demonotesapp.usecase.impl;

import com.backend.demonotesapp.repository.NoteRepository;
import com.backend.demonotesapp.domain.entity.Note;
import com.backend.demonotesapp.dto.NoteResponseDTO;
import com.backend.demonotesapp.usecase.GetAllNoteUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetAllNoteUsecaseImpl implements GetAllNoteUsecase {
    private final NoteRepository noteRepository;

    @Override
    public List<NoteResponseDTO> execute() {
        List<Note> notes = noteRepository.findAll();

        return notes.stream()
                .map(note -> NoteResponseDTO.builder()
                        .id(note.getId())
                        .title(note.getTitle())
                        .content(note.getContent())
                        .createdAt(note.getCreatedAt())
                        .updatedAt(note.getUpdatedAt())
                        .build())
                .collect(Collectors.toList());
    }
}
