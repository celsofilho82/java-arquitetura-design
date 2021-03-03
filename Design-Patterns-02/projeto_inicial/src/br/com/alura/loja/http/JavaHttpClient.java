package br.com.alura.loja.http;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class JavaHttpClient implements HttpAdapter {

	/*
	 * Neste problema utilizamos o padrão de projeto Adapter que esconde os detalhes
	 * de infraestrutura da chamada HTTP e disponibiliza uma interface que todas as
	 * classes que fazem requisições HTTP devem implementar.
	 */

	@Override
	public void post(String url, Map<String, Object> dados) {
		try {
			URL urlDaAPI = new URL(url);
			URLConnection connection = urlDaAPI.openConnection();
			connection.connect();
		} catch (MalformedURLException e) {
			throw new RuntimeException("Erro ao montar a requisição HTTP " + e.getMessage());
		} catch (IOException e) {
			throw new RuntimeException("Erro ao fazer a conexão com a API " + e.getMessage());
		}
	}

}
