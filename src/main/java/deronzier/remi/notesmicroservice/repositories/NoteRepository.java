package deronzier.remi.notesmicroservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import deronzier.remi.notesmicroservice.models.Note;

/**
 * This interface is the DAO layer for Note entity
 * 
 * @author Rémi Deronzier
 */
public interface NoteRepository extends MongoRepository<Note, String> {

}
