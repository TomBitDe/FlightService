package flightservice.model;

import flightservice.model.PassengerFlgt;
import flightservice.model.SeatCategoryPK;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-26T14:52:18")
@StaticMetamodel(SeatCategory.class)
public class SeatCategory_ { 

    public static volatile SingularAttribute<SeatCategory, SeatCategoryPK> seatCategoryPK;
    public static volatile SingularAttribute<SeatCategory, String> updtuser;
    public static volatile SingularAttribute<SeatCategory, Integer> seats;
    public static volatile SingularAttribute<SeatCategory, Timestamp> updated;
    public static volatile SingularAttribute<SeatCategory, Integer> version;
    public static volatile SingularAttribute<SeatCategory, PassengerFlgt> passengerFlgt;

}