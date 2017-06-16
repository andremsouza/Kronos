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
	
	///Construtor
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
	
	///Apenas para testes
	public void mostraValores (){
		System.out.println("valor infantil "+valorinfantil);
		System.out.println("valor fundamental "+valorfundamental);
		System.out.println("valor matricula infantil "+valormatriculainfant);
		System.out.println("valor matricula fundamental "+valormatriculafundam);
		System.out.println("inicio "+inicio);
		System.out.println("fim "+fim);
		System.out.println("totaldias "+totaldias);
	}
	
	///Apenas para arredondar o valor final da funcao
	protected static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	///Corrige erro do usuario
	public int achaDataFim (String s){
		LocalDate data;
		int auxdia=Integer.parseInt(s.substring(8));
		int auxmes=Integer.parseInt(s.substring(5,7));
		while (true){
			data=LocalDate.parse(s);
			if (m1.containsKey(data))
				break;
			auxdia--;
			s=s.substring(0,5);
			if (auxdia<1){
				auxdia=31;
				auxmes--;
				if (auxmes<1)
					return -1;
			}
			if (auxmes<10)
				s+='0';
			s+=auxmes;
			s+='-';
			if (auxdia<10)
				s+='0';
			s+=auxdia;
		}
		return m1.get(data);
	}
	
	///Corrige erro do usuario
	public int achaDataComeco (String s){
		LocalDate data;
		int auxdia=Integer.parseInt(s.substring(8));
		int auxmes=Integer.parseInt(s.substring(5,7));
		while (true){
			data=LocalDate.parse(s);
			if (m1.containsKey(data))
				break;
			auxdia++;
			s=s.substring(0,5);
			if (auxdia>31){
				auxdia=1;
				auxmes++;
				if (auxmes>12)
					return -1;
			}
			if (auxmes<10)
				s+='0';
			s+=auxmes;
			s+='-';
			if (auxdia<10)
				s+='0';
			s+=auxdia;
		}
		return m1.get(data);
	}
	
	///Apenas Diretor/Admin
	public void atualizarInicio(String s){
		LocalDate data = LocalDate.parse(s);
		inicio=m1.get(data);
	}

	///Apenas Diretor/Admin
	public void atualizarFim(String s){
		LocalDate data = LocalDate.parse(s);
		fim=m1.get(data);
	}
	
	///Apenas Diretor/Admin
	public void atualizarValorInfantil(double s){
		valorinfantil=s;
	}
	
	///Apenas Diretor/Admin
	public void atualizarValorFundamental(double s){
		valorfundamental=s;
	}
	
	///Apenas Diretor/Admin
	public void atualizarMatriculaInfantil(double s){
		valormatriculainfant=s;
	}
	
	///Apenas Diretor/Admin
	public void atualizarMatriculaFundamental(double s){
		valormatriculafundam=s;
	}
	
	///Todos
		public void atualizarMatricula(boolean s){
			matricula=s;
		}
	
	///Calcula valor com data de termino fora do padrao
	public double valorProporcionalDataFim (int dia, int mes, int tipo) throws InterruptedException{
		int ndias=-1;
		LocalDate data = LocalDate.now();
		double total=0;
		String aux="";
		Scanner teclado = new Scanner(System.in);
		aux=(Integer.toString(data.getYear()));
		aux+="-";
		if (String.valueOf(mes).length()==1)
			aux+="0";	
		aux+=mes;
		aux+="-";
		if (String.valueOf(dia).length()==1)
			aux+="0";
		aux+=dia;
		ndias=this.achaDataFim(aux);
		if (ndias==-1){
			teclado.close();
			return -1;
		}
		if (tipo==1){
			total+=(ndias-inicio+1)*(valorinfantil*12/totaldias);
			if (matricula)
				total+=valormatriculainfant;
		}
		if (tipo==2){
			total+=(ndias-inicio+1)*(valorfundamental*12/totaldias);
			if (matricula)
				total+=valormatriculafundam;
		}
		total=round(total,2);
		teclado.close();
		return total;
	}
	
	///Calcula valor com data de comeco fora do padrao
	public double valorProporcionalDataComeco (int dia, int mes, int tipo) throws InterruptedException{
		int ndias=-1;
		LocalDate data = LocalDate.now();
		double total=0;
		String aux="";
		Scanner teclado = new Scanner(System.in);
		aux=(Integer.toString(data.getYear()));
		aux+="-";
		if (String.valueOf(mes).length()==1)
			aux+="0";	
		aux+=mes;
		aux+="-";
		if (String.valueOf(dia).length()==1)
			aux+="0";
		aux+=dia;
		ndias=this.achaDataComeco(aux);
		if (ndias==-1){
			teclado.close();
			return -1;
		}
		if (tipo==1){
			total+=(fim-ndias+1)*(valorinfantil*12/totaldias);
			if (matricula)
				total+=valormatriculainfant;
		}
		if (tipo==2){
			total+=(fim-ndias+1)*(valorfundamental*12/totaldias);
			if (matricula)
				total+=valormatriculafundam;
		}
		total=round(total,2);
		teclado.close();
		return total;
	}
}
