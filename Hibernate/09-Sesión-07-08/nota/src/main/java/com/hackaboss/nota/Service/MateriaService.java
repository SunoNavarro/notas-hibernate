package com.hackaboss.nota.Service;

import com.hackaboss.nota.Entity.Materia;
import com.hackaboss.nota.IRepository.IMateriaRepository;
import com.hackaboss.nota.IService.IMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class MateriaService implements IMateriaService {
    @Autowired IMateriaRepository materiaRepository;
    @Override
    public List<Materia> all() {
        return materiaRepository.findAll();
    }

    @Override
    public Optional<Materia> findById(Long id) {
        return materiaRepository.findById(id);
    }

    @Override
    public Materia save(Materia materia) {
        return materiaRepository.save(materia);
    }

    @Override
    public Materia update(Long id, Materia materia) {
        Optional<Materia> op = materiaRepository.findById(id);
         Materia materiaUpdate = op.orElseThrow();
         materiaUpdate.setMateria(materia.getMateria());
         materiaUpdate.setCodigo(materia.getCodigo());
         materiaUpdate.setDescripcion(materia.getDescripcion());

         materiaRepository.save(materiaUpdate);
         return materiaUpdate;
        }

    @Override
    public void delete(Long id) {
        materiaRepository.deleteById(id);

    }
}
