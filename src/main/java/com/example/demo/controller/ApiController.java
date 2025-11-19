package com.example.demo.controller;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@EnableScheduling
@RequestMapping("/api")
public class ApiController {

    // Dummy Log Buffer
    private final List<String> logBuffer = new ArrayList<>();

    public ApiController() {
        // Dummy initial logs
        logBuffer.add("[INFO] Application started.");
        logBuffer.add("[DEBUG] Initializing state...");
        logBuffer.add("[DEBUG] Ready.");
    }

    // Dummy states
    @GetMapping("/states")
    public List<Map<String, Object>> getStates() {
        List<Map<String, Object>> states = new ArrayList<>();

        states.add(Map.of(
                "name", "Berechneter Zustand",
                "red", 0,
                "green", 255,
                "blue", 0
        ));

        states.add(Map.of(
                "name", "Licht Zustand",
                "red", 0,
                "green", 150,
                "blue", 255
        ));

        return states;
    }

    // Logs
    @GetMapping("/logs")
    public List<String> getLogs() {
        return logBuffer;
    }



    // Hilfsmethode zum Hinzufügen neuer Dummy-Einträge (später ersetzt durch echtes Logging)
    @PostMapping("/logs/add")
    public void addLog(@RequestBody String entry) {
        logBuffer.add(entry);
        if (logBuffer.size() > 500) {
            logBuffer.remove(0);
        }
    }

    @Scheduled(fixedRate = 2*1000) // Alle 60 Sekunden
    public void generateDummyLog() {
        addLog("[DEBUG] Dummy log entry at " + new Date());
    }
}
