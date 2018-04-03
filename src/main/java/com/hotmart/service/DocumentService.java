package com.hotmart.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DocumentService {

    ResponseMetadata save(MultipartFile multipartFile, String identificadorUsuario, long tempoInicio) throws IOException;

    Document getDocumentFile(Long id);

    List<ResponseMetadata> findAll() throws IOException;
    
    public ResponseMetadata toResponseMetadata(Document arquivo, String status);
    
    public int getQuantidadeBloco(int tamFileBytes);
}
