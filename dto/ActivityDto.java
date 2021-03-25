package com.example.Producer.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ActivityDto {

    String name;
    LocalDateTime startDate;
    LocalDateTime endDate;
    UUID patientId;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d HH:mm:ss", Locale.ENGLISH);

    public ActivityDto(String str) {
        String[] array = str.split("\t\t");
        LocalDateTime startTime = LocalDateTime.parse(array[0], formatter);
        LocalDateTime finishTime = LocalDateTime.parse(array[1], formatter);
        String name = array[2];

        this.name = name.trim();
        this.startDate = startTime;
        this.endDate = finishTime;
        this.patientId = UUID.fromString("6cc22df6-0d97-4f97-b92f-1c1df1ee40e2");
    }
}
