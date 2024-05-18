package example;

import org.eclipse.rdf4j.model.IRI;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.vocabulary.FOAF;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.model.vocabulary.RDFS;
import org.eclipse.rdf4j.model.vocabulary.XMLSchema;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryException;
import org.eclipse.rdf4j.repository.http.HTTPRepository;
import org.eclipse.rdf4j.repository.manager.RepositoryManager;
import org.eclipse.rdf4j.repository.manager.RepositoryProvider;
import org.eclipse.rdf4j.repository.sail.SailRepository;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.RDFHandlerException;
import org.eclipse.rdf4j.rio.RDFParseException;
import org.eclipse.rdf4j.sail.memory.MemoryStore;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.QueryLanguage;
//import org.eclipse.rdf4j.sail.inferencer.fc.CustomGraphQueryInferencer;

public class Ex01 {

	
	public static void main(String[] args) {
		String pre1 = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n",
			   pre2 = "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n",
			   pre3 = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n",
			   pre4 = "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n",
			   pre5 = "PREFIX ex: <http://example.com/ontology#>\n";

		String rdf4jServer = "http://localhost:8080/rdf4j-server/";
		String repositoryID = "1";
		
		Repository rep1 = new HTTPRepository(rdf4jServer, repositoryID);
		
		// You can get the same connection in other way
		RepositoryManager repositoryManager  = RepositoryProvider.getRepositoryManager("http://localhost:8080/rdf4j-server/");
		Repository rep = repositoryManager.getRepository("1");

			RepositoryConnection conn = rep.getConnection();			
			
			try {
			String queryString = pre5+"SELECT ?ceramicInstance\n" +
					"WHERE {\n" +
					"   ?ceramicInstance a ex:Ceramics .\n" +
					"} ";
			TupleQuery tupleQuery = conn.prepareTupleQuery(QueryLanguage.SPARQL, queryString);
			// next, after evaluation, the result set is ready to be processed  
				try (TupleQueryResult result = tupleQuery.evaluate()) {
					while (result.hasNext()) { // iterate over the result
						BindingSet bindingSet = result.next();
						Value valueOfCeramicInstance = bindingSet.getValue("ceramicInstance");
//aspect(4), ontologia, raport
						// Print out the value of ceramicInstance
						System.out.println("Ceramic Instance: " + valueOfCeramicInstance);
					}
				}

				// If you with to have some logging
			//Logger logger = LoggerFactory.getLogger(Ex01.class);
			//logger.info("Hello World");

		} catch (RDFParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			conn.close();
		}
	}
}