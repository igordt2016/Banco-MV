package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

	static Scanner input = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;
	
	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();

	}
	
	public static void operacoes() {
		
		System.out.println("--------------------------------------------------------------------");
		System.out.println("--------------------Bem Vindos a A nossa Agência--------------------");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("************* Seleciona a Operação que deseja Realizar *************");
		System.out.println("--------------------------------------------------------------------");
		System.out.println(" |     Opção 1 - Criar Conta		| ");
		System.out.println(" |     Opção 2 - Depositar		| ");
		System.out.println(" |     Opção 3 - Sacar			| ");
		System.out.println(" |     Opção 4 - Transferir	 	| ");
		System.out.println(" |     Opção 5 - Listar 	 	| ");
		System.out.println(" |     Opção 6 - Sair		 	| ");

		int operacao = input.nextInt();
		
		switch (operacao) {
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listarContas();
			break;
		case 6:			
			System.out.println("Até Logo !");
			System.exit(0);

		default:
			System.out.println("Operação Inválida!");
			operacoes();
			break;
		}
		
	}
	
    public static void criarConta() {
        //System.out.println("Você está criando uma conta\n");

        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("Email: ");
        String email = input.next();

        Cliente cliente = new Cliente(nome, cpf, email);

        Conta conta = new Conta(cliente);

        contasBancarias.add(conta);
        System.out.println("--- Sua conta foi criada com sucesso! ---");

        operacoes();

    }
	
    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if(contasBancarias.size() > 0) {
            for(Conta contaa : contasBancarias) {
                if(contaa.getNumeroConta() == numeroConta) {
                    conta = contaa;
                }
            }
        }
        return conta;
    }
	
	public static void depositar() {
		
		System.out.println("Favor digite o numero da conta: ");
		int numeroConta = input.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if (conta != null) {
			System.out.println("Qual valor Deseja depositar? ");
			double valorDeposito = input.nextDouble();
			conta.depositar(valorDeposito);
		}else {
			System.out.println("Conta não encontrada!");
		}
		operacoes();
	}

	public static void sacar() {
		
		System.out.println("Favor digite o numero da conta: ");
		int numeroConta = input.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if (conta != null) {
			System.out.println("Qual valor Deseja sacar? ");
			double valorSaque = input.nextDouble();
			conta.sacar(valorSaque);
		}else {
			System.out.println("Conta não encontrada!");
		}
		operacoes();
	}
	
	public static void transferir() {
		
		System.out.println("Favor digite o numero da conta Remetente: ");
		int numeroContaRm = input.nextInt();
		
		Conta contaRm = encontrarConta(numeroContaRm);
		
		if (contaRm != null) {
			System.out.println("Favor digite o numero da conta Destino: ");
			int numeroContaDs = input.nextInt();
			Conta contaDs = encontrarConta(numeroContaDs);
			if (contaDs != null) {
				System.out.println("Digite o valor a transferir: ");
				double valorTransf = input.nextDouble();
				contaRm.transferencia(contaDs, valorTransf);
			}else {
				System.out.println("Conta Destino não encontrada!");
			}
			
		}else {
			System.out.println("Conta Remetente não encontrada!");
		}
		operacoes();
	}
	
	public static void listarContas() {
		
		if (contasBancarias.size() > 0) {
			for(Conta conta: contasBancarias) {
				System.out.println(conta);
			}
			
		}else {
			System.out.println("Não existem contas cadastradas!");
		}
		operacoes();
	}
	
}
