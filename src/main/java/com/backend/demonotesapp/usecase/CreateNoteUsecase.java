package com.backend.demonotesapp.usecase;

import com.backend.demonotesapp.dto.CreateNoteRequestDTO;
import com.backend.demonotesapp.dto.NoteResponseDTO;

public interface CreateNoteUsecase {
    NoteResponseDTO execute(CreateNoteRequestDTO request);
}
