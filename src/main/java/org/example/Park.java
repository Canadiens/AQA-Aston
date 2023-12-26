package org.example;
public class Park {
    private class Attractions {
        private final String attractionName;
        private final String operationTimes;
        private final double cost;
        public Attractions(String attractionName, String operationTimes, double cost) {
            this.attractionName = attractionName;
            this.operationTimes = operationTimes;
            this.cost = cost;
        }
    }
}