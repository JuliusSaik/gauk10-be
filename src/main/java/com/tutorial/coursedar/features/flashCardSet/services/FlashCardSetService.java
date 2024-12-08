package com.tutorial.coursedar.features.flashCardSet.services;

import com.tutorial.coursedar.features.flashCard.models.FlashCard;
import com.tutorial.coursedar.features.flashCardSet.dtos.CreateSetRequest;
import com.tutorial.coursedar.features.flashCardSet.models.FlashCardSet;
import com.tutorial.coursedar.features.flashCardSet.repositories.FlashCardSetRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class FlashCardSetService {

    private FlashCardSetRepository flashCardSetRepository;


    public List<FlashCardSet> findAllSets(){
        return flashCardSetRepository.findAll();
    }

    public FlashCardSet findSetById(int id){
        return flashCardSetRepository.findById(id).orElse(null);

    }

    public int createSet(FlashCardSet flashCardSet){
        for (FlashCard flashCard : flashCardSet.getFlashcards()) {
            flashCard.setFlashCardSet(flashCardSet);
        }
        FlashCardSet createdSet = flashCardSetRepository.save(flashCardSet);
        return createdSet.getId();
    }

    public int updateFlashCardSetProgress(int id, int progress) {
        Optional<FlashCardSet> optionalFlashCardSet = flashCardSetRepository.findById(id);
        if (optionalFlashCardSet.isPresent()) {
            FlashCardSet flashCardSet = optionalFlashCardSet.get();
            flashCardSet.setProgress(progress);
            flashCardSetRepository.save(flashCardSet);

        }
        return progress;
    }
}
