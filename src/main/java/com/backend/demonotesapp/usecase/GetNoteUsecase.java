package com.backend.demonotesapp.usecase;

import com.backend.demonotesapp.dto.NoteResponseDTO;

public interface GetNoteUsecase {
    NoteResponseDTO execute(Long id);
}
