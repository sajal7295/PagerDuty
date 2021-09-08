package com.acko.PagerDuty.request;


import java.util.List;

//{"team": {"name": "claims"}, "developers": [{"name": "someone", "phone_number":
//        "9999999999"}, {"name": "somebody", "phone_number": "9111111111"}]}
public class NewTeamRequest {

    TeamRequest team;
    List<DevelopersRequest> developers;

    public TeamRequest getTeam() {
        return team;
    }

    public List<DevelopersRequest> getDevelopers() {
        return developers;
    }

}
