package Model;

public class Duracion {


	private int iCPU;
	private int EyS;
	private int fCPU;

	public Duracion(int iCPU, int eyS, int fCPU) {
		this.iCPU = iCPU;
		this.EyS = eyS;
		this.fCPU = fCPU;
	}

	public Duracion() {
		this.iCPU = 0;
		this.EyS = 0;
		this.fCPU = 0;
	}
	public int getiCPU() {
		return iCPU;
	}

	public void setiCPU(int iCPU) {
		this.iCPU = iCPU;
	}

	public int getEyS() {
		return EyS;
	}

	public void setEyS(int eyS) {
		EyS = eyS;
	}

	public int getfCPU() {
		return fCPU;
	}

	public void setfCPU(int fCPU) {
		this.fCPU = fCPU;
	}

	@Override
	public String toString() {
		return "[CPU=" + getiCPU()
				+ ", E/S=" + getEyS()
				+ ", CPU=" + getfCPU() 
				+ "]";
	}

}
