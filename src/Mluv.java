import java.util.Scanner;

/**
 * Trida reprezentujici prikaz pro mluveni s postavami.
 */
public class Mluv implements Command {
    private Scanner sc = new Scanner(System.in);
    private Map map;
    private Player player;
    private Location currentLocation;

    /**
     * Vytvori prikaz Mluv.
     *
     * @param map    Mapa hry.
     * @param player Hrac.
     */
    public Mluv(Map map, Player player) {
        this.map = map;
        this.player = player;
    }

    /**
     * Vykona prikaz mluv, ktery umozni hraci komunikovat s postavou v aktualni lokalite.
     * Pokud je v lokalite postava, hrac muze s ni promluvit a ziskat informace.
     *
     * @return Zprava o tom, zda byla nalezena postava a co hrac o ni zjistil.
     */
    @Override
    public String execute() {
        int currentID = map.getCurrentPosition();
        currentLocation = map.getCurrentLocation(currentID);

        System.out.println(" who you wannda talk to");
        String characterName = sc.nextLine().trim().toLowerCase();

        Character character = currentLocation.findCharacter(characterName);
        if (character == null) {
            return "this chararacter does not exist";
        }

        if (character.getLocation().equals(currentLocation)) {
            currentLocation.setLocked(true);
            if (player.hasItem("Svitilna")) {
                map.getLocation("Kemp").setLocked(false);
            }
            return "you are talking with " + character.getName();
        } else {
            return "this character is not in your location.";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}