package com.hotmart.rest;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.hotmart.service.Document;
import com.hotmart.service.DocumentService;
import com.hotmart.service.ResponseMetadata;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(value = "doc")
@Controller
@RequestMapping(value = "/doc")
public class DocumentController {
    
    @Autowired
    DocumentService documentService;
    
    @ApiOperation(value = "Upload do arquivo.")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody ResponseMetadata handleFileUpload(@RequestParam(value="file") MultipartFile file
    		,@RequestParam(value="identificadorUsuario",required=false) String identificadorUsuario) throws IOException {
    	long tempoInicio = System.currentTimeMillis();
        return documentService.save(file,identificadorUsuario,tempoInicio);
    }

    @ApiOperation(value = "Download do arquivo." )
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public HttpEntity<byte[]> getDocument(@PathVariable Long id) {
    	Document file = new Document();
    	file = documentService.getDocumentFile(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("content-disposition", "attachment; filename=" + file.getDocName());
        return new ResponseEntity<byte[]>(file.getFile(), httpHeaders, HttpStatus.OK);
    }
    
    @ApiOperation(value = "Retorna todos os objetos." )
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<ResponseMetadata> getDocument() throws IOException {
        return documentService.findAll();
    }
    
    
}
