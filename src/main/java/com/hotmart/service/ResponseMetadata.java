package com.hotmart.service;

public class ResponseMetadata {

	private String identificadorUsuario;
	private String nomeArquivo;
    private String statusUpload;
    private Long tempoDeEnvio;
    private int quantBlocosArquivo;
    private String linkParaDownload;
    
    
	public Long getTempoDeEnvio() {
		return tempoDeEnvio;
	}

	public void setTempoDeEnvio(Long tempoDeEnvio) {
		this.tempoDeEnvio = tempoDeEnvio;
	}

	public int getQuantBlocosArquivo() {
		return quantBlocosArquivo;
	}

	public void setQuantBlocosArquivo(int quantBlocosArquivo) {
		this.quantBlocosArquivo = quantBlocosArquivo;
	}

	public String getLinkParaDownload() {
		return linkParaDownload;
	}

	public void setLinkParaDownload(String linkParaDownload) {
		this.linkParaDownload = linkParaDownload;
	}

	public String getIdentificadorUsuario() {
		return identificadorUsuario;
	}

	public void setIdentificadorUsuario(String identificadorUsuario) {
		this.identificadorUsuario = identificadorUsuario;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public String getStatusUpload() {
		return statusUpload;
	}

	public void setStatusUpload(String statusUpload) {
		this.statusUpload = statusUpload;
	}

}
