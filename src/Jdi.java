import java.util.Scanner;

public class Jdi implements Command {
    private Scanner sc = new Scanner(System.in);
    private Map map;
    public Jdi(Map map){
        this.map = map;
    }
    @Override
    public String execute() {
        int currentID = map.getCurrentPosition();
        Location currentLocation = map.getCurrentLocation(currentID);
        System.out.println("Current " + currentLocation);
        System.out.println("Current ID: " + currentID);
        System.out.println("Avaible id of locations from this location" + currentLocation.getLocations());
        System.out.println("enter id of your target location");
        System.out.println(">>");
        try {
            int input = sc.nextInt();
            int targetID = input;
            if (currentLocation.getLocations().contains(targetID)) {
                map.setCurrentPosition(targetID);
                System.out.println("You moved into: " + map.getCurrentLocation(targetID).getName());
            } else {
                System.out.println("You cant go there.");
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
