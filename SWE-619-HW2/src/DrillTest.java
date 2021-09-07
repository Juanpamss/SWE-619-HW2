import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

@RunWith(Parameterized.class)
public class DrillTest {

	public Map<String, String> map;
	public String prompt;
	public String answer;
	
	//Constructor
	public DrillTest(String prompt, String answer) {
		this.prompt = prompt;
		this.answer = answer;
	}
	
	@Parameters
	public static List<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{"DoG", "Le ChIeN"},
			{"CAT", "le chat"},
			{"car", "La VOITURE"},
			{"book", "le livre"},
		});		
	}
	
	//Initialize Map
	@Before
	public void initMap() {		
		map = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);		
		map.put("dog", "le chien");
		map.put("cat", "le chat");
		map.put("car", "la voiture");
		map.put("BoOk", "le livre");
	}
	
	@Test
	public void testMapMatch() {
		
		//Test arguments not null
		assertTrue(Drill.matchEnhanced(map, prompt, answer));
	}
	
	@Test
	public void testMapExceptions() {
		
		//Test NPE
		
		//Map = null
		Assertions.assertThrows(NullPointerException.class, () -> {
			Drill.matchEnhanced(null, prompt, answer);
		});
		//Prompt = null
		Assertions.assertThrows(NullPointerException.class, () -> {
			Drill.matchEnhanced(map, null, answer);
		});
		
		//Answer = null
		Assertions.assertThrows(NullPointerException.class, () -> {
			Drill.matchEnhanced(map, prompt, null);
		});
		
	}
	
	@Test
	public void testMapNonExistingKey() {
		
		//Test non existing key in Map (IAE)
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Drill.matchEnhanced(map, "cheese", "le fromage");
		});
	}
	
	@Test
	public void testMapIncorrectAnswer() {
		
		//Test incorrect answer for existing key in Map.
		assertFalse(Drill.matchEnhanced(map, "dog", "le chat"));
	}
}
