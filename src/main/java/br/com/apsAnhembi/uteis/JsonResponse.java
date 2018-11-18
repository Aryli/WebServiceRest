package br.com.apsAnhembi.uteis;

/**
 * A Classe JsonResponse
 *
 * @author Christian
 */
public class JsonResponse {

    boolean success = false;
    String message = null;

    /**
     * Construtor da classe, onde se realiza a inserção dos dados de response do JSON
     * @param success sucesso da request
     * @param message mensagem de resposta
     */
    public JsonResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    @Override
    public String toString() {
        return "{\"sucess\": " + this.success + ", \"message\": \"" + this.message + "\"}";
    }

}
