package br.com.caelum.fj11.programa;

import java.util.ArrayList;
import java.util.Collection;

public class RegistroDeMensagens {

	/**
	 * Rodando com classes que não são thread-safe é comum que algum registro seja pulado ou 
	 * que caia um null em alguma posição da coleção.
	 * Rodando várias vezes, às vezes temos a sorte de não ter problemas, mas é comum que os 
	 * vejamos acontecendo com frequência e em números diferentes.
	 * @param args
	 * @throws InterruptedException
	 */
    public static void main(String[] args) throws InterruptedException {
        Collection<String> mensagens = new ArrayList<String>();

        Thread t1 = new Thread(new ProduzMensagens(0, 10000, mensagens));
        Thread t2 = new Thread(new ProduzMensagens(10000, 20000, mensagens));
        Thread t3 = new Thread(new ProduzMensagens(20000, 30000, mensagens));

        t1.start();
        t2.start();
        t3.start();

        // faz com que a thread que roda o main aguarde o fim dessas
        t1.join();
        t2.join();
        t3.join();

        System.out.println("Threads produtoras de mensagens finalizadas!");

        // verifica se todas as mensagens foram guardadas
        for (int i = 0; i < 30000; i++) {
            if (!mensagens.contains("Mensagem " + i)) {
                throw new IllegalStateException("não encontrei a mensagem: " + i);
            }
        }

        // verifica se alguma mensagem ficou nula
        if (mensagens.contains(null)) {
            throw new IllegalStateException("não devia ter null aqui dentro!");
        }

        System.out.println("Fim da execucao com sucesso");
    }
}