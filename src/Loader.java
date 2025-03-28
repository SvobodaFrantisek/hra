import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Loader {
    private Map map;
    private HashMap<String, Character> characters = new HashMap<>();

    public Loader(Map gameMap) {
        this.map = gameMap;
    }

    public boolean loadItems() {
        try (BufferedReader br = new BufferedReader(new FileReader("Itemy.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(",");

                String name = lines[0].trim();
                String description = lines[1].trim();
                String locationName = lines[2].trim();

                Location location = map.getLocation(locationName);
                Item item = new Item(name, description, locationName);
                location.addItem(item);

            }
            return true;
        } catch (IOException e) {
            System.out.println("chyba pri nacitani itemu " + e.getMessage());
        }
        return false;
    }

    public boolean loadCharacters() {
        try (BufferedReader br = new BufferedReader(new FileReader("Characters.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(",");


                String name = lines[0].trim();
                String role = lines[1].trim();
                String text = lines[2].trim();
                String locationName = lines[3].trim();

                Location location = map.getLocation(locationName);
                Character character = new Character(name, role, text, location);
                location.addCharacter(character);
            }
            return true;
        } catch (IOException e) {
            System.out.println("Chyba pri nacitani postav: " + e.getMessage());
        }
        return false;
    }

}
