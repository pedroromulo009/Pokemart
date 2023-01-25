package br.com.digix.pokemart.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ArquivoUtils {
    
    public static byte[] abrirArquivo(String caminhoPath) throws IOException {
        File caminho = new File(caminhoPath);
        FileInputStream fileInputStream = new FileInputStream(caminho);
        byte[] arrayDeBytes = new byte[(int)caminho.length()];
        fileInputStream.read(arrayDeBytes);
        fileInputStream.close();
        return arrayDeBytes;
    }
    
}
