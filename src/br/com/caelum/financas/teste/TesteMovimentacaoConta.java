package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Movimentacao movimentacao = em.find(Movimentacao.class, 3);
		Conta conta = movimentacao.getConta();  //nessas duas linhas eu busquei a movimentação e a conta que esta dentro deste objeto
		
		System.out.println(conta.getTitular());
		
		System.out.println(conta.getMovimentacoes().size());
		
	}

}
