package com.example.Producer.service;

import com.example.Producer.dto.ActivityDto;
import com.example.Producer.dto.ActivityJson;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.ParseException;

import java.util.List;

public interface ProduceMsg {

    List<ActivityDto> readActivities();

    List<ActivityJson> convertToJSON() throws ParseException;
}
