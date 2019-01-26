package flightservice.boundary;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Seat Category Value Object.
 */
@XmlRootElement(name = "SeatCategoryVO")
public class SeatCategoryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    public SeatCategoryVO() {
    }
}
