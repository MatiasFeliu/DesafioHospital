package com.example.desafiohospital.controller;

import org.springframework.ui.Model;
import com.example.desafiohospital.DesafioHospitalApplication;
import com.example.desafiohospital.entity.Paciente;
import com.example.desafiohospital.service.IPacienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller

public class PacienteController {
    private final static Logger LOG = LoggerFactory.getLogger(DesafioHospitalApplication.class);

    @Autowired
    private IPacienteService pacienteService;

    @GetMapping("/")
    public String getAllPacientes(Model model) {
        LOG.info("Listando pacientes");
        List<Paciente> pacientes = pacienteService.getAllPacientes();
        if(pacientes.isEmpty()){
            LOG.error("Lista de pacientes vacía");
            model.addAttribute("error", "No existen pacientes");
        }
        model.addAttribute("pacientes", pacientes);
        return "index";
    }
}
