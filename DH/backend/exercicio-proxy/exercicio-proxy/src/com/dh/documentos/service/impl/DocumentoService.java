package com.dh.documentos.service.impl;

import com.dh.documentos.model.Documento;
import com.dh.documentos.service.IDocumentoService;

import java.util.List;

public class DocumentoService implements IDocumentoService {
    // Como exemplo, utilizaremos uma lista de documentos para guardar e pesquisar documentos.
    private List<Documento> documentos;

    public DocumentoService(List<Documento> documentos) {
        this.documentos = documentos;
    }

    //Procuramos um documento que tenha a mesma url, e que o e-mail esteja na lista dos autorizados a lê-lo.
    @Override
    public Documento buscarDocumento(String url, String email) {
        /*documentos.forEach(doc -> {
            if(doc.getUrl().equals(url) && doc.getUsuariosAutorizados().contains(email)){
                return doc;
            } else {
                return null;
            }
        });*/

        return this.documentos.stream().filter(doc -> doc.getUrl().equals(url) && doc.getUsuariosAutorizados().contains(email)).findFirst().orElse(null);
    }
}
