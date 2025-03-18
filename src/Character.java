public class Character {
    private String name;
    private String role;
    private String text;
    private Location location;

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
        return "Character{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", text='" + text + '\'' +
                ", location=" + location.getName() +
                '}';
    }
}