package com.example.desafiohospital.service;

import com.example.desafiohospital.entity.Paciente;

import java.util.List;

public interface IPacienteService {
    Paciente getPaciente(long id);
    List<Paciente> getAllPacientes();
    Paciente savePaciente(Paciente paciente);
    Paciente updatePaciente(Paciente paciente);
    void deletePacienteById(Long id);
    void deletePaciente(Paciente paciente);
}
