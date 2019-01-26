package flightservice.boundary;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Seat Configuration Value Object.
 */
@XmlRootElement(name = "SeatConfigurationVO")
public class SeatConfigurationVO implements Serializable {
    private static final long serialVersionUID = 1L;

    public SeatConfigurationVO() {
    }
}
