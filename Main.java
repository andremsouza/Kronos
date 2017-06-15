import operations.Dates;

public class Main {

	public static void main(String[] args) throws Exception {
		Dates wc=new Dates();
		String s="2017-06-22";
		wc.atualizarInicio(s);
		wc.atualizarFim(s);
		//wc.mostraValores();
		wc.valorProporcionalDataFim();
	}

}
