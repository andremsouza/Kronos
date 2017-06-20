package operations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Gerencia os cálculos feitos pelo programa.
 *
 */
public class Dates {

	/**
	 * Apenas para arredondar o valor final da funcao
	 */
	protected static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	Map<LocalDate, Integer> m1 = new TreeMap<LocalDate, Integer>();
	Map<String, Double> m2 = new TreeMap<String, Double>();
	boolean matricula = false;
	boolean integral = false;
	int inicio = 1;
	int fim = -1;
	int totaldias = -1;
	double valorinfantil = -1;
	double valorfundamental = -1;
	double valorintegral = -1;
	double valormatriculainfant = -1;

	double valormatriculafundam = -1;

	/**
	 * Construtor.
	 * 
	 * @throws Exception
	 *             - Erro de leitura do arquivo de datas
	 */
	public Dates() throws Exception {
		BufferedReader in;
		in = new BufferedReader(new FileReader("src/datas.txt"));
		int i = 0;
		Scanner scan1 = new Scanner(in);
		LocalDate data = LocalDate.now();
		while (scan1.hasNext()) {
			data = LocalDate.parse(scan1.next());
			i++;
			m1.put(data, i);
		}
		totaldias = fim = i;
		in = new BufferedReader(new FileReader("src/valores.txt"));
		Scanner scan2 = new Scanner(in);
		valorinfantil = Double.parseDouble(scan2.next());
		valormatriculainfant = Double.parseDouble(scan2.next());
		valorfundamental = Double.parseDouble(scan2.next());
		valormatriculafundam = Double.parseDouble(scan2.next());
		valorintegral = Double.parseDouble(scan2.next());
		in = new BufferedReader(new FileReader("src/cursos.txt"));
		Scanner scan3 = new Scanner(in);
		while (scan3.hasNext()) {
			m2.put(scan3.next(), Double.parseDouble(scan3.next()));
		}
		scan1.close();
		scan2.close();
		scan3.close();
	}

	/**
	 * Corrige erro do usuario.
	 * 
	 * @param s
	 * @return
	 */
	public int achaDataComeco(String s) {
		LocalDate data;
		int auxdia = Integer.parseInt(s.substring(8));
		int auxmes = Integer.parseInt(s.substring(5, 7));
		while (true) {
			data = LocalDate.parse(s);
			if (m1.containsKey(data))
				break;
			auxdia++;
			s = s.substring(0, 5);
			if (auxdia > 31) {
				auxdia = 1;
				auxmes++;
				if (auxmes > 12)
					return -1;
			}
			if (auxmes < 10)
				s += '0';
			s += auxmes;
			s += '-';
			if (auxdia < 10)
				s += '0';
			s += auxdia;
		}
		return m1.get(data);
	}

	/**
	 * Corrige erro do usuario.
	 * 
	 * @param s
	 * @return
	 */
	public int achaDataFim(String s) {
		LocalDate data;
		int auxdia = Integer.parseInt(s.substring(8));
		int auxmes = Integer.parseInt(s.substring(5, 7));
		while (true) {
			data = LocalDate.parse(s);
			if (m1.containsKey(data))
				break;
			auxdia--;
			s = s.substring(0, 5);
			if (auxdia < 1) {
				auxdia = 31;
				auxmes--;
				if (auxmes < 1)
					return -1;
			}
			if (auxmes < 10)
				s += '0';
			s += auxmes;
			s += '-';
			if (auxdia < 10)
				s += '0';
			s += auxdia;
		}
		return m1.get(data);
	}

	/**
	 * Adiciona curso novo e tambem atualiza valor de algum curso
	 * 
	 * @param s
	 * @param v
	 */
	public void adicionaCurso(String s, double v) {
		m2.put(s.toLowerCase(), v);
	}

	/**
	 * Apenas Diretor/Admin
	 * 
	 * @param s
	 */
	public void atualizarIntegral(double s) {
		valorintegral = s;
	}

	/**
	 * Todos
	 * 
	 * @param s
	 */
	public void atualizarMatricula(boolean s) {
		matricula = s;
	}

	/**
	 * Apenas Diretor/Admin
	 * 
	 * @param s
	 */
	public void atualizarMatriculaFundamental(double s) {
		valormatriculafundam = s;
	}

	/**
	 * Apenas Diretor/Admin
	 * 
	 * @param s
	 */
	public void atualizarMatriculaInfantil(double s) {
		valormatriculainfant = s;
	}

	/**
	 * Apenas Diretor/Admin
	 * 
	 * @param s
	 */
	public void atualizarValorFundamental(double s) {
		valorfundamental = s;
	}

	/**
	 * Apenas Diretor/Admin
	 * 
	 * @param s
	 */
	public void atualizarValorInfantil(double s) {
		valorinfantil = s;
	}

