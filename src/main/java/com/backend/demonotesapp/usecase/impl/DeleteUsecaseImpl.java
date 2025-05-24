package com.backend.demonotesapp.usecase.impl;

import com.backend.demonotesapp.repository.NoteRepository;
import com.backend.demonotesapp.usecase.DeleteNoteUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteUsecaseImpl implements DeleteNoteUsecase {

    private final NoteRepository noteRepository;

    @Override
    public void execute(Long id) {
        if (!noteRepository.existsById(id)) {
            throw new RuntimeException("Note not found");
        }
        noteRepository.deleteById(id);
    }

}
