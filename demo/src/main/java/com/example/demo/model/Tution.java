package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.conversions.Bson;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "tutions")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Tution  {

    private String status;
    @Id
    private String tutionId;
    private String username;
    private String phone;
    private String subject;
    private String location;
    private int feePerHour;
}
