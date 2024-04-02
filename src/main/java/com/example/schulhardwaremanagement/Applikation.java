package com.example.schulhardwaremanagement;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.ArrayList;
import java.util.List;

public class Applikation {

    private static List<SseEmitter> emitters = new ArrayList<>();

    public static void addEmitter(final SseEmitter emitter) {
        emitters.add(emitter);
    }

    public static void removeEmitter(final SseEmitter emitter) {
        emitters.remove(emitter);
    }

    public static void broadcast(final String chipId) {
        List<SseEmitter> deadEmitters = new ArrayList<>();
        emitters.forEach(emitter -> {
            try {
                emitter.send(SseEmitter.event().name("chipId").data(chipId));
            } catch (Exception e) {
                deadEmitters.add(emitter);
            }
        });
        emitters.removeAll(deadEmitters);
    }

}
