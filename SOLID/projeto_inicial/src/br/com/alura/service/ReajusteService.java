package br.com.alura.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.alura.rh.model.Funcionario;

/**
 * 
 * @author celso Essa classe foi criada para melhorar a coes�o da classe
 *         funcion�rio extraindo dela o m�todo que calcula o reajuste do
 *         sal�rio. Refatoramos a classe e criamos um Service cujo a �nica
 *         responsabilidade � fazer o reajuste do sal�rio deixando a regra de
 *         neg�cio isolada.
 * 
 *         Nessa refatora��o aplicamos o primeiro principio do SOLID que � a
 *         letra S = Single Responsibility. Que � o principio da
 *         responsabilidade �nica. Que define que uma classe (ou m�dulo, fun��o,
 *         etc) deve ter um e apenas um motivo para mudar
 * 
 *         Nessa refatoração encontramos um problema na classe ReajusteService.
 *         Enquanto novas validações de reajuste fossem criadas, novas condições
 *         deveriam ser adicionadas a esta classe, fazendo-a crescer
 *         interminavelmente. O principio do SOLID utilizado foi o principio do
 *         "Aberto\Fechado" onde a estratégia adotada foi criar classes
 *         especificas para cuidar de cada validação e uma interface que vai
 *         servir de molde para as classes de validação. Assim se for preciso
 *         alterar uma validação ou criar uma nova basta fazer a alteração em un
 *         único ponto dexando a classe mais extensivel. A classe fica aberta
 *         para extensões mais fechada para modificações
 */
public class ReajusteService {

	private List<ValidacaoReajuste> validacoes;

	public ReajusteService(List<ValidacaoReajuste> validacoes) {
		this.validacoes = validacoes;
	}

	public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento) {

		this.validacoes.forEach(validacao -> validacao.validar(funcionario, aumento));

		BigDecimal salarioReajustado = funcionario.getSalario().add(aumento);
		funcionario.atualizarSalario(salarioReajustado);
	}
}
