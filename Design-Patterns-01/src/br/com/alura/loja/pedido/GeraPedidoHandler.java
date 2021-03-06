package br.com.alura.loja.pedido;

import java.time.LocalDateTime;
import java.util.List;

import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.pedido.acao.AcaoAposGerarPedido;

public class GeraPedidoHandler {

	/*
	 * Command Handler tem como responsabilidade, normalmente, apenas orquestrar as
	 * tarefas a serem executadas, ou seja, chamar as classes necessárias que
	 * realizam as tarefas desejadas.
	 *
	 * Separar cada uma das tarefas em classes distintas é benéfico para:
	 * 
	 * Se em algum momento uma das tarefas parar de funcionar, nós sabemos que há
	 * uma classe específica para este propósito e podemos começar a depuração por
	 * ela.
	 * 
	 * O nosso Command Handler não precisa saber detalhe específico, então é
	 * interessante que cada classe seja responsável apenas por uma pequena tarefa.
	 * 
	 * Utilizamos aqui o padrão Observer e definimos as classes EnviarEmail e
	 * SalvarPedidoNoBanco como observadores. O padrão Observer é comumente
	 * utilizado por diversas bibliotecas que trabalham com eventos. Muitas
	 * tecnologias em Java, como o Spring e o CDI, possuem componentes que nos
	 * auxiliam a trabalhar com eventos.
	 */

	private List<AcaoAposGerarPedido> acoes;

	public GeraPedidoHandler(List<AcaoAposGerarPedido> acoes) {
		this.acoes = acoes;
	}

	public void execute(GeraPedido dados) {
		Orcamento orcamento = new Orcamento(dados.getValorOrcamento(), dados.getQuantidadeItens());
		Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);

		acoes.forEach(acao -> acao.executar(pedido));

	}

}
