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
     
}
