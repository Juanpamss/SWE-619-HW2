import java.util.Map;

public class Match {

	public static boolean match (Map < String, String > m, String prompt, String answer) throws NullPointerException, IllegalArgumentException{
		/*
		 * Requires: m, prompt, answer not null; prompt is a key in Map m, ignoring case
	   		Effects:  returns true iff the Map m maps prompt to answer, ignoring case
		 * */
		
		if(m != null && prompt != null && answer != null) {
			if(m.get(prompt.toLowerCase()) != null) {
				if(m.get(prompt.toLowerCase()).equalsIgnoreCase(answer)) {
					return true;
				}
			}else {
				//Throws MFAE or Illegal Argument Exception
				throw new IllegalArgumentException();
			}
		}else {
			//Throws NPE
			throw new NullPointerException();
		}
		
		//If the input answer does not match
		return false;
	} 
}
