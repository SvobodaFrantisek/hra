import java.util.ArrayList;

public class Inventar implements Command {
    private ArrayList<Item> items;
    private Player player;

    public Inventar(Player player) {
        this.player = player;
        if (player.getInventory() != null) {
            this.items = player.getInventory().getItems();
        } else {
            this.items = new ArrayList<>();
        }
    }

    public Inventar() {
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void showInventory() {
        if (items.isEmpty()) {
            System.out.println("inventory is empty");
        } else {
            System.out.println("your inventory");
            for (int i = 0; i < items.size(); i++) {
                System.out.println(items.get(i).getName() + " || " + items.get(i).getDescription());
            }
        }
    }

    @Override
    public String toString() {
        return "Inventar{" +
                "items=" + items +
                '}';
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public String execute() {
        showInventory();
        return "";
    }
}