package br.com.apsAnhembi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.apsAnhembi.repository.entity.ConfiguracaoEntity;
import br.com.apsAnhembi.repository.entity.ConfiguracaoEntityPK;

/**
 * Classe ConfiguraçãoRepository
 *
 * @author Gabriela
 */
public class ConfiguracaoRepository {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public ConfiguracaoRepository() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_db_estudo");
        this.entityManager = this.entityManagerFactory.createEntityManager();
    }

    /**
     * Método para realizar uma inserção da entidade Configuração
     *
     * @param configuracaoEntity dados para serem inseridos
     */
    public void cadastrar(ConfiguracaoEntity configuracaoEntity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(configuracaoEntity);
        this.entityManager.getTransaction().commit();
    }

    /**
     * Método para realizar uma atualização da entidade configuração
     *
     * @param configuracaoEntity dados para serem atualizados
     */
    public void alterar(ConfiguracaoEntity configuracaoEntity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(configuracaoEntity);
        this.entityManager.getTransaction().commit();
    }

    /**
     * Busca todas as configurações de um usuário
     *
     * @param idUsuario id do Usuário para busca
     * @return listagem de entidades Configuração
     */
    @SuppressWarnings("unchecked")
    public List<ConfiguracaoEntity> configuracoesUsuario(String idUsuario) {
        return this.entityManager.createQuery("SELECT p FROM ConfiguracaoEntity p where p.id.idUsuario = :id").setParameter(":id", idUsuario).getResultList();
    }

    /**
     * Busca uma configuração pelo id
     *
     * @param id chave para a busca
     * @return entidade encontrada
     */
    public ConfiguracaoEntity getConfiguracao(ConfiguracaoEntityPK id) {
        return this.entityManager.find(ConfiguracaoEntity.class, id);
    }

    /**
     * excluir uma configuração
     *
     * @param id elemento para ser excluido
     */
    public void excluir(ConfiguracaoEntityPK id) {
        ConfiguracaoEntity configuracao = this.getConfiguracao(id);
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(configuracao);
        this.entityManager.getTransaction().commit();
    }

}
