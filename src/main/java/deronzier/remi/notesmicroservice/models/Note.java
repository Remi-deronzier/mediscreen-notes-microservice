package deronzier.remi.notesmicroservice.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
