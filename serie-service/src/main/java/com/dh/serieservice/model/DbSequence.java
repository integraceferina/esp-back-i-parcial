package com.dh.serieservice.model;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Document(collection = "dbSequence")
public class DbSequence {

    @Id
    private String id;
    private Long seq;

}
