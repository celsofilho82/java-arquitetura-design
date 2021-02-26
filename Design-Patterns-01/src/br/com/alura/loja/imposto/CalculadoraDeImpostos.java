package br.com.alura.loja.imposto;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;

public class CalculadoraDeImpostos {

	/**
	 * Como diminuir a complexidade do nosso código, trocando múltiplas condicionais
	 * por classes: Esta técnica é chamada de Strategy, que é um dos padrões de
	 * projeto
	 * 
	 * Utilizamos o padrão de projeto chamado Strategy para resolver o problema do
	 * cálculo de impostos. Este padrão pode ser utilizado quando há diversos
	 * possíveis algoritmos para uma ação (como calcular imposto, por exemplo).
	 * Nele, nós separamos cada um dos possíveis algoritmos em classes separadas.
	 * 
	 */

	public BigDecimal calcular(Orcamento orcamento, Imposto imposto) {

		return imposto.calcular(orcamento);
	}

}
