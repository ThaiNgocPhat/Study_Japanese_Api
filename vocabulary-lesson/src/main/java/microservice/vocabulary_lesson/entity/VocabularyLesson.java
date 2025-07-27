package microservice.vocabulary_lesson.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "vocabulary_lesson")
public class VocabularyLesson {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "vocabulary_lesson_id", nullable = false)
    private String id;

    @Column(name = "vocabulary_lesson_level", nullable = false)
    private String level;

    @Column(name = "vocabulary_lesson_lesson", nullable = false)
    private int lessonNumber;
}
