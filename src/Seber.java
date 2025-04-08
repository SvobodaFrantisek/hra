import java.util.Scanner;

/**
 * Trida reprezentujici prikaz pro sebrani predmetu.
 */
public class Seber implements Command {
    private Scanner sc = new Scanner(System.in);
    private Map map;
    private Player player;

    /**
     * Vytvori prikaz Seber.
     *
     * @param map    Mapa hry.
     * @param player Hrac.
     */
    public Seber(Map map, Player player) {
        this.map = map;
        this.player = player;
    }

    /**
     * Vykona prikaz seber, ktery umozni hraci sebrat predmet z aktualni lokace,
     * pokud je predmet k dispozici v lokalite.
     *
     * @return Zprava o tom, zda byl predmet sebran, nebo zda nebyl dostupny.
     */
    @Override
    public String execute() {
        int currentID = map.getCurrentPosition();
        Location currentLocation = map.getCurrentLocation(currentID);

        if (currentLocation.getAvailableItems().isEmpty()) {
            return "no items available";
        }

        System.out.println("Available items: ");
        for (int i = 0; i < currentLocation.getAvailableItems().size(); i++) {
            System.out.println(i + 1 + ": " + currentLocation.getAvailableItems().get(i).getName() + " - " + currentLocation.getAvailableItems().get(i).getDescription());
        }
        System.out.print("Enter the number of the item you wanna pick up: ");
        System.out.println(">> ");

        try {
            int input = sc.nextInt() - 1;
            if (player.getInventory().getItems().size()<player.getInventory().getCapacity()){
                Item item = currentLocation.getAvailableItems().remove(input);
                player.getInventory().addItem(item);
            }else {
                return "inventory is full";
            }

            return "You picked up item ";
        } catch (Exception e) {
            sc.nextLine();
            return "invalid input";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}