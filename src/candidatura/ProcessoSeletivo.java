package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
  public static void main(String[] args) {
    String[] candidatos = { "FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO" };
    for (String candidato : candidatos) {
      entrandoEmContato(candidato);// chama o metodo

    }
  }

  static void entrandoEmContato(String candidato) {// recebe como parametro a variavel candidato
    int tentativasRealizadas = 1; // conta as tentativas de contato
    boolean continuarTentando = true; // variavel que controla se continua tentando
    boolean atendeu = false; // indica se candidato atendeu ou não
    do {
      atendeu = atender(); // chama a função que simula se o candidato atendeu ou não
      continuarTentando = !atendeu; // se o candidato atender a variavel continuarTentando se torna false e para de
                                    // tocar
      if (continuarTentando)
        tentativasRealizadas++;
      else
        System.out.println("Contato realizado com sucesso");

    } while (continuarTentando && tentativasRealizadas < 3);

    if (atendeu)
      System.out.println("Conseguimos contato com " + candidato + " Na " + tentativasRealizadas + " tentativas.");

    else
      System.out.println("Não conseguimos contato com " + candidato + ", número máximo de tentativas "
          + tentativasRealizadas + " realizadas ");
  }

  static boolean atender() {
    return new Random().nextInt(3) == 1;// aqui determina um valor aleatorio entre 0 e 2 e quando for significa que o
                                        // candidato atendeu
  }

  static void imprimirSelecionados() {
    String[] candidatos = { "FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO" };

    System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");

    for (int indice = 0; indice < candidatos.length; indice++) {
      System.out.println("O candidato de nº " + (indice + 1) + " é o " + candidatos[indice]);
    }

    System.out.println("Utilizando for each");
    for (String candidato : candidatos) { // dessa forma é criado uma variavel temporaria com nome de candidato que
                                          // herda os elementos de candidatos
                                          // percorre o array e imprime os nomes
      System.out.println("O candidato selecionado foi " + candidato);
    }

  }

  static void selecaoCandidatos() {

    String[] candidatos = { "FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA",
        "JORGE" };

    int candidatosSelecionados = 0;
    int candidatosAtual = 0;
    double salarioBase = 2000.0;
    while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
      String candidato = candidatos[candidatosAtual];
      double salarioPretendido = valorPretendido();

      System.out.println("O candidato " + candidato + " solicitou este valor de salário " + salarioPretendido);
      if (salarioBase >= salarioPretendido) {
        System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
        candidatosSelecionados++;
      }
      candidatosAtual++;
    }
  }

  static double valorPretendido() {
    return ThreadLocalRandom.current().nextDouble(1800, 2200);
  }

  static void analisarCandidato(double salarioPretendido) {
    double salarioBase = 2000.0;
    if (salarioBase > salarioPretendido) {
      System.out.println("Ligar para o candidato");

    } else if (salarioBase == salarioPretendido)
      System.out.println("Ligar para o candidato com contra proposta");

    else
      System.out.println("Aguardando o resultados dos demais candidatos");
  }
}
