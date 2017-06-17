package funcionario;

import funcionario.Admin;
public class main{

	/**
	 * Criada apenas para testes
	 * @param args
	 */
	public static void main(String[] args) {
		Admin adm = new Admin("adm", "123");
		//adm.criaDiretor("diretora", "senha");
		//adm.criaDiretor("diretor", "senha");
		adm.criaSecretario("secretario", "senha2");
		adm.criaSecretario("secretaria", "senha3");
		adm.criaAdmin("adminn", "senha2");
		adm.criaAdmin("admina", "senha3");
		//retornaContas();
		
		
		System.out.println(adm.validaUsuario("diretor","senh"));
		adm.mudarSenha("diretor", "senha");
		System.out.println(adm.validaUsuario("diretor","senha"));
		
		//retornaContas();
		adm.removeUsuario("diretora");
		adm.retornaContas();
	}

}