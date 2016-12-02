
import fr.utbm.formation.core.entity.Course;
import fr.utbm.formation.core.entity.CourseSession;
import fr.utbm.formation.core.entity.Location;
import fr.utbm.formation.core.service.ServiceFormation;
import static java.lang.System.exit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws ParseException {
        Course c = new Course("testcode", "testtitle");
       // Location loc = new Location("Belfort");
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date stDate;
        Date edDate;

        stDate = formatter.parse("11/11/2016");
        edDate = formatter.parse("16/11/2016");
        
        
      // CourseSession cs = new CourseSession(stDate, edDate, "testcode", 1);
        ServiceFormation service = new ServiceFormation();
        //service.registerCourse(c, cs, loc); //sauvegarde d'un nouveau cours dans la bdd
        service.filterFormation(1, "test"); //recherche dans la bdd table course avec filtre
        service.filterFormation(2,"11/11/2016");
        exit(0);
    }
}
