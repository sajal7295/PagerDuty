package com.acko.PagerDuty.controller;

import com.acko.PagerDuty.entity.Team;
import com.acko.PagerDuty.request.AlertRequest;
import com.acko.PagerDuty.request.NewTeamRequest;
import com.acko.PagerDuty.service.AlertService;
import com.acko.PagerDuty.service.TeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AlertsController {

    @Autowired
    private AlertService alertService;

    @PostMapping(path = "/alert")
    public ResponseEntity<String> addTeam(@RequestBody AlertRequest alertRequest) {
        alertService.sendAlert(Long.valueOf(alertRequest.getTeamId()));
        return new ResponseEntity("Alert sent successfully.", HttpStatus.CREATED);
    }
}