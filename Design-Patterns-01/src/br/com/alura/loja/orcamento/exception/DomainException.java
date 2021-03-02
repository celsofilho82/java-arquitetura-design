package br.com.alura.loja.orcamento.exception;

public class DomainException extends RuntimeException {
	private static final long serialVersionUID = 5848921993900089600L;

	public DomainException(String message) {
		super(message);
	}
}
