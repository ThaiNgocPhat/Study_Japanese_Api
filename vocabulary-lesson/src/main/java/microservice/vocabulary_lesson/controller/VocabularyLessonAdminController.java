package microservice.vocabulary_lesson.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import microservice.common_lib.response.MessageResponse;
import microservice.common_lib.response.ResponseWrapper;
import microservice.vocabulary_lesson.dto.CreateVocabularyLessonDto;
import microservice.vocabulary_lesson.service.IVocabularyLessonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/vocabulary-lesson")
public class VocabularyLessonAdminController {
    private final IVocabularyLessonService vocabularyLessonService;

    @PostMapping
    public ResponseEntity<ResponseWrapper<MessageResponse>> createVocabularyLesson(@Valid @RequestBody CreateVocabularyLessonDto req){
        ResponseWrapper<MessageResponse> response = vocabularyLessonService.createVocabularyLesson(req);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
