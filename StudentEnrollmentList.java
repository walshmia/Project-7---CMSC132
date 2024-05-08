package studentEnrollmentList;

import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

/*  Mia Walsh, CMSC132 - 0303 
 * I pledge on my honor that I have not given nor received any unauthorized 
 * assistance on this assignment. */

public class StudentEnrollmentList {

    // you have to instantiate this field appropriately, but DO NOT ADD ANY
    // OTHER FIELDS, and DO NOT CHANGE THE TYPE OF THIS FIELD, or you will
    // LOSE CREDIT
    private Map<String, Collection<String>> aCourses = new HashMap<>();

    public void takeCourse(String aStudent, String aCourse) {
    	
        if (aStudent == null && aCourse == null) {
        	throw new IllegalArgumentException("Illegal argument");
        }
        
        if (aCourses.get(aStudent) == null) {
        	Set<String> courses = new HashSet<>();
           	courses.add(aCourse);
           	aCourses.put(aStudent, courses);
           	
       	} else {
       		aCourses.get(aStudent).add(aCourse);
       	}
    }

    public boolean isTakingCourse(String aStudent, String aCourse) {
        
    	if (aStudent != null && aCourse != null) {
    		
    		if (aCourses.containsKey(aStudent)) {
    			if (aCourses.get(aStudent).contains(aCourse)) {
    				return true;
    			}
    		}
    		
    		return false;
    	}
    	
    	throw new IllegalArgumentException("Illegal argument");
    }

    public int numCoursesTaking(String aStudent) {
        int retVal = 0;
    	
    	if (aStudent != null) {
    		
    		if (aCourses.containsKey(aStudent)) {
    			retVal = aCourses.get(aStudent).size();
    		}
    		return retVal;
    	}
    	
    	throw new IllegalArgumentException("Illegal argument");
    }

    public int numEnrolled(String aCourse) {
        int count = 0;
        
    	if (aCourse != null) {
    		
    		for (String student : aCourses.keySet()) {
    			
    			if (aCourses.get(student).contains(aCourse)) {
    				count = count + 1;
    			}
    		}
    		return count;
    	}
    	
    	throw new IllegalArgumentException("Illegal argument");
    }

    public String mostPopularCourse() {
        String mostPopular = null;
        int prev = 0, current;
        
        for (String student : aCourses.keySet()) {
        	
        	for (String course : aCourses.get(student)) {
        		current = numEnrolled(course);
        		
        		if (current > prev) {
        			mostPopular = course;
        		}
        		
        		prev = current;
        	}
        }
        
        return mostPopular;
    }

    public boolean dropCourse(String aStudent, String aCourse) {
        boolean retVal = false;
    	
    	if (aStudent != null && aCourse != null) {
    		
    		if (aCourses.containsKey(aStudent) && aCourses.get(aStudent).contains(aCourse)) {
    			
    			aCourses.get(aStudent).remove(aCourse);
    			retVal = true;
    		}
    		return retVal;
    	}
    	
    	throw new IllegalArgumentException("Illegal argument");
    }

}
