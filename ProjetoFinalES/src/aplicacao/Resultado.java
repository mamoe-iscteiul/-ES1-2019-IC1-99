package aplicacao;

import java.util.ArrayList;
import java.util.List;

import gui.GUI;

public class Resultado {

	private int method_id;
	private String ferramenta_utilizada;
	private boolean defeitos_detetados;

	private List<Metodo>TrueLongMethod= new ArrayList<Metodo>();
	private List<Metodo>FalseLongMethod= new ArrayList<Metodo>();
	private List<Metodo>DCI= new ArrayList<Metodo>();
	private List<Metodo>DII= new ArrayList<Metodo>();
	private List<Metodo>ADCI= new ArrayList<Metodo>();
	private List<Metodo>ADII= new ArrayList<Metodo>();


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

	public void isLongMethod(GUI g,int LOC, int CYCLO){
		for(int i=0;i<g.getMetodos().size();i++){
			if(g.getMetodos().get(i).getLoc()>LOC && g.getMetodos().get(i).getCyclo()>CYCLO){
				TrueLongMethod.add(g.getMetodos().get(i));
			}
			FalseLongMethod.add(g.getMetodos().get(i));
		}
	}

	public void compararIplasma(){
		for(int i=0;i<TrueLongMethod.size();i++){
			if(TrueLongMethod.get(i).isPlasma()==true){
				DCI.add(TrueLongMethod.get(i));
			}
			ADII.add(TrueLongMethod.get(i));
		}
		for(int i=0;i<FalseLongMethod.size();i++){
			if(FalseLongMethod.get(i).isPlasma()==true){
				DII.add(FalseLongMethod.get(i));
			}
			ADCI.add(FalseLongMethod.get(i));
		}
	}
	public List<Metodo> getTrueLongMethod() {
		return TrueLongMethod;
	}
	public List<Metodo> getFalseLongMethod() {
		return FalseLongMethod;
	}
	public List<Metodo> getDCI() {
		return DCI;
	}
	public List<Metodo> getDII() {
		return DII;
	}
	public List<Metodo> getADCI() {
		return ADCI;
	}
	public List<Metodo> getADII() {
		return ADII;
	}

}
