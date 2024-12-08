package com.tutorial.coursedar.features.flashCard.controllers;

import com.tutorial.coursedar.features.flashCard.models.FlashCard;
import com.tutorial.coursedar.features.flashCard.services.FlashCardService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cards")
public class FlashCardController {

    private FlashCardService flashCardService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<FlashCard> getAllFlashCards(){
            return flashCardService.getAllFlashCards();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createFlashCard(@Valid @RequestBody FlashCard flashCard){
      flashCardService.createFlashCard(flashCard);
    }


}
