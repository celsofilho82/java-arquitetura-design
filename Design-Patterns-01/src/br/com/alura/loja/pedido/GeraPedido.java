package br.com.alura.loja.pedido;

import java.math.BigDecimal;

public class GeraPedido {

	/*
	 * Neste problema separamos os aspectos da geração de um pedido em duas classes:
	 * A classe que recebe os dados para gerar o pedido GeraPedidoHandler e a classe
	 * GeraPedido que contém os dados do pedido.
	 * 
	 * Utilizamos o padrão de projeto Command. O padrão de projetos Command é,
	 * provavelmente, um dos que mais gera confusão, principalmente no mundo de
	 * desenvolvimento web em geral, já que alguns conceitos mais específicos pro
	 * mundo da web surgiram. Utilizamos nesse problema especifico o padrão Command
	 * Handlers que separa os dados da execução em si
	 * 
	 * Um caso de uso em nossa aplicação pode ter várias ações (salvar
	 * no banco, enviar e-mail, etc);
	 */

	private String cliente;
	private BigDecimal valorOrcamento;
	private int quantidadeItens;

	public GeraPedido(String cliente, BigDecimal valorOrcamento, int quantidadeItens) {
		this.cliente = cliente;
		this.valorOrcamento = valorOrcamento;
		this.quantidadeItens = quantidadeItens;
	}

	public String getCliente() {
		return cliente;
	}

	public BigDecimal getValorOrcamento() {
		return valorOrcamento;
	}

	public int getQuantidadeItens() {
		return quantidadeItens;
	}

}
