package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.List;

class VideoServiceTest {

    private static class TestVideo extends Video {
        TestVideo(String title, String genre) { super(title, genre); }
        @Override public void play() {}
    }

    @Test
    void addAndRetrieveVideos() {
        VideoService service = new VideoService();
        service.addVideo(new TestVideo("A", "G"));
        service.addVideo(new TestVideo("B", "G"));

        List<Video> all = service.getAllVideos();
        assertThat(all).hasSize(2);
    }

    @Test
    void rentAndReturnChangesAvailability() {
        VideoService service = new VideoService();
        TestVideo v = new TestVideo("A", "G");
        service.addVideo(v);

        assertThat(service.getAvailableVideos()).contains(v);

        service.rentVideo("A");
        assertThat(v.isAvailable()).isFalse();
        assertThat(service.getAvailableVideos()).doesNotContain(v);

        service.returnVideo("A");
        assertThat(v.isAvailable()).isTrue();
    }
}