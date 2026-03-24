import java.util.ArrayList;
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
      public static void cadastrarAluno(String[] nomes){
        for (int i=0; i < nomes.length; i++){
            System.out.print("Digite o nome do aluno " + (i+1) + ": ");
            nomes[i] = sc.nextLine();
        }
     }

     // Função para cadastrar materia 
       public static void cadastrarMateria(){
        for(int i=0;i<5;i++){
            System.out.print("Digite o nome da matéria " + (i+1) + ": ");
            materia[i] = sc.nextLine();
        }
     }
    
     // Função para Cadastrar Notas 
      public static void cadastrarNotas(double notas[][][]){
        for (int i=0; i< 5; i++){

            System.out.println("\nNotas do aluno " + nomes[i]);

            for(int j=0;j<5;j++){

                System.out.println("\nMatéria: " + materia[j]);

                for (int k=0; k<3; k++){
                    System.out.print("Digite a nota " +(k+1) + ": ");
                    notas[i][j][k] = sc.nextDouble();
                }
            }
        }
     }
 
     // Função para mostrar as notas e a media dos alunos
       public static void tabelaNotas() {
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
                System.out.println("Média: " + media);
            }
        }
    }

    // Criando função para mostrar alunos aprovados
     public static void mostrarAprovados(){
        // Apaga os aprovados antigos pra não duplicar
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
    }

    // Função para mostrar a maior media de um aluno 
     public static void maiorMedia(){
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
        System.out.println("Média: " + maior);
    }

    // Função para mostrar a media da turma toda
     public static void mediaTurma(){
        double soma = 0;
        int totalNotas = 0;

        for(int i=0; i<5; i++){ // alunos
            for(int j=0; j<5; j++){ // matérias
                for(int k=0;k<3;k++){ // notas
                    soma += notas[i][j][k];
                    totalNotas++;
                }
            }
        }

        double media = soma / totalNotas;

        System.out.println("\nMédia geral da turma: " + media);
    }

    // Função para mostrar a matéria com a maior média da turma
    public static void disciplinaMaiorMedia(){
        double maior = 0;
        String disciplina = "";

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
        System.out.println("Média: " + maior);
    }
     
}
