import java.util.ArrayList;

/**
 * Inventar hrace.
 */
public class Inventar implements Command {
    private ArrayList<Item> items;
    private Player player;
    private int capacity;

    /**
     * Vytvori inventar pro hrace.
     *
     * @param player Hrac, kteremu inventar patri.
     */
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

    /**
     * Prida predmet do inventare.
     *
     * @param item predmet ve hre
     */
    public String addItem(Item item) {
        String vypis ="";
        if (items.size()<capacity) {
            items.add(item);
            vypis = "item added";
        }else {
            vypis = "inventory is full";
        }
        return vypis;
    }

    /**
     * Vypise obsah inventare.
     */
    public String showInventory() {
        String vypis = "your inventory:\n";
        if (items.isEmpty()) {
            vypis += "empty";
        } else {
            for (int i = 0; i < items.size(); i++) {
                vypis += items.get(i).getName() + " || " + items.get(i).getDescription() + "\n";
            }
        }
        return vypis;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Vykona prikaz inventar, ktery vypise obsah inventare hrace.
     * Pokud je inventar prazdny, vypise informaci, ze je prazdny.
     *
     * @return Zprava o obsahu inventare nebo o tom, ze je prazdny.
     */
    @Override
    public String execute() {
        return showInventory();
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public String toString() {
        return "Inventar{" + "items=" + items + '}';
    }
}