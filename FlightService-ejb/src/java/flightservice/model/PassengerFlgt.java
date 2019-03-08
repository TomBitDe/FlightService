package flightservice.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;

/**
 * Passenger flight master data.
 */
@Entity
@DiscriminatorValue(value = "PAX")
public class PassengerFlgt extends Flgt {
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumns({
        @JoinColumn(name = "FLGTNO", referencedColumnName = "FLGTNO", insertable = false, updatable = false)
        , @JoinColumn(name = "SCHEDFLGTDT", referencedColumnName = "SCHEDFLGTDT", insertable = false, updatable = false)
    })
    private List<SeatCategory> seatConfiguration = new ArrayList<>();

    public PassengerFlgt() {
        super();
    }

    public PassengerFlgt(FlgtPK flgtPK) {
        super(flgtPK);
    }

    public PassengerFlgt(FlgtPK flgtPK, String acType) {
        super(flgtPK, acType);
    }

    public List<SeatCategory> getSeatConfiguration() {
        return seatConfiguration;
    }

    public void setSeatConfiguration(List<SeatCategory> seatConfiguration) {
        this.seatConfiguration = seatConfiguration;
    }

    @Override
    public String toString() {
        return "PassengerFlgt{" + "seatConfiguration=" + seatConfiguration + " " + super.toString() + '}';
    }
}
