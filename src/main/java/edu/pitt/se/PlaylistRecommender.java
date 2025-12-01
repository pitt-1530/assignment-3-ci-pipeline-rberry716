package edu.pitt.se;

import java.util.List;

public class PlaylistRecommender {

    public static String classifyEnergy(List<Integer> bpms) {
        if (bpms == null || bpms.isEmpty()) {
            throw new IllegalArgumentException("BPMS list cannot be null or empty");
        }
        int total = 0;
        for (int bpm : bpms) {
            total += bpm;
        }
        int average = total / bpms.size();
        if (average >= 140) {
            return "HIGH";
        } else if (average >= 100) {
            return "MEDIUM";
        } else {
            return "LOW";
        }
    }

    public static boolean isValidTrackTitle(String title) {
        if(title == null) {
            return false;
        }
        if(title.length() < 1 || title.length() > 30) {
            return false;
        }
        for (int i = 0; i < title.length(); i++) {
            if(!Character.isLetter(title.charAt(i)) && title.charAt(i) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static int normalizeVolume(int volumeDb) {
        if (volumeDb < 0) {
            return 0;
        }
        if (volumeDb > 100) {
            return 100;
        }
        return volumeDb;
    }
}
