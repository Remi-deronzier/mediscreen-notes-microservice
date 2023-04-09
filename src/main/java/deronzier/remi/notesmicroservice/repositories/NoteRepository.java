package deronzier.remi.notesmicroservice.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import deronzier.remi.notesmicroservice.models.Note;

/**
 * This interface is the DAO layer for Note entity
 * 
 * @author Rémi Deronzier
 */
public interface NoteRepository extends MongoRepository<Note, String> {

    Page<Note> findByPatientId(long patientId, Pageable pageable);

    long countByPatientIdAndContentRegex(long patientId, String regex);

}
