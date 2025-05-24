package com.backend.demonotesapp.dto;

import lombok.Data;

@Data
public class UpdateNoteRequestDTO {
    private String title;
    private String content;
}
