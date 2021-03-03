package com.myapi.spring.onlinetutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myapi.spring.onlinetutorial.data.QuestionsDao;
import com.myapi.spring.onlinetutorial.exception.TopicNotFoundException;
import com.myapi.spring.onlinetutorial.model.Questions;
import com.myapi.spring.onlinetutorial.model.Welcome;
import com.myapi.spring.onlinetutorial.util.ResponseConstants;

@RestController 
public class Controller {

	@Autowired
	private QuestionsDao questionaire;

	@GetMapping(path = "/welcome")
	public Welcome greet() {
		return new Welcome("hello");
	}

	@GetMapping(path = "/greet-user/{name}")
	public Welcome greetUserWithName(@PathVariable String name) {
		return new Welcome(String.format("hi, welcome back, %s", name));
	}

	@GetMapping(path = "/getQuestionsFor/{topicName}")
	public Questions getQuestionsByTopicName(@PathVariable String topicName) {
		Questions topic =  questionaire.findByTopic(topicName);
		if(topic == null) {
			throw new TopicNotFoundException(ResponseConstants.topic_notFound_exception);
		}
		return questionaire.findByTopic(topicName);
	}
	
	@DeleteMapping(path = "/deleteQuestionsFor/{topicName}")
	public void deleteQuestionsByTopicName(@PathVariable String topicName) {
		Questions topic =  questionaire.deleteByTopic(topicName);
		if(topic == null) {
			throw new TopicNotFoundException(ResponseConstants.topic_notFound_exception);
		}
	}

	@GetMapping(path = "/getAllQuestions")
	public List<Questions> getAllQuestions() {
		return questionaire.findAll();
	}

	@PostMapping(path = "/uploadQuestion")
	public String saveQuestions(@RequestBody Questions uploadedQuestion) {
		return questionaire.uploadQuestions(uploadedQuestion);
	}	
}
