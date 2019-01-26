package flightservice.model;

import flightservice.model.Flgt;
import flightservice.model.FlgtSgmtPK;
import flightservice.model.FlgtSgmtSchedule;
import flightservice.model.FlgtStatus;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-26T14:52:18")
@StaticMetamodel(FlgtSgmt.class)
public class FlgtSgmt_ { 

    public static volatile SingularAttribute<FlgtSgmt, String> parkingLot;
    public static volatile SingularAttribute<FlgtSgmt, Flgt> flgt;
    public static volatile SingularAttribute<FlgtSgmt, Integer> seqNo;
    public static volatile SingularAttribute<FlgtSgmt, FlgtStatus> flgtStatus;
    public static volatile SingularAttribute<FlgtSgmt, FlgtSgmtPK> flgtSgmtPK;
    public static volatile SingularAttribute<FlgtSgmt, String> schedFlgtTm;
    public static volatile SingularAttribute<FlgtSgmt, FlgtSgmtSchedule> sgmtSchedule;
    public static volatile SingularAttribute<FlgtSgmt, Integer> version;
    public static volatile SingularAttribute<FlgtSgmt, String> checkinCounter;
    public static volatile SingularAttribute<FlgtSgmt, String> updtuser;
    public static volatile SingularAttribute<FlgtSgmt, String> paxExit;
    public static volatile SingularAttribute<FlgtSgmt, String> comment;
    public static volatile SingularAttribute<FlgtSgmt, String> gate;
    public static volatile SingularAttribute<FlgtSgmt, Timestamp> updated;

}