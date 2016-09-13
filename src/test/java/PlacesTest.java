import org.junit.*;
import static org.junit.Assert.*;

public class PlacesTest{

  @Test
  public void Places_instantiatesCorrectly_true(){
    Places placesList = new Places("Portland, OR");
    assertEquals(true, placesList instanceof Places);
  }
  @Test
  public void Places_instantiatesWithDescription_String(){
    Places placesList = new Places("Portland, OR");
    assertEquals("Portland, OR", placesList.getDescription());
  }
}
