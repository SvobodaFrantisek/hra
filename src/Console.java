

import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private boolean exit = false;
    private HashMap<String, Command> commands = new HashMap<>();
    private Scanner sc = new Scanner(System.in);
    private Map map = new Map();
    private Loader loader = new Loader(map);
    private Player player = new Player("Hrac", 100, 0);

    public void inicialization() {
        commands.put("jdi", new Jdi(map));
        commands.put("pomoc", new Pomoc());
        commands.put("prozkoumej", new Prozkoumej(map));
        commands.put("seber", new Seber(map, player));
        commands.put("inventar", new Inventar(player));
        commands.put("poloz", new Poloz(player));
        commands.put("mluv", new Mluv(map, loader));
        commands.put("pouzij", new Pouzij(player));
        commands.put("konec", new Konec());

    }

    public void run() {
        System.out.println(">>");
        String input = sc.next();
        input = input.toLowerCase();
        input.trim();
        if (commands.containsKey(input)) {
            System.out.println(">>" + commands.get(input).execute());
        } else {
            System.out.println(">> undefined command");
        }
    }

    public void start() {
        inicialization();
        map.loadMap();
        loader.loadItems();
        loader.loadCharacters();
        try {

            do {
                run();
            } while (!exit);
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
