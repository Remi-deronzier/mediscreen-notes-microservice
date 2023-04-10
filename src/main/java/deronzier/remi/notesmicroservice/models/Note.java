package deronzier.remi.notesmicroservice.models;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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
    @Positive(message = "Patient ID must be positive", groups = CreateClass.class)
    @NotNull(message = "Patient ID is mandatory", groups = CreateClass.class)
    private long patientId;

    @NotBlank(message = "Content is mandatory", groups = CreateClass.class)
    private String content;

    @Field("created_at")
    private LocalDateTime createdAt;
}
