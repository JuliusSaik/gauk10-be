package com.tutorial.coursedar.features.flashCardSet.repositories;

import com.tutorial.coursedar.features.flashCardSet.models.FlashCardSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlashCardSetRepository extends JpaRepository<FlashCardSet, Integer> {

}
