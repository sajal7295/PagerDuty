package com.acko.PagerDuty.controller;

import com.acko.PagerDuty.entity.Team;
import com.acko.PagerDuty.request.NewTeamRequest;
import com.acko.PagerDuty.service.TeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TeamsController {

    @Autowired
    private TeamsService teamsService;

    @PostMapping(path = "/teams")
    public ResponseEntity<String> addTeam(@RequestBody NewTeamRequest team) {
        Long teamId=teamsService.addTeam(team);
        return new ResponseEntity("A new team created with team id "+teamId, HttpStatus.CREATED);
    }
}