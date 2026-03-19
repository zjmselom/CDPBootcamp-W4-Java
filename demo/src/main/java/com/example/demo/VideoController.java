package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/videos")
public class VideoController {
    
    @Autowired
    private VideoService videoService;

    @GetMapping
    public List<Video> getAllVideos() {
        return videoService.getAllVideos();
    }

    @GetMapping("/available")
    public List<Video> getAvailableVideos() {
        return videoService.getAvailableVideos();
    }

    @GetMapping("/{id}")
    public String getVideoById(@PathVariable String id) {
        return "Get video with id: " + id;
    }

    @PostMapping("/add/movie")
    public String createVideo(@RequestBody Video video) {
        videoService.addVideo(video);
        return "Video created: " + video.getTitle();
    }

    @PutMapping("/{title}/rent")
    public String rentVideo(@PathVariable String title) {
        videoService.rentVideo(title);
        return "Video rented: " + title;
    }

    @PutMapping("/{title}/return")
    public String returnVideo(@PathVariable String title) {
        videoService.returnVideo(title);
        return "Video returned: " + title;
    }
}