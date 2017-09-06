package Model;

import java.util.ArrayList;
import java.util.List;

public class Listo {

	private int idListo;
	private List<Proceso> lstProcesos;

	public Listo(int idListo) {
		this.idListo = idListo;
		this.lstProcesos = new ArrayList<Proceso>();
	}

	public int getIdListo() {
		return idListo;
	}

	public void setIdListo(int idListo) {
		this.idListo = idListo;
	}

	public List<Proceso> getLstProcesos() {
		return lstProcesos;
	}

	public void setLstProcesos(List<Proceso> lstProcesos) {
		this.lstProcesos = lstProcesos;
	}

	@Override
	public String toString() {
		String string = "IdListo=" + getIdListo();
		if (!getLstProcesos().isEmpty()) {
			string += ", LstProcesos=[";
			for (Proceso proceso : getLstProcesos()) {
				string += "\n\t" + proceso;
			}
			string += "]";
		} else {
			string += ", LstProcesos=[" + null + "]";
		}
		return string;
	}

}
