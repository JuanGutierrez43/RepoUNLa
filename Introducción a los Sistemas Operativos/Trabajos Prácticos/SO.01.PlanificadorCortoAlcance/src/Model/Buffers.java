package Model;

import java.util.ArrayList;
import java.util.List;

public class Buffers {

	private int idBuffers;
	private List<Proceso> lstProcesos;

	public Buffers(int idBuffers) {
		this.idBuffers = idBuffers;
		this.lstProcesos = new ArrayList<Proceso>();
	}

	public Buffers(int idBuffers, List<Proceso> lstProcesos) {
		this.idBuffers = idBuffers;
		this.lstProcesos = lstProcesos;
	}

	public int getIdBuffers() {
		return idBuffers;
	}

	public void setIdBuffers(int idBuffers) {
		this.idBuffers = idBuffers;
	}

	public List<Proceso> getLstProcesos() {
		return lstProcesos;
	}

	public void setLstProcesos(List<Proceso> lstProcesos) {
		this.lstProcesos = lstProcesos;
	}

	/*------------------------------------------------------*/
	// Metodos
	public boolean bloquearProceso(Proceso proceso) {
		boolean validate = false;
		validate = getLstProcesos().add(proceso);
		return validate;
	}

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

	public boolean ejecutarEyS(int idProceso) {
		boolean ejecutado = true;
		Proceso procesoAux = traerProceso(idProceso);
		int tiempo = 0;
		if (!procesoAux.equals(null)) {
			tiempo = procesoAux.getDuracion().getEyS();
			if (tiempo >= 0) {
				procesoAux.getDuracion().setEyS(tiempo - 1);
			}else{
				ejecutado = false;
			}
		}
		return ejecutado;
	}

	public Proceso eliminarBloqueado(int idProceso) {
		Proceso procesoAux = null;
		if (!traerProceso(idProceso).equals(null)) {
			procesoAux = traerProceso(idProceso);
			int i = 0;
			int lenD = getLstProcesos().size();
			while (i < lenD) {
				if (getLstProcesos().get(i).equal(idProceso)) {
					getLstProcesos().remove(i);
					i = lenD;
				}
				i++;
			}
		}
		return procesoAux;
	}

	public boolean ordenarId() {

		int lenD = getLstProcesos().size();
		Proceso procesoAux = new Proceso();int k;
		boolean ordenado=false;

		// Ordeno lista por InsertionSort
		for(int i=1;i<lenD;i++){
			procesoAux=getLstProcesos().get(i);
			k=i-1;
			ordenado=false;
			while(!ordenado && k>=0){
				if(procesoAux.getIdProceso()<getLstProcesos().get(k).getIdProceso()){	
					getLstProcesos().set(k+1, getLstProcesos().get(k));
					k=k-1;
				}else{
					ordenado=true;
				}
			}
			getLstProcesos().set(k+1, procesoAux);
		}
		return ordenado;
	}
	
	@Override
	public String toString() {
		String string = "IdBuffers=" + getIdBuffers();
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
