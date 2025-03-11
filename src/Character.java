public class Character {
    public String name;
    public String role;
    public String text;

    public Character(String name, String role, String text) {
        this.name = name;
        this.role = role;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
