package br.com.alura.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

/**
 * 
 * @author celso 
 * Essa classe foi criada para melhorar a coesão da classe
 * funcionário extraindo dela o método que calcula o reajuste do
 * salário. Refatoramos a classe e criamos um Service cujo a única 
 * responsabilidade é fazer o reajuste do salário deixando a regra 
 * de negôcio isolada.
 * 
 * Nessa refatoração aplicamos o primeiro principio do SOLID que é
 * a letra S = Single Responsibility.
 * Que é o principio da responsabilidade única.
 * Que define que uma classe (ou módulo, função, etc) deve ter 
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
