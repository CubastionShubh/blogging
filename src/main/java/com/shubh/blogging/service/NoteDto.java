package com.shubh.blogging.service;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class NoteDto {
    private String note;
    private LocalDateTime createdOn;
    private Long createdBy;
    private List<String> tags;
}
