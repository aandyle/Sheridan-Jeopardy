package com.prog32758;

public class Question {
	private String category;
	private int value;
	private String question;
	private String a1;
	private String a2;
	private String a3;
	private String a4;
	private String aCorrect;
	private String disabled;
	private Boolean dailyDouble;
	private int oldValue;
		
	public Question() {
		
	}
	
	public Question(String category, int value, String question, String a1, String a2, String a3, String a4, String aCorrect) {
		this.category = category;
		this.value = value;
		this.question = question;
		this.a1 = a1;
		this.a2 = a2;
		this.a3 = a3;
		this.a4 = a4;
		this.aCorrect = aCorrect;
		this.disabled = "";		//added to track selected questions
		this.dailyDouble = false;
		this.oldValue = value;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getA1() {
		return a1;
	}

	public void setA1(String a1) {
		this.a1 = a1;
	}

	public String getA2() {
		return a2;
	}

	public void setA2(String a2) {
		this.a2 = a2;
	}

	public String getA3() {
		return a3;
	}

	public void setA3(String a3) {
		this.a3 = a3;
	}

	public String getA4() {
		return a4;
	}

	public void setA4(String a4) {
		this.a4 = a4;
	}

	public String getaCorrect() {
		return aCorrect;
	}

	public void setaCorrect(String aCorrect) {
		this.aCorrect = aCorrect;
	}

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public Boolean getDailyDouble() {
		return dailyDouble;
	}

	public void setDailyDouble(Boolean dailyDouble) {
		this.dailyDouble = dailyDouble;
	}

	public int getOldValue() {
		return oldValue;
	}

	public void setOldValue(int oldValue) {
		this.oldValue = oldValue;
	}

}
