package funcionario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Esta classe representa um administrador do sistema. Com o construtor, é
 * possível criar um Admin, e os métodos possibilitam a adição, edição e remoção
 * de outros usuários.
 * 
 *
 */
public class Admin extends Funcionario {
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor da classe. Criar um Admin com login e senha.
	 * 
	 * @param login
	 * @param senha
	 */
	public Admin(String login, String senha) {
		this.login = login;
		this.senha = hashSenha(senha);
		this.tipo = 3;
	}

	/**
	 * Adiciona o objeto no arquivo "data"
	 * 
	 * @param d
	 * @return
	 */
	public boolean armazenaUsuario(Funcionario d) {
		try {
			File file = new File("src/data");

			// Verifica se o arquivo de dados existe e caso não exista, o
			// arquivo é criado e inicializado
			verificaArquivo();

			// Lê o arquivo de dados e retorna o resultado em funcionarios
			funcionarios = leDados();

			// Verifica se já existe o login
			for (Funcionario funcionario : funcionarios) {
				if (d.login.equals(funcionario.login))
					return false;
			}

			funcionarios.add(d);

			// Escreve os objetos no arquivo
			FileOutputStream f = new FileOutputStream(file);
			ObjectOutputStream o = new ObjectOutputStream(f);

			o.writeObject(funcionarios);

			o.close();
			f.close();
			return true;

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado");
			return false;
		} catch (IOException e) {
			System.out.println("Erro de inicialização");
			return false;
		}
	}

	/**
	 * Método que cria um usuário Admin e escreve a operação no log do programa.
	 * 
	 * @param login
	 * @param senha
	 */
	public void criaAdmin(String login, String senha) {
		Admin d = new Admin(login, senha);
		armazenaUsuario(d);
		GregorianCalendar calendar = new GregorianCalendar();
		escreverLog(calendar.getTime() + " --- O administrador " + this.login
				+ " criou um novo administrador cujo login é: " + login);
	}

	/**
	 * Método que cria um usuário Diretor e escreve a operação no log do
	 * programa.
	 * 
	 * @param login
	 * @param senha
	 */
	public void criaDiretor(String login, String senha) {
		Diretor d = new Diretor(login, senha);
		armazenaUsuario(d);
		GregorianCalendar calendar = new GregorianCalendar();
		escreverLog(calendar.getTime() + " --- O administrador " + this.login + " criou um novo diretor cujo login é: "
				+ login);
	}

	/**
	 * Método que cria um usuário Secretario e escreve a operação no log do
	 * programa.
	 * 
	 * @param login
	 * @param senha
	 */
	public void criaSecretario(String login, String senha) {
		Secretario d = new Secretario(login, senha);
		armazenaUsuario(d);
		GregorianCalendar calendar = new GregorianCalendar();
		escreverLog(calendar.getTime() + " --- O administrador " + this.login
				+ " criou um novo funcionário cujo login é: " + login);
	}

	/**
	 * Recebe o login do usuário e a nova senha, depois os dados são atualizados
	 * no arquivo "data"
	 * 
	 * @param login
	 * @param NovaSenha
	 */
	public void mudarSenha(String login, String NovaSenha) {

		// Verifica se o arquivo de dados existe e caso não exista, o arquivo é
		// criado e inicializado
		verificaArquivo();

		// Lê o arquivo de dados e retorna o resultado em funcionarios
		funcionarios = leDados();
		for (Funcionario funcionario : funcionarios) {
			if (login.equalsIgnoreCase(funcionario.login)) {
				funcionario.senha = hashSenha(NovaSenha);
			}
		}

		// Insere a mudança no arquivo "data"
		File file = new File("src/data");
		try {
			FileOutputStream f = new FileOutputStream(file);
			ObjectOutputStream o = new ObjectOutputStream(f);

			o.writeObject(funcionarios);

			o.close();
			f.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado");
		} catch (IOException e) {
			System.out.println("Erro de inicialização");
		}

		GregorianCalendar calendar = new GregorianCalendar();
		escreverLog(calendar.getTime() + " --- O administrador " + this.login
				+ " alterou a senha da conta cujo login é: " + login);

	}

	/**
	 * Remove usuário através do login
	 * 
	 * @param tlogin
	 * @return
	 */
	public boolean removeUsuario(String tlogin) {

		// Verifica se o arquivo de dados existe e caso não exista, o arquivo é
		// criado e inicializado
		verificaArquivo();

		// Lê o arquivo de dados e retorna o resultado em funcionarios
		funcionarios = leDados();

		Set<Funcionario> copia = new LinkedHashSet<Funcionario>();

		// Se não for o elemento removido, adiciona na cópia
		for (Funcionario funcionario : funcionarios) {
			if (!tlogin.equals(funcionario.login)) {
				copia.add(funcionario);
			}
		}

		// Insere a mudança no arquivo "data"
		File file = new File("src/data");
		try {
			FileOutputStream f = new FileOutputStream(file);
			ObjectOutputStream o = new ObjectOutputStream(f);

			o.writeObject(copia);

			o.close();
			f.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado");
		} catch (IOException e) {
			System.out.println("Erro de inicialização");
		}

		GregorianCalendar calendar = new GregorianCalendar();
		escreverLog(
				calendar.getTime() + " --- O administrador " + this.login + " removeu a conta cujo login é: " + tlogin);

		return true;
	}

	@Override
	public String toString() {
		return "Login: " + login + "\nSenha: " + senha;
	}

}
