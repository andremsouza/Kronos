import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.nio.file.*;

/**
 * Classe criada com a visão de possíveis expansões do programa
 * @author guilherme
 *
 */
abstract class Funcionario implements Serializable{
	protected String nome;
	protected String login;
	protected String senha;
	protected int tipo; // '1' para Diretor e '2' para Secretário
	static Set<Funcionario> funcionarios = new LinkedHashSet<Funcionario>();
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * @param tlogin é o login a ser testado
	 * @param tsenha é a senha a ser testada
	 * @return '-1' se as informações não são coerentes, '1' se for um diretor, '2' se for um secretario ou '3' se for admin
	 */
	static int validaUsuario(String tlogin, String tsenha){
		int tipo = -1;
		try{
			Path path = Paths.get("data");

			if (Files.notExists(path)) { 				// Se o arquivo não existe ainda, criamos e inserimos o admin
				Admin adm = new Admin("admin", "admin", "adm123");
				funcionarios.add(adm);
				FileOutputStream f = new FileOutputStream(new File("data"));
				ObjectOutputStream o = new ObjectOutputStream(f);

				o.writeObject(funcionarios);
				o.close();
				f.close();
			}
			
			// Lê os objetos procurando as informações batem
			FileInputStream fi = new FileInputStream(new File("data"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			funcionarios = (Set<Funcionario>) oi.readObject();
			
			for(Funcionario funcionario : funcionarios){
				if(tlogin.equalsIgnoreCase(funcionario.login)){
					if(hashSenha(tsenha).equalsIgnoreCase(funcionario.senha)) tipo = funcionario.tipo;	
				}
			}
			oi.close();
			fi.close();

		} catch (FileNotFoundException e) {
			System.out.println("Nenhum objeto inserido somado ao fato de não ter o arquivo");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
            
            hash = construtorString.toString();									//hash recebe o resulto da criptografia
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        return hash;
    }
	
	/**
	 * Utilizado para armazenar novos usuários para serem buscados em outras execuções do programa
	 * @param d
	 */
	public void escreverArquivo(Funcionario d){
		try {
			Path path = Paths.get("data");
			File file = new File("data");
			
			if (Files.exists(path)) {	// Se o arquivo já existe, puxa os dados do arquivo.
				FileInputStream fi = new FileInputStream(file);
				ObjectInputStream oi = new ObjectInputStream(fi);
				funcionarios = (Set<Funcionario>) oi.readObject();
				
				oi.close();
				fi.close();
			}

			if (Files.notExists(path)) {
				Admin adm = new Admin("admin", "admin", "adm123");
				funcionarios.add(adm);
			}
			
			funcionarios.add(d);
			// Escreve os objetos no arquivo
			FileOutputStream f = new FileOutputStream(file);
			ObjectOutputStream o = new ObjectOutputStream(f);

			
			o.writeObject(funcionarios);

			o.close();
			f.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
