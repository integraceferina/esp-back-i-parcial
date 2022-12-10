package com.dh.catalogService.models;

import lombok.Data;

import java.util.List;

@Data
public class Season {

    /* ================== Attributes ================== */
    private Long id;
    private Integer seasonNumber;
    private List<Chapter> chapters;
}
