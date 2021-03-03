package br.com.alura.loja.http;

import java.util.Map;

public interface HttpAdapter {

	/*
	 * Quando precisamos utilizar código legado ou código de componentes externos em
	 * nosso sistema, é muito comum não ter a interface (métodos públicos) batendo
	 * com o que a gente precisa, então nesses casos nós criamos adapters.
	 * 
	 * O padrão Adapter pode nos ajudar a trocar detalhes de infraestrutura,
	 * sem muitas dores de cabeça
	 */

	void post(String url, Map<String, Object> dados);

}
