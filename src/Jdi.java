import java.util.Scanner;

public class Jdi implements Command {
    private Scanner sc = new Scanner(System.in);
    private Map map;
    private Player player;
    private Location currentLocation = new Location();
    private Location targetLocation = new Location();

    public Jdi(Map map, Player player) {
        this.map = map;
        this.player = player;
    }

    @Override
    public String execute() {
        int currentID = map.getCurrentPosition();
        currentLocation = map.getCurrentLocation(currentID);
        System.out.println("Current " + currentLocation);
        System.out.println("Current ID: " + currentID);
        System.out.println("Avaible id of locations from this location" + currentLocation.getLocations());
        System.out.println("enter id of your target location");
        System.out.println(">>");
        try {
            int targetID = sc.nextInt();
            targetLocation = map.getWorld().get(targetID);

            if (targetLocation.isLocked()) {
                if (player.hasItem(targetLocation.getRequiredItem())) {
                    targetLocation.setLocked(false);
                    return "you used " + targetLocation.getRequiredItem() + " to unlock this location now you can go there";
                }
                return "this location is locked you need " + targetLocation.getRequiredItem() + " to unlock it";
            }

            if (currentLocation.getLocations().contains(targetID)) {
                map.setCurrentPosition(targetID);

                if (targetLocation.getName().equalsIgnoreCase("Kemp")) {
                    System.out.println("congratulations! you reached the camp and won the game!");
                    System.exit(0);
                }
            } else {
                return "you cant move there";
            }


            return "you move into" + targetLocation.getName();
        } catch (Exception e) {
            sc.nextLine();
            return " you entered invalid input";
        }
    }


    @Override
    public boolean exit() {
        return false;
    }
}
