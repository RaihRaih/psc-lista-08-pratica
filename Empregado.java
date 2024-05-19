public class Empregado {
  private String nome;
  private int idade;
  private double salario;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getIdade() {
    return idade;
  }

  @Override
  public String toString() {
    return "Empregado [nome=" + nome + ", idade=" + idade + ", salario=" + salario + "]";
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }

  public void promover() {
    if (idade > 18) {
      aumentarSalario(25);
    } else {
      System.out.println(
          "Promoção não pode ser realizada. O funcionário deve ter mais de 18 anos.");
    }
  }

  public void aumentarSalario(double percentual) {
    double aumento = salario * (percentual / 100);
    salario += aumento;
    System.out.printf("Salário aumentado em %.2f%%. Novo salário: %.2f\n", percentual, salario);
  }

  public void demitir(int motivo) {
    switch (motivo) {
      case 1:
        System.out.println("Demissão por justa causa. O funcionário deve cumprir aviso prévio.");
        break;
      case 2:
        double multa = salario * 0.40;
        System.out.printf(
            "Demissão por decisão do empregador. Multa de 40%% do salário: %.2f\n", multa);
        break;
      case 3:
        double salarioAposentadoria = calcularSalarioAposentadoria();
        System.out.printf("Aposentadoria. Salário de aposentadoria: %.2f\n", salarioAposentadoria);
        break;
      default:
        System.out.println("Motivo de demissão inválido.");
        break;
    }
  }

  private double calcularSalarioAposentadoria() {
    if (salario >= 1000 && salario < 2000) {
      return 1500;
    } else if (salario >= 2000 && salario < 3000) {
      return 2500;
    } else if (salario >= 3000 && salario < 4000) {
      return 3500;
    } else if (salario >= 4000) {
      return 4000;
    } else {
      return 0;
    }
  }

  public void fazerAniversario() {
    idade++;
  }
}
