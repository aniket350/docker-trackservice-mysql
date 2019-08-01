package com.stackroute.service;

import com.stackroute.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackService extends JpaRepository<Track,Integer>
{
    public Track saveTrack(Track track);

    public Track getTrackById(int id);

    public Track deleteTrackById(int id);
}