	/**
	 * funcao que escreve os valores finais nos arquivos quando o programa for
	 * fechar.
	 * 
	 * @throws IOException
	 */
	public void fimDePrograma() throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter("src/valores.txt"));
		out.write(valorinfantil + "");
		out.newLine();
		out.write(valormatriculainfant + "");
		out.newLine();
		out.write(valorfundamental + "");
		out.newLine();
		out.write(valormatriculafundam + "");
		out.newLine();
		out.write(valorintegral + "");
		out.close();
		out = new BufferedWriter(new FileWriter("src/cursos.txt"));
		for (Map.Entry<String, Double> entry : m2.entrySet()) {
			out.write(entry.getKey() + "");
			out.newLine();
			out.write(entry.getValue() + "");
			out.newLine();

		}
		out.close();
	}

	/**
	 * Usado para a interface gráfica.
	 * 
	 * @return Matriz para ser utilizada em jTables
	 */
	public Object[][] getCursos() {
		int i = 0;
		Object[][] cursos = new Object[m2.size()][];
		for (Map.Entry<String, Double> entry : m2.entrySet()) {
			String key = entry.getKey();
			Double value = entry.getValue();
			cursos[i] = new Object[2];
			cursos[i][0] = key;
			cursos[i][1] = value;
			i++;
		}
		return cursos;
	}

	/**
	 * Calcula quantas parcelas inteiras
	 * 
	 * @param s
	 * @param tipo
	 * @param integral
	 * @return
	 */
	public int quantasInteiras(double s, int tipo, boolean integral) {
		if (tipo == 1)
			if (integral)
				return (int) (s / (valorinfantil + valorintegral));
			else
				return (int) (s / valorinfantil);
		else if (tipo == 2)
			if (integral)
				return (int) (s / (valorfundamental + valorintegral));
			else
				return (int) (s / valorfundamental);
		return -1;
	}

	/**
	 * Remove Curso
	 * 
	 * @param s
	 */
	public void RemoveCurso(String s) {
		m2.remove(s.toLowerCase());
	}

	/**
	 * get do valor
	 * 
	 * @param tipo
	 * @return
	 */
	public double valor(int tipo) {
		if (tipo == 1)
			return valorinfantil;
		else if (tipo == 2)
			return valorfundamental;
		else if (tipo == 3)
			return valorintegral;
		else if (tipo == 4)
			return valormatriculainfant;
		else if (tipo == 5)
			return valormatriculafundam;
		return -1;
	}

	/**
	 * get da parcela inteira
	 * 
	 * @param tipo
	 * @param integral
	 * @return
	 */
	public double valorParcelaInteira(int tipo, boolean integral) {
		if (tipo == 1)
			if (integral)
				return valorinfantil + valorintegral;
			else
				return valorinfantil;
		else if (tipo == 2)
			if (integral)
				return valorfundamental + valorintegral;
			else
				return valorfundamental;
		return -1;
	}

	/**
	 * Calcula o valor da parcela proporcional
	 * 
	 * @param s
	 * @param tipo
	 * @param integral
	 * @return
	 */
	public double valorParcelaProporcional(double s, int tipo, boolean integral) {
		if (tipo == 1)
			if (integral)
				return round(s % (valorinfantil + valorintegral), 2);
			else
				return round(s % valorinfantil, 2);
		else if (tipo == 2)
			if (integral)
				return round(s % (valorfundamental + valorintegral), 2);
			else
				return round(s % valorfundamental, 2);
		return -1;
	}

	/**
	 * Calcula valor com data de termino fora do padrao
	 * 
	 * @param dia
	 * @param mes
	 * @param tipo
	 * @param termino
	 * @param integral
	 * @param matricula
	 * @return
	 */
	public double valorProporcional(int dia, int mes, int tipo, boolean termino, boolean integral, boolean matricula) {
		int ndias = -1;
		LocalDate data = LocalDate.now();
		double total = 0;
		String aux = "";
		aux = (Integer.toString(data.getYear()));
		aux += "-";
		if (String.valueOf(mes).length() == 1)
			aux += "0";
		aux += mes;
		aux += "-";
		if (String.valueOf(dia).length() == 1)
			aux += "0";
		aux += dia;
		if (termino)
			ndias = this.achaDataFim(aux);
		else
			ndias = this.achaDataComeco(aux);
		if (ndias == -1) {
			return -1;
		}
		if (tipo == 1) {
			if (termino)
				if (integral)
					total += (ndias - inicio + 1) * ((valorinfantil + valorintegral) * 12 / totaldias);
				else
					total += (ndias - inicio + 1) * (valorinfantil * 12 / totaldias);
			else if (integral)
				total += (fim - ndias + 1) * ((valorinfantil + valorintegral) * 12 / totaldias);
			else
				total += (fim - ndias + 1) * (valorinfantil * 12 / totaldias);
			if (matricula)
				total += valormatriculainfant;
		} else if (tipo == 2) {
			if (termino)
				if (integral)
					total += (ndias - inicio + 1) * ((valorfundamental + valorintegral) * 12 / totaldias);
				else
					total += (ndias - inicio + 1) * (valorfundamental * 12 / totaldias);
			else if (integral)
				total += (fim - ndias + 1) * ((valorfundamental + valorintegral) * 12 / totaldias);
			else
				total += (fim - ndias + 1) * (valorfundamental * 12 / totaldias);
			if (matricula)
				total += valormatriculafundam;
		}
		total = round(total, 2);
		return total;
	}

	/**
	 * get do valor total das parecelas inteiras.
	 * 
	 * @param q
	 * @param v
	 * @return
	 */
	public double valorTotalParcelaInteira(int q, double v) {
		return q * v;
	}
}