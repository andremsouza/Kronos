import operations.Dates;

public class Main {

	public static void main(String[] args) throws Exception {
		Dates wc=new Dates();
		String s="2017-06-22";
		//wc.atualizarInicio(s);
		//wc.atualizarFim(s);
		System.out.println(wc.valorProporcional(22,06,2,false));
		System.out.println(wc.quantasInteiras(wc.valorProporcional(22,06,2,false),2));
		System.out.println(wc.valorParcelaProporcional(wc.valorProporcional(22,06,2,false),2));
	}

}
