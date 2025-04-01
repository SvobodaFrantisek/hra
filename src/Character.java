/**
 * Reprezentuje postavu ve hre.
 */
public class Character {
    private String name;
    private String role;
    private String text;
    private Location location;

    /**
     * Konstruktor pro vytvoreni postavy.
     *
     * @param name     Jmeno postavy.
     * @param role     Role postavy.
     * @param text     Text, ktery postava rika.
     * @param location Lokace, ve ktere se postava nachazi.
     */
    public Character(String name, String role, String text, Location location) {
        this.name = name;
        this.role = role;
        this.text = text;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getText() {
        return text;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Character{" + "name='" + name + '\'' + ", role='" + role + '\'' + ", text='" + text + '\'' + ", location=" + location.getName() + '}';
    }
}