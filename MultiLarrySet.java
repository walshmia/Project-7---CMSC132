package multiLarrySet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*  Mia Walsh, CMSC132 - 0303 
 * I pledge on my honor that I have not given nor received any unauthorized 
 * assistance on this assignment. */

public class MultiLarrySet {
	
	private Map<Integer, Integer> elements = new HashMap<>();
	private int size;

    public void add(int elt) {
    	if (elements.get(elt) != null) {
    		elements.put(elt, elements.get(elt) + 1);
    	} else {
    		elements.put(elt, 1);
    	}
    	size++;
    }

    public boolean isInSet(int elt) {
        boolean retVal = false;
        
        if (elements.containsKey(elt)) {
        	retVal = true;
        }
        
        return retVal;
    }

    public int getCountOf(int elt) {
    	if (elements.get(elt) != null) {
    		return elements.get(elt);
    	}
    	return 0;
    }

    public int size() {
        return size;
    }

    public Set<Integer> uniqueElements() {
        Set<Integer> retVal = new HashSet<>();
        
        for (Integer i : elements.keySet()) {
        	retVal.add(i);
        }
        
        return retVal;
    }

    public void removeOccurrence(int elt) {
    	if (elements.get(elt) != null) {
    		if (elements.get(elt) == 1) {
    			elements.remove(elt);
    		} else {
    			elements.put(elt, elements.get(elt) - 1);
    		}
    		size--;
    	}
    }

}
