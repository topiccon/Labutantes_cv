package com.labuta.Labuta.controller;

import java.util.Collection;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diaristas")
public class DiariaController {

    public static final Collection<DiaristaController>  diaristacontroller


    @GetMapping
    public String listarDiaristas() {
        return "Listando diaristas...";
    }
}
