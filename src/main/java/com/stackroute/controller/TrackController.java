package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")

public class TrackController {
    private TrackService trackService;

    public TrackController() {
    }

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) {
        Track savedTrack = trackService.saveTrack(track);
        return new ResponseEntity<>(savedTrack, HttpStatus.OK);
    }

    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable int id) {
        System.out.println(id);
        Track retrivedTrack = trackService.getTrackById(id);
        return new ResponseEntity<Track>(retrivedTrack, HttpStatus.OK);
    }

    @GetMapping("track/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int id) {
        Track deletedTrack = trackService.deleteTrackById(id);
        return new ResponseEntity<Track>(deletedTrack, HttpStatus.OK);

    }
}