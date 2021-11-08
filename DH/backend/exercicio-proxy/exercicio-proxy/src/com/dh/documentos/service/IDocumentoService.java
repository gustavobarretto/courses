package com.dh.documentos.service;

import com.dh.documentos.model.Documento;

public interface IDocumentoService {

    public Documento buscarDocumento(String url,String email);
}
