package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteBuscaContas {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 1);
		
		conta.setTitular("Jo�o");
		conta.setAgencia("456");
		
		System.out.println(conta.getTitular());
		
		em.getTransaction().commit();
		em.close();
		
		EntityManager em2 = new JPAUtil().getEntityManager();
		em2.getTransaction().begin();
		
		conta.setTitular("Leonardo");
		em2.merge(conta); //quando a entidade j� foi gerenciada ela fica "detached" e n�o pode ser utilizada. ao usar o m�todo "merge" ela volta a ficar sincronizada
		
		em2.getTransaction().commit();
		em2.close();
	}

}
