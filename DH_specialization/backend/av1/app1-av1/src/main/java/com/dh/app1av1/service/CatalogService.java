package com.dh.app1av1.service;

import com.dh.app1av1.entity.Catalog;

import java.util.List;

public interface CatalogService {

    List<Object> getByGenre(String genre);

    Catalog create(Catalog catalog);
}
