package flightservice.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Freighter flight master data.
 */
@Entity
@DiscriminatorValue(value = "FTR")
public class FreighterFlgt extends Flgt {
    /**
     * Maximum payload for this flight
     */
    private int maxPayload;
    /**
     * The maximum payloads unit e.g. kilogram, tons etc.
     */
    private String payloadUnit;

    public FreighterFlgt() {
        super();
    }

    public FreighterFlgt(FlgtPK flgtPK) {
        super(flgtPK);
    }

    public FreighterFlgt(FlgtPK flgtPK, String acType) {
        super(flgtPK, acType);
    }

    public int getMaxPayload() {
        return maxPayload;
    }

    public void setMaxPayload(int maxPayload) {
        this.maxPayload = maxPayload;
    }

    public String getPayloadUnit() {
        return payloadUnit;
    }

    public void setPayloadUnit(String payloadUnit) {
        this.payloadUnit = payloadUnit;
    }

    @Override
    public String toString() {
        return "FreighterFlgt{" + "maxPayload=" + maxPayload + ", payloadUnit=" + payloadUnit + " " + super.toString() + '}';
    }
}
