package com.example.Producer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public final class ActivityJson implements Serializable {

    String name;
    LocalDateTime startDate;
    LocalDateTime endDate;
    UUID patientId;

    public ActivityJson(@JsonProperty("patient_id") UUID patientId, @JsonProperty("activity") String name,
                    @JsonProperty("start") LocalDateTime startDate, @JsonProperty("end") LocalDateTime endDate) {
        this.patientId = patientId;
        this.name = name;
        this.startDate = startDate;
        this.endDate=endDate;
    }
}
