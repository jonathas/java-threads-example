package br.com.caelum.fj11.programa;

import java.util.Collection;

public class ProduzMensagens implements Runnable {
    private int comeco;
    private int fim;
    private Collection<String> mensagens;

    public ProduzMensagens(int comeco, int fim, Collection<String> mensagens) {
        this.comeco = comeco;
        this.fim = fim;
        this.mensagens = mensagens;
    }

    public void run() {
        for (int i = comeco; i < fim; i++) {
        	/**
        	 * Tornar a coleção synchronized resolve o problema: 
        	 * agora, só é possível rodar o código dentro desse bloco quando 
        	 * ninguém mais estiver usando esse objeto.
        	 */
        	// synchronized (mensagens) {
        		mensagens.add("Mensagem " + i);	
			// }
        }
    }
}