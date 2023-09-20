import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    Database db;

    //udføres en gang for hver test

    @BeforeEach
    void setUP(){
        //text fixture
        db = new Database();
        db.getSuperherolist().addAll(List.of(
                new Superhero("Superman", "Kent Clark", "Flying", 1938, "No", "9000"),
                new Superhero("Batman", "Bruce Wayne", "Strong", 1920, "Yes", "200"),
                new Superhero("Ironman", "Tony Stark", "Robot", 1995, "Yes", "3000")));
    }

    @Test
    void findSuperhero() {
        //Arrange test
        String expectedName = "Superman";
        //act on method
        //metode der tester "find superhero"
        Superhero result = db.findSuperhero("Superman");
        //tester at result ikke er null
        assertNotNull(result);
        String actualName = result.getName();
        //assert result
        assertEquals(expectedName,actualName);

    }

    @Test
    void findSuperheroes() {
        // AssertTrue(false)
        int expectedSize = 3;
        ArrayList<Superhero> result = db.findSuperheroes("man");
        int actualSize=result.size();
        assertEquals(expectedSize,actualSize);
    }

    @Test
    void addSuperhero() {
        //tilføj superhero
        int startSize = db.getSuperherolist().size();
        db.addSuperhero(new Superhero("Aquaman", "Jens", "Fish", 1999, "No", "9000"));
        int expectedDbSize = startSize +1;
        int actualSize = db.getSuperherolist().size();
        assertEquals(expectedDbSize,actualSize);
    }

    @Test
    void deleteSuperhero() {
        int startSize = db.getSuperherolist().size();
        db.deleteSuperhero("Batman");
        int expectedDbSize = startSize -1;
        int actualSize = db.getSuperherolist().size();
        assertEquals(expectedDbSize,actualSize);
        System.out.println(db.getSuperherolist());
    }








}