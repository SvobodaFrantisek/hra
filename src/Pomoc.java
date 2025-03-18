public class Pomoc implements Command {
    @Override
    public String execute() {
        return "Dostupne prikazy: Jdi, Seber, Poloz, Mluv, Prozkoumej, Pomoc, Napoveda, Inventar, Konec";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
