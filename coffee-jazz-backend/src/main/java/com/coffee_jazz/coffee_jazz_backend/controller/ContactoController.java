package com.coffee_jazz.coffee_jazz_backend.controller;

import com.coffee_jazz.coffee_jazz_backend.model.Contacto;
import com.coffee_jazz.coffee_jazz_backend.service.ContactoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/contacto")
public class ContactoController {

    @Autowired
    private ContactoService contactoService;

    @PostMapping("/save")
    public ResponseEntity<String> saveContacto(@RequestBody @Valid Contacto contacto) throws ExecutionException, InterruptedException {
        contactoService.saveContacto(contacto);
        return ResponseEntity.ok("Contacto creado con éxito");
    }
}
