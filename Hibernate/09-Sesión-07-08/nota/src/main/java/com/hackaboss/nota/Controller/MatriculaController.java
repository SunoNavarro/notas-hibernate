package com.hackaboss.nota.Controller;

import com.hackaboss.nota.Entity.Materia;
import com.hackaboss.nota.Entity.Matricula;
import com.hackaboss.nota.IService.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/matricula")
public class MatriculaController {

    @Autowired
    private IMatriculaService service;

    @GetMapping()
    public List<Matricula> all(){ return service.all();}

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> retrieveById(
            final @PathVariable("id") Long id)
    {
        Optional<Matricula> entity = service.findById(id);
        // TODO: Apply Entity-2-Dto conversion
        return entity.map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }
    @PostMapping
    public ResponseEntity<Matricula> create(
            final @RequestBody Matricula body)
    {
        // TODO: Apply Dto-2-Entity conversion
        Matricula entity = service.save(body);
        // TODO: Apply Entity-2-Dto conversion

        // Compose URI Location of the retrieve endpoint for this created resource
        final URI createdResourceLocationUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
        // build response entity providing URI and body of the created resource
        return ResponseEntity
                .created(createdResourceLocationUri)
                .body(entity);
    }
    @PutMapping("{id}")
    public Matricula  update(@PathVariable Long id, @RequestBody Matricula matricula) {
        return service.update(id, matricula);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
