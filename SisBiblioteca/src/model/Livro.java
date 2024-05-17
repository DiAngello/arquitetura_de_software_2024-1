public class Livro {
    private String titulo;
    private String autor;
    private String numeroRegistro;
    private boolean emprestado;

    public Livro(String titulo, String autor, String numeroRegistro) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroRegistro = numeroRegistro;
        this.emprestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    @Override
    public String toString() {
        return String.format("Título: %s\nAutor: %s\nNúmero de Registro: %s\nEmprestado: %s",
                titulo, autor, numeroRegistro, emprestado ? "Sim" : "Não");
    }
}
