import java.util.Scanner;

public class Seber implements Command {
    private Scanner sc = new Scanner(System.in);
    private Map map;
    private Player player;

    public Seber(Map map, Player player) {
        this.map = map;
        this.player = player;
    }

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
            Item item = currentLocation.getAvailableItems().remove(input);
            player.getInventory().addItem(item);

            return "You picked up " + item.getName();
        } catch (Exception e) {
            return "invalid input";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}