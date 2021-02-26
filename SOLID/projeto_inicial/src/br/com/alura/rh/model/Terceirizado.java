package br.com.alura.rh.model;

import java.math.BigDecimal;

/**
 * 
 * @author celso
 * 
 *         Foi necessário criar uma nova regra adicionando os terceirizados como
 *         classe de dominio. Poderiamos extender a classe Terceirizados com a
 *         classe Funcionários mas desta forma ganhariamos comportamentos não
 *         desejados para a classe Terceirizados, alguns métodos herdados não
 *         deveriam existir nessa classe.
 * 
 *         Utilizar a composição através da classe DadosPessoais contendo
 *         somente os campos necessários para a classe Terceirizado é uma das
 *         maneiras de evitar a herança sem duplicação de código.
 * 
 *         Em SOLID chamamos o principio da substituição de Linskov esse
 *         principio diz que devemos poder substituir classes base por suas
 *         classes derivadas em qualquer lugar, sem problema. Embora a herança
 *         favoreça o reaproveitamento de código, ela pode trazer efeitos
 *         colaterais quando não utilizada da maneira correta;
 * 
 */

public class Terceirizado {

	private String empresa;
	private DadosPessoais dadosPessoais;

	public Terceirizado(String nome, String cpf, Cargo cargo, BigDecimal salario) {
		this.dadosPessoais = new DadosPessoais(nome, cpf, cargo, salario);
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}

}
