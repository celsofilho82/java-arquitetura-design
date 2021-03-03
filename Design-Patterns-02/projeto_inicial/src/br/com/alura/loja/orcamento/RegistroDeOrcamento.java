package br.com.alura.loja.orcamento;

import java.util.Map;

import br.com.alura.loja.DomainException;
import br.com.alura.loja.http.HttpAdapter;

public class RegistroDeOrcamento {

	/*
	 * Essa classe tem como objetivo chamar uma API externa para registrar um
	 * orçamento
	 * 
	 * Como recomentação: Devemos depender sempre de abstrações, e não de
	 * implementações específicas. Esse é um dos princípio de SOLID (Dependency
	 * Inversion Principle, a letra D). Devemos sempre preferir depender de
	 * abstrações, ou seja, interfaces ou classes abstratas, sempre que possível, ao
	 * invés de implementações específicas.
	 */

	private HttpAdapter http;

	public RegistroDeOrcamento(HttpAdapter http) {
		this.http = http;
	}

	public void registrar(Orcamento orcamento) {
		if (!orcamento.isFinalizado()) {
			throw new DomainException("Esse orçamento não foi finalizado");
		}

		String url = "https://api.externa/orcamento";
		Map<String, Object> dados = Map.of("valor", orcamento.getValor(), "quantidadeItens",
				orcamento.getQuantidadeItens());
		http.post(url, dados);
	}

}
