package br.com.caelum.fj11.programa;

public class Conta implements Comparable<Conta> {

	private double saldo;
	private double limite;
	private Cliente titular;
	private int agencia;
	private int numero;
	
	public Conta(double saldo) {
		this.saldo = saldo;
	}
	
	public void saca(double valor) {
		this.saldo -= valor;
	}
	
	public synchronized void deposita(double valor) {
		this.saldo += valor;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public Cliente getTitular() {
		return titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public int compareTo(Conta o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
