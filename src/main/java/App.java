
import fr.utbm.formation.core.entity.Client;
import fr.utbm.formation.core.entity.Course;
import fr.utbm.formation.core.entity.CourseSession;
import fr.utbm.formation.core.entity.Location;
import fr.utbm.formation.core.repository.ClientDAO;
import fr.utbm.formation.core.repository.CourseSessionDAO;
import fr.utbm.formation.core.service.ServiceFormation;
import fr.utbm.formation.core.tools.JasperUtil;
import static java.lang.System.exit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * TEST des fonctions
 */
public class App {

    public static void main(String[] args) throws ParseException {
        Course c = new Course("testcode", "testtitle");
        Location loc = new Location("Belfort");
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date stDate;
        Date edDate;

        stDate = formatter.parse("11/11/2017");
        edDate = formatter.parse("16/11/2017");

        CourseSession cs = new CourseSession(stDate, edDate, c, loc);
        ServiceFormation service = new ServiceFormation();
        service.registerCourse(c, loc); //sauvegarde d'un nouveau cours dans la bdd
        service.resgisterCourseSession(cs);
      //  service.filterFormation(1, "testtitle"); //recherche dans la bdd table course avec filtre
       // service.filterFormation(2, "11/11/2016");

        //List result = service.getAllFormation();
        //new JasperUtil(result);
       // ServiceFormation service = new ServiceFormation();
        CourseSessionDAO getCsS = new CourseSessionDAO();
        CourseSession csS = getCsS.getCourseSessionById("1");
        System.out.print(cs);
        service.subscribe("nom", "prenom", "adresse", "phone", "email@jj.com", "2");//sauvegarde de l'inscription ds la BDD
        ClientDAO clD = new ClientDAO();
        Client cl = new Client("lastname", "firstname", "address", "phone", "email", cs);
        // clD.addClient(cl);
        if (clD.isAlreadySubscribed(cl)) {
            System.out.println("est deja inscrit");
        } else {
            System.out.println("n'est pas inscrit");
        }
        service.getMyFormations("emailx");
        exit(0);
    }
}
