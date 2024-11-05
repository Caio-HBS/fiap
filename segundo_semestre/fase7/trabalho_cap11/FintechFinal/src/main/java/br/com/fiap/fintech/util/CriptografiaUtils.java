package br.com.fiap.fintech.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * Classe utilitária para criptografia de dados sensíveis, como senhas, usando o algoritmo MD5.
 * <p>
 * Esta classe utiliza o algoritmo MD5 para gerar um hash hexadecimal de uma senha em texto simples (não criptografada).
 * </p>
 *
 * <p>Exemplo de Uso:</p>
 * <pre>
 *     String criptografada = CriptografiaUtils.criptografar("minhaSenha123");
 * </pre>
 *
 * <p>Parâmetros:</p>
 * <ul>
 *     <li><code>senha</code>: A senha em texto simples a ser criptografada.</li>
 * </ul>
 *
 * <p>Retorno:</p>
 * <ul>
 *     <li>Retorna a senha criptografada em formato hexadecimal.</li>
 * </ul>
 *
 * <p>Exceções:</p>
 * <ul>
 *     <li><code>Exception</code>: Lançada se houver um problema ao inicializar o algoritmo de hash.</li>
 * </ul>
 *
 * @see MessageDigest
 */
public class CriptografiaUtils {

    public static String criptografar(String senha) throws Exception {

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(senha.getBytes(StandardCharsets.ISO_8859_1));

        BigInteger hash = new BigInteger(1, md.digest());
        return hash.toString(16);

    }

}
