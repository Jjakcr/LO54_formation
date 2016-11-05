


import fr.utbm.formation.core.entity.Course;
import fr.utbm.formation.core.service.ServiceFormation;

/**
 * Hello world!
 */
public class App {

	public static void main(String[] args) {
		Course c = new Course("testcode","testtitle"); 
                ServiceFormation service= new ServiceFormation();
                service.registerCourse(c); //sauvegarde d'un nouveau cours dans la bdd
                service.filterFormation(1, "test"); //recherche dans la bdd table course avec filtre
	}
}
