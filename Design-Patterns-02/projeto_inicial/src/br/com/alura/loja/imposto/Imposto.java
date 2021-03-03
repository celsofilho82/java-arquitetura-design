package br.com.alura.loja.imposto;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;

public abstract class Imposto {

	/*
	 * Decorator: Neste exemplo a classe Imposto tem como composição ela mesma ou
	 * seja tem um auto relacionamento com ela mesma (Decoração).
	 * 
	 * Utilizamos o padrão Decorator para resolver um problema em específico da
	 * aplicação. Flexibilizar, de maneira dinâmica, o cálculo de diferentes
	 * impostos de um orçamento.
	 * 
	 * O padrão Decorator permite adicionar novos comportamentos a um objeto,
	 * tornando o código bastante flexível e dinâmico.
	 * 
	 * O padrão Decorator é muito poderoso e bastante comum de ser implementado, mas
	 * possui alguns detalhes importantes a serem observados, como o fato do
	 * Decorator precisar possuir a mesma interface do objeto que ele está
	 * decorando.
	 */

	private Imposto outroImposto;

	public Imposto(Imposto outroImposto) {
		this.outroImposto = outroImposto;
	}

	protected abstract BigDecimal realizarCalculo(Orcamento orcamento);

	public BigDecimal calcular(Orcamento orcamento) {
		BigDecimal valorImposto = realizarCalculo(orcamento);
		BigDecimal valorOutroImposto = BigDecimal.ZERO;
		if (outroImposto != null) {
			valorImposto = outroImposto.realizarCalculo(orcamento);
		}

		return valorImposto.add(valorOutroImposto);
	}

}
