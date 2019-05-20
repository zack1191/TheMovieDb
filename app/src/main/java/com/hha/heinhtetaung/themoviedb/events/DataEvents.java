package com.hha.heinhtetaung.themoviedb.events;

public class DataEvents {
    public static class TabLayoutChangedEvent {
        private String title;

        public TabLayoutChangedEvent(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }
}
