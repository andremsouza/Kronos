public class Secretario extends Funcionario{
	
	private static final long serialVersionUID = 1L;
	
	public Secretario(String nome, String login, String senha){
		this.nome = nome;
		this.login = login;
		this.senha = hashSenha(senha);
		this.tipo = 2;
		escreverArquivo(this);
	}
	
	@Override
	public String toString() {
		return "Name:" + nome + "\nLogin: " + login + "\nSenha: " + senha;
	}
	
}
