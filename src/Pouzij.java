import java.util.Scanner;

/**
 * Trida reprezentujici prikaz pro pouziti predmetu.
 */
public class Pouzij implements Command {
    private Player player;
    private Scanner sc = new Scanner(System.in);

    /**
     * Vytvori prikaz Pouzij.
     *
     * @param player Hrac.
     */
    public Pouzij(Player player) {
        this.player = player;
    }

    /**
     * Vykona prikaz pouzij, ktery umozni hraci pouzit predmet z inventare.
     * Hrac muze pouzit predmet na aktualni lokaci, pokud to situace dovoluje.
     *
     * @return Zprava o tom, zda byl predmet uspechne pouzit, nebo zda predmet neni vhodny k pouziti.
     */
    @Override
    public String execute() {
        if (player.getInventory().getItems().isEmpty()) {
            return "no items to use in your invetory ";
        }

        for (int i = 0; i < player.getInventory().getItems().size(); i++) {
            System.out.println(i + 1 + ": " + player.getInventory().getItems().get(i).getName() + " - " + player.getInventory().getItems().get(i).getDescription());
        }
        System.out.print("Enter the number of the item you wanna use ");
        System.out.println(">> ");
        try {
            Item item = null;
            int input = sc.nextInt() - 1;
            for (int i = 0; i < player.getInventory().getItems().size(); i++) {
                if (player.getInventory().getItems().get(i).equals(player.getInventory().getItems().get(input))) {
                    item = player.getInventory().getItems().get(i);
                }
            }
            String vypis = "";
            if (item != null) {
                vypis = player.useItem(item);
                player.getInventory().getItems().remove(item);
                System.out.println(player.getInventory().getCapacity());
            }
            return vypis;

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