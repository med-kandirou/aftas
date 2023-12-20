package com.mkandirou.aftas;


import com.mkandirou.aftas.competition.Competition;
import com.mkandirou.aftas.competition.CompetitionRepository;
import com.mkandirou.aftas.fish.Fish;
import com.mkandirou.aftas.hunting.Hunting;
import com.mkandirou.aftas.hunting.HuntingRepository;
import com.mkandirou.aftas.level.Level;
import com.mkandirou.aftas.member.IdentityDocumentType;
import com.mkandirou.aftas.member.Member;
import com.mkandirou.aftas.ranking.Ranking;
import com.mkandirou.aftas.ranking.RankingId;
import com.mkandirou.aftas.ranking.RankingRepository;
import com.mkandirou.aftas.ranking.RankingService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

public class TestRanking {

    @InjectMocks
    private RankingService rankingService;

    @Mock
    private CompetitionRepository competitionRepository;

    @Mock
    private HuntingRepository huntingRepository;

    @Mock
    private RankingRepository rankingRepository;

    @Test
    void testCalculePointbyCompetition() {
        // Initialize mocks
        MockitoAnnotations.initMocks(this);

        Competition competition = new Competition("hoc-19-12-23", LocalDate.of(2023,12,18), LocalTime.of(10, 0), LocalTime.of(12, 0), 50, "hoceima", 1000.0);  // You may need to set up a valid Competition object
        Level level1 = new Level(1,"level 1",1);
        Fish fish1 = new Fish("Trout", 2.5, level1);
        Member m1 = new Member("John", "Doe", LocalDate.now(), "US", IdentityDocumentType.PASSPORT, "AB123456");
        Hunting hunting = new Hunting(2,fish1,m1,competition);

        RankingId rankingId= new RankingId();
        rankingId.setMember(m1);
        rankingId.setCompetition(competition);

        Ranking ranking = new Ranking(rankingId,0,0);

        // Mock repository responses
        when(competitionRepository.findById(competition.getCode())).thenReturn(java.util.Optional.of(competition));
        when(huntingRepository.findByCompetitionCode(competition.getCode())).thenReturn(Collections.singletonList(hunting));
        when(rankingRepository.findById(any())).thenReturn(java.util.Optional.of(ranking));
        when(rankingRepository.findByRankingId_Competition_Code(competition.getCode())).thenReturn(Collections.singletonList(ranking));

        // Call the method
        Boolean result = rankingService.calculePointbyCompetition(competition.getCode());

        // Verify that the repositories were called appropriately
        verify(competitionRepository, times(1)).findById(competition.getCode());
        verify(huntingRepository, times(1)).findByCompetitionCode(competition.getCode());
        verify(rankingRepository, times(1)).findById(any());
        verify(rankingRepository, times(1)).findByRankingId_Competition_Code(competition.getCode());


        assertTrue(result);
        //assertEquals(4, ranking.getScore());
        //assertEquals(1, ranking.getRank());
    }
}
