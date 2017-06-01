import java.io.Serializable;

public class Diretor extends Funcionario{
	
	private static final long serialVersionUID = 1L;
	
	public Diretor(String nome, String login, String senha){
		this.nome = nome;
		this.login = login;
		this.senha = hashSenha(senha);
		this.tipo = 1;
		escreverArquivo(this);
	}
	
	@Override
	public String toString() {
		return "Name:" + nome + "\nLogin: " + login + "\nSenha: " + senha;
	}
}
