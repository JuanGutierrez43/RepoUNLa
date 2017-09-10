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

	/*------------------------------------------------------*/
	// Metodos
	public Proceso traerProceso(int idProceso) {
		Proceso procesoAux = null;
		int i = 0;
		int lenD = 0;
		if (!getLstProcesos().isEmpty()) {
			lenD = getLstProcesos().size();
			while (i < lenD) {
				if (getLstProcesos().get(i).equal(idProceso)) {
					procesoAux = getLstProcesos().get(i);
					i = lenD;
				}
				i++;
			}
		}
		return procesoAux;
	}

	public boolean listarProceso(Proceso proceso) {
		boolean agregar = false;
		agregar = getLstProcesos().add(proceso);
		return agregar;
	}

	public Proceso deslistarProceso(int idProceso) {
		Proceso procesoAux = null;
		if (!traerProceso(idProceso).equal(null)) {
			procesoAux = traerProceso(idProceso);
			int i = 0;
			int lenD = getLstProcesos().size();
			while (i < lenD) {
				if (traerProceso(i + 1).equals(idProceso)) {
					getLstProcesos().remove(i);
					i = lenD;
				}
				i++;
			}
		}
		return procesoAux;
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
