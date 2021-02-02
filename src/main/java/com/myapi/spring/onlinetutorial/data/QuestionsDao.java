package com.myapi.spring.onlinetutorial.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.myapi.spring.onlinetutorial.model.Questions;
import com.myapi.spring.onlinetutorial.util.ResponseConstants;

@Component
public class QuestionsDao {
	boolean isAnExistingQuestion = false;

	StringBuilder response = new StringBuilder();

	private static List<Questions> questions = new ArrayList<>();

	static {
		questions.add(new Questions("core-java", "what is cohesion",
				" cohesion is  a measure of  how methods are related in class"));
		questions.add(new Questions("collections", "why do we need collections",
				" collections are used in a situation where data is random"));
	}

	public List<Questions> findAll() {
		return questions;
	}

	public Questions findByTopic(String topicName) {
		for (Questions interviewQuestions : questions) {
			if (!interviewQuestions.getTopicName().contentEquals(topicName)) {
				return interviewQuestions;
			}
		}
		return null;
	}
	
	public String uploadQuestions(Questions uploadedQuestion) {
		
		
		for (Questions interviewQuestions : questions) {
			if (interviewQuestions.getQuestion().contentEquals(uploadedQuestion.getQuestion())) {
				isAnExistingQuestion =  true;
			}
			else {
				isAnExistingQuestion = false;
			}
		}
			if(isAnExistingQuestion) {
				questions.add(uploadedQuestion);
				response.append(ResponseConstants.upload_response_success + uploadedQuestion.getQuestion());
				return response.toString();
			}
			else {
				return ResponseConstants.already_existing_question;
			}
	}

}
