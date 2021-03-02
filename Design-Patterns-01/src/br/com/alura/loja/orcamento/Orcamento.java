package br.com.alura.loja.orcamento;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.situacao.EmAnalise;
import br.com.alura.loja.orcamento.situacao.SituacaoOrcamento;

public class Orcamento {

	/*
	 * Neste problema utilizamos o padrão State assim como o padrão Strategy,
	 * resolve o problema de muitos ifs no código justamente na transição entre
	 * estados da aplicação.
	 * 
	 * O padrão State é aplicado quando temos uma situação de transição de estado ou
	 * um algoritmo baseado no estado de um objeto de uma classe.
	 * 
	 * Neste exemplo transformamos cada situação(estado) em uma classe criando uma
	 * classe abstrata chamada(SituacaoOrcamento) e utilizamos a herança que cada
	 * classe que corresponde a uma situação deve herdar e sobrescrever se for o
	 * caso os métodos desta classe
	 */

	private BigDecimal valor;

	private int quantidadeItens;

	private SituacaoOrcamento situacao;

	public Orcamento(BigDecimal valor, int quantidadeItens) {
		this.valor = valor;
		this.quantidadeItens = quantidadeItens;
		this.situacao = new EmAnalise();
	}

	public void aplicarDescontoExtra() {
		BigDecimal valorDoDescontoExtra = this.situacao.calcularValorDescontoExtra(this);
		this.valor = this.valor.subtract(valorDoDescontoExtra);
	}

	public BigDecimal getValor() {
		return valor;
	}

	public int getQuantidadeItens() {
		return quantidadeItens;
	}

	public SituacaoOrcamento getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoOrcamento situacao) {
		this.situacao = situacao;
	}

	public void aprovar() {
		this.situacao.aprovar(this);
	}

	public void reprovar() {
		this.situacao.reprovar(this);
	}

	public void finalizar() {
		this.situacao.finalizar(this);
	}

}
