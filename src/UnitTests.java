import static org.junit.jupiter.api.Assertions.*;


/**
 * Trida UnitTests obsahuje jednotkove testy pro hlavni komponenty hry.
 * poznamka: zde mi pomahalo https://chatgpt.com jinak bych se vubec nechytal.
 */
public class UnitTests {
    private Console console;
    private Map map;
    private Loader loader;
    private Player player;

    @org.junit.jupiter.api.BeforeEach
    public void setup() {
        console = new Console();
        map = new Map();
        loader = new Loader(map);
        console.inicialization();
        map.loadMap();
        loader.loadItems();
        loader.loadCharacters();
        player = new Player("test", 100, 100,100,0);
    }
    /**
     * Testuje, zda se mapa spravne nacte.
     */
    @org.junit.jupiter.api.Test
    public void testLoadMap() {
        boolean expected = true;
        boolean actual = map.loadMap();
        assertEquals(expected, actual, "Map should load correctly");
    }
    /**
     * Testuje, zda se predmety spravne nactou.
     */
    @org.junit.jupiter.api.Test
    public void testLoadItems() {
        boolean expected = true;
        boolean actual = loader.loadItems();
        assertEquals(expected, actual, "Items should load correctly");
    }
    /**
     * Testuje, zda se postavy spravne nactou.
     */
    @org.junit.jupiter.api.Test
    public void testLoadCharacters() {
        boolean expected = true;
        boolean actual = loader.loadCharacters();
        assertEquals(expected, actual, "Characters should load correctly");
    }
    /**
     * Testuje vykonani validniho prikazu v konzoli.
     */
    @org.junit.jupiter.api.Test
    public void testRunValidCommand() {
        String actual = console.run("inventar");
        System.out.println("Inventar command returned: '" + actual + "'");
        assertEquals("your inventory:\nempty", actual, "Command inventar should return empty inventory");
    }
    /**
     * Testuje vykonani neplatneho prikazu v konzoli.
     */
    @org.junit.jupiter.api.Test
    public void testRunInvalidCommand() {
        String expected = "undefined command";
        String actual = console.run("gfgfgffg");
        assertEquals(expected, actual, "Unknown command should return as a undefined command");
    }
    /**
     * Testuje spravu inventare hrace.
     */
    @org.junit.jupiter.api.Test
    void testInventoryManagement() {
        Inventar inventar = new Inventar(player);
        Item item = new Item("Svitilna", "test", "TestLocation");
        inventar.addItem(item);
        assertTrue(inventar.getItems().contains(item), "Item should be in inventory");
    }
}