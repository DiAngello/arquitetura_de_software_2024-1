public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        BibliotecaController controller = new BibliotecaController(biblioteca);
        controller.iniciar();
    }
}
