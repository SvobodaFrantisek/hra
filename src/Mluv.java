import java.util.Scanner;

public class Mluv implements Command {
    private Scanner sc = new Scanner(System.in);
    private Map map;
    private Loader loader;
    private Location currentLocation;

    public Mluv(Map map, Loader loader) {
        this.map = map;
        this.loader = loader;
    }

    @Override
    public String execute() {
        int currentID = map.getCurrentPosition();
        currentLocation = map.getCurrentLocation(currentID);
        System.out.println("who do you wanna talk to");
        String characterName = sc.nextLine().trim().toLowerCase();

        Character character = loader.getCharacter(characterName);
        if (character == null) {
            return "this character doesn't exist";
        }
        System.out.println(character.getLocation());
        System.out.println(currentLocation);

        if (character.getLocation().equals(currentLocation)) {
            return "you are talking with " + character.getName();
        } else {
            return "this character is not in your location";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}