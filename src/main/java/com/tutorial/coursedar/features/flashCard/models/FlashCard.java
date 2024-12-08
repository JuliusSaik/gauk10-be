package com.tutorial.coursedar.features.flashCard.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tutorial.coursedar.features.flashCardSet.models.FlashCardSet;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class FlashCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @NotEmpty(message =  "Question cannot be empty")
    private String question;

    @Column(nullable = false)
    @NotEmpty(message = "Answer cannot be empty")
    private String answer;

    @ManyToOne
    @JsonIgnore
    FlashCardSet flashCardSet;

}
