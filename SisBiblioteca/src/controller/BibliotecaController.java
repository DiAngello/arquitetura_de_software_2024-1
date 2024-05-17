import java.util.List;

public class BibliotecaController {
    private Biblioteca biblioteca;
    private BibliotecaView view;

    public BibliotecaController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        this.view = new BibliotecaView(this);
    }

    public void iniciar() {
        view.iniciar();
    }

    public List<Livro> buscarLivrosPorTitulo(String titulo) {
        return biblioteca.buscarLivrosPorTitulo(titulo);
    }

    public List<Livro> buscarLivrosPorAutor(String autor) {
        return biblioteca.buscarLivrosPorAutor(autor);
    }

    public void adicionarLivro(Livro livro) {
        biblioteca.adicionarLivro(livro);
    }

    public boolean emprestarLivro(String numeroRegistro) {
        return biblioteca.emprestarLivro(numeroRegistro);
    }

    public boolean devolverLivro(String numeroRegistro) {
        return biblioteca.devolverLivro(numeroRegistro);
    }
}
