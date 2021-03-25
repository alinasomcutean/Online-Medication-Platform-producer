package com.example.Producer.controller;

import com.example.Producer.dto.ActivityDto;
import com.example.Producer.dto.ActivityJson;
import com.example.Producer.service.ProduceMsg;
import com.example.Producer.service.ProducerBinding;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.ParseException;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ProducerController {

    private final ProduceMsg produceMsg;
    private final MessageChannel messageChannel;

    public ProducerController(ProduceMsg produceMsg, ProducerBinding binding) {
        this.produceMsg = produceMsg;
        messageChannel = binding.sending();
    }

    @GetMapping("/sending")
    public List<ActivityJson> publish() throws InterruptedException, ParseException {
        List<ActivityJson> activities = produceMsg.convertToJSON();

        for(int i = 0; i < activities.size(); i++) {
            Message<ActivityJson> msg = MessageBuilder.withPayload(activities.get(i)).build();
            this.messageChannel.send(msg);
            Thread.sleep(1000);
        }
        return activities;
    }
}
