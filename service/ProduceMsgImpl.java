package com.example.Producer.service;

import com.example.Producer.dto.ActivityDto;
import com.example.Producer.dto.ActivityJson;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProduceMsgImpl implements ProduceMsg {

    private String fileName = "E:\\Facultate\\Anul IV\\Sem I\\DS\\Labs\\Assignment_2\\activity.txt";
    private List<ActivityDto> activityDtos = new ArrayList<>();

    public List<ActivityDto> readActivities() {
        Stream<String> line = null;
        try {
            line = Files.lines(Paths.get(fileName));
            activityDtos = line.map(ActivityDto::new).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return activityDtos;
    }

    public List<ActivityJson> convertToJSON() throws ParseException {
        List<ActivityJson> json = new ArrayList<>();
        activityDtos = readActivities();

        for(ActivityDto a : activityDtos) {
            json.add(new ActivityJson(a.getPatientId(), a.getName(), a.getStartDate(), a.getEndDate()));
        }

        return json;
    }
}
