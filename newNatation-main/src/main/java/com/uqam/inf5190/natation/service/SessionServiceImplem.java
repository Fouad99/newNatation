package com.uqam.inf5190.natation.service;

import com.uqam.inf5190.natation.dao.SaisonRepository;
import com.uqam.inf5190.natation.entities.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SessionServiceImplem implements SessionService {

    @Autowired
    private SaisonRepository saisonRepository;

    @Override
    public Session createSession(Session session) {
        return saisonRepository.save(session);
    }

    @Override
    public List<Session> getAllSessions() {
        return this.saisonRepository.findAll();
    }

    @Override
    public Session getSessionById(Long sessionId) {
        Optional<Session> sessionObj = this.saisonRepository.findById(sessionId);
        return sessionObj.get();
    }

    @Override
    public void deleteSession(Long sessionId) {
        Optional<Session> sessionObj = this.saisonRepository.findById(sessionId);
        this.saisonRepository.delete(sessionObj.get());
    }
}
