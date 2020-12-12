package com.example.demo.service.mehod;

import com.example.demo.dao.ConferenceJourneyDAO;
import com.example.demo.entity.DO.ConferenceJourneyDO;
import com.example.demo.entity.DTO.Conference;
import com.example.demo.entity.DTO.ConferenceJourney;
import com.example.demo.entity.DTO.Journey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConferenceJourneyService {
    @Autowired
    ConferenceJourneyDAO conferenceJourneyDAO;
    @Autowired
    ConferenceService conferenceService;
    @Autowired
    JourneyService journeyService;
    List<ConferenceJourney> list=new ArrayList<>();
    List<ConferenceJourneyDO> conferenceJourneyDOList=new ArrayList<>();

    public ConferenceJourneyDO saveConferenceJourney(ConferenceJourney conferenceJourney){
        return conferenceJourneyDAO.save(toConferenceJourneyDO(conferenceJourney));
    }

    public void deleteConferenceJourneyByID(int conferenceJourneyID){
        conferenceJourneyDAO.deleteById(conferenceJourneyID);
    }

    public ConferenceJourney queryConferenceJourneyByID(int conferenceJourneyID){
        return toConferenceJourney(conferenceJourneyDAO.queryConferenceJourneyDOByID(conferenceJourneyID));
    }

    public List<ConferenceJourney> queryConferenceJourneys(){
        list.clear();
        conferenceJourneyDOList=conferenceJourneyDAO.findAll();
        for (ConferenceJourneyDO conferenceJourneyDO:conferenceJourneyDOList){
            list.add(toConferenceJourney(conferenceJourneyDO));
        }
        return list;
    }

    public List<ConferenceJourney> queryConferenceJourneysByConference(Conference conference){
        list.clear();
        conferenceJourneyDOList=conferenceJourneyDAO.queryConferenceJourneyDOSByConferenceID(conference.getID());
        for (ConferenceJourneyDO conferenceJourneyDO:conferenceJourneyDOList){
            list.add(toConferenceJourney(conferenceJourneyDO));
        }
        return list;
    }

    public List<ConferenceJourney> queryConferenceJourneysByJourney(Journey journey){
        list.clear();
        conferenceJourneyDOList=conferenceJourneyDAO.queryConferenceJourneyDOSByConferenceID(journey.getID());
        for (ConferenceJourneyDO conferenceJourneyDO:conferenceJourneyDOList){
            list.add(toConferenceJourney(conferenceJourneyDO));
        }
        return list;
    }

    public int queryForCountTotal(){
        return (int) conferenceJourneyDAO.count();
    }

    public List<ConferenceJourney> queryForPageItems(int begin,int pageSize){
        list.clear();
        conferenceJourneyDOList=conferenceJourneyDAO.queryForPageItems(begin,pageSize);
        for (ConferenceJourneyDO conferenceJourneyDO:conferenceJourneyDOList){
            list.add(toConferenceJourney(conferenceJourneyDO));
        }
        return list;
    }


    public ConferenceJourney toConferenceJourney(ConferenceJourneyDO conferenceJourneyDO){
        ConferenceJourney conferenceJourney=new ConferenceJourney();

        conferenceJourney.setID(conferenceJourneyDO.getID());
        conferenceJourney.setConference(conferenceService.queryConferenceByID(conferenceJourneyDO.getConferenceID()));
        conferenceJourney.setJourney(journeyService.queryJourneyByID(conferenceJourneyDO.getJourneyID()));

        return conferenceJourney;
    }

    public ConferenceJourneyDO toConferenceJourneyDO(ConferenceJourney conferenceJourney){
        ConferenceJourneyDO conferenceJourneyDO=new ConferenceJourneyDO();

        conferenceJourneyDO.setID(conferenceJourney.getID());
        conferenceJourneyDO.setConferenceID(conferenceJourney.getConference().getID());
        conferenceJourneyDO.setJourneyID(conferenceJourney.getJourney().getID());

        return conferenceJourneyDO;
    }
}
