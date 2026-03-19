package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class VideoService {
    
    private List<Video> videos = new ArrayList<>();

    public List<Video> getAllVideos() {
        return videos;
    }

    public List<Video> getAvailableVideos() {
        return videos.stream()
            .filter(Video::isAvailable)
            .toList();
    }

    public void addVideo(Video video) {
        videos.add(video);
    }

    public void rentVideo(String title) {
        videos.stream()
            .filter(v -> v.getTitle().equals(title))
            .forEach(Video::rentVideo);
    }

    public void returnVideo(String title) {
        videos.stream()
            .filter(v -> v.getTitle().equals(title))
            .forEach(Video::returnVideo);
    }
}