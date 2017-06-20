package funcionario;

public class Diretor extends Funcionario {

	private static final long serialVersionUID = 1L;

	public Diretor(String login, String senha) {
		this.login = login;
		this.senha = hashSenha(senha);
		this.tipo = 2;
	}

	@Override
	public String toString() {
		return "Login: " + login + "\nSenha: " + senha;
	}
}
