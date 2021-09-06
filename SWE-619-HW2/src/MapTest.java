import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

@RunWith(Parameterized.class)
public class MapTest {

	public Map<String, String> map;
	public String prompt;
	public String answer;
	
	public MapTest(String prompt, String answer) {
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
		map = new HashMap<String, String>();		
		map.put("dog", "le chien");
		map.put("cat", "le chat");
		map.put("car", "la voiture");
		map.put("book", "le livre");
	}
	
	@Test
	public void testMapMatch() {
		
		//Test arguments not null
		assertTrue(Match.match(map, prompt, answer));
	}
	
	@Test
	public void testMapExceptions() {
		
		//Test NPE and IAE exceptions
		
		//Map = null
		Assertions.assertThrows(NullPointerException.class, () -> {
			Match.match(null, prompt, answer);
		});
		//Prompt = null
		Assertions.assertThrows(NullPointerException.class, () -> {
			Match.match(map, null, answer);
		});
		
		//Answer = null
		Assertions.assertThrows(NullPointerException.class, () -> {
			Match.match(map, prompt, null);
		});
		
	}
	
	@Test
	public void testMapNonExistingKey() {
		
		//Test non existing key in Map.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Match.match(map, "cheese", "le fromage");
		});
	}
	
	@Test
	public void testMapIncorrectAnswer() {
		
		//Test incorrect answer for existing key in Map.
		assertFalse(Match.match(map, "dog", "le chat"));
	}
}
