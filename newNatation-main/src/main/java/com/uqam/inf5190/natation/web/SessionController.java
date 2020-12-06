package com.uqam.inf5190.natation.web;

import com.uqam.inf5190.natation.entities.Session;
import com.uqam.inf5190.natation.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//cette classe sert 'a communiquer avec l'API REST
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping("/sessions")
    public ResponseEntity<List<Session>> getAllSessions(){
        return ResponseEntity.ok().body(sessionService.getAllSessions());
    }

    @GetMapping("/sessions/{id}")
    public ResponseEntity<Session> getSessionById(@PathVariable long id){
        return ResponseEntity.ok().body(sessionService.getSessionById(id));
    }

    @PostMapping("/sessions")
    public ResponseEntity<Session> createSession(@RequestBody Session session){
        return ResponseEntity.ok().body(this.sessionService.createSession(session));
    }

    @DeleteMapping("/sessions/{id}")
    public HttpStatus deleteSession(@PathVariable long id){
        this.sessionService.deleteSession(id);
        return HttpStatus.OK;
    }
}
