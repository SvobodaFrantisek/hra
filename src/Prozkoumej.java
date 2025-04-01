import java.util.Scanner;

/**
 * Trida reprezentujici prikaz pro prozkoumani lokace.
 */
public class Prozkoumej implements Command {
    private Location location;
    private Scanner sc = new Scanner(System.in);
    private Map map;
    private Player player;
    private Location currentLocation = new Location();
    private Location targetLocation = new Location();

    /**
     * Vytvori prikaz Prozkoumej.
     *
     * @param map    Mapa hry.
     * @param player Hrac.
     */
    public Prozkoumej(Map map, Player player) {
        this.map = map;
        this.player = player;
    }

    @Override
    public boolean exit() {
        return false;
    }

    /**
     * Vykona prikaz prozkoumej, ktery umozni hraci prozkoumat aktualni lokaci.
     * Hrac muze ziskat informace o dostupnych predmetech a postavach v dane lokalite.
     *
     * @return Popis dostupnych predmetu a postav v aktualni lokalite.
     */
    @Override
    public String execute() {
        int currentID = map.getCurrentPosition();
        currentLocation = map.getCurrentLocation(currentID);

        System.out.println("current " + currentLocation.getName());
        System.out.println("avaiable location to explore " + currentLocation.getLocations());
        System.out.print("enter ID of location you wannna explore ");
        System.out.println(">>");


        try {
            int targetID = sc.nextInt();

            targetLocation = map.getWorld().get(targetID);

            if (targetLocation == null) {
                return "this location is not available";
            }

            if (targetLocation.isLocked()) {
                return "this location is locked";
            }
            System.out.println(targetLocation.toString());

            if (player.hasItem("Svitilna")) {
                return "you explored " + targetLocation.getName() + "avaiable items " + targetLocation.getAvailableItems() + " characters in this room " + targetLocation.getCharacters();

            }
            return "you explored " + targetLocation.getName() + "avaiable items " + targetLocation.getAvailableItems();
        } catch (Exception e) {
            sc.nextLine();
            return "invalid input";
        }
    }
}
