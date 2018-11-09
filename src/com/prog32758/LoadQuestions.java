package com.prog32758;

import java.util.Random;

public class LoadQuestions {	
	private Question[] questions = new Question[25];
	
	
	
	public Question[] getQuestions() {
		return questions;
	}



	public void setQuestions(Question[] questions) {
		this.questions = questions;
	}

	

	public void load() {
		questions[0] = new Question("Food", 400, "The number of Tim Hortons locations at Davis.", "1", "2", "3", "4", "2");
		questions[1] = new Question("Food", 800, "This campus does not have a Starbucks location on campus.", "What is the Trafalgar campus?", "What is the Hazel McCallion campus?", "What is the Davis campus?", "What is the STC?", "What is the Davis campus?");
		questions[2] = new Question("Food", 1200, "This campus has a Subway® restaurant.", "What is the Trafalgar campus?", "What is the Hazel McCallion campus?", "What is the Davis campus?", "What is the STC?", "What is the Trafalgar campus?");
		questions[3] = new Question("Food", 1600, "The name of the Student Center pub at the Trafalgar campus", "What is The Marquee?", "What is The Den?", "What is The Marketplace?", "What is The Pub?", "What is The Marquee?");
		questions[4] = new Question("Food", 2000, "Sheridan food services are run by this company.", "What is Gordon Food Services?", "What is Pizza Pizza", "What is Chartwells?", "What is Sheridan College?", "What is Chartwells?");
		questions[5] = new Question("History", 400, "This is the Sheridan Mascot", "Who is The Bear?", "Who is The Bruin?", "Who is The Beaver?", "Who is The Bee?", "Who is The Bruin?");
		questions[6] = new Question("History", 800, "Sheridan is persuing a partnership with this Toronto University.", "What is Ryerson University?", "What is York University?", "What is The University of Toronto?", "What is OCADU?", "What is Ryerson University?");
		questions[7] = new Question("History", 1200, "Sheridan plans to become a University by this year.", "What is 2022?", "What is 2024?", "What is 2025?", "What is 2020?", "What is 2020?");
		questions[8] = new Question("History", 1600, "Sheridan College was founded in this year.", "What is 1957?", "What is 1967?", "What is 1977?", "What is 1987?", "What is 1967?");
		questions[9] = new Question("History", 2000, "This person was the first President of Sheridan College.", "Who is Jack Porter?", "Who is Jeff Zabudsky?", "Who is Rober Turner?", "Who is Don Shields?", "Who is Jack Porter?");
		questions[10] = new Question("Facilities", 400, "Sheridan College has this many Campuses.", "1", "2", "3", "4", "3");
		questions[11] = new Question("Facilities", 800, "This is the newest Sheridan building.", "What is the Davis A-wing?", "What is the HMC B-wing?", "What is the Trafalgar SCAET wing?", "What is the Davis S-wing", "What is the Davis A-wing?");
		questions[12] = new Question("Facilities", 1200, "This is Sheridan's largest campus.", "What is the Trafalgar campus?", "What is the Davis campus?", "What is the HMC campus?", "What is the STC?", "What is the Davis campus?");
		questions[13] = new Question("Facilities", 1600, "The Hazel McCallion Campus was opened in this year.", "What was 2016?", "What was 2010?", "What was 2015?", "What was 2011?", "What was 2011?");
		questions[14] = new Question("Facilities", 2000, "This campus is open 24/7.", "What is the Trafalgar campus?", "What is the Davis campus?", "What is the HMC campus?", "What is the STC?", "What is the Trafalgar campus?");
		questions[15] = new Question("Academics", 400, "Sheridan's FAST.", "What is the Faculty of Apples, Spaghetti and Tuna?", "What is the Faculty of Animation, Arts and Design?", "What is the Faculty of Arts, Science and Technology?", "What is the Faculty of Applied Science and Technology?", "What is the Faculty of Applied Science and Technology?");
		questions[16] = new Question("Academics", 800, "This Faculty has the most students.", "What is the Faculty of Animation, Arts and Design?", "What is the Faculty of Applied Health and Community Studies?", "What is the Pilon School of Business?", "What is the Faculty of Applied Science and Technology?", "What is the Faculty of Applied Science and Technology?");
		questions[17] = new Question("Academics", 1200, "Sheridan's 4.0 GPA percentage grade equivalent.", "What is 90% or higher?", "What is 80% or higher?", "What is 75% or higher?", "What is 95% or higher?", "What is 90% or higher?");
		questions[18] = new Question("Academics", 1600, "Minimum GPA standard for co-op.", "What is 3.0 GPA?", "What is 3.5 GPA?", "What is 2.5 GPA?", "What is 2.0 GPA?", "What is 2.5 GPA?");
		questions[19] = new Question("Academics", 2000, "This number of Sheridan alumni have won Oscars.", "What is zero?", "What is two?", "What is four?", "What is six?", "What is six?");
		questions[20] = new Question("Services", 400, "This bus only travels between the three Sheridan Campuses.", "What is the Sheridan Shuttle?", "What is miWay Transit?", "What is Brampton Transit?", "What is GO Transit", "What is the Sheridan Shuttle?");
		questions[21] = new Question("Services", 800, "These rooms can be booked by students.", "What are conference rooms?", "What are group study rooms?", "What are classrooms?", "What are washrooms?", "What are group study rooms?");
		questions[22] = new Question("Services", 1200, "A place to get course help outside of class.", "What is the Coffee Loft", "What is The Den?", "What is the Student Centre", "What is the Tutoring Centre?", "What is the Tutoring Centre?");
		questions[23] = new Question("Services", 1600, "You go here to obtain a transcript.", "What is the Office of the Registrar?", "What is the Admissions Office?", "What is the Library?", "What is the Student Advisment Centre?", "What is the Office of the Registrar?");
		questions[24] = new Question("Services", 2000, "Colour printers are only available at this campus", "What is the Trafalgar campus?", "What is the Hazel McCallion campus?", "What is the Davis campus?", "What is the STC?", "What is the Hazel McCallion campus?");
		
		// selects two questions for daily double
		Random r = new Random();
		for (int i = 0; i < 2; i++) {
			int random = r.nextInt(25);
			if (!questions[random].getDailyDouble()) {
				questions[random].setDailyDouble(true);
				System.out.println("Daily double: " + random);
			} else {
				i--;
			}
		}
		
	}
	
}
