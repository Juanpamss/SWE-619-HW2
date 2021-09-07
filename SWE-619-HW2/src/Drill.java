import java.util.Map;

public class Drill {
	
	public static boolean match (Map<String, String > m, String prompt, String answer) {
		// Requires: m, prompt, answer not null; prompt is a key in Map m, ignoring case
		// Effects:  returns true iff the Map m maps prompt to answer, ignoring case
		
		return m.get(prompt).equalsIgnoreCase(answer) ? true : false;
	}

	public static boolean matchEnhanced (Map<String, String > m, String prompt, String answer)
			throws NullPointerException, IllegalArgumentException {
		// Effects: 
		// 		if m, prompt, or answer is null throws NullPointerException 
		// 		if prompt is not a key in Map m, ignoring case, throws IllegalArgumentException
		//		else returns true iff the Map m maps prompt to answer, ignoring case
		
		if (answer == null || prompt == null) {
			throw new NullPointerException();
		}
		if (!m.containsKey(prompt)) {
			throw new IllegalArgumentException();
		}
		return m.get(prompt).equalsIgnoreCase(answer) ? true : false;
	}
	
}
