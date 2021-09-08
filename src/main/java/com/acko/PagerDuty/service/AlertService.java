package com.acko.PagerDuty.service;

import com.acko.PagerDuty.dto.NotificationDto;
import com.acko.PagerDuty.entity.Developer;
import com.acko.PagerDuty.entity.Team;
import com.acko.PagerDuty.helper.NotificationHelper;
import com.acko.PagerDuty.repository.DeveloperRepository;
import com.acko.PagerDuty.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@Service
public class AlertService {

    @Autowired
    TeamRepository teamRepository;
    @Autowired
    DeveloperRepository developerRepository;

    @Autowired
    NotificationHelper notificationHelper;
    //strategy pattern
    //IStrategy strategy;


    public void sendAlert(Long teamId) {
        Team team=teamRepository.getOne(teamId);
        if(team==null){
            //this type of exception handling can be done using controlleradvice.
            //throw new PagerDutyException("team id is wrong.",stauscode);
        }
        List<Developer> developerList=team.getDeveloperList();
        Random random = new Random();
        int idx= random.nextInt(developerList.size()-1);
        Developer developer=team.getDeveloperList().get(idx);
        notificationHelper.sendNotification(developer.getPhoneNumber());
    }
}
