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

import br.com.apsAnhembi.http.Historico;
import br.com.apsAnhembi.repository.HistoricoRepository;
import br.com.apsAnhembi.repository.entity.HistoricoEntity;
import br.com.apsAnhembi.uteis.JsonResponse;

/**
 * A classe Controlador historico.
 *
 * @author GabrielaVieira
 *
 */
@Path("/historico")
public class HistoricoController {

    private final HistoricoRepository historicoRepository = new HistoricoRepository();

    /**
     * Método cadastrar, responsável por cadastrar um novo item no histórico
     *
     * @param historico Dados para construção da entidade
     * @return String Json com messagem e status de sucesso
     */
    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrar")
    public String cadastrar(Historico historico) {
        HistoricoEntity historicoEntity = new HistoricoEntity();
        if (historico != null) {
            try {
                historicoEntity.setIdLocal(historico.getIdLocal());
                historicoEntity.setEntrada(historico.getEntrada());
                historicoEntity.setSaida(historico.getSaida());
                historicoRepository.cadastrar(historicoEntity);
                return new JsonResponse(true, "Historico cadastrado com sucessso").toString();
            } catch (Exception e) {
                return new JsonResponse(false, "Ocorreu um erro ao cadastrar o historico. " + e.getMessage()).toString();
            }
        }
        return new JsonResponse(false, "Falha ao cadastrar, verifique formatação da Request.").toString();
    }

    /**
     * Método alterar, responsável pelo alteração de uma entitade do tipo
     * Historico
     *
     * @param historico Dados de atualização de uma entidade
     * @return String Json com messagem e status de sucesso
     */
    @PUT
    @Produces("application/json; charset=UTF-8")
    @Consumes("application/json; charset=UTF-8")
    @Path("/alterar")
    public String alterar(Historico historico) {
        if (historico != null) {
            try {
                HistoricoEntity historicoEntity = historicoRepository.getHistorico(historico.getId());
                historicoEntity.setEntrada(historico.getEntrada());
                historicoEntity.setSaida(historico.getSaida());
                historicoEntity.setId(historico.getId());
                historicoRepository.alterar(historicoEntity);
                return new JsonResponse(true, "O historico foi alterado com sucesso").toString();
            } catch (Exception e) {
                return new JsonResponse(false, "Ocorreu um erro ao tentar alterar o historico" + e.getMessage()).toString();
            }
        }
        return new JsonResponse(false, "Falha ao cadastrar, verifique formatação da Request.").toString();
    }

    /**
     * Método historicoLocal, responsável por listar todos historico de um
     * local.
     *
     * @param idLocal que será de base para a listagem de históricos
     * @return List lista de historicos achados
     */
    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/historico-local/{idLocal}")
    public List<Historico> historicoLocal(@PathParam("idLocal") int idLocal) {
        List<Historico> locais = new ArrayList<>();
        List<HistoricoEntity> listaEntityLocais = historicoRepository.historicoLocal(idLocal);

        listaEntityLocais.forEach((historicoEntity) -> {
            locais.add(new Historico(historicoEntity.getId(), historicoEntity.getIdLocal(),
                    historicoEntity.getEntrada(), historicoEntity.getSaida()));
        });
        return locais;
    }

    /**
     * Método getHistorico, responsável por pegar um historico pelo id
     *
     * @param id id do historico
     * @return Historico Historico encontrado
     */
    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/getHistorico/{id}")
    public Historico getHistorico(@PathParam("id") Integer id) {
        HistoricoEntity historicoEntity = historicoRepository.getHistorico(id);
        if (historicoEntity != null) {
            return new Historico(historicoEntity.getId(), historicoEntity.getIdLocal(), historicoEntity.getEntrada(),
                    historicoEntity.getSaida());
        }
        return null;
    }

    /**
     * Método excluir, responsável por remover uma entidade Historico do banco
     * de dados
     *
     * @param id id do local para ser excluido
     * @return String Json com messagem e status de sucesso
     */
    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{id}")
    public String excluir(@PathParam("id") Integer id) {
        try {
            historicoRepository.excluir(id);
            return new JsonResponse(true, "O historico foi excluído com sucesso").toString();
        } catch (Exception e) {
            return new JsonResponse(false, "Ocorreu um erro ao tentar excluir o historico.").toString();
        }
    }

}
