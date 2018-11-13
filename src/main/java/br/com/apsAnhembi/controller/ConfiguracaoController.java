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

@Path("/configuracao")
public class ConfiguracaoController {
	private final ConfiguracaoRepository configuracaoRepository = new ConfiguracaoRepository();

	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public String Cadastrar(Configuracao configuracao) {
		ConfiguracaoEntity configuracaoEntity = new ConfiguracaoEntity();
		if (configuracaoEntity != null) {
			try {
				configuracaoEntity
						.setId(new ConfiguracaoEntityPK(configuracao.getIdUsuario(), configuracao.getChave()));
				configuracaoEntity.setValor(configuracao.getValor());
				configuracaoRepository.Salvar(configuracaoEntity);

				return "Configuracao cadastrada com sucessso";

			} catch (Exception e) {
				// TODO: handle exception
				return "Ocorreu um erro ao cadastrar a configuracao. " + e.getMessage();
			}
		}
		return "Falha ao cadastrar, verifique formatação da Request";
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterar")
	public String Alterar(Configuracao configuracao) {
		ConfiguracaoEntity configuracaoEntity = configuracaoRepository
				.GetConfiguracao(new ConfiguracaoEntityPK(configuracao.getIdUsuario(), configuracao.getChave()));
		if (configuracaoEntity != null) {
			try {
				configuracaoEntity.setValor(configuracao.getValor());
				configuracaoRepository.Alterar(configuracaoEntity);

				return "A configuracao foi alterado com sucesso";

			} catch (Exception e) {
				// TODO: handle exception
				return "Ocorreu um erro ao tentar alterar a configuracao" + e.getMessage();
			}
		}
		return "Falha ao cadastrar, verifique formatação da Request";
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/todasConfiguracoes")
	public List<Configuracao> TodosConfiguracoes() {
		List<Configuracao> configuracoes = new ArrayList<Configuracao>();

		List<ConfiguracaoEntity> listaEntityLocais = configuracaoRepository.TodasConfiguracoes();

		for (ConfiguracaoEntity configuracaoEntity : listaEntityLocais) {
			configuracoes.add(new Configuracao(configuracaoEntity.getId().getIdUsuario(),
					configuracaoEntity.getId().getChave(), configuracaoEntity.getValor()));
		}
		return configuracoes;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/getConfiguracao/{idUsuario}/{chave}")
	public Configuracao GetConfiguracao(@PathParam("idUsuario") String idUsuario, @PathParam("chave") String chave) {
		ConfiguracaoEntity configuracaoEntity = configuracaoRepository
				.GetConfiguracao(new ConfiguracaoEntityPK(idUsuario, chave));

		if (configuracaoEntity != null) {
			return new Configuracao(configuracaoEntity.getId().getIdUsuario(), configuracaoEntity.getId().getChave(),
					configuracaoEntity.getValor());
		}
		return null;
	}

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