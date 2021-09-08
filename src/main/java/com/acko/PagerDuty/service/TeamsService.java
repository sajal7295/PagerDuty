package com.acko.PagerDuty.service;

import com.acko.PagerDuty.entity.Developer;
import com.acko.PagerDuty.entity.Team;
import com.acko.PagerDuty.repository.DeveloperRepository;
import com.acko.PagerDuty.repository.TeamRepository;
import com.acko.PagerDuty.request.DevelopersRequest;
import com.acko.PagerDuty.request.NewTeamRequest;
import com.acko.PagerDuty.request.TeamRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeamsService {

    @Autowired
    TeamRepository teamRepository;
    @Autowired
    DeveloperRepository developerRepository;


    @Transactional
    public Long addTeam(NewTeamRequest newTeamRequest){

        ///validation logics
        TeamRequest teamRequest=newTeamRequest.getTeam();
        //Team team=teamRepository.findByName(teamRequest.getName());
        List<DevelopersRequest> developersRequest=newTeamRequest.getDevelopers();
        List<Developer> developers=new ArrayList<>();
        for(DevelopersRequest developerRequest : developersRequest){
            developers.add(new Developer(developerRequest.getName(),developerRequest.getPhone_number()));
        }
        //developerRepository.saveAll(developers);
        Team team=new Team(teamRequest.getName(),developers);
        teamRepository.save(team);
        return team.getId();
    }


}
