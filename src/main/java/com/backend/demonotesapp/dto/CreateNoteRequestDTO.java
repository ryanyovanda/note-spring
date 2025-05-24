package com.backend.demonotesapp.dto;

import lombok.Data;

@Data
public class CreateNoteRequestDTO {
    private String title;
    private String content;
}
