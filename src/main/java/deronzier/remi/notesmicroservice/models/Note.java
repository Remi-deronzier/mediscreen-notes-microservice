package deronzier.remi.notesmicroservice.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * This class is the POJO class for the Note entity
 * 
 * @author Rémi Deronzier
 */
@Document(collection = "notes")
@Data
public class Note {

    @Id
    private String id;

    @Field("patient_id")
    private long patientId;
    private String content;

    @Field("created_at")
    private LocalDateTime createdAt;
}
