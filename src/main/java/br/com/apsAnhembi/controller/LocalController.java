package br.com.apsAnhembi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.apsAnhembi.http.Local;
import br.com.apsAnhembi.repository.LocalRepository;
import br.com.apsAnhembi.repository.entity.LocalEntity;
import br.com.apsAnhembi.uteis.JsonResponse;

/**
 * A classe Controlador local.
 *
 * @author GabrielaVieira
 *
 */
@Path("/local")
public class LocalController {

    private final LocalRepository localRepository = new LocalRepository();

    /**
     * Método cadastrar, responsável pelo cadastro de novas entidades do tipo
     * Local
     *
     * @param local Dados para construção da entidade
     * @return String Json com messagem e status de sucesso
     */
    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrar")
    public String cadastrar(Local local) {
        LocalEntity localEntity = new LocalEntity();
        if (local != null) {
            try {
                localEntity.setIdUsuario(local.getIdUsuario());
                localEntity.setLatitude(local.getLatitude());
                localEntity.setLongitude(local.getLongitude());
                localEntity.setTitulo(local.getTitulo());
                localRepository.cadastrar(localEntity);

                return new JsonResponse(true, "Local cadastrado com sucessso.").toString();
            } catch (Exception e) {
                return new JsonResponse(false, "Ocorreu um erro ao cadastrar o local: " + e.getMessage()).toString();
            }
        }
        return new JsonResponse(false, "Falha ao cadastrar, verifique formatação da Request").toString();
    }

    /**
     * Método alterar, responsável pelo alteração de uma entitade do tipo Local
     *
     * @param local Dados de atualização de uma entidade
     * @return String Json com messagem e status de sucesso
     */
    @PUT
    @Produces("application/json; charset=UTF-8")
    @Consumes("application/json; charset=UTF-8")
    @Path("/alterar")
    public String alterar(Local local) {
        if (local != null) {
            LocalEntity localEntity = localRepository.getLocal(local.getId());
            try {
                localEntity.setLatitude(local.getLatitude());
                localEntity.setLongitude(local.getLongitude());
                localEntity.setTitulo(local.getTitulo());
                localRepository.alterar(localEntity);

                return new JsonResponse(true, "O local foi alterado com sucesso").toString();
            } catch (Exception e) {
                return new JsonResponse(false, "Ocorreu um erro ao alterar o local: " + e.getMessage()).toString();
            }
        }
        return new JsonResponse(false, "Falha ao cadastrar, verifique formatação da Request").toString();
    }

    /**
     * Métolo locaisUsuario, reposável pelo busca dos locais do usuario
     * informado
     *
     * @param idUsuario id do usuário para busca dos locais
     * @return List lista de locais achados
     */
    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/locais-usuario/{idUsuario}")
    public List<Local> locaisUsuario(@PathParam("idUsuario") String idUsuario) {
        List<Local> locais = new ArrayList<>();
        List<LocalEntity> listaEntityLocais = localRepository.locaisUsuario(idUsuario);

        listaEntityLocais.forEach((localEntity) -> {
            locais.add(new Local(localEntity.getId(), localEntity.getIdUsuario(), localEntity.getLatitude(),
                    localEntity.getLongitude(), localEntity.getTitulo()));
        });
        return locais;
    }

    /**
     * Método excluir, responsável por remover uma entidade Local do banco de
     * dados
     *
     * @param id id do local para ser excluido
     * @return String Json com messagem e status de sucesso
     */
    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{id}")
    public String excluir(@PathParam("id") Integer id) {
        try {
            localRepository.excluir(id);
            return new JsonResponse(true, "O local foi excluído com sucesso.").toString();
        } catch (Exception e) {
            return new JsonResponse(false, "Ocorreu um erro ao tentar excluir o local. " + e.getMessage()).toString();
        }
    }

}
