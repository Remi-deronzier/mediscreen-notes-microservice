package deronzier.remi.notesmicroservice.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import deronzier.remi.notesmicroservice.exceptions.NoteNotFoundException;
import deronzier.remi.notesmicroservice.models.Note;

/**
 * This interface is the service layer for Note entity
 * 
 * @author Rémi Deronzier
 */
public interface NoteService {
    public Page<Note> findAll(Pageable pageable);

    public Note find(String id) throws NoteNotFoundException;

    public Page<Note> findByPatientId(long patientId, Pageable pageable);

    public Note insert(Note note);

    public String delete(String id) throws NoteNotFoundException;

    public Note update(String id, Note note) throws NoteNotFoundException;

    public long countByPatientIdWithContentContainingTriggeringTerms(long patientId, List<String> keywords);
}
