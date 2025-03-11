

import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private boolean exit = false;
    private HashMap<String, Command> commands = new HashMap<>();
    private Scanner sc = new Scanner(System.in);
    private Map map = new Map();

    public void inicialization() {
        commands.put("jdi", new Jdi(map));
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
        try {

            do {
                run();
            } while (!exit);
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
