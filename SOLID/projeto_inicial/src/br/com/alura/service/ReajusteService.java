package br.com.alura.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

/**
 * 
 * @author celso 
 * Essa classe foi criada para melhorar a coes�o da classe
 * funcion�rio extraindo dela o m�todo que calcula o reajuste do
 * sal�rio. Refatoramos a classe e criamos um Service cujo a �nica 
 * responsabilidade � fazer o reajuste do sal�rio deixando a regra 
 * de neg�cio isolada.
 * 
 * Nessa refatora��o aplicamos o primeiro principio do SOLID que �
 * a letra S = Single Responsibility.
 * Que � o principio da responsabilidade �nica.
 * Que define que uma classe (ou m�dulo, fun��o, etc) deve ter 
 * um e apenas um motivo para mudar
 */
public class ReajusteService {

	public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento) {
		BigDecimal salarioAtual = funcionario.getSalario();
		BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
		if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
			throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
		}
		BigDecimal salarioReajustado = salarioAtual.add(aumento);
		funcionario.atualizarSalario(salarioReajustado);
	}
}
