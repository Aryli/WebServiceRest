package br.com.apsAnhembi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.apsAnhembi.repository.entity.ConfiguracaoEntity;
import br.com.apsAnhembi.repository.entity.ConfiguracaoEntityPK;

public class ConfiguracaoRepository {
	private final EntityManagerFactory entityManagerFactory;	
	private final EntityManager entityManager;
	
	public ConfiguracaoRepository() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_db_estudo");
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	public void Salvar(ConfiguracaoEntity configuracaoEntity) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(configuracaoEntity);
		this.entityManager.getTransaction().commit();
	}
	
	public void Alterar(ConfiguracaoEntity configuracaoEntity) {
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(configuracaoEntity);
		this.entityManager.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<ConfiguracaoEntity> TodasConfiguracoes(){
		return this.entityManager.createQuery("SELECT p FROM ConfiguracaoEntity p").getResultList();
	}
	
	public ConfiguracaoEntity GetConfiguracao(ConfiguracaoEntityPK id){		
		return this.entityManager.find(ConfiguracaoEntity.class, id);
	}
	
	public void Excluir(ConfiguracaoEntityPK id){
		ConfiguracaoEntity configuracao = this.GetConfiguracao(id);	
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(configuracao);
		this.entityManager.getTransaction().commit();	
	}
	
}
