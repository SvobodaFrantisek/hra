import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Map {
    private HashMap<Integer, Location> world = new HashMap<>();
    private int start = 0;
    private int currentPosition = start;

    public boolean loadMap(){
        try (BufferedReader br = new BufferedReader(new FileReader("mapa.txt"))) {
            String line;
            while ((line = br.readLine()) != null){
                String[] lines = line.split(",");
                Location l = new Location(
                );
                world.put(Integer.valueOf(lines[0]), l);

            }
            return true;
        }catch (IOException e){
            return false;
        }
    }

}
