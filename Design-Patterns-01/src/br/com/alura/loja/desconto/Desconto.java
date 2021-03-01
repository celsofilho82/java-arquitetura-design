package br.com.alura.loja.desconto;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;

public abstract class Desconto {

	/**
	 * Refatoramos a classe Desconto e aplicamos o pattern Template Method com a
	 * criação de um método concreto na classe “mãe”, que chama métodos abstratos
	 * implementados nas classes “filhas”.
	 * 
	 * O padrão Template Method favorece o reaproveitamento de códigos comuns entre
	 * classes, evitando assim duplicações de códigos. Criamos um template de
	 * algoritmo que estava sendo replicado em mais de uma classe e utilizamos
	 * herança para reaproveitar esse código:
	 */

	protected Desconto proximo;

	public Desconto(Desconto proximo) {
		this.proximo = proximo;
	}

	public BigDecimal calcular(Orcamento orcamento) {
		if (deveAplicar(orcamento)) {
			return efetuarCalculo(orcamento);
		}

		return proximo.calcular(orcamento);
	}

	protected abstract BigDecimal efetuarCalculo(Orcamento orcamento);

	protected abstract boolean deveAplicar(Orcamento orcamento);

}
