package funcionario;

import funcionario.Admin;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.swing.JOptionPane;

import java.nio.file.*;

/**
 * Classe criada com a visão de possíveis expansões do programa
 * @author guilherme
 *
 */
abstract class Funcionario implements Serializable{
	protected String login;
	protected String senha;
	protected int tipo; // '1' para Secretario, '2' para Diretor, '3' para Administrador
	static Set<Funcionario> funcionarios = new LinkedHashSet<Funcionario>();
	private static final long serialVersionUID = 1L;
	
	/*Funções*/
	
	/**
	 * Verifica se o arquivo de dados existe e caso não exista, o arquivo é criado e inicializado
	 */
	static void verificaArquivo(){
		try{
			Path path = Paths.get("data");

			// Se o arquivo não existe ainda, criamos e inserimos o admin
			if (Files.notExists(path)) {
				Admin adm = new Admin("admin", "adm123");
				funcionarios.add(adm);
				FileOutputStream f = new FileOutputStream(new File("data"));
				ObjectOutputStream o = new ObjectOutputStream(f);

				o.writeObject(funcionarios);
				o.close();
				f.close();
			}
		}catch (FileNotFoundException e) {
			System.out.println("Nenhum objeto inserido somado ao fato de não ter o arquivo");
		} catch (IOException e) {
			System.out.println("Erro de inicialização");
		}
	}
	
	
	
	/**
	 * Retorna o conjunto de dados dos usuários
	 * @return
	 */
	static Set<Funcionario> leDados(){
		Set<Funcionario> Tfuncionarios;
		try{
			FileInputStream fi = new FileInputStream(new File("data"));
			ObjectInputStream oi = new ObjectInputStream(fi);
			Tfuncionarios = (Set<Funcionario>) oi.readObject();
			
			oi.close();
			fi.close();
		} catch (FileNotFoundException e) {
			System.out.println("Nenhum objeto inserido somado ao fato de não ter o arquivo");
			Tfuncionarios = new LinkedHashSet<Funcionario>();
		} catch (IOException e) {
			System.out.println("Erro de inicialização");
			Tfuncionarios = new LinkedHashSet<Funcionario>();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			Tfuncionarios = new LinkedHashSet<Funcionario>();
		}
		return Tfuncionarios;
	}
	/**
	 * Usada na verificação do login
	 * @param tlogin é o login a ser testado
	 * @param tsenha é a senha a ser testada
	 * @return '-1' se as informações não são coerentes, '1' se for um secretário, '2' se for um diretor ou '3' se for admin
	 */
	public int validaUsuario(String tlogin, String tsenha){
		int tipo = -1;
		
		//Verifica se o arquivo de dados existe e caso não exista, o arquivo é criado e inicializado
		verificaArquivo();
			
		//Lê o arquivo de dados e retorna o resultado em funcionarios
		funcionarios = leDados();
		
		for(Funcionario funcionario : funcionarios){ 
			if( (tlogin.equals(funcionario.login)) && (hashSenha(tsenha).equals(funcionario.senha)) ) tipo = funcionario.tipo;	
		}
		
		return tipo;
	}
	
	/**
	 * Classe usada para dar segurança ao sistema, criptografando todas as senhas para que ninguém tenha a acesso a senha de ninguém
	 * @param senha
	 * @return hash da senha
	 */
	public static String hashSenha(String senha){
        String hash = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");				// Cria uma instancia de MessageDigest para MD5
            md5.update(senha.getBytes());										//Adiciona os bytes da senha para processar
            byte[] bytes = md5.digest();										//Pega os bytes da hash armazenados no formato decimal
            
            StringBuilder construtorString = new StringBuilder();				//Vamos construir a string e ao mesmo tempo converter para o formato hexadecimal
            for(int i=0; i< bytes.length ;i++){
                construtorString.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            
            hash = construtorString.toString();									//hash recebe o resultado da criptografia
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        return hash;
    }
	
	/**
	 * Utilizado para administrar o log do programa, registando informações sobre o que determinados usuários fizeram
	 * @param texto
	 */
	public static void escreverLog(String texto){
		try
		{
		    String filename= "log";
		    FileWriter fw = new FileWriter(filename,true); 		//true vai escrever no fim do arquivo
		    fw.write(texto+"\n");		//escreve no fim do arquivo
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
	}
	
	/**
	 * Retorna um vetor de matrizes com todos os dados de todos os usuários
	 * @return 
	 */
	public String[][] retornaContas(){
		String [][] Contas;
		
		//Verifica se o arquivo de dados existe e caso não exista, o arquivo é criado e inicializado
		verificaArquivo();
					
		//Lê o arquivo de dados e retorna o resultado em funcionarios
		funcionarios = leDados();
			
		Contas = new String[funcionarios.size()][3];
		
		int contador=0;
		for(Funcionario funcionario : funcionarios){
			Contas[contador][0] = funcionario.login;
			Contas[contador][1] = funcionario.senha;
			switch(funcionario.tipo) {
				case 1:	Contas[contador][2] = "Secretaria";	break;
				case 2:	Contas[contador][2] = "Diretoria";	break;
				case 3:	Contas[contador][2] = "Admin";		break;
			}
			contador++;
		}
		
		//Usado apenas para testes -- Imprime todos os dados
		/*System.out.println(funcionarios.size());
		for(int i=0; i<funcionarios.size(); i++){
			System.out.println(Contas[i][0] + " "+Contas[i][1] + " "+Contas[i][2] + "\n");
		}*/
		return Contas;
	}
}



