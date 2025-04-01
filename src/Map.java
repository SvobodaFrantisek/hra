import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Trida reprezentujici mapu hry a nacteni mapy ze souboru.
 */
public class Map {
    private HashMap<Integer, Location> world = new HashMap<>();
    private int start = 1;
    private int currentPosition = start;

    /**
     * Nacte mapu hry.
     */
    public boolean loadMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("mapa.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(",");
                int id = Integer.parseInt(lines[0]);
                String name = lines[1];
                ArrayList<Integer> avaible = new ArrayList<>();
                boolean locked = false;
                String requiredItem = null;
                int i = 2;
                while (i < lines.length) {
                    if (lines[i].equals("LOCKED")) {
                        locked = true;
                        i++;
                        if (i < lines.length) {
                            requiredItem = lines[i];
                        }
                        break;
                    } else {
                        avaible.add(Integer.parseInt(lines[i]));
                    }
                    i++;
                }

                Location l = new Location(id, name, avaible, locked, requiredItem);
                world.put(id, l);
            }

            return true;
        } catch (IOException e) {
            System.out.println("chyba pri nacitani mapy");
        }
        return false;

    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    /**
     * Vrati lokaci podle ID.
     *
     * @param id ID hledane lokace.
     * @return Objekt lokace nebo null, pokud neexistuje.
     */
    public Location getCurrentLocation(int id) {
        return world.get(id);
    }

    public HashMap<Integer, Location> getWorld() {
        return world;
    }

    /**
     * Vrati lokaci podle nazvu.
     *
     * @param name Nazev hledane lokace.
     * @return Objekt lokace nebo null, pokud neexistuje.
     */
    public Location getLocation(String name) {
        for (Location location : world.values()) {
            if (location.getName().equalsIgnoreCase(name)) {
                return location;
            }
        }
        return null;
    }
}
