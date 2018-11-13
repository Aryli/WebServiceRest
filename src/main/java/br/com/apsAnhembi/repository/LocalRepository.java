package br.com.apsAnhembi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.apsAnhembi.repository.entity.LocalEntity;

public class LocalRepository {
	private final EntityManagerFactory entityManagerFactory;	
	private final EntityManager entityManager;
	
	public LocalRepository() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_db_estudo");
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	public void Salvar(LocalEntity localEntity) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(localEntity);
		this.entityManager.getTransaction().commit();
	
	}
	
	public void Alterar(LocalEntity localEntity) {
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(localEntity);
		this.entityManager.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<LocalEntity> TodosLocais(){		
		return this.entityManager.createQuery("SELECT p FROM LocalEntity p ORDER BY p.titulo").getResultList();
	}
	
	public LocalEntity GetLocal(Integer codigo){		
		return this.entityManager.find(LocalEntity.class, codigo);
	}
	
	public void Excluir(Integer codigo){
		
		LocalEntity local = this.GetLocal(codigo);
		
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(local);
		this.entityManager.getTransaction().commit();
		
	}
	
}
