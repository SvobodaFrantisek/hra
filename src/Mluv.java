
public class Mluv implements Command{
    private Character character;
    public Mluv(Character character) {
        this.character = character;
    }

    @Override
    public String execute() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
