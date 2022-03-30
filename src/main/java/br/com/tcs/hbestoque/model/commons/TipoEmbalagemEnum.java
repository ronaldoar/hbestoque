package br.com.tcs.hbestoque.model.commons;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum TipoEmbalagemEnum {
	
	LATA("Lata", 0),
	GARRAFA("Garrafa", 1),
	PLASTICO("Plástico", 2);
	
	private final String nome;
	private final int id;
	
	private TipoEmbalagemEnum(String nome, int id){
		this.nome  = nome;
		this.id    = id;
	}
	
	/**
	 * 
	 * @param text
	 * @return enum or null
	 */
	public static TipoEmbalagemEnum fromText(String text) {
		
		try {
			return Arrays.stream(values())
					.filter(bl -> bl.getNome().equalsIgnoreCase(text))
					.findFirst().get();
			
		}catch(NoSuchElementException ex) {
			return null;
		}
		
    }
	
	public String getNome() {
		return nome;
	}

	public int getId() {
		return id;
	}
	
}
