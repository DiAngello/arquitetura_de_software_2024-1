import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
    private List<Livro> livros;

    public Biblioteca() {
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> buscarLivrosPorTitulo(String titulo) {
        return livros.stream()
                .filter(livro -> livro.getTitulo().equalsIgnoreCase(titulo))
                .collect(Collectors.toList());
    }

    public List<Livro> buscarLivrosPorAutor(String autor) {
        return livros.stream()
                .filter(livro -> livro.getAutor().equalsIgnoreCase(autor))
                .collect(Collectors.toList());
    }

    public boolean emprestarLivro(String numeroRegistro) {
        for (Livro livro : livros) {
            if (livro.getNumeroRegistro().equals(numeroRegistro) && !livro.isEmprestado()) {
                livro.setEmprestado(true);
                return true;
            }
        }
        return false;
    }

    public boolean devolverLivro(String numeroRegistro) {
        for (Livro livro : livros) {
            if (livro.getNumeroRegistro().equals(numeroRegistro) && livro.isEmprestado()) {
                livro.setEmprestado(false);
                return true;
            }
        }
        return false;
    }

    public List<Livro> getLivros() {
        return livros;
    }
}
