package com.backend.demonotesapp.usecase.impl;

import com.backend.demonotesapp.repository.NoteRepository;
import com.backend.demonotesapp.domain.entity.Note;
import com.backend.demonotesapp.dto.CreateNoteRequestDTO;
import com.backend.demonotesapp.dto.NoteResponseDTO;
import com.backend.demonotesapp.usecase.CreateNoteUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateNoteUsecaseImpl implements CreateNoteUsecase {

    private final NoteRepository noteRepository;

    @Override
    public NoteResponseDTO execute(CreateNoteRequestDTO request){
        Note note = Note.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();

        Note saved = noteRepository.save(note);

        return NoteResponseDTO.builder()
                .id(saved.getId())
                .title(saved.getTitle())
                .content(saved.getContent())
                .createdAt(saved.getCreatedAt())
                .updatedAt(saved.getUpdatedAt())
                .build();

    }


}
