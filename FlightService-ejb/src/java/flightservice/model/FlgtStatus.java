package flightservice.model;

/**
 * A flight status can be delayed, canceled...
 */
public enum FlgtStatus {

    /**
     * Flight is on time
     */
    OnTime("On time"),
    /**
     * Flight arrived
     */
    Arrived("Arrived"),
    /**
     * Plane is taxiing
     */
    Taxiing("Taxiing"),
    /**
     * Boarding started
     */
    Boarding("Boarding"),
    /**
     * Boarding finished
     */
    EndOfBoarding("Boarding finished"),
    /**
     * Flight departed
     */
    Departed("Departed"),
    /**
     * Flight has delay
     */
    Delayed("Delayed"),
    /**
     * Flight is canceled
     */
    Canceled("Canceled"),
    /**
     * Status is unknown
     */
    Unknown("Unknown");

    private final String statusText;

    private FlgtStatus(String statusText) {
        this.statusText = statusText;
    }

    /**
     * Check if this status text equals an other text
     *
     * @param otherText the other text
     *
     * @return true if it equals, else false
     */
    public boolean equalsName(String otherText) {
        // (otherName == null) check is not needed because name.equals(null) returns false
        return statusText.equals(otherText);
    }

    @Override
    public String toString() {
        return this.statusText;
    }
}
