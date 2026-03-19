package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/videos")
public class VideoController {
    
    private List<Video> videos = new ArrayList<>();

    @GetMapping
    public List<Video> getAllVideos() {
        return videos;
    }

    @GetMapping("/available")
    public List<Video> getAvailableVideos() {
        return videos.stream()
            .filter(Video::isAvailable)
            .toList();
    }

    @GetMapping("/{id}")
    public String getVideoById(@PathVariable String id) {
        return "Get video with id: " + id;
    }

    @PostMapping("/add/movie")
    public String createVideo(@RequestBody Video video) {
        videos.add(video);
        return "Video created: " + video.getTitle();
    }

    @PutMapping("/{title}/rent")
    public String rentVideo(@PathVariable String title) {
        videos.stream()
            .filter(v -> v.getTitle().equals(title))
            .forEach(Video::rentVideo);
        return "Video rented: " + title;
    }

    @PutMapping("/{title}/return")
    public String returnVideo(@PathVariable String title) {
        videos.stream()
            .filter(v -> v.getTitle().equals(title))
            .forEach(Video::returnVideo);
        return "Video returned: " + title;
    }
}