package excecoes;

public class DomainException extends Exception {
	private static final long serialVersionUID = 1L; // os objetos dessa classe podem ser convertidos para bytes.
	
	public DomainException(String msg) {
		super(msg);
	}
}
