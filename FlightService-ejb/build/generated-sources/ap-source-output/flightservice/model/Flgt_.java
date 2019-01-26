package flightservice.model;

import flightservice.model.FlgtPK;
import flightservice.model.FlgtSgmt;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-26T14:52:18")
@StaticMetamodel(Flgt.class)
public class Flgt_ { 

    public static volatile SingularAttribute<Flgt, String> updtuser;
    public static volatile SingularAttribute<Flgt, String> flgtType;
    public static volatile SingularAttribute<Flgt, String> acType;
    public static volatile SingularAttribute<Flgt, Timestamp> updated;
    public static volatile SingularAttribute<Flgt, Integer> version;
    public static volatile SingularAttribute<Flgt, FlgtPK> flgtPK;
    public static volatile ListAttribute<Flgt, FlgtSgmt> segments;

}