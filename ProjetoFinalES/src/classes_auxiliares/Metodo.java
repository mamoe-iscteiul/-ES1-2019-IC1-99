package classes_auxiliares;

import java.util.ArrayList;
import java.util.List;

public class Metodo {

	private int method_id;
	private String package_name;
	private String class_name;
	private String name;
	private int loc;
	private int cyclo;
	private int atfd;
	private double laa;
	private boolean is_long_method;
	private boolean plasma;
	private boolean pmd;
	private boolean is_feature_envy;
	
	private List<Object> dados = new ArrayList<>();
	
	
	public List<Object> getDados() {
		return dados;
	}
	public void setDados() {
		dados.set(0, method_id);
		dados.set(1, package_name);
		dados.set(2,class_name);
		dados.set(3, name);
		dados.set(4, loc);
		dados.set(5, cyclo);
		dados.set(6, atfd);
		dados.set(7, laa);
		dados.set(8, is_long_method);
		dados.set(9, plasma);
		dados.set(10, pmd);
		dados.set(11, is_feature_envy);
	}
	public int getMethod_id() {
		return method_id;
	}
	public void setMethod_id(int method_id) {
		this.method_id = method_id;
	}
	public String getPackage_name() {
		return package_name;
	}
	public void setPackage_name(String package_name) {
		this.package_name = package_name;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLoc() {
		return loc;
	}
	public void setLoc(int loc) {
		this.loc = loc;
	}
	public int getCyclo() {
		return cyclo;
	}
	public void setCyclo(int cyclo) {
		this.cyclo = cyclo;
	}
	public int getAtfd() {
		return atfd;
	}
	public void setAtfd(int atfd) {
		this.atfd = atfd;
	}
	public double getLaa() {
		return laa;
	}
	public void setLaa(double laa) {
		this.laa = laa;
	}
	public boolean isIs_long_method() {
		return is_long_method;
	}
	public void setIs_long_method(boolean is_long_method) {
		this.is_long_method = is_long_method;
	}
	public boolean isPlasma() {
		return plasma;
	}
	public void setPlasma(boolean iPlasma) {
		this.plasma = iPlasma;
	}
	public boolean isPmd() {
		return pmd;
	}
	public void setPmd(boolean pmd) {
		this.pmd = pmd;
	}
	public boolean isIs_feature_envy() {
		return is_feature_envy;
	}
	public void setIs_feature_envy(boolean is_feature_envy) {
		this.is_feature_envy = is_feature_envy;
	}
	
	public void setAtributos(List<Object> o) {
		setMethod_id(Integer.parseInt((String) o.get(0)));
		setPackage_name((String) o.get(1));
		setClass_name((String) o.get(2));
		setName((String) o.get(3));
		setLoc(Integer.parseInt((String)o.get(4)));
		setCyclo(Integer.parseInt((String) o.get(5)));
		setAtfd(Integer.parseInt((String) o.get(6)));
		setLaa(Double.parseDouble((String) o.get(7)));
		setIs_long_method(Boolean.parseBoolean((String) o.get(8)));
		setPlasma(Boolean.parseBoolean((String) o.get(9)));
		setPmd(Boolean.parseBoolean((String) o.get(10)));
		setIs_feature_envy(Boolean.parseBoolean((String) o.get(11)));
	}
	
	@Override
	public String toString() {
		return new String("Method id: " + method_id + " | Package: " + package_name + " | Class: " + class_name + " | Method: " + name);
	}
	
}
