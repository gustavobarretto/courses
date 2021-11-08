package com.dh.documentos.service.impl;

import com.dh.documentos.model.Documento;
import com.dh.documentos.service.IDocumentoService;

import java.sql.Array;
import java.util.*;

public class ProxyDocumentoService implements IDocumentoService {
    private IDocumentoService documentoService;
    // A título de exemplo, utilizaremos uma lista para armazenar os acessos
    private List<Map<String,String>> registroDeUsuarios;

    public ProxyDocumentoService(IDocumentoService documentoService) {
        this.documentoService = documentoService;
        this.registroDeUsuarios = new ArrayList<>();
    }

    @Override
    public Documento buscarDocumento(String url, String email) {

        Documento documento = documentoService.buscarDocumento(url, email);
        if (documento != null) {
            System.out.println("Usuario : " + email + " acessando ao documento com url " + url);
            registroDeUsuarios.add(createSingletonMap(url,email));
            System.out.println("Registro: "+registroDeUsuarios.toString());
        } else {
            System.out.println("O documento não existe ou não tem acesso.");
        }

        return documento;
    }



    private Map<String, String> createSingletonMap(String key, String value) {
        return Collections.singletonMap(key, value);
    }
}
