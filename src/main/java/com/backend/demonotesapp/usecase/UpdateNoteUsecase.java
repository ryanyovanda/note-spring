package com.backend.demonotesapp.usecase;

import com.backend.demonotesapp.dto.NoteResponseDTO;
import com.backend.demonotesapp.dto.UpdateNoteRequestDTO;

public interface UpdateNoteUsecase {
    NoteResponseDTO execute(Long id, UpdateNoteRequestDTO request);

}
