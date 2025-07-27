package microservice.vocabulary_lesson.service;

import microservice.common_lib.response.MessageResponse;
import microservice.common_lib.response.ResponseWrapper;
import microservice.vocabulary_lesson.dto.CreateVocabularyLessonDto;

public interface IVocabularyLessonService {
    ResponseWrapper<MessageResponse> createVocabularyLesson(CreateVocabularyLessonDto req);
}
