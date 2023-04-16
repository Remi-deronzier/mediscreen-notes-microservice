package deronzier.remi.notesmicroservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import deronzier.remi.notesmicroservice.exceptions.NoteNotFoundException;
import deronzier.remi.notesmicroservice.models.CreateClass;
import deronzier.remi.notesmicroservice.models.Note;
import deronzier.remi.notesmicroservice.models.UpdateClass;
import deronzier.remi.notesmicroservice.services.NoteService;

/**
 * This class is the controller layer for Note entity
 * 
 * @author Rémi Deronzier
 */
@RestController
@RequestMapping("/notes")
@CrossOrigin(origins = "*")
public class NoteController {

    @Autowired
    private NoteService service;

    /**
     * @param "createdAt"
     * @param pageable
     * @return Page<Note>
     */
    @GetMapping
    public Page<Note> findAll(@SortDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        return service.findAll(pageable);
    }

    /**
     * @param findByPatientId(
     * @return Page<Note>
     */
    @GetMapping("/patient/{patientId}")
    public Page<Note> findByPatientId(@PathVariable long patientId,
            @SortDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        return service.findByPatientId(patientId, pageable);
    }

    /**
     * @param id
     * @return Note
     * @throws NoteNotFoundException
     */
    @GetMapping("/{id}")
    public Note find(@PathVariable String id) throws NoteNotFoundException {
        return service.find(id);
    }

    /**
     * @param note
     * @return Note
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Note insert(@Validated(CreateClass.class) @RequestBody Note note) {
        return service.insert(note);
    }

    /**
     * @param id
     * @return String
     * @throws NoteNotFoundException
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) throws NoteNotFoundException {
        return service.delete(id);
    }

    /**
     * @param id
     * @param note
     * @return Note
     * @throws NoteNotFoundException
     */
    @PatchMapping("/{id}")
    public Note update(@PathVariable String id, @Validated(UpdateClass.class) @RequestBody Note note)
            throws NoteNotFoundException {
        return service.update(id, note);
    }

    @GetMapping("/count-notes-with-triggering-terms/patient/{patientId}")
    public long countByPatientIdAndContentIn(@PathVariable long patientId, @RequestParam List<String> keywords) {
        return service.countByPatientIdWithContentContainingTriggeringTerms(patientId, keywords);
    }
}
