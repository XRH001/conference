package com.example.demo.dao;

import com.example.demo.service.mehod.ConferenceService;
import com.example.demo.service.mehod.JourneyService;
import com.example.demo.service.mehod.UserJourneyService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class UserJourneyDAOTest {
    @Autowired
    UserJourneyDAO userJourneyDAO;

    @Test
    void insertConferenceAndJourney() {
        System.out.println(userJourneyDAO.insertConferenceAndJourney(21,1));
    }
}