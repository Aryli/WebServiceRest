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
	 * 
	 * @param historico
	 * @return
	 */
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public String cadastrar(Historico historico) {
		HistoricoEntity historicoEntity = new HistoricoEntity();
		if (historicoEntity != null) {
			try {
				historicoEntity.setIdLocal(historico.getIdLocal());
				historicoEntity.setEntrada(historico.getEntrada());
				historicoEntity.setSaida(historico.getSaida());
				historicoRepository.Salvar(historicoEntity);

				return "Historico cadastrado com sucessso";
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				return "Ocorreu um erro ao cadastrar o historico" + e.getMessage();
			}
		}
		return "Falha ao cadastrar, verifique formatação da Request";
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterar")
	public String Alterar(Historico historico) {
		HistoricoEntity historicoEntity = historicoRepository.GetHistorico(historico.getId());

		try {
			historicoEntity.setEntrada(historico.getEntrada());
			historicoEntity.setSaida(historico.getSaida());
			historicoEntity.setId(historico.getId());

			historicoRepository.Alterar(historicoEntity);

			return "O historico foi alterado com sucesso";

		} catch (Exception e) {
			// TODO: handle exception
			return "Ocorreu um erro ao tentar alterar o historico" + e.getMessage();
		}
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/TodosHistoricos")
	public List<Historico> TodosHistoricos() {
		List<Historico> locais = new ArrayList<Historico>();

		List<HistoricoEntity> listaEntityLocais = historicoRepository.TodoHistorico();

		for (HistoricoEntity historicoEntity : listaEntityLocais) {
			locais.add(new Historico(historicoEntity.getId(), historicoEntity.getIdLocal(),
					historicoEntity.getEntrada(), historicoEntity.getSaida()));
		}
		return locais;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/getHistorico/{codigo}")
	public Historico GetHistorico(@PathParam("codigo") Integer codigo) {
		HistoricoEntity historicoEntity = historicoRepository.GetHistorico(codigo);

		if (historicoEntity != null) {
			return new Historico(historicoEntity.getId(), historicoEntity.getIdLocal(), historicoEntity.getEntrada(),
					historicoEntity.getSaida());
		}
		return null;
	}

	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluir/{codigo}")
	public String Excluir(@PathParam("codigo") Integer codigo) {
		try {
			historicoRepository.Excluir(codigo);
			return "O historico foi excluído com sucesso";
		} catch (Exception e) {
			// TODO: handle exception
			return "Ocorreu um erro ao tentar excluir o historico" + e.getMessage();
		}
	}

}
