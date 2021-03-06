package com.example.SpringAOP.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ExceptionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String message;
    private Date timestamp;
    private String path;

    public ExceptionLog(String message, Date timestamp,String path) {
        this.message = message;
        this.timestamp = timestamp;
        this.path=path;
    }
}
