import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 0;

        while (opcao != 7) {
            mostrarMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    criarNovoEmpregado();
                    break;
                case 2:
                    promoverEmpregado();
                    break;
                case 3:
                    aumentarSalarioEmpregado();
                    break;
                case 4:
                    demitirEmpregado();
                    break;
                case 5:
                    fazerAniversarioEmpregado();
                    break;
                case 6:
                    mostrarDetalhesEmpregados();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("Menu:");
        System.out.println("1. Criar novo empregado");
        System.out.println("2. Promover empregado");
        System.out.println("3. Aumentar salário do empregado");
        System.out.println("4. Demitir empregado");
        System.out.println("5. Fazer aniversário do empregado");
        System.out.println("6. Mostrar detalhes dos empregados");
        System.out.println("7. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void criarNovoEmpregado() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        System.out.print("Salário: ");
        double salario = scanner.nextDouble();
        scanner.nextLine();  // Consumir a nova linha

        Funcionario novoFuncionario = new Funcionario(nome, idade, salario);
        funcionarios.add(novoFuncionario);
        System.out.println("Novo empregado criado com sucesso.");
    }

    private static void promoverEmpregado() {
        Funcionario funcionario = selecionarFuncionario();
        if (funcionario != null) {
            funcionario.promover();
        }
    }

    private static void aumentarSalarioEmpregado() {
        Funcionario funcionario = selecionarFuncionario();
        if (funcionario != null) {
            System.out.print("Percentual de aumento: ");
            double percentual = scanner.nextDouble();
            scanner.nextLine();  // Consumir a nova linha
            funcionario.aumentarSalario(percentual);
        }
    }

    private static void demitirEmpregado() {
        Funcionario funcionario = selecionarFuncionario();
        if (funcionario != null) {
            System.out.println("Motivos para demissão:");
            System.out.println("1. Justa causa");
            System.out.println("2. Decisão do empregador");
            System.out.println("3. Aposentadoria");
            System.out.print("Escolha o motivo: ");
            int motivo = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha
            funcionario.demitir(motivo);
        }
    }

    private static void fazerAniversarioEmpregado() {
        Funcionario funcionario = selecionarFuncionario();
        if (funcionario != null) {
            funcionario.fazerAniversario();
            System.out.println("Aniversário celebrado. Idade atual: " + funcionario.getIdade());
        }
    }

    private static void mostrarDetalhesEmpregados() {
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome() + ", Idade: " + funcionario.getIdade() + ", Salário: " + funcionario.getSalario());
        }
    }

    private static Funcionario selecionarFuncionario() {
        if (funcionarios.isEmpty()) {
            System.out.println("Não há empregados cadastrados.");
            return null;
        }

        System.out.println("Lista de empregados:");
        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.println((i + 1) + ". " + funcionarios.get(i).getNome());
        }
        System.out.print("Escolha um empregado pelo número: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine();  // Consumir a nova linha

        if (indice >= 0 && indice < funcionarios.size()) {
            return funcionarios.get(indice);
        } else {
            System.out.println("Índice inválido.");
            return null;
        }
    }
}
