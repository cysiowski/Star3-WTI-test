import java.io.InputStream;
import java.util.Iterator;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;


public class test {

	public static void main(String[] args) {
		
		
		InputStream testFileIn = null;
		try {
			testFileIn = FileManager.get().open( "E:\\catie.owl");
			if (testFileIn == null) {
		        throw new IllegalArgumentException("File not found");
		        }
			
			OntModel ontModel = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM);
			System.out.println( "ontModel=" + ontModel);
			
			ontModel.read(testFileIn, "");
			
			ExtendedIterator classes = ontModel.listClasses();
	        while (classes.hasNext()) {
	        OntClass cls = (OntClass) classes.next();
	        System.out.println("Classes: " + cls.getLocalName());
	        for (Iterator i = cls.listSubClasses(true); i.hasNext();) {
	        OntClass c = (OntClass) i.next();
	        System.out.print("		" + c.getLocalName() + "\n");
	        } // end for
	        }
		} catch(IllegalArgumentException ex) {
			System.out.println( "File not found");
			System.exit( 0);
		}
		

	}

}
