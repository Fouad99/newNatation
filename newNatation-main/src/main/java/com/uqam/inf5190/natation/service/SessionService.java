package com.uqam.inf5190.natation.service;

import com.uqam.inf5190.natation.entities.Session;

import java.util.List;

public interface SessionService {
    Session createSession(Session session);
    List<Session> getAllSessions();
    Session getSessionById(Long sessionId);
    void deleteSession(Long id);
}
