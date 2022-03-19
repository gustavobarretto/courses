package com.digitalbooking.backend.api.controller;

import com.digitalbooking.backend.api.assembler.CategoryAssemblerProducts;
import com.digitalbooking.backend.api.assembler.CategoryDisassemblerProducts;
import com.digitalbooking.backend.api.model.CategoryResponseProducts;
import com.digitalbooking.backend.domain.model.Category;
import com.digitalbooking.backend.domain.service.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("categories")
@AllArgsConstructor
public class CategoryController {

    private final ICategoryService service;
    private final CategoryAssemblerProducts assembler;
    private final CategoryDisassemblerProducts disassembler;
    private final PagedResourcesAssembler<Category> categoryPagedResourcesAssembler;

    @GetMapping()
    public PagedModel<CategoryResponseProducts> getAll(Pageable pageable) {
        Page<Category> categoryPage = service.findAll(pageable);
        return categoryPagedResourcesAssembler.toModel(categoryPage, assembler);
    }
}
