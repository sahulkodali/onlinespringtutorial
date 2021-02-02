package com.myapi.spring.onlinetutorial.model;

public class Questions {

	private String topicName;
	private String question;
	private String answer;

	public Questions(String topicName, String question, String answer) {
		super();
		this.topicName = topicName;
		this.question = question;
		this.answer = answer;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Questions [topicName=" + topicName + ", question=" + question + ", answer=" + answer + "]";
	}

}
