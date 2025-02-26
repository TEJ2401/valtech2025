package services;

import jakarta.servlet.http.HttpSession;

public class SessionService {
	
	public void clearSession(HttpSession session) {
		session.setAttribute("SortByNameDepts",null);
		session.setAttribute("SortByAgeDepts",null);
		session.setAttribute("SortBySalaryDepts",null);
		session.setAttribute("SortByGenderDepts",null);
		session.setAttribute("SortByExperiencDepts",null);
		session.setAttribute("SortByLevelDepts",null);
		

		
	}
}
