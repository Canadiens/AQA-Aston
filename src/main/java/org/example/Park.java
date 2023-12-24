package org.example;

public class Park {

    private class Attractions {
        private String attractionName;
        private String operationTimes;
        private double cost;

        public Attractions(String attractionName, String operationTimes, double cost) {
            this.attractionName = attractionName;
            this.operationTimes = operationTimes;
            this.cost = cost;
        }
    }
}
