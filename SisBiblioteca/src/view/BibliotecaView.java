package view;

import controller.BibliotecaController;
import model.Livro;

import java.util.List;
import java.util.Scanner;

public class BibliotecaView {
    private BibliotecaController controller;
    private Scanner scanner;

    public BibliotecaView(BibliotecaController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Adicionar livro");
            System.out.println("2. Buscar livro por título");
            System.out.println("3. Buscar livro por autor");
            System.out.println("4. Emprestar livro");
            System.out.println("5. Devolver livro");
            System.out.println("6. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            switch (opcao) {
                case 1:
                    adicionarLivro();
                    break;
                case 2:
                    buscarPorTitulo();
                    break;
                case 3:
                    buscarPorAutor();
                    break;
                case 4:
                    emprestarLivro();
                    break;
                case 5:
                    devolverLivro();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void adicionarLivro() {
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite o autor do livro: ");
        String autor = scanner.nextLine();
        System.out.print("Digite o número de registro do livro: ");
        String numeroRegistro = scanner.nextLine();
        controller.adicionarLivro(new Livro(titulo, autor, numeroRegistro));
        System.out.println("Livro adicionado com sucesso!");
    }

    private void buscarPorTitulo() {
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();
        List<Livro> livros = controller.buscarLivrosPorTitulo(titulo);
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado com esse título.");
        } else {
            livros.forEach(System.out::println);
        }
    }

    private void buscarPorAutor() {
        System.out.print("Digite o autor do livro: ");
        String autor = scanner.nextLine();
        List<Livro> livros = controller.buscarLivrosPorAutor(autor);
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado com esse autor.");
        } else {
            livros.forEach(System.out::println);
        }
    }

    private void emprestarLivro() {
        System.out.print("Digite o número de registro do livro a ser emprestado: ");
        String numeroRegistro = scanner.nextLine();
        if (controller.emprestarLivro(numeroRegistro)) {
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("Livro não encontrado ou já emprestado.");
        }
    }

    private void devolverLivro() {
        System.out.print("Digite o número de registro do livro a ser devolvido: ");
        String numeroRegistro = scanner.nextLine();
        if (controller.devolverLivro(numeroRegistro)) {
            System.out.println("Livro devolvido com sucesso!");
        } else {
            System.out.println("Livro não encontrado ou não está emprestado.");
        }
    }
}