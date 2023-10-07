package com.example.computingproject;

import com.google.android.gms.maps.model.Marker;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MarkerCollection {

    private static List<Marker> markerList = new LinkedList<>();

    public static void insertMarker(Marker marker) {
        markerList.add(marker);
    }

    public static Marker getMarker(String driverId) {
        for (Marker marker : markerList)
            if (Objects.requireNonNull(marker.getTag()).equals(driverId)) return marker;
        return null;
    }

    public static void clearMarkers() {
        markerList.clear();
    }

    public static void removeMarker(String driverId) {
        Marker marker = getMarker(driverId);
        if (marker != null) {
            marker.remove();
            markerList.remove(marker);
        }
    }

    public static List<Marker> allMarkers() {
        return markerList;
    }
}
