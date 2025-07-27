package microservice.vocabulary_lesson.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateVocabularyLessonDto {

    @NotBlank(message = "Level must not be blank")
    @Pattern(regexp = "^N[1-5]$", message = "Level must be one of N1, N2, N3, N4, N5")
    private String level;

    @Min(value = 1, message = "Lesson number must be at least 1")
    @Max(value = 100, message = "Lesson number must not exceed 100")
    private int lessonNumber;
}

