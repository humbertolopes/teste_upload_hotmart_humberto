package com.hotmart.service;

import javax.persistence.*;

@Entity
public class Document {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String docName;
    
    @Column
    private String identificadorUsuario;

    @Column
    @Lob
    private byte[] file;
    
    @Column
    private int quantBlocos;
    
    @Column
    private long tempoDeEnvio;
    

    public long getTempoDeEnvio() {
		return tempoDeEnvio;
	}

	public void setTempoDeEnvio(long tempoDeEnvio) {
		this.tempoDeEnvio = tempoDeEnvio;
	}

	public int getQuantBlocos() {
		return quantBlocos;
	}

	public void setQuantBlocos(int quantBlocos) {
		this.quantBlocos = quantBlocos;
	}

	public String getIdentificadorUsuario() {
		return identificadorUsuario;
	}

	public void setIdentificadorUsuario(String identificadorUsuario) {
		this.identificadorUsuario = identificadorUsuario;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public byte[] getFile() {
        return file;
    }
}
