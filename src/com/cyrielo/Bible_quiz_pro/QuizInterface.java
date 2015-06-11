package com.cyrielo.Bible_quiz_pro;

/**
 * Created by cyrielo on 2/6/2015.
 */
public interface QuizInterface {

    public void setNextQuestion();

    public void checkAnswer(String user_answer);

    public void endQuiz(String level_string, int nextLevel);
}
