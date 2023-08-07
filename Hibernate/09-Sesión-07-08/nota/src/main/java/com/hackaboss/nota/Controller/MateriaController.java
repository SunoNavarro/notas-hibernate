package com.hackaboss.nota.Controller;

import com.hackaboss.nota.Entity.Estudiante;
import com.hackaboss.nota.Entity.Materia;
import com.hackaboss.nota.IService.IMateriaService;
import com.hackaboss.nota.Service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/materia")
public class MateriaController {

    @Autowired
    private IMateriaService service;

    @GetMapping()

    public List<Materia> all(){ return service.all();}

    @GetMapping("/{id}")
    public ResponseEntity<Materia> retrieveById(
            final @PathVariable("id") Long id)
    {
        Optional<Materia> entity = service.findById(id);
        // TODO: Apply Entity-2-Dto conversion
        return entity.map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }
    @PostMapping
    public ResponseEntity<Materia> create(
            final @RequestBody Materia body)
    {
        // TODO: Apply Dto-2-Entity conversion
        Materia entity = service.save(body);
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
    public Materia  update(@PathVariable Long id, @RequestBody Materia materia) {
        return service.update(id, materia);

    }
    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
