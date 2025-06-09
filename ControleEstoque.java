import java.util.ArrayList;
import java.util.Scanner;

class Produto {
    String nome;
    String codigo;
    int quantidade;
    double preco;

    Produto(String nome, String codigo, int quantidade, double preco) {
        this.nome = nome;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String toString() {
        return "Código: " + codigo + " | Nome: " + nome + " | Quantidade: " + quantidade + " | Preço: R$" + preco;
    }
}

public class ControleEstoque {
    static ArrayList<Produto> estoque = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Excluir produto");
            System.out.println("4 - Alterar produto");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1: cadastrar(); break;
                case 2: listar(); break;
                case 3: excluir(); break;
                case 4: alterar(); break;
                case 0: System.out.println("Saindo..."); break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    static void cadastrar() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Código: ");
        String codigo = sc.nextLine();
        System.out.print("Quantidade: ");
        int quantidade = sc.nextInt();
        System.out.print("Preço: ");
        double preco = sc.nextDouble();
        sc.nextLine(); // limpar buffer

        estoque.add(new Produto(nome, codigo, quantidade, preco));
        System.out.println("Produto cadastrado!");
    }

    static void listar() {
        if (estoque.isEmpty()) {
            System.out.println("Estoque vazio!");
        } else {
            for (Produto p : estoque) {
                System.out.println(p);
            }
        }
    }

    static void excluir() {
        System.out.print("Digite o código do produto a excluir: ");
        String codigo = sc.nextLine();
        Produto removido = null;
        for (Produto p : estoque) {
            if (p.codigo.equals(codigo)) {
                removido = p;
                break;
            }
        }
        if (removido != null) {
            estoque.remove(removido);
            System.out.println("Produto removido!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    static void alterar() {
        System.out.print("Digite o código do produto a alterar: ");
        String codigo = sc.nextLine();
        for (Produto p : estoque) {
            if (p.codigo.equals(codigo)) {
                System.out.print("Novo nome: ");
                p.nome = sc.nextLine();
                System.out.print("Nova quantidade: ");
                p.quantidade = sc.nextInt();
                System.out.print("Novo preço: ");
                p.preco = sc.nextDouble();
                sc.nextLine(); // limpar buffer
                System.out.println("Produto alterado!");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }
}
