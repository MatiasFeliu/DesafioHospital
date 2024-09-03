package com.example.desafiohospital.service.impl;

import com.example.desafiohospital.entity.Paciente;
import com.example.desafiohospital.repository.IPacienteRepository;
import com.example.desafiohospital.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements IPacienteService {
    @Autowired
    IPacienteRepository pacienteRepository;
    @Override
    public Paciente getPaciente(long id) {
        Paciente paciente = pacienteRepository.findById(id).orElse(null);
        return paciente;
    }

    @Override
    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente savePaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente updatePaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public void deletePacienteById(Long id) {
        pacienteRepository.deleteById(id);

    }

    @Override
    public void deletePaciente(Paciente paciente) {
        pacienteRepository.delete(paciente);
    }
}
