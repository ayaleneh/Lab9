package edu.miu.cs.se.lab9.Lesson9.Lab.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "transcript")
@Data
public class Transcript {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transcriptId;
    private String degreeTitle;

    public Transcript(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    public Transcript() {

    }
}
