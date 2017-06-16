import operations.Dates;

public class Main {

	public static void main(String[] args) throws Exception {
		Dates wc=new Dates();
		//String s="2017-01-02";
		//wc.atualizarInicio(s);
		//wc.atualizarFim(s);
		System.out.println(wc.valorProporcional(22,06,2,false,true));
		System.out.println(wc.quantasInteiras(wc.valorProporcional(22,06,2,false,true),2,true));
		System.out.println(wc.valorParcelaProporcional(wc.valorProporcional(22,06,2,false,true),2,true));
		//wc.adicionaCurso("australopitecus", 352);
		//wc.RemoveCurso("DANCA");
		wc.fimDePrograma();
	}

}
