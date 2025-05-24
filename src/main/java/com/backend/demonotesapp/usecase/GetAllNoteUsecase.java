package com.backend.demonotesapp.usecase;


import com.backend.demonotesapp.dto.NoteResponseDTO;

import java.util.List;

public interface GetAllNoteUsecase {
    List<NoteResponseDTO> execute();
}
