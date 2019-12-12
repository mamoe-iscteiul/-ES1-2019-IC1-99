package aplicacao;

import java.util.ArrayList;
import java.util.List;

import gui.GUI;

public class Resultado {

	private int method_id;
	private String ferramenta_utilizada;
	private boolean defeitos_detetados;
	
	private List<Metodo>metodos_long= new ArrayList<Metodo>();
	private List<Metodo>metodos_non_long= new ArrayList<Metodo>();
	private List<Metodo>metodos_DCI= new ArrayList<Metodo>();
	private List<Metodo>metodos_DII= new ArrayList<Metodo>();
	private List<Metodo>metodos_ADCI= new ArrayList<Metodo>();
	private List<Metodo>metodos_ADII= new ArrayList<Metodo>();



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
	
	public void isLongMethod(GUI g,int LOC,int CYCLO){
		for(int i=0;i<g.getMetodos().size();i++){
			if(g.getMetodos().get(i).getLoc()>LOC || g.getMetodos().get(i).getCyclo()>CYCLO){
				metodos_long.add(g.getMetodos().get(i));
			}else if(g.getMetodos().get(i).getLoc()<LOC || g.getMetodos().get(i).getCyclo()<CYCLO){
				metodos_non_long.add(g.getMetodos().get(i));
			}
		}
	}
	
	public void compararIplasma(){
		for(int i=0;i<metodos_long.size();i++){
			if(metodos_long.get(i).isPlasma()==true){
				metodos_DCI.add(metodos_long.get(i));
			}else
			metodos_ADII.add(metodos_long.get(i));
		}
		for(int i=0;i<metodos_non_long.size();i++){
			if(metodos_non_long.get(i).isPlasma()==true){
				metodos_DII.add(metodos_non_long.get(i));
			}else
			metodos_ADCI.add(metodos_non_long.get(i));
		}
	}
	public List<Metodo> getTrueLongMethod() {
		return metodos_long;
	}
	public List<Metodo> getFalseLongMethod() {
		return metodos_non_long;
	}
	public List<Metodo> getDCI() {
		return metodos_DCI;
	}
	public List<Metodo> getDII() {
		return metodos_DII;
	}
	public List<Metodo> getADCI() {
		return metodos_ADCI;
	}
	public List<Metodo> getADII() {
		return metodos_ADII;
	}

}
