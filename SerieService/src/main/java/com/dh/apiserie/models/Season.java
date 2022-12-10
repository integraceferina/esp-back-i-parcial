package com.dh.apiserie.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Season {

    /* ================== Attributes ================== */
    @Id
    private Long id;
    private Integer seasonNumber;
    private List<Chapter> chapters;

    public static final String SEQUENCE_NAME = "season_sequence";

}
