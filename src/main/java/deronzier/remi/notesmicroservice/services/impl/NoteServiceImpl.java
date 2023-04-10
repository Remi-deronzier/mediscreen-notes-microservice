package deronzier.remi.notesmicroservice.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import deronzier.remi.notesmicroservice.exceptions.NoteNotFoundException;
import deronzier.remi.notesmicroservice.models.Note;
import deronzier.remi.notesmicroservice.repositories.NoteRepository;
import deronzier.remi.notesmicroservice.services.NoteService;

/**
 * This class is the implementation of the service layer for Note entity
 * 
 * @author Rémi Deronzier
 */
@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository repository;

    @Value("${label.note}")
    private String note;

    @Value("${label.successfully-deleted}")
    private String successfullyDeleted;

    @Value("${label.not-found}")
    private String notFound;

    /**
     * @param id
     * @return String
     */
    private String noteSuccessfullyDeletedMessage(String id) {
        return note + " " + id + " " + successfullyDeleted;
    }

    /**
     * @param pageable
     * @return Page<Note>
     */
    @Override
    public Page<Note> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    /**
     * @param id
     * @return Note
     * @throws NoteNotFoundException
     */
    @Override
    public Note find(String id) throws NoteNotFoundException {
        return repository.findById(id).orElseThrow(() -> new NoteNotFoundException(id));
    }

    /**
     * @param note
     * @return Note
     */
    @Override
    public Note insert(Note note) {
        note.setCreatedAt(LocalDateTime.now());
        return repository.insert(note);
    }

    /**
     * @param id
     * @return String
     * @throws NoteNotFoundException
     */
    @Override
    public String delete(String id) throws NoteNotFoundException {
        repository.findById(id).orElseThrow(() -> new NoteNotFoundException(id));
        repository.deleteById(id);
        return noteSuccessfullyDeletedMessage(id);
    }

    /**
     * @param id
     * @param note
     * @return Note
     * @throws NoteNotFoundException
     */
    @Override
    public Note update(String id, Note note) throws NoteNotFoundException {
        Note noteToUpdate = repository.findById(id).orElseThrow(() -> new NoteNotFoundException(id));
        if (note.getPatientId() != 0) {
            noteToUpdate.setPatientId(note.getPatientId());
        }
        if (note.getContent() != null) {
            noteToUpdate.setContent(note.getContent());
        }
        return repository.save(noteToUpdate);
    }

    @Override
    public Page<Note> findByPatientId(long patientId, Pageable pageable) {
        return repository.findByPatientId(patientId, pageable);
    }

    @Override
    public long countByPatientIdWithContentContainingTriggeringTerms(long patientId, List<String> keywords) {
        String regex = String.join("|", keywords);
        return repository.countByPatientIdAndContentRegex(patientId, regex);
    }

}
