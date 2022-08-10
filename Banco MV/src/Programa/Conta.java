package Programa;

public class Conta {

	private static int contadorDeContas = 1;
	private int numeroConta;
	private Cliente cliente;
	private double saldo = 0.0;
	
	public Conta(Cliente cliente) {
		this.numeroConta = contadorDeContas;
		this.cliente = cliente;
		this.updateSaldo();
		contadorDeContas +=1;
	}
	public int getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
    private void updateSaldo() {
        this.saldo = this.getSaldo();
    }

	
	public String toString() {
		return "\nNumero da Conta: "+ this.getNumeroConta() +
				"\nNome: "+ this.cliente.getNome() +
				"\nCpf: "+ this.cliente.getCpf() +
				"\nEmail: "+ this.cliente.getEmail()+
				"\nSaldo: "+ Utils.Utilitarios.doubleToString(this.getSaldo())+
				"\n";
				
	}
	
	public void depositar(double valor) {
		
		if (valor > 0) {
			this.setSaldo(getSaldo()+valor);
			System.out.println("Valor Depositado com Sucesso!");
		}else {
			System.out.println("Não foi possível Depositar!");
		}
		
	}
	
	public void sacar(double valor) {
		
		if (valor > 0 && this.getSaldo() >= valor) {
			this.setSaldo(getSaldo() - valor);
			System.out.println("Valor Sacado com Sucesso!");
		}else {
			System.out.println("Não foi possível sacar!");
		}
		
	}
	
    public void transferencia(Conta contaParaDeposito, double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            //this.saldo = this.getSaldo() - valor;
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println("TransferÃªncia realizada com sucesso!");
        }else {
            System.out.println("NÃ£o foi possÃ­vel realizar a tranferÃªncia");
        }

    }
	
	
}
