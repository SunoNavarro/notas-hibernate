package com.hackaboss.nota.Service;


import com.hackaboss.nota.Entity.Materia;
import com.hackaboss.nota.Entity.Matricula;
import com.hackaboss.nota.IRepository.IMatriculaRepository;
import com.hackaboss.nota.IService.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MatriculaService  implements IMatriculaService {
    @Autowired
    IMatriculaRepository matriculaRepository;
    @Override
    public List<Matricula> all() {
        return matriculaRepository.findAll();
    }

    @Override
    public Optional<Matricula> findById(Long id) {
        return matriculaRepository.findById(id);
    }

    @Override
    public Matricula save(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula update(Long id, Matricula matricula) {
        Optional<Matricula> op = matriculaRepository.findById(id);
        Matricula matriculaUpdate = op.orElseThrow();
        matriculaUpdate.setMateriaId(matricula.getMateriaId());
        matriculaUpdate.setEstudianteId(matricula.getEstudianteId());
        matriculaUpdate.setNota(matricula.getNota());
        matriculaRepository.save(matriculaUpdate);
        return matriculaUpdate;
    }

    @Override
    public void delete(Long id) {
        matriculaRepository.deleteById(id);

    }
}
