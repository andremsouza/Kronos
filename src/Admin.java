import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;

public class Admin extends Funcionario{
	private static final long serialVersionUID = 1L;
	
	public Admin(String login, String senha){
		this.login = login;
		this.senha = hashSenha(senha);
		this.tipo = 3;
	}
	
	@Override
	public String toString() {
		return "Login: " + login + "\nSenha: " + senha;
	}
	
	public void criaDiretor(String login, String senha){
		Diretor d = new Diretor(login, senha);
	}
	
	public void criaSecretario(String login, String senha){
		Secretario d = new Secretario(login, senha);
	}
	
	private static void mudarSenha(String login, String NovaSenha){
		try{
			// Lê os objetos procurando as informações batem
			FileInputStream fi = new FileInputStream(new File("data"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			funcionarios = (Set<Funcionario>) oi.readObject();
			
			for(Funcionario funcionario : funcionarios){
				if(login.equalsIgnoreCase(funcionario.login)){
					funcionario.senha = hashSenha(NovaSenha);	
				}
			}
			oi.close();
			fi.close();
			
			// Salva no arquivo a modificação
			FileOutputStream f = new FileOutputStream(new File("data"));
			ObjectOutputStream o = new ObjectOutputStream(f);

			
			o.writeObject(funcionarios);

			o.close();
			f.close();

			} catch (FileNotFoundException e) {
				System.out.println("Nenhum objeto inserido somado ao fato de não ter o arquivo");
			} catch (IOException e) {
				System.out.println("Erro de inicialização");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}

	/**
	 * Criada apenas para testes
	 * @param args
	 */
	public static void main(String[] args) {
		//Diretor teste2 = new Diretor("login", "senha");
		//Secretario teste3 = new Secretario("g","h","i");
		mudarSenha("b", "d");
		if(validaUsuario("b","c") == 1) System.out.println("Achou Diretor");
		if(validaUsuario("h","i") == 2) System.out.println("Achou Secretario");
		if(validaUsuario("admin","adm123") == 3) System.out.println("Achou Admin");
		if(validaUsuario("admin","adm123") == -1) System.out.println("Não achou");
		if(validaUsuario("admin","adm12") == -1) System.out.println("Não achou");
		//escreverLog("oi");
		retornaContas();
		
	}

}
