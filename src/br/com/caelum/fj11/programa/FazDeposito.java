package br.com.caelum.fj11.programa;

public class FazDeposito implements Runnable {

	private final Conta conta;
	
	public FazDeposito(Conta conta) {
		this.conta = conta;
	}
	
	@Override
	public void run() {
		conta.deposita(100.0);
	}

}
