package com.tutorial.coursedar.features.flashCardSet.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateSetRequest {

    @NotEmpty(message = "Title cannot be empty.")
    @Size(max = 80, message = "Name cannot be longer than 80 characters.")
    private String title;

    @Size(max  = 160, message = "description can't be longer than 160 characters")
    private String description;

}
