package com.tutorial.coursedar.features.flashCard.services;

import com.tutorial.coursedar.features.flashCard.models.FlashCard;
import com.tutorial.coursedar.features.flashCard.repositories.FlashCardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor
public class FlashCardService {

    private FlashCardRepository flashCardRepository;

    public List<FlashCard> getAllFlashCards(){
        return flashCardRepository.findAll();
    }


    public void createFlashCard(@RequestBody FlashCard flashCard) {
        flashCardRepository.save(flashCard);
    }

}
