import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class trabalhoNo {

  // Adicionando os vetores, matriz e listas
     static String nomes [] = new String[5];
     static String materia [] = new String[5];
     static double notas [][][] = new double[5][5][3];
     static ArrayList<String> aprovados = new ArrayList<>(); 
     static ArrayList<String> reprovados = new ArrayList<>(); 
     static Scanner sc = new Scanner(System.in);

     // Função para cadastrar Aluno
     public static void cadastrarAluno(String[] nomes) {
    try {
        limparTela();
        System.out.println("\n - Cadastro de aluno\n");

        for (int i = 0; i < nomes.length; i++) {
            String nome;
            boolean valido;

            do {
                System.out.print("Digite o nome do aluno " + (i + 1) + ": ");
                nome = sc.nextLine();
                valido = true;

                // Verifica se está vazio
                if (nome.trim().isEmpty()) {
                    System.out.println("Erro: nome não pode ser vazio!\n");
                    valido = false;
                }

                // Verifica se tem número
                for (int j = 0; j < nome.length(); j++) {
                    if (Character.isDigit(nome.charAt(j))) { // Pega cada letra do nome e vê se é número
                        System.out.println("Erro: não pode ter números!\n");
                        valido = false;
                        break;
                    }
                }

            } while (!valido);

            nomes[i] = nome;
            System.out.println();
        }

        System.out.println("ENTER para continuar...");
        sc.nextLine();

    } catch (Exception e) {
        System.out.println("Erro ao cadastrar dados.");
    }
}

     // Função para cadastrar materia 
      public static void cadastrarMateria() {
    try {
        limparTela();
        System.out.println("\n - Cadastro de matéria\n");

        for (int i = 0; i < 5; i++) {
            String nomeMateria;

            do {
                System.out.print("Digite o nome da matéria " + (i + 1) + ": ");
                nomeMateria = sc.nextLine();

                if (nomeMateria.trim().isEmpty()) {
                    System.out.println("Erro: o nome da matéria não pode ficar vazio!\n");
                }

            } while (nomeMateria.trim().isEmpty());

            materia[i] = nomeMateria;
            System.out.println(); // <-- pula linha (melhora visual)
        }

        System.out.println("ENTER para continuar...");
        sc.nextLine();

    } catch (Exception e) {
        System.out.println("Erro ao cadastrar dados.");
    }
}
     // Função para Cadastrar Notas 
      public static void cadastrarNotas(double notas[][][]){
        try {
            limparTela();
        System.out.println("\n - Cadatro de notas\n");
        for (int i=0; i< 5; i++){
            limparTela();

            System.out.println("\nNotas do aluno " + nomes[i]);

            for(int j=0;j<5;j++){

                System.out.println("\nMatéria: " + materia[j]);

                for (int k=0; k<3; k++){
                    double nota;

                    do{
                    System.out.print("Digite a nota " +(k+1) + ": ");
                   nota= sc.nextDouble();

                    if (nota >9){
                        System.out.println("Erro: não pode ter mais de 1 dígitos!");
                    }

                    }while (nota >9);
                    notas[i][j][k]= nota;
                }
            } 
        } 
         System.out.println("ENTER para continuar...");
          sc.nextLine();
    
        } catch (Exception e) {
              System.out.println("Erro ao cadastrar dados.");
        }
     }
 
     // Função para mostrar as notas e a media dos alunos
       public static void tabelaNotas() {
        try {
        limparTela();
        double soma,media;
       
        System.out.println("Tabela de Notas:");

        for (int i=0; i<nomes.length; i++){
            System.out.println("\nAluno: " + nomes[i]);

            for (int j=0; j<5; j++){
                soma = 0;
                System.out.print("Matéria: " + materia[j] + "\t");

                for(int k=0;k<3;k++){
                    System.out.print("Nota " + (k+1) + ": " + notas[i][j][k] + "\t");
                    soma += notas[i][j][k];
                }
                media = soma / 3;
                System.out.printf("Média: %.2f ", media);
            }
        } 
         System.out.println("ENTER para continuar...");
         sc.nextLine();

        } catch (Exception e) {
             System.out.println("Erro ao cadastrar dados.");
        }
    } 

    // Criando função para mostrar alunos aprovados
     public static void mostrarAprovados(){
        try {
        // Apaga os aprovados antigos pra não duplicar
        limparTela();
        aprovados.clear();
        
        for(int i=0; i<5; i++){
            double somaAluno = 0; // Guardar a soma das médias das matérias

            for(int j=0; j<5; j++){
                double somaMateria = 0;// cada materia

                for(int k=0;k<3;k++){
                    somaMateria += notas[i][j][k];
                }
                somaAluno += somaMateria/3;
            }
            double media = somaAluno/5;

            if(media >= 7){
                aprovados.add(nomes[i]);
            }
        }
        System.out.println("\nAlunos aprovados:");

        for(String nome : aprovados){
            System.out.println(nome);
        } 

         System.out.println("ENTER para continuar...");
         sc.nextLine();

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar dados.");
        }
    }

    // Função para mostrar a maior media de um aluno 
     public static void maiorMedia(){
        try {
        limparTela();
        double maior = 0;
        String alunoMaior = "";
       
        for(int i=0; i<5; i++){
            double somaAluno = 0;

            for(int j=0; j<5; j++){
                double somaMateria = 0;

                for(int k=0;k<3;k++){
                    somaMateria += notas[i][j][k];
                }

                // Calcula a média da matéria e soma no total
                somaAluno += somaMateria/3;
            }

            double media = somaAluno/5;

            //  Se a média atual for maior, atualiza a maior média e o aluno
            if(media > maior){
                maior = media;
                alunoMaior = nomes[i];
            }
        }

        System.out.println("\nAluno com maior média: " + alunoMaior);
        System.out.printf("Média: %.2f ",maior);


        System.out.println("ENTER para continuar...");
        sc.nextLine();

         } catch (Exception e) {
            System.out.println("Erro ao cadastrar dados.");
        }
    }

    // Função para mostrar a media da turma toda
     public static void mediaTurma(){
        try {
        double soma = 0;
        int totalNotas = 0;
        limparTela();
        for(int i=0; i<5; i++){ // alunos
            for(int j=0; j<5; j++){ // matérias
                for(int k=0;k<3;k++){ // notas
                    soma += notas[i][j][k];
                    totalNotas++;
                }
            }
        }

        double media = soma / totalNotas;

        System.out.printf("\nMédia geral da turma: %.2f ", media);

        System.out.println("ENTER para continuar...");
        sc.nextLine();

         } catch (Exception e) {
            System.out.println("Erro ao cadastrar dados.");
        }
    }

    // Função para mostrar a matéria com a maior média da turma
    public static void disciplinaMaiorMedia(){
        try {
        double maior = 0;
        String disciplina = "";
        
        limparTela();
        for(int j=0; j<5; j++){ // matéria
            double soma = 0;
            int total = 0;

            for(int i=0; i<5; i++){ // alunos
                for(int k=0;k<3;k++){ // notas
                    soma += notas[i][j][k];
                    total++;
                }
            }
            double media = soma/total;

            // // Se a média for maior, atualiza a disciplina com maior média
            if(media > maior){
                maior = media;
                disciplina = materia[j];
            }
        }

        System.out.println("\nDisciplina com maior média: " + disciplina);
        System.out.printf("Média: %.2f ", maior);

        System.out.println("ENTER para continuar...");
        sc.nextLine();

         } catch (Exception e) {
             System.out.println("Erro ao cadastrar dados.");
        }
    }

    // Função para mostrar alunos aprovados em oredem alfabética
     public static void aprovadosOrdem(){
        try {
    // limpa a lista antes de usar
    limparTela();
    aprovados.clear();

        for(int i=0; i<5; i++){ // alunos
            double somaAluno = 0;

            for(int j=0; j<5; j++){ // materia
                double somaMateria = 0;

                for(int k=0;k<3;k++){ // notas
                    somaMateria += notas[i][j][k];
                }

                somaAluno += somaMateria/3;
            }

            double media = somaAluno/5;

            if(media >= 7){
                aprovados.add(nomes[i]);
            }
        }

        // Coloca os nomes em ordem alfabética
        Collections.sort(aprovados);

        System.out.println("\nAprovados em ordem alfabética:");

        for(String nome : aprovados){
            System.out.println(nome);
        } 
        System.out.println("ENTER para continuar...");
        sc.nextLine();
    
    } catch (Exception e) {
           System.out.println("Erro ao cadastrar dados.");
        }
    }

    // Função para mostrar alunos reprovados em oredem alfabética
     public static void reprovadosOrdem(){
        try {
        limparTela();
        reprovados.clear();

        for(int i=0; i<5; i++){
            double somaAluno = 0;

            for(int j=0; j<5; j++){
                double somaMateria = 0;

                for(int k=0;k<3;k++){
                    somaMateria += notas[i][j][k];
                }

                somaAluno += somaMateria/3;
            }

            double media = somaAluno/5;

            if(media < 7){
                reprovados.add(nomes[i]);
            }
        }
        
        // Coloca em oredem alfabética
        Collections.sort(reprovados);

        System.out.println("\nReprovados em ordem alfabética:");

        for(String nome : reprovados){
            System.out.println(nome);

        }

        System.out.println("ENTER para continuar...");
        sc.nextLine();

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar dados.");
        }

    }

    // Função para limpár tela
    public static void limparTela() {
    try {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    } catch (Exception e) {
        System.out.println("Erro ao limpar a tela");
    }
 }
     public static void main(String[] args) {
        int opcao;

        do{
            limparTela();
            System.out.println("---------------------------------------------");
            System.out.println("                MENU                         ");
            System.out.println("---------------------------------------------");
            System.out.println("1 - Cadastrar nomes dos alunos               ");
            System.out.println("2 - Cadastrar materia                        ");
            System.out.println("3 - Cadastrar notas dos alunos               ");
            System.out.println("4 - Mostrar tabela de notas                  ");
            System.out.println("5 - Mostrar alunos aprovados                 ");
            System.out.println("6 - Mostrar aluno com maior média            ");
            System.out.println("7 - Mostrar média geral da turma             ");
            System.out.println("8 - Mostrar disciplina com maior média       ");
            System.out.println("9 - Mostrar aprovados em ordem alfabética    ");
            System.out.println("10 - Mostrar reprovados em ordem alfabética  ");
            System.out.println("0 - Sair                                     ");
            System.out.println("Escolha uma opção:");

            opcao=sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    cadastrarAluno(nomes);
                    break;

                case 2:
                    cadastrarMateria();
                    break;

                case 3:
                    cadastrarNotas(notas);
                    break;

                case 4:
                    tabelaNotas();
                    break;

                case 5:
                    mostrarAprovados();
                    break;

                case 6:
                    maiorMedia();
                    break;

                case 7:
                    mediaTurma();
                    break;

                case 8:
                    disciplinaMaiorMedia();
                    break;

                case 9:
                    aprovadosOrdem();
                    break;

                case 10:
                    reprovadosOrdem();
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção Inválida");
                    break;
            }

        }while(opcao != 0);
    }
}
    

