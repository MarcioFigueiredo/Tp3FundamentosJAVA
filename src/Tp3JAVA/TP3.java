package Tp3JAVA;

import java.util.Arrays;
import java.util.Scanner;

import auxiliar.Constante;
import Dominio.Administrativo;
import Dominio.Programador;
import Negocio.Funcionario;
import Tp3JAVA.InstituicaoDeEnsino;

public class TP3 {
	
private static Funcionario[] funcionarios;
	
	private static void imprimir(int id) {
		System.out.println(funcionarios[id].toString());
	}
	
	private static void imprimir() {
		for (int i = 0; i < Constante.QTDE; i++) {
			if(funcionarios[i] != null) {
				imprimir(i);
			}
		}
	}

	private static float calcularMediaSalarial(int qtde){
		float somaSalarial = 0;		
		for(int x = 0; x < qtde; x++) {
			somaSalarial = somaSalarial + funcionarios[x].calcularSalarioLiquido();
		}		

		return somaSalarial / qtde;
	}

	public static void main(String[] args) {
		funcionarios = new Funcionario[Constante.QTDE];

		Scanner in = new Scanner(System.in);
		
		int i = 0;
		int opcao;
		do {			
			System.out.println("[1] Cadastrar Professor");
			System.out.println("[2] Cadastrar Aluno");
			System.out.println("[3] Consultar um");
			System.out.println("[4] Consultar todos");
			System.out.println("[5] Sair.");
			System.out.print("Informe a op��o desejada: ");
			
			opcao = in.nextInt();
			
			if(Arrays.asList(Constante.OPCOES).contains(opcao)) {
				
				switch (opcao) {
				case 1:
					if(i < Constante.QTDE) {
						
						Administrativo prof = new Administrativo();
						
						System.out.println("Informe o seu nome:");
						prof.setNome(in.next());
						
						System.out.println("Informe a sua idade:");
						prof.setIdade(in.nextInt());
						
						System.out.println("Informe o seu sal�rio:");
						prof.setSalario(in.nextFloat());

						System.out.println("Informe o seu b�nus: ");
						prof.setBonus(in.nextFloat());
						
						System.out.println("Informe o seu desconto: ");
						prof.setDesconto(in.nextFloat());
						
						funcionarios[i] = prof;

						System.out.println("... Inclus�o realizada ...");
						imprimir(i);
						System.out.println("...... com sucesso! ......");
						
						i++;
					}else {
						System.out.println("Impossivel cadastrar um novo funcionario!!!");
					}					
					break;

				case 2:
					if(i < Constante.QTDE) {
						
						Programador aluno = new Programador();
						
						System.out.println("Informe o seu nome:");
						aluno.setNome(in.next());
						
						System.out.println("Informe a sua idade:");
						aluno.setIdade(in.nextInt());
						
						System.out.println("Informe o seu sal�rio:");
						aluno.setSalario(in.nextFloat());

						System.out.println("Informe se � fullstack: ");
						aluno.setFullStack(in.nextBoolean());
						
						System.out.println("Informe a sua linguagem: ");
						aluno.setLinguagem(in.next());
						
						funcionarios[i] = aluno;

						System.out.println("... Inclus�o realizada ...");
						imprimir(i);
						System.out.println("...... com sucesso! ......");
						
						i++;
					}else {
						System.out.println("Impossivel cadastrar um novo funcionario!!!");
					}					
					break;

				case 3:
					System.out.print("Informe a identifica��o do funcion�rio: ");
					int id = in.nextInt();
	
					if(id >= 0 && id < i) {
						System.out.println("... Funcion�rio ...");
						imprimir(id);
						System.out.println("...................");
					}else {
						System.out.println("Identifica��o inv�lida!!!");
					}
					break;
					
				case 4:
					System.out.println("... Lista de funcion�rios ...");
					imprimir();
					System.out.println(".............................");
					break;
				}
			}else {
				System.out.println("Op��o inv�lida!!!");
			}
		} while (opcao != 5);

		System.out.println("Sistema finalizado com sucesso!!!");		
		System.out.println("Quantidade de funcion�rios: " + i);
		System.out.println("M�dia salarial: " + calcularMediaSalarial(i));
		
		in.close();
	}

}
