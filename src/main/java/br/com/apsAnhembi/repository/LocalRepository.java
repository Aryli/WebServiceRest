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

    public void cadastrar(LocalEntity localEntity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(localEntity);
        this.entityManager.getTransaction().commit();

    }

    public void alterar(LocalEntity localEntity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(localEntity);
        this.entityManager.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<LocalEntity> locaisUsuario(String idUsuario) {
        return this.entityManager.createQuery("SELECT p FROM LocalEntity p where p.idUsuario = :id ORDER BY p.titulo").setParameter(":id", idUsuario).getResultList();
    }

    public LocalEntity getLocal(Integer codigo) {
        return this.entityManager.find(LocalEntity.class, codigo);
    }

    public void excluir(Integer codigo) {
        LocalEntity local = this.getLocal(codigo);
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(local);
        this.entityManager.getTransaction().commit();

    }

}
