package aplicacao;

public class Resultado {

	private int method_id;
	private String ferramenta_utilizada;
	private boolean defeitos_detetados;
	
	
	public int getMethod_id() {
		return method_id;
	}
	public void setMethod_id(int method_id) {
		this.method_id = method_id;
	}
	public String getFerramenta_utilizada() {
		return ferramenta_utilizada;
	}
	public void setFerramenta_utilizada(String ferramenta_utilizada) {
		this.ferramenta_utilizada = ferramenta_utilizada;
	}
	public boolean isDefeitos_detetados() {
		return defeitos_detetados;
	}
	public void setDefeitos_detetados(boolean defeitos_detetados) {
		this.defeitos_detetados = defeitos_detetados;
	}
	
}
