package com.codecool.supersplinter3000.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@Entity
//@Table(name = "user_stories")
public class UserStory {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Size(min = 5, max = 50, message = "Title must be between 5 and 50!")
    private String title;
    @NotBlank(message = "Cannot be empty!")
    private String story;
    private String acceptanceCriteria;
    @DecimalMin(value = "0.5", message = "Min 0.5")
    @DecimalMax(value = "40.0", message = "Max 40")
    @NotEmpty(message = "Cannot be empty!")
    private Double estimation;
    private Integer businessValue = 100;
    @Enumerated(EnumType.STRING)
    private UserStoryStatus userStoryStatus;
}
