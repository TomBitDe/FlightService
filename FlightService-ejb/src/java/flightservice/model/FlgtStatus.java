package flightservice.model;

/**
 * A flight status can be delayed, canceled...
 */
public enum FlgtStatus {
    OnTime("On time"),
    Arrived("Arrived"),
    Taxiing("Taxiing"),
    Boarding("Boarding"),
    EndOfBoarding("Boarding finished"),
    Departed("Departed"),
    Delayed("Delayed"),
    Canceled("Canceled"),
    Unknown("Unknown");

    private final String statusText;

    private FlgtStatus(String statusText) {
        this.statusText = statusText;
    }

    public boolean equalsName(String otherText) {
        // (otherName == null) check is not needed because name.equals(null) returns false
        return statusText.equals(otherText);
    }

    @Override
    public String toString() {
        return this.statusText;
    }
}
