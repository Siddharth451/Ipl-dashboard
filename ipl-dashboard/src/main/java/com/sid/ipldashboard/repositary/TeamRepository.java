package com.sid.ipldashboard.repositary;

import com.sid.ipldashboard.model.Team;

import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team,Long> {
    Team findByTeamName(String teamName);
    
}
