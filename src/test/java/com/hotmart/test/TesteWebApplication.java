package com.hotmart.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hotmart.service.DocumentService;
import com.hotmart.service.ResponseMetadata;


public class TesteWebApplication  extends TesteApplication{
	
	@Autowired
	DocumentService servico;
	
	@Before
	public void setup() {

	}
		
	@Test
	public void testSave() throws Exception {
		servico.save(null, "UserTeste", System.currentTimeMillis());
	}
	
	@Test
	public void testFindAll() throws Exception {
		List<ResponseMetadata> listaResponseMetadata = servico.findAll();
		for (ResponseMetadata responseMetadata : listaResponseMetadata) {
			System.out.println(responseMetadata.getNomeArquivo());
		}
	}
	
	@Test
	public void testGetID() throws Exception {
		servico.getDocumentFile((long) 1);
		servico.getDocumentFile(null);
	}
	
	@Test
	public void testToResponseMetadata() throws Exception {
		
		ResponseMetadata metadata = servico.toResponseMetadata(null, "Qualquer");
		System.out.println(metadata.getIdentificadorUsuario());
	}
	
	@Test
	public void testQuantidadeBlocos() throws Exception {
		servico.getQuantidadeBloco(1234);
		servico.getQuantidadeBloco(0);
	}
		

}
