package com.example.hateoasminiproject.api.controller;

import com.example.hateoasminiproject.api.assembler.UserAssembler;
import com.example.hateoasminiproject.api.assembler.UserDisassembler;
import com.example.hateoasminiproject.api.model.ProductRequest;
import com.example.hateoasminiproject.api.model.ProductResponse;
import com.example.hateoasminiproject.api.model.UserRequest;
import com.example.hateoasminiproject.api.model.UserResponse;
import com.example.hateoasminiproject.domain.filter.ProductFilter;
import com.example.hateoasminiproject.domain.filter.UserFilter;
import com.example.hateoasminiproject.domain.model.Product;
import com.example.hateoasminiproject.domain.model.User;
import com.example.hateoasminiproject.domain.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.lang.reflect.Field;
import java.util.Map;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {

    private final IUserService service;
    private final UserDisassembler disassembler;
    private final UserAssembler assembler;
    private final PagedResourcesAssembler<User> userPagedResourcesAssembler;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserRequest userRequest) {
        User user = disassembler.toDomainObject(userRequest);
        return ResponseEntity.created(ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(service.save(user).getId())
                        .toUri())
                .build();
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponse> get(@PathVariable String id) {
        return ResponseEntity.ok(assembler.toModel(service.findById(id)));
    }

    @GetMapping()
    public PagedModel<UserResponse> getAll(UserFilter filter , Pageable pageable) {
        Page<User> pageUsers = service.findAll(filter, pageable);
        return userPagedResourcesAssembler.toModel(pageUsers, assembler);
    }

    @PatchMapping("{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Map<String, Object> fields) {
        User currentUser = service.findById(id);
        merge(fields, currentUser);
        service.save(currentUser);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return ResponseEntity.ok().build();
    }

    private void merge(Map<String, Object> fields, User currentUser) {
        ObjectMapper mapper = new ObjectMapper();
        User userOrigin = mapper.convertValue(fields, User.class);

        fields.forEach((propertyName, propertyValue) -> {
            Field field = ReflectionUtils.findField(User.class, propertyName);
            assert field != null;
            field.setAccessible(true);
            Object newValue = ReflectionUtils.getField(field, userOrigin);
            ReflectionUtils.setField(field, currentUser, newValue);
        });
    }
}
