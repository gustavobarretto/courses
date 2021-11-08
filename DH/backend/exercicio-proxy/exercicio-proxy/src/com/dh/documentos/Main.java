package com.dh.documentos;

import com.dh.documentos.model.Documento;
import com.dh.documentos.service.IDocumentoService;
import com.dh.documentos.service.impl.DocumentoService;
import com.dh.documentos.service.impl.ProxyDocumentoService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Documento> documentosGuardados = new ArrayList<>();
        documentosGuardados.add(new Documento("1","www.docs.com/1", Arrays.asList("test1@digitalhouse.com", "test2@digitalhouse.com")));
        documentosGuardados.add(new Documento("2","www.docs.com/2", Arrays.asList("test3@digitalhouse.com", "test2@digitalhouse.com")));
        IDocumentoService documentoService = new ProxyDocumentoService(new DocumentoService(documentosGuardados));

        documentoService.buscarDocumento("www.docs.com/1","test1@digitalhouse.com");
        documentoService.buscarDocumento("www.docs.com/1","test2@digitalhouse.com");
        documentoService.buscarDocumento("www.docs.com/2","test1@digitalhouse.com"); // este usuario no tiene acceso
        documentoService.buscarDocumento("www.docs.com/2","test2@digitalhouse.com");



    }
}
