package aplicacao;

import java.util.Locale;
import java.util.Scanner;

public class Trabalho02 {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		Locale.setDefault(new Locale("en", "US"));
		
		String vetornome[], vetorcontato[];
		int N, i, tipo[], minutos[], contamenor, clientetipo1, tipo1min, menos91min, mais120min, clientetipo2;
		double valorconta[], assinaturas[][], total, mediatipo1, porcentagemtipo2;

		System.out.println();
		System.out.print("QUANTOS CLIENTES SERÃO INSERIDOS? ");
		N = sc.nextInt();
		
		System.out.println();
		System.out.println();
		
		if (N != 0) {
		
			vetornome = new String[N];
			vetorcontato = new String[N];
			tipo = new int[N];
			minutos = new int[N];
			valorconta = new double[N];
			assinaturas = new double[3][2];
			
			for (i = 0; i < N; i++) {
				
				System.out.println("CLIENTE " + (i+1));
				
				System.out.print("NOME:     ");
				vetornome[i] = sc.nextLine();
				vetornome[i] = sc.nextLine();
				
				System.out.print("TELEFONE: ");
				vetorcontato[i] = sc.nextLine();
				
				System.out.print("TIPO:     ");
				tipo[i] = sc.nextInt();
	
				System.out.print("MINUTOS:  ");
				minutos[i] = sc.nextInt();
				
				System.out.println();
				
			}
			
			System.out.println();
			
			for (i = 0; i <= 2; i++) {
				
				System.out.println("ASSINATURA TIPO " + i);
				
				System.out.print("PREÇO BÁSICO:     R$ ");
				assinaturas[i][0] = sc.nextDouble();
	
				System.out.print("MINUTO EXCEDENTE: R$ ");
				assinaturas[i][1] = sc.nextDouble();
				
				System.out.println();
				
			}
			
			System.out.println();
			
			for (i = 0; i < N; i++) {
				
				if (minutos[i] <= 90) {
					
					switch (tipo[i]) {
					case 0:
						valorconta[i] = assinaturas[0][0];
						break;
					case 1:
						valorconta[i] = assinaturas[1][0];
						break;
					case 2:
						valorconta[i] = assinaturas[2][0];
						break;
					}
					
				}else {
					
					switch (tipo[i]) {
					case 0:
						valorconta[i] = assinaturas[0][0] + ((minutos[i] - 90) * assinaturas[0][1]);
						break;
					case 1:
						valorconta[i] = assinaturas[1][0] + ((minutos[i] - 90) * assinaturas[1][1]);
						break;
					case 2:
						valorconta[i] = assinaturas[2][0] + ((minutos[i] - 90) * assinaturas[2][1]);
						break;
					}
					
				}
				
			}
			
			System.out.println("------------------------------------------------------------------------");
			System.out.println("|      NOME       |  TELEFONE   | TIPO ASS. | MINUTOS | VALOR DA CONTA |");
			for (i = 0; i < N; i++) {
				
				System.out.printf("| %-15s | ", vetornome[i]);
				System.out.printf(" %-10s | ", vetorcontato[i]);
				System.out.printf("%5d     | ", tipo[i]);
				System.out.printf("%7d | ", minutos[i]);
				System.out.printf("R$ %11.2f |\n", valorconta[i]);
				
			}
			
			System.out.println("------------------------------------------------------------------------");
			System.out.println();
			System.out.println();
			
			total = 0.0;
			for (i = 0; i < N; i++) {
				
				total = total + valorconta[i];
				
			}
			System.out.printf("1) RECEITA TOTAL: R$ %.2f\n", total);
			
			System.out.println();
			
			contamenor = 0;
			for (i = 0; i < N; i++) {
				
				if (i == 0) {
					
					contamenor = i;
					
				}else {
				
					if ( valorconta[i] < valorconta[contamenor]) {
						
						contamenor = i;
						
					}
				
				}
				
			}
			System.out.printf("2) CONTA MAIS BARATA: %s | %s\n", vetornome[contamenor], vetorcontato[contamenor]);
			System.out.println();
			
			clientetipo1 = 0;
			tipo1min = 0;
			mediatipo1 = 0.0;
			for (i = 0; i < N; i++) {
				
				if (tipo[i] == 1) {
					
					clientetipo1 = clientetipo1 + 1;
					tipo1min = tipo1min + minutos[i];
					
				}
				
			}
			mediatipo1 = (double) tipo1min / (double) clientetipo1;
			System.out.printf("3) MÉDIA MIN. CONSU. CLIENTES TIPO 1: %.2f\n", mediatipo1);
			System.out.println();
			
			System.out.println("4) CLIENTES QUE NÃO EXCEDERAM SUA FRANQUIA (90MIN):");
			menos91min = 0;
			for (i = 0; i < N; i++) {
				
				if (minutos[i] <= 90) {
					
					menos91min = menos91min + 1;
					
				}
				
			}
			
			if (menos91min != 0) {
				
				System.out.println("         ---------------------------------");
				System.out.println("         |      NOME       |  TELEFONE   |");
				
				for (i = 0; i < N; i++) {
					
					if (minutos[i] <= 90) {
						
						System.out.printf("         | %-15s |", vetornome[i]);
						System.out.printf("  %-10s |\n", vetorcontato[i]);
						
					}
					
				}
				System.out.println("         ---------------------------------\n");
				
			}else {
				
				System.out.println("         *** NENHUM CLIENTE ENCONTRADO ***\n");
				
			}
			
			mais120min = 0;
			for (i = 0; i < N; i++) {
				
				if (minutos[i] > 120) {
					
					mais120min = mais120min + 1;
					
				}
				
			}
			System.out.println("5) QTD CLIENTES CONSU. MAIS QUE 120MIN: " + mais120min + "\n");
			
			porcentagemtipo2 = 0.0;
			clientetipo2 = 0;
			for (i = 0; i < N; i++) {
				
				if (tipo[i] == 2) {
					
					clientetipo2 = clientetipo2 + 1;
					
				}
				
			}
			porcentagemtipo2 = (double) clientetipo2 * 100.00 / (double) N;
			System.out.printf("6) PORCENTAGEM DE CLIENTES TIPO 2: %.2f%%\n", porcentagemtipo2);
			
			System.out.println();
			
		}
		
		sc.close();
	}
}