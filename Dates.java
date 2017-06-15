package operations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.*;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Dates {

	Map<LocalDate,Integer> m1 = new TreeMap<LocalDate,Integer>();
	boolean matricula=false;
	int inicio=1;
	int fim=-1;
	int totaldias=-1;
	double valorinfantil=-1;
	double valorfundamental=-1;
	double valormatriculainfant=-1;
	double valormatriculafundam=-1;
	
	public Dates() throws Exception{
		BufferedReader in;
		in = new BufferedReader(new FileReader("datas.txt"));
		int i=0;
		Scanner scan1=new Scanner(in);
		while (scan1.hasNext()){
			LocalDate data = LocalDate.parse(scan1.next());
			i++;
				m1.put(data, i);
		}
		totaldias=fim=i;
		in = new BufferedReader(new FileReader("valores.txt"));
		Scanner scan2=new Scanner(in);
		valorinfantil=Double.parseDouble(scan2.next());
		valormatriculainfant=Double.parseDouble(scan2.next());
		valorfundamental=Double.parseDouble(scan2.next());
		valormatriculafundam=Double.parseDouble(scan2.next());
		scan1.close();
		scan2.close();
	}
	
	public void mostraValores (){
		System.out.println("valor infantil "+valorinfantil);
		System.out.println("valor fundamental "+valorfundamental);
		System.out.println("valor matricula infantil "+valormatriculainfant);
		System.out.println("valor matricula fundamental "+valormatriculafundam);
		System.out.println("inicio "+inicio);
		System.out.println("fim "+fim);
		System.out.println("totaldias "+totaldias);
	}
	
	protected static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	public int achaDataFim (String s){
		LocalDate data;
		int aux=Integer.parseInt(s.substring(8));
		while (true){
			data=LocalDate.parse(s);
			if (m1.containsKey(data))
				break;
			aux--;
			s=s.substring(0,8);
			s+=aux;
		}
		return m1.get(data);
	}
	
	public void atualizarInicio(String s){
		LocalDate data = LocalDate.parse(s);
		inicio=m1.get(data);
	}

	public void atualizarFim(String s){
		LocalDate data = LocalDate.parse(s);
		fim=m1.get(data);
	}
	
	public void atualizarMatricula(boolean s){
		matricula=s;
	}
	public void atualizarValorInfantil(double s){
		valorinfantil=s;
	}
	public void atualizarValorFundamental(double s){
		valorfundamental=s;
	}
	public void atualizarMatriculaInfantil(double s){
		valormatriculainfant=s;
	}
	public void atualizarMatriculaFundamental(double s){
		valormatriculafundam=s;
	}
	
	public void valorProporcionalDataFim () throws InterruptedException{
		int ndias=-1;
		LocalDate data = LocalDate.now();
		double infantil=0,fundamental=0;
		String dia="",mes="",aux="";
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite o Dia");
		dia= teclado.nextLine();
		while (Integer.parseInt(dia)>31 || Integer.parseInt(dia)<1 || dia.length()>2){
			System.out.println("Dia invalido, digite novamente");
			dia= teclado.nextLine();
		}
		System.out.println("Digite o Mes");
		mes= teclado.nextLine();
		while (Integer.parseInt(mes)>12 || Integer.parseInt(mes)<1 || mes.length()>2){
			System.out.println("Mes invalido, digite novamente");
			mes= teclado.nextLine();
		}
		aux=(Integer.toString(data.getYear()));
		aux+="-";
		if (mes.length()==1)
		aux+="0";	
		aux+=mes;
		aux+="-";
		aux+=dia;
		//data=LocalDate.parse(aux);
		ndias=this.achaDataFim(aux);
		//fim=m1.get(data);
		infantil+=(ndias-inicio+1)*(valorinfantil*12/totaldias);
		fundamental+=(ndias-inicio+1)*(valorfundamental*12/totaldias);
		if (matricula){
			infantil+=valormatriculainfant;
			fundamental+=valormatriculafundam;
		}
		infantil=round(infantil,2);
		fundamental=round(fundamental,2);
		System.out.println("Valor Proporcional Infantil "+infantil);
		System.out.println("Valor Proporcional Fundamental "+fundamental);
		teclado.close();
	}
}
