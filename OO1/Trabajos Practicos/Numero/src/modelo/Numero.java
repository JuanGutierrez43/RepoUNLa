package modelo;

public class Numero {
	private int n = 10;

	public Numero(int n) {

		this.n = n;
	}

	public int getN() {
		return this.n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int sumar(int n1) {
		n = 10;
		return n + n1;
	}

	public int multiplicar(int n1) {
		n = 10;
		return n * n1;
	}

	public boolean esPar() {
		n = 15;
		if (n % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}
	public boolean esPrimo() {
		n=1;
		boolean resu = true;
		int i = 2;
		while (i < n) {
			if (n % i == 0) {
				resu = false;
			}
			i++;
		}
		return resu;
	}
	public String convertirAString() {
		n=15;
		return String.valueOf(n);
	}
	public double convertirDouble() {
		n=35;
		String num=String.valueOf(n);
		return Double.parseDouble(num);
	}

	public double calcularPotencia(int exp) {
		n=2;
		return Math.pow(n, exp);
	}

	public String pasarBase2() {
		n=18;
		int cociente = 0;
		int resto = 0;
		String resultado = "";
		cociente = n / 2;
		resto = n % 2;
		resultado = "" + (resto) + "";
		while (cociente != 0) {
			resto = cociente % 2;
			cociente = cociente / 2;
			resultado = "" + (resto) + "" + (resultado) + "";
		}
		return resultado;
	}

	public int calcularFactorial() {
		n=5;
		int resultado = n;
		if (n > 0) {
			for (int i = (n - 1); i > 0; i--) {
				resultado = resultado * i;
			}
		} else if (n == 0) {
			resultado = 1;
		} else {
			resultado = -1;
		}
		return resultado;
	}

	public int numeroCombinatorio(int n1) {
		n=20;
		int resultado = n;
		if (n > 0 && n1 > 0) {
			if (n > n1) {
				int i = (n - 1);
				int flag = 1;
				while (flag < n1) {
					resultado = resultado * i;
					i--;
					flag++;
				}
			}
		}
		return resultado;
	}

}
