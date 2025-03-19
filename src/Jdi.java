
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
            int targetID = sc.nextInt();
            targetLocation = map.getWorld().get(targetID);

            if (targetLocation.isLocked()) {
                return "this location is locked";
            }

            if (currentLocation.getLocations().contains(targetID)) {
                map.setCurrentPosition(targetID);
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
