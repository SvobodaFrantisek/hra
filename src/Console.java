import java.util.HashMap;
import java.util.Scanner;

/**
 * Konzolovy system hry.
 */
public class Console {
    private boolean exit = false;
    private HashMap<String, Command> commands = new HashMap<>();
    private Scanner sc = new Scanner(System.in);
    private Map map = new Map();
    private Loader loader = new Loader(map);
    private Player player = new Player("Hrac", 100, 100, 100, 0);

    /**
     * Inicializuje dostupne prikazy.
     */
    public void inicialization() {
        commands.put("jdi", new Jdi(map, player));
        commands.put("pomoc", new Pomoc());
        commands.put("prozkoumej", new Prozkoumej(map, player));
        commands.put("seber", new Seber(map, player));
        commands.put("inventar", new Inventar(player));
        commands.put("poloz", new Poloz(player));
        commands.put("mluv", new Mluv(map, player));
        commands.put("pouzij", new Pouzij(player));
        commands.put("konec", new Konec());
        commands.put("napoveda", new Napoveda(map, player));
    }

    /**
     * Spusti konzoli a umoznuje zadavani prikazu.
     */
    public String run(String input) {
        input = input.toLowerCase().trim();
        if (commands.containsKey(input)) {
            String result = commands.get(input).execute();
            if (input.equals("konec")) {
                exit = true;
            }
            return result;
        } else {
            return "undefined command";
        }
    }

    /**
     * Spusti hru.
     */
    public void start() {
        inicialization();
        map.loadMap();
        loader.loadItems();
        loader.loadCharacters();
        player.getInventory().setCapacity(3);

        try {
            while (!exit) {
                System.out.println(player.status());
                System.out.print(">> ");
                String input = sc.nextLine();
                String output = run(input);
                System.out.println(">> " + output);
                if (!player.isAlive()){
                    exit = true;
                }
                if (input.equals("konec")) {
                    exit = true;
                }
            }
        } catch (Exception e) {
             e.getMessage();
        }
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }
}