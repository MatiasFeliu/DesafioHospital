package com.example.desafiohospital.controller;


import ch.qos.logback.core.model.Model;
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
@RequestMapping("/paciente")
public class PacienteController implements CommandLineRunner {
    private final static Logger LOG = LoggerFactory.getLogger(DesafioHospitalApplication.class);

    @Autowired
    private IPacienteService pacienteService;

    @GetMapping("getAll")
    public String getAllPacientes(Model model) {
        LOG.info("Listando pacientes");
        List<Paciente> pacientes = pacienteService.getAllPacientes();
        if(pacientes.isEmpty()){
            LOG.error("Lista de pacientes vacía");
            model.addAttribute("error", "No existen pacientes");
        }
        model.addAttribute("pacientes", pacientes);
        return "paciente";
    }

    @GetMapping("/edit/{id}")
    public String editPaciente(@PathVariable Long id, Model model) {
        LOG.info("Editando paciente con ID: " + id);
        Paciente paciente = pacienteService.getPaciente(id);
        if(paciente != null) {
            model.addAttribute("paciente", paciente);
            return "newPaciente";
        } else {
            LOG.error("No existe paciente");
            model.addAttribute("error", "Paciente no encontrado");
        }
        return "newPatient";
    }

    @GetMapping("/newPaciente")
    public String createPaciente(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "newPaciente";
    }

    @PostMapping("/savePaciente")
    public String savePaciente(@ModelAttribute("paciente") Paciente paciente){
        if(paciente.getId() !=null){
            LOG.info("Actualizando nuevo paciente" );
        }else{
            LOG.info("Creando nuevo Paciente");
        }
        pacienteService.savePaciente(paciente);
        return "redirect:/patient/getAll";
    }

    @GetMapping("/delete/{id}")
    public String deletePaciente(@PathVariable("id") Long id) {
        LOG.warn("Eliminando paciente con ID: " + id);
        pacienteService.deletePacienteById(id);
        return "redirect:/paciente/getAll";
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Iniciando sistema");
    }
}
