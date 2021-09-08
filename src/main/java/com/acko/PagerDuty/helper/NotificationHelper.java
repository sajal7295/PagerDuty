package com.acko.PagerDuty.helper;

import com.acko.PagerDuty.dto.NotificationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NotificationHelper {

    @Autowired
    RestTemplate restTemplate;

    public void sendNotification(String phoneNumber) {
        NotificationDto notificationDto=new NotificationDto(phoneNumber);
        HttpEntity<NotificationDto> entity = new HttpEntity<NotificationDto>(notificationDto);

        restTemplate.exchange(
                "https://run.mocky.io/v3/fd99c100-f88a-4d70-aaf7-393dbbd5d99f", HttpMethod.POST, entity, String.class);
    }
}
