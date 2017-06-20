package funcionario;

/**
 * Esta classe representa um funcionário com nível de privilégios 1. Capaz de
 * visualizar, mas não de alterar dados do sistema.
 *
 */
public class Secretario extends Funcionario {

	private static final long serialVersionUID = 1L;

	public Secretario(String login, String senha) {
		this.login = login;
		this.senha = hashSenha(senha);
		this.tipo = 1;
	}

	@Override
	public String toString() {
		return "Login: " + login + "\nSenha: " + senha;
	}

}
