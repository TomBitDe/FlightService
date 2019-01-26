package flightservice.model;

import flightservice.model.FlgtSgmt;
import flightservice.model.FlgtSgmtPK;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-26T14:52:18")
@StaticMetamodel(FlgtSgmtSchedule.class)
public class FlgtSgmtSchedule_ { 

    public static volatile SingularAttribute<FlgtSgmtSchedule, Timestamp> lot;
    public static volatile SingularAttribute<FlgtSgmtSchedule, Timestamp> sdt;
    public static volatile SingularAttribute<FlgtSgmtSchedule, Timestamp> edt;
    public static volatile SingularAttribute<FlgtSgmtSchedule, Timestamp> tdt;
    public static volatile SingularAttribute<FlgtSgmtSchedule, FlgtSgmtPK> flgtSgmtPK;
    public static volatile SingularAttribute<FlgtSgmtSchedule, Timestamp> sat;
    public static volatile SingularAttribute<FlgtSgmtSchedule, String> updtuser;
    public static volatile SingularAttribute<FlgtSgmtSchedule, Timestamp> eat;
    public static volatile SingularAttribute<FlgtSgmtSchedule, FlgtSgmt> flgtSgmt;
    public static volatile SingularAttribute<FlgtSgmtSchedule, Timestamp> updated;
    public static volatile SingularAttribute<FlgtSgmtSchedule, Integer> version;

}