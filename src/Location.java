import java.util.ArrayList;
import java.util.Map;

public class Location {
    private int id;
    private String name;
    private ArrayList<Integer> locations;
    private ArrayList<Item> availableItems;
    private ArrayList<Character> characters;
    private boolean locked;
    private String requiredItem;

    public Location(int id, String name, ArrayList<Integer> locations, boolean locked, String requiredItem) {
        this.id = id;
        this.name = name;
        this.locations = locations;
        this.availableItems = new ArrayList<>();
        this.characters = new ArrayList<>();
        this.locked = locked;
        this.requiredItem = requiredItem;
    }

    public Location() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Integer> locations) {
        this.locations = locations;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public void addItem(Item item) {
        availableItems.add(item);
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public Character findCharacter(String characterName) {
        for (int i = 0; i < characters.size(); i++) {
            if (characters.get(i).getName().equalsIgnoreCase(characterName)) {
                return characters.get(i);
            }
        }
        return null;
    }

    public ArrayList<Item> getAvailableItems() {
        if (availableItems == null) {
            return new ArrayList<>();
        }
        return availableItems;
    }

    public ArrayList<Character> getCharacters() {
        if (characters == null) {
            return new ArrayList<>();
        }
        return characters;
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }

    public void setAvailableItems(ArrayList<Item> availableItems) {
        this.availableItems = availableItems;
    }

    public String getRequiredItem() {
        return requiredItem;
    }

    public void setRequiredItem(String requiredItem) {
        this.requiredItem = requiredItem;
    }

    @Override
    public String toString() {
        return "Location{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
