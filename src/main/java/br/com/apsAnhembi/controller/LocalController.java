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
	 * Método cadastrar, responsável pelo cadastro de novas entidades do tipo Local
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
		if (localEntity != null) {
			try {
				localEntity.setIdUsuario(local.getIdUsuario());
				localEntity.setLatitude(local.getLatitude());
				localEntity.setLongitude(local.getLongitude());
				localEntity.setTitulo(local.getTitulo());

				localRepository.Salvar(localEntity);

				return "{\"sucess\": true, \"message\": \"Local cadastrado com sucessso\"}";
			} catch (Exception e) {
				return "{\"sucess\": false, \"message\": \"Ocorreu um erro ao cadastrar o local: " + e.getMessage()
						+ " \"}";
			}
		}
		return "{\"sucess\": false, \"message\": \"Falha ao cadastrar, verifique formatação da Request\"}";
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
		LocalEntity localEntity = localRepository.GetLocal(local.getId());
		if (localEntity != null) {
			try {
				localEntity.setLatitude(local.getLatitude());
				localEntity.setLongitude(local.getLongitude());
				localEntity.setTitulo(local.getTitulo());

				localRepository.Alterar(localEntity);

				return "{\"sucess\": true, \"message\": \"O local foi alterado com sucesso\"}";

			} catch (Exception e) {
				return "{\"sucess\": false, \"message\": \"Ocorreu um erro ao alterar o local: " + e.getMessage()
						+ " \"}";
			}
		}
		return "{\"sucess\": false, \"message\": \"Falha ao cadastrar, verifique formatação da Request\"}";

	}

	/**
	 * Métolo locaisUsuario, reposável pelo busca dos locais do usuario informado
	 * 
	 * @param idUsuario id do usuário para busca dos locais
	 * @return List<Local> lista de locais achados
	 */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/locais-usuario/{idUsuario}")
	public List<Local> locaisUsuario(@PathParam("idUsuario") String idUsuario) {
		List<Local> locais = new ArrayList<Local>();
		List<LocalEntity> listaEntityLocais = localRepository.TodosLocais();

		for (LocalEntity localEntity : listaEntityLocais) {
			locais.add(new Local(localEntity.getId(), localEntity.getIdUsuario(), localEntity.getLatitude(),
					localEntity.getLongitude(), localEntity.getTitulo()));
		}
		return locais;
	}

	/**
	 * Método excluir, responsável por remover uma entidade Local do banco de dados
	 * @param id id do local para ser excluido
	 * @return String Json com messagem e status de sucesso
	 */
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluir/{id}")
	public String excluir(@PathParam("id") Integer id) {
		try {
			localRepository.Excluir(id);
			return "{\"message\" : \"O local foi excluído com sucesso\"}";
		} catch (Exception e) {
			return "Ocorreu um erro ao tentar excluir o local" + e.getMessage();
		}
	}

}
