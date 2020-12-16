package com.example.demo.service.mehod;

import com.example.demo.entity.DTO.Journey;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JourneyServiceTest {
    @Autowired
    JourneyService journeyService;
    Journey journey=new Journey(1, LocalDateTime.now(),"南昌西站","南昌大学");
    @Test
    public void saveJourney() {
        journeyService.saveJourney(journey);
    }

    @Test
    public void deleteJourney() {
        System.out.println(journeyService.deleteJourney(5));
    }

    @Test
    public void queryByID() {
        System.out.println(journeyService.queryJourneyByID(4));
    }

    @Test
    public void queryJourneys() {
        System.out.println(journeyService.queryJourneys());
    }

    @Test
    public void queryJourneysByTimeBetween() {
        System.out.println(journeyService.queryJourneysByTimeBetween(LocalDate.of(2020,1,1),LocalDate.of(2020,12,12)));
    }

    @Test
    public void queryJourneysByOrigin() {
        System.out.println(journeyService.queryJourneysByOrigin("南昌西"));
    }

    @Test
    public void queryJourneysByTarget() {
        System.out.println(journeyService.queryJourneysByTarget("南昌大"));
    }

    @Test
    public void queryJourneysByOriginAndTarget() {
        System.out.println(journeyService.queryJourneysByOriginAndTarget("南昌西站","南昌大学"));
    }

    @Test
    public void queryForCountTotal() {
        System.out.println(journeyService.queryForCountTotal());

    }

    @Test
    public void queryForPageItems() {
        System.out.println(journeyService.queryForPageItems(0,4));
    }
}