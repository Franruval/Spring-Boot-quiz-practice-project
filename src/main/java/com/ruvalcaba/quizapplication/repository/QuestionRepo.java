package com.ruvalcaba.quizapplication.repository;

import com.ruvalcaba.quizapplication.model.QuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<QuestionModel, Long> {

    List<QuestionModel> findByCategory(String category);
    List<QuestionModel> findByDifficultyLevel(String difficulty);

    @Query(value = "SELECT * FROM question2 q WHERE q.category=:category ORDER BY RANDOM() LIMIT :totalQuestions", nativeQuery = true)
    List<QuestionModel> findRandomQuestionsByCategory(String category, int totalQuestions);
}
