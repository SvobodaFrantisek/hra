
public class Konec implements Command {
    @Override
    public String execute() {
        return "Hra ukoncena";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
