package com.tutorial.coursedar.features.flashCardSet.controllers;

import com.tutorial.coursedar.features.flashCardSet.dtos.CreateSetRequest;
import com.tutorial.coursedar.features.flashCardSet.models.FlashCardSet;
import com.tutorial.coursedar.features.flashCardSet.services.FlashCardSetService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/sets")
public class FlashCardSetController {

    private final FlashCardSetService flashCardSetService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FlashCardSet> getAllSets(){
        return flashCardSetService.findAllSets();
    }

    @GetMapping("/{id}")
    public FlashCardSet getFlashCardSetById(@PathVariable int id){
       return flashCardSetService.findSetById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public int createSet(@Valid @RequestBody FlashCardSet flashCardSet){
        return flashCardSetService.createSet(flashCardSet);
    }

    @PutMapping("/{id}/progress/{progress}")
    public int updateFlashCardSetProgress(@PathVariable int id, @PathVariable int progress) {
        return flashCardSetService.updateFlashCardSetProgress(id, progress);

    }

}
