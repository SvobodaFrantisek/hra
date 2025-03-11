import java.util.ArrayList;

public class Inventar implements Command{
    private ArrayList<Item> items;
    private int capacity;

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Inventar(ArrayList<Item> items, int capacity) {
        this.items = items;
        this.capacity = capacity;
    }

    @Override
    public String execute() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
