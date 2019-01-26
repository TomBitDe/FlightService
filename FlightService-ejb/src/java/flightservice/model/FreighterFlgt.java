package flightservice.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Freighter flight master data.
 */
@Entity
@DiscriminatorValue(value = "FTR")
public class FreighterFlgt extends Flgt {
    public FreighterFlgt() {
        super();
    }

    public FreighterFlgt(FlgtPK flgtPK) {
        super(flgtPK);
    }

    public FreighterFlgt(FlgtPK flgtPK, String acType) {
        super(flgtPK, acType);
    }
}
