package br.com.alura.loja.pedido;

import java.time.LocalDateTime;

import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.pedido.acao.EnviarEmail;
import br.com.alura.loja.pedido.acao.SalvarPedidoNoBanco;

public class GeraPedidoHandler {

	public void execute(GeraPedido dados) {
		Orcamento orcamento = new Orcamento(dados.getValorOrcamento(), dados.getQuantidadeItens());
		Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);

		EnviarEmail enviarEmail = new EnviarEmail();
		SalvarPedidoNoBanco salvarPedidoNoBanco = new SalvarPedidoNoBanco();

		enviarEmail.executar(pedido);
		salvarPedidoNoBanco.executar(pedido);

	}

}
