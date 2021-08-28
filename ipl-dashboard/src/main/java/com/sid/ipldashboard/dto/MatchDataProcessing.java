package com.sid.ipldashboard.dto;

import java.time.LocalDate;

import com.sid.ipldashboard.model.Match;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

public class MatchDataProcessing implements ItemProcessor<MatchData, Match> {

    private static final Logger log = LoggerFactory.getLogger(MatchDataProcessing.class);

    @Override
    public Match process(final MatchData matchData) throws Exception {
        Match match = new Match();
        match.setId(Long.parseLong(matchData.getId()));
        match.setCity(matchData.getCity());
        match.setDate(LocalDate.parse(matchData.getDate()));
        match.setPlayerOfMatch(matchData.getPlayer_of_match());
        match.setVenue(matchData.getVenue());

        String firstInnings, secondInnings;
        if ("bat".equals(matchData.getToss_decision())) {
            firstInnings = matchData.getToss_winner();
            secondInnings = matchData.getToss_winner().equals(matchData.getTeam1()) ? matchData.getTeam2()
                    : matchData.getTeam1();
        } else {
            secondInnings = matchData.getToss_winner();
            firstInnings = matchData.getToss_winner().equals(matchData.getTeam1()) ? matchData.getTeam2()
                    : matchData.getTeam1();
        }
        match.setTeam1(firstInnings);
        match.setTeam2(secondInnings);
        match.setTossWinner(matchData.getToss_winner());
        match.setTossWinner(matchData.getToss_winner());
        match.setMatchWinner(matchData.getWinner());
        match.setResult(matchData.getResult());
        match.setResultMargin(matchData.getResult_margin());
        match.setUmpire1(matchData.getUmpire1());
        match.setUmpire2(matchData.getUmpire2());
        return match;

    }
}