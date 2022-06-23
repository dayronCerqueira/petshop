package br.com.petshop.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Constantes {

    //Constantes de Erros HTTP
    public final Long BAD_REQUEST = 400L;
    public final Long OK = 200L;
    public final Long NOT_FOUND = 404L;
    public final Long NO_CONTENT = 204L;
    public final Long ACCEPTED = 202L;

    //Constantes de Tamanho de Animais
    public final String GRANDE = "Grande";
    public final String PEQUENO = "Pequeno";
    public final String MEDIO = "Médio";

    //Constantes Caracteres
    public final String VAZIA = "";
    public final String ESPACO = " ";

}
