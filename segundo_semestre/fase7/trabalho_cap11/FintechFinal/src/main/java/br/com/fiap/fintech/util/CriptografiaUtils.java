package br.com.fiap.fintech.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class CriptografiaUtils {

    public static String criptografar(String senha) throws Exception {

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(senha.getBytes(StandardCharsets.ISO_8859_1));

        BigInteger hash = new BigInteger(1, md.digest());
        return hash.toString(16);

    }

}
