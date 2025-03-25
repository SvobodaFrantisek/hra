import java.util.Scanner;

public class Mluv implements Command {
    private Scanner sc = new Scanner(System.in);
    private Map map;
    private Player player;
    private Location currentLocation;

    public Mluv(Map map, Player player) {
        this.map = map;
        this.player = player;
    }

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