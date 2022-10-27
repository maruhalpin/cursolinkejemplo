package ar.edu.utn.link.correlativas.model;

public class CorrelativasException extends Exception {

	private Materia materia;
	private Materia corr;

	public CorrelativasException() {
		super();
	}

	public CorrelativasException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public CorrelativasException(String message, Throwable cause) {
		super(message, cause);
	}

	public CorrelativasException(String message,Materia mat, Materia corr) {
		super(message);
		this.materia = mat;
		this.corr = corr;
	}
	
	public CorrelativasException(String message) {
		super(message);
	}

	public CorrelativasException(Throwable cause) {
		super(cause);
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Materia getCorr() {
		return corr;
	}

	public void setCorr(Materia corr) {
		this.corr = corr;
	}

	
	
	
	
}
