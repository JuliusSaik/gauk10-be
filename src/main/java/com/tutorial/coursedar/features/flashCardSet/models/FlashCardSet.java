package com.tutorial.coursedar.features.flashCardSet.models;


import com.tutorial.coursedar.features.flashCard.models.FlashCard;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class FlashCardSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Title cannot be empty.")
    @Size(max = 80, message = "Name cannot be longer than 80 characters.")
    private String title;

    @Size(max = 160, message = "description can't be longer than 160 characters")
    private String description;

    @Range(min = 0, max = 100)
    private int progress;

    private LocalDate date;

    @NotNull
    @OneToMany(mappedBy = "flashCardSet", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<FlashCard> flashcards = new ArrayList<>();

}
