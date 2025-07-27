package microservice.vocabulary_lesson.service.impl;

import lombok.RequiredArgsConstructor;
import microservice.common_lib.exception.HttpConflict;
import microservice.common_lib.response.MessageResponse;
import microservice.common_lib.response.ResponseWrapper;
import microservice.vocabulary_lesson.dto.CreateVocabularyLessonDto;
import microservice.vocabulary_lesson.entity.VocabularyLesson;
import microservice.vocabulary_lesson.repository.IVocabularyLessonRepository;
import microservice.vocabulary_lesson.service.IVocabularyLessonService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VocabularyLessonServiceImpl implements IVocabularyLessonService {
    private final IVocabularyLessonRepository lessonRepository;
    @Override
    public ResponseWrapper<MessageResponse> createVocabularyLesson(CreateVocabularyLessonDto req) {
        boolean exists = lessonRepository.existsByLevelAndLessonNumber(req.getLevel(), req.getLessonNumber());

        if (exists) {
            throw new HttpConflict("Vocabulary lesson already exists");
        }

        VocabularyLesson lesson = new VocabularyLesson();
        lesson.setLevel(req.getLevel());
        lesson.setLessonNumber(req.getLessonNumber());
        lessonRepository.save(lesson);

        ResponseWrapper<MessageResponse> response = new ResponseWrapper<>();
        response.setCode(201);
        response.setStatus(HttpStatus.CREATED);
        response.setData(new MessageResponse("Created vocabulary lesson successfully"));
        return response;
    }
}
