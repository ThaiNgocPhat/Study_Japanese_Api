package microservice.vocabulary_lesson.repository;

import microservice.vocabulary_lesson.entity.VocabularyLesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVocabularyLessonRepository extends JpaRepository<VocabularyLesson, String> {
    boolean existsByLevelAndLessonNumber(String level, int lessonNumber);
}
