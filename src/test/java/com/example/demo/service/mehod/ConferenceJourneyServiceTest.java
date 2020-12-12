package com.example.demo.service.mehod;

import com.example.demo.entity.DO.ConferenceJourneyDO;
import com.example.demo.entity.DTO.ConferenceJourney;
import com.example.demo.entity.DTO.User;
import com.example.demo.enumValue.Sex;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class ConferenceJourneyServiceTest {
    @Autowired
    ConferenceJourneyService conferenceJourneyService;

    @Before
    void before(){

    }

    @Test
    void saveConferenceJourney() {
        ConferenceJourney conferenceJourney=conferenceJourneyService.toConferenceJourney(new ConferenceJourneyDO(1,1,1));
        System.out.println(conferenceJourneyService.saveConferenceJourney(conferenceJourney));
    }

    @Test
    void deleteConferenceJourneyByID() {

    }

    @Test
    void queryConferenceJourneyByID() {
    }

    @Test
    void queryConferenceJourneys() {
    }

    @Test
    void queryConferenceJourneysByConference() {
    }

    @Test
    void queryConferenceJourneysByJourney() {
    }

    @Test
    void queryForCountTotal() {
    }

    @Test
    void queryForPageItems() {
    }

    @Test
    void toConferenceJourney() {
    }

    @Test
    void toConferenceJourneyDO() {
    }
}