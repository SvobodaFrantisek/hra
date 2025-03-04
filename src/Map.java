import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Map {
    private HashMap<Integer, Location> world = new HashMap<>();
    private int start = 1;
    private int currentPosition = start;

    public boolean loadMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("mapa.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(",");
                int id = Integer.parseInt(lines[0]);
                String name = lines[1];
                ArrayList<Integer> avaible = new ArrayList<>();
                boolean locked = false;
                for (int i = 2; i < lines.length; i++) {
                    if (lines[i].equals("LOCKED")) {
                        locked = true;
                    } else {
                        avaible.add(Integer.parseInt(lines[i]));
                    }
                }
                Location l = new Location(id, name, avaible, locked);
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

    public Location getCurrentLocation(int id) {
        return world.get(id);
    }

    public HashMap<Integer, Location> getWorld() {
        return world;
    }
}
