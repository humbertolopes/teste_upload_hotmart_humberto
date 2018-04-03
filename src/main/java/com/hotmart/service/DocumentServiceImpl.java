package com.hotmart.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hotmart.dao.DocumentDao;

@Service
public class DocumentServiceImpl implements DocumentService {
	
    
    @Autowired
    private DocumentDao documentDao;

    @Override
    public ResponseMetadata save(MultipartFile file, String identificadorUsuario, long tempoInicio) throws IOException {
    	 Document arquivo = new Document();
         arquivo.setDocName(file.getOriginalFilename());
         arquivo.setFile(file.getBytes());
         arquivo.setIdentificadorUsuario(identificadorUsuario);
         arquivo.setQuantBlocos(getQuantidadeBloco(file.getBytes().length));
         arquivo.setTempoDeEnvio(System.currentTimeMillis()- tempoInicio);
    	try {
    		documentDao.save(arquivo);
            return toResponseMetadata(arquivo, "Concluído");
			
		} catch (Exception e) {
			return toResponseMetadata(arquivo, "Erro");
		}
    }

    @Override
    public Document getDocumentFile(Long id) {
      return documentDao.findOne(id);
    }

    @Override
    public List<ResponseMetadata> findAll() throws IOException {
    	List<Document> listaDeArquivos = (List<Document>) documentDao.findAll();
    	List<ResponseMetadata> listaRetornada = new ArrayList<ResponseMetadata>();
    	for (Document arquivo : listaDeArquivos) {
    		listaRetornada.add(toResponseMetadata(arquivo, "Concluído"));
		}
        return listaRetornada;
    }
    
    @Override
    public ResponseMetadata toResponseMetadata(Document arquivo, String status) {
    	
    	ResponseMetadata metadata = new ResponseMetadata();
		metadata.setIdentificadorUsuario(arquivo.getIdentificadorUsuario());
		metadata.setNomeArquivo(arquivo.getDocName());
		metadata.setStatusUpload(status);
		metadata.setTempoDeEnvio(arquivo.getTempoDeEnvio());
		metadata.setQuantBlocosArquivo(arquivo.getQuantBlocos());
		metadata.setLinkParaDownload("http://localhost:8080/doc/"+arquivo.getId().toString()); 
		
    	return metadata;
    	
    }
    
    @Override
    public int getQuantidadeBloco(int tamFileBytes) {
    	int MB = 1048576;
    	int result = tamFileBytes / MB;
    	if(tamFileBytes % MB == 0) {
    		return result;
    	}
    	return result + 1;
    	
    }

}
