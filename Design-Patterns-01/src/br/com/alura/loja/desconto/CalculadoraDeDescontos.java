package br.com.alura.loja.desconto;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;

public class CalculadoraDeDescontos {

	public BigDecimal calcular(Orcamento orcamento) {

		/**
		 * No caso do cálculo de descontos não sabemos qual desconto vai ser aplicado no
		 * orçamento portanto, precisamos verificar todos os descontos possíveis de
		 * serem aplicados e caso o desconto em questão não seja aplicado é preciso
		 * chamar o próximo desconto seguindo uma cadeia. Implementamos a classe
		 * SemDesconto, que é responsável por finalizar essa cadeia de
		 * responsabilidades.
		 * 
		 * Chain of Responsibility, padrão para aplicar um desconto dentro de uma cadeia
		 * de possíveis descontos.
		 */

		Desconto desconto = new DescontoParaOrcamentoComMaisDeCincoItens(
				new DescontoParaOrcamentoComValorMaiorQueQuinhentos(new SemDesconto()));

		return desconto.calcular(orcamento);
	}

}
