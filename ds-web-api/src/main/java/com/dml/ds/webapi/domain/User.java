package com.dml.ds.webapi.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

@Data
@Document(collection = "user")
public class User {

    @Id
    private String id;

    private String staffId;
    private String name;
    private String position;
}
