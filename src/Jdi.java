import java.util.Scanner;

public class Jdi implements Command {
    private Scanner sc = new Scanner(System.in);
    private Map map;
    private Location currentLocation = new Location();
    private Location targetLocation = new Location();

    public Jdi(Map map) {
        this.map = map;
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
            int input = sc.nextInt();
            int targetID = input;

            targetLocation = map.getWorld().get(targetID);

            if (targetLocation.isLocked()) {
                return "this location is locked";
            }

            if (currentLocation.getLocations().contains(targetID)) {
                map.setCurrentPosition(targetID);
                return "you moved to " + targetLocation.getName();
            } else {
                return "you cant move there";
            }
        } catch (Exception e) {
            System.out.println("you entered an invalid input");
        }
        return null;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
