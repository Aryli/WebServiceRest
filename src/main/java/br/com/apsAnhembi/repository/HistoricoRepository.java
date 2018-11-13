package br.com.apsAnhembi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.apsAnhembi.repository.entity.HistoricoEntity;

public class HistoricoRepository {
	private final EntityManagerFactory entityManagerFactory;	
	private final EntityManager entityManager;
	
	public HistoricoRepository() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_db_estudo");
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	public void Salvar(HistoricoEntity historicoEntity) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(historicoEntity);
		this.entityManager.getTransaction().commit();
	}
	
	public void Alterar(HistoricoEntity historicoEntity) {
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(historicoEntity);
		this.entityManager.getTransaction().commit();
	
	}
	
	@SuppressWarnings("unchecked")
	public List<HistoricoEntity> TodoHistorico(){		
		return this.entityManager.createQuery("SELECT p FROM LocalEntity p ORDER BY p.titulo").getResultList();
	}
	
	public HistoricoEntity GetHistorico(Integer codigo){		
		return this.entityManager.find(HistoricoEntity.class, codigo);
	}
	
	public void Excluir(Integer codigo){		
		HistoricoEntity historico = this.GetHistorico(codigo);	
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(historico);
		this.entityManager.getTransaction().commit();
		
	}
	
	
}
