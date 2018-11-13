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

import br.com.apsAnhembi.http.Configuracao;
import br.com.apsAnhembi.repository.ConfiguracaoRepository;
import br.com.apsAnhembi.repository.entity.ConfiguracaoEntity;
import br.com.apsAnhembi.repository.entity.ConfiguracaoEntityPK;

/**
 * A classe Configuração historico.
 *
 * @author GabrielaVieira
 */
@Path("/configuracao")
public class ConfiguracaoController {

    private final ConfiguracaoRepository configuracaoRepository = new ConfiguracaoRepository();

    /**
     * Método cadastrar, responsável por cadastrar um novo item no configuração
     *
     * @param configuracao Dados para construção da entidade
     * @return String Json com messagem e status de sucesso
     */
    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrar")
    public String cadastrar(Configuracao configuracao) {
        ConfiguracaoEntity configuracaoEntity = new ConfiguracaoEntity();
        if (configuracao != null) {
            try {
                configuracaoEntity
                        .setId(new ConfiguracaoEntityPK(configuracao.getIdUsuario(), configuracao.getChave()));
                configuracaoEntity.setValor(configuracao.getValor());
                configuracaoRepository.Salvar(configuracaoEntity);
                return "Configuracao cadastrada com sucessso";
            } catch (Exception e) {
                return "Ocorreu um erro ao cadastrar a configuracao. " + e.getMessage();
            }
        }
        return "Falha ao cadastrar, verifique formatação da Request";
    }

    /**
     * Método alterar, responsável pelo alteração de uma entitade do tipo
     * Configuração
     *
     * @param configuracao Dados de atualização de uma entidade
     * @return String Json com messagem e status de sucesso
     */
    @PUT
    @Produces("application/json; charset=UTF-8")
    @Consumes("application/json; charset=UTF-8")
    @Path("/alterar")
    public String alterar(Configuracao configuracao) {
        ConfiguracaoEntity configuracaoEntity = configuracaoRepository
                .GetConfiguracao(new ConfiguracaoEntityPK(configuracao.getIdUsuario(), configuracao.getChave()));
        if (configuracaoEntity != null) {
            try {
                configuracaoEntity.setValor(configuracao.getValor());
                configuracaoRepository.Alterar(configuracaoEntity);

                return "A configuracao foi alterado com sucesso";
            } catch (Exception e) {
                return "Ocorreu um erro ao tentar alterar a configuracao" + e.getMessage();
            }
        }
        return "Falha ao cadastrar, verifique formatação da Request";
    }

    /**
     * Método configuracoesUsuario, responsável por listar todos configurações
     * de um usuário
     *
     * @param idUsuario que será de base para a listagem de históricos
     * @return List lista de historicos achados
     */
    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/configuracoes-usuario/{idUsuario}")
    public List<Configuracao> configuracoesUsuario(@PathParam("idusuario") String idUsuario) {
        List<Configuracao> configuracoes = new ArrayList<Configuracao>();

        List<ConfiguracaoEntity> listaEntityLocais = configuracaoRepository.TodasConfiguracoes();

        for (ConfiguracaoEntity configuracaoEntity : listaEntityLocais) {
            configuracoes.add(new Configuracao(configuracaoEntity.getId().getIdUsuario(),
                    configuracaoEntity.getId().getChave(), configuracaoEntity.getValor()));
        }
        return configuracoes;
    }

    /**
     * Método getConfiguracao, responsável por pegar uma configuração
     *
     * @param idUsuario id do usuário
     * @param chave chave da configuração
     * @return Configuracao Configuração encontrada
     */
    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/getConfiguracao/{idUsuario}/{chave}")
    public Configuracao getConfiguracao(@PathParam("idUsuario") String idUsuario, @PathParam("chave") String chave) {
        ConfiguracaoEntity configuracaoEntity = configuracaoRepository
                .GetConfiguracao(new ConfiguracaoEntityPK(idUsuario, chave));

        if (configuracaoEntity != null) {
            return new Configuracao(configuracaoEntity.getId().getIdUsuario(), configuracaoEntity.getId().getChave(),
                    configuracaoEntity.getValor());
        }
        return null;
    }

    /**
     * Método excluir, responsável por remover uma entidade Configuracao do
     * banco de dados
     *
     * @param idUsuario id do usuário
     * @param chave chave da configuração
     * @return String Json com messagem e status de sucesso
     */
    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{idUsuario}/{chave}")
    public String Excluir(@PathParam("idUsuario") String idUsuario, @PathParam("chave") String chave) {
        try {
            configuracaoRepository.Excluir(new ConfiguracaoEntityPK(idUsuario, chave));
            return "A configuracao foi excluída com sucesso";
        } catch (Exception e) {
            // TODO: handle exception
            return "Ocorreu um erro ao tentar excluir a configuracao" + e.getMessage();
        }
    }

}
