package br.com.apsAnhembi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.apsAnhembi.repository.entity.HistoricoEntity;

/**
 * Classe HistoricoRepository
 *
 * @author Gabriela
 */
public class HistoricoRepository {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public HistoricoRepository() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_db_estudo");
        this.entityManager = this.entityManagerFactory.createEntityManager();
    }

    /**
     * Método para realizar uma inserção da entidade Historico
     *
     * @param historicoEntity dados para serem inseridos
     */
    public void cadastrar(HistoricoEntity historicoEntity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(historicoEntity);
        this.entityManager.getTransaction().commit();
    }

    /**
     * Método para realizar uma atualização da entidade Historico
     *
     * @param historicoEntity dados para serem atualizados
     */
    public void alterar(HistoricoEntity historicoEntity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(historicoEntity);
        this.entityManager.getTransaction().commit();
    }

    /**
     * Lista todos historico de um local
     *
     * @param idLocal chave para a busca
     * @return listagem de entidade Historico
     */
    @SuppressWarnings("unchecked")
    public List<HistoricoEntity> historicoLocal(int idLocal) {
        return this.entityManager.createQuery("SELECT p FROM HistoricoEntity p where p.idLocal = :id").setParameter("id", idLocal).getResultList();
    }

    /**
     * Busca um historico pelo id
     *
     * @param id chave para a busca
     * @return entidade encontrada
     */
    public HistoricoEntity getHistorico(Integer id) {
        return this.entityManager.find(HistoricoEntity.class, id);
    }

    /**
     * excluir um historico/
     *
     * @param id elemento para ser excluido
     */
    public void excluir(Integer id) {
        HistoricoEntity historico = this.getHistorico(id);
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(historico);
        this.entityManager.getTransaction().commit();
    }

}
