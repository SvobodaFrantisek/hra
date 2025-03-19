import java.util.ArrayList;
import java.util.Map;

public class Location {
    private int id;
    private String name;
    private ArrayList<Integer> locations;
    private ArrayList<Item> availableItems;
    private boolean locked;

    public Location(int id, String name, ArrayList<Integer> locations, boolean locked) {
        this.id = id;
        this.name = name;
        this.locations = locations;
        this.availableItems = new ArrayList<>();
        this.locked = locked;
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

    public ArrayList<Item> getAvailableItems() {
        if (availableItems == null) {
            return new ArrayList<>();
        }
        return availableItems;
    }

    public void setAvailableItems(ArrayList<Item> availableItems) {
        this.availableItems = availableItems;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
