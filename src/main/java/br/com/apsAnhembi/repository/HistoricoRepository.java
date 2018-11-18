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

    public void cadastrar(HistoricoEntity historicoEntity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(historicoEntity);
        this.entityManager.getTransaction().commit();
    }

    public void alterar(HistoricoEntity historicoEntity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(historicoEntity);
        this.entityManager.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<HistoricoEntity> historicoLocal(int idLocal) {
        return this.entityManager.createQuery("SELECT p FROM HistoricoEntity p where p.idLocal = :id").setParameter("id", idLocal).getResultList();
    }

    public HistoricoEntity getHistorico(Integer codigo) {
        return this.entityManager.find(HistoricoEntity.class, codigo);
    }

    public void excluir(Integer codigo) {
        HistoricoEntity historico = this.getHistorico(codigo);
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(historico);
        this.entityManager.getTransaction().commit();
    }

}
