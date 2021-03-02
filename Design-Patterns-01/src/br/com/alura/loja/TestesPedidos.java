package br.com.alura.loja;

import java.math.BigDecimal;
import java.util.Arrays;

import br.com.alura.loja.pedido.GeraPedido;
import br.com.alura.loja.pedido.GeraPedidoHandler;
import br.com.alura.loja.pedido.acao.EnviarEmail;
import br.com.alura.loja.pedido.acao.SalvarPedidoNoBanco;

public class TestesPedidos {

	public static void main(String[] args) {

		String cliente = "Celso Ribeiro";
		BigDecimal valorOrcamento = new BigDecimal("400");
		int quantidadeItens = Integer.parseInt("5");

		GeraPedido pedido = new GeraPedido(cliente, valorOrcamento, quantidadeItens);
		GeraPedidoHandler geraPedidoHandler = new GeraPedidoHandler(
				Arrays.asList(new EnviarEmail(), new SalvarPedidoNoBanco()));
		geraPedidoHandler.execute(pedido);

	}

}
