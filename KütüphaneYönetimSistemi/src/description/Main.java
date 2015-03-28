package description;
import org.apache.jena.atlas.lib.Tuple;

import com.hp.hpl.jena.query.ParameterizedSparqlString;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.sparql.vocabulary.FOAF;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.XSD;





 
 
 
public class Main {

	
	public static void yaz (long tc){
	
		
		String sparqlTxt = "PREFIX xsd:<http://www.w3.org/2001/XMLSchema#> "
				+ "PREFIX foaf:<" + FOAF.getURI() + "> " + "PREFIX library:<"
				+ OntologyConstants.ONTOLOGY_BASE_URI + "> "
				+ "SELECT * WHERE {" + "?s library:tc \"" + tc
				+ "\"^^xsd:long." 
				+ "?s foaf:name ?name." 
				 + "}";
				
		
		
//		String sparqlTxt = "PREFIX rdf:<" + RDF.getURI() + "> "
//				+"PREFIX xsd:<" + XSD.getURI() +  "> "
//				+ "PREFIX foaf:<" + FOAF.getURI() + "> " + "PREFIX library:<"
//				+ OntologyConstants.ONTOLOGY_BASE_URI + "> "
//				+ "SELECT * WHERE {" + "?s rdf:type foaf:Person. "
//				+ "?s foaf:family_name ?soyad ."
//				+ "?s library:password ?password ."
//				+ "?s foaf:name ?name." 
//				+ "?s library:email ?mail." 
//				+  "?s library:tc  \"" +tc+  "\"^^xsd:long. "
//						+ "?s foaf:knows ?friend. "
//						+ "?friend foaf:name ?friendName }"   ;
//		
      
       
		
      
		ResultSet ppersonResultSet = KutuphaneStore.getInstance().queryModelAsSelect(
				sparqlTxt);
		
		 System.out.println(sparqlTxt);
		 
		while (ppersonResultSet.hasNext()) {
			
			
			
			QuerySolution querySolution = (QuerySolution) ppersonResultSet.next();
			String name = querySolution.getLiteral("name").getString();
//			int tcValue = querySolution.getLiteral("tc").getInt();
			//String soyad = querySolution.getLiteral("soyad").getString();
			//String password = querySolution.getLiteral("password").getString();
			//String email = querySolution.getLiteral("mail").getString();
			//String friendName = querySolution.getLiteral("friendName").getString();
			//System.out.println(name + "    " + soyad+"    " +" sifre:"+ password + " email  :  "+ email+" friend name: "+friendName) ;
			System.out.println("     ad:"+ name);
		}
			
	
			
			
			
			
		
		 
		
		/*
		
		ParameterizedSparqlString queryStr = new ParameterizedSparqlString();
		queryStr.setNsPrefix("rdf", RDF.getURI());
		queryStr.setNsPrefix("xsd", XSD.getURI());
		queryStr.setNsPrefix("foaf", FOAF.getURI());
		queryStr.setNsPrefix("library", OntologyConstants.ONTOLOGY_BASE_URI);
		
		queryStr.append("?name ?soyad ?password ?tc");
		queryStr.append("{");
		queryStr.append("  ?s foaf:name ?name .");
		queryStr.append("  ?s foaf:family_name ?soyad .");
		queryStr.append("  ?s library:password ?password . ");
		queryStr.append(" ?tc  library:tc ");
		queryStr.append(tc);
		queryStr.append(".");
	
		queryStr.append("  ?s rdf:type foaf:Person .");
		
	
		

		Query q = queryStr.asQuery(); */
		
		
		
		
		
		
		 
	 }
	
	
	
public static void kitapYaz (int isbn){
	
		
		String sparqlTxt = "PREFIX xsd:<http://www.w3.org/2001/XMLSchema#> "
//				
				+ "PREFIX library:<"
				+ OntologyConstants.ONTOLOGY_BASE_URI + "> "
				+ "SELECT * WHERE {"  
				+ " ?s library:title ?title."
				+ " ?s library:isbn ?b."
				+"}";

		
		ResultSet kitapResultSet = KutuphaneStore.getInstance().queryModelAsSelect(
				sparqlTxt);
		
		 System.out.println(sparqlTxt);
		 
		while (kitapResultSet.hasNext()) {
			System.out.println(" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  ");
			QuerySolution querySolution = (QuerySolution) kitapResultSet.next();
			String title = querySolution.getLiteral("title").getString();
			int isbnn = querySolution.getLiteral("b").getInt();
			System.out.println("     kitap:"+ title+"    "+ isbnn );
		}
		
		 
	 }



	public static void main(String[] args) {
		
//		KutuphaneStore.getInstance().printModel();
	   String tcc= "10856213714";
	  long t = 112551;
		System.out.println("sorgu ba��");
		
		
	
		yaz(Long.parseLong(tcc));
		
		System.out.println("parse edilmi� long :    "+tcc);
		
		String is="123";
		kitapYaz(Integer.parseInt(is));
		
		
		System.out.println("##################################");
		System.out.println("sorgu sonucu");
		
		String sparqlTxt = "PREFIX rdf:<" + RDF.getURI() + "> "
				+ "PREFIX foaf:<" + FOAF.getURI() + "> " + "PREFIX library:<"
				+ OntologyConstants.ONTOLOGY_BASE_URI + "> "
				+ "SELECT * WHERE {" + "?s rdf:type foaf:Person. "
				+ "?s foaf:family_name ?soyad ."
				+ "?s library:password ?password ."
				+ "?s foaf:name ?name." 
				+ "?s library:email ?mail."
				+ "?s foaf:knows ?friend. "
				+ "?friend foaf:name ?friendName ."
				+ "?friend library:email ?friendMail ."
				+  "?s library:tc ?tc}"; 
		
		
		ResultSet personResultSet = KutuphaneStore.getInstance().queryModelAsSelect(
				sparqlTxt);
		
		System.out.println("ikinci sorgu hepsini listeliyor");
		while (personResultSet.hasNext()) {
			QuerySolution querySolution = (QuerySolution) personResultSet.next();
			String name = querySolution.getLiteral("name").getString();
			long tcValue = querySolution.getLiteral("tc").getLong();
			String soyad = querySolution.getLiteral("soyad").getString();
			String password = querySolution.getLiteral("password").getString();
			String email = querySolution.getLiteral("mail").getString();
			String friend = querySolution.getLiteral("friendName").getString();
			String friendm = querySolution.getLiteral("friendMail").getString();
//			System.out.println("*******************************");
            System.out.println(querySolution.getLiteral("tc"));
//			System.out.println("*******************************");
			System.out.println(name + "    " + soyad+"    " + tcValue + " sifre:"+ password + " email  :  "+ email + "   arkada��: "+friend+"    :"+friendm) ;
			
			
		}
		
		
		String sparqlKitap ="PREFIX xsd:<http://www.w3.org/2001/XMLSchema#> "
				+ "PREFIX foaf:<" + FOAF.getURI() + "> " + "PREFIX library:<"
				+ OntologyConstants.ONTOLOGY_BASE_URI + "> "
					+ "SELECT * WHERE {" + "?s library:title ?title. "
					+ "?s library:isbn ?isbn ."
				
					+  "}"; 
			
			
			ResultSet bookkResultSet = KutuphaneStore.getInstance().queryModelAsSelect(
					sparqlKitap);
			
			System.out.println("kitaplar�n hepsini sorgula^^^^^^^^^^^^^^^^^^");
			
//			while (bookkResultSet.hasNext()) {
//				QuerySolution querySolution = (QuerySolution) bookkResultSet.next();
//				String title = querySolution.getLiteral("title").getString();
//				int isbn = querySolution.getLiteral("isbn").getInt();
//			//	String authorList = querySolution.getLiteral("authorList").getString();
//				String publicationDate = querySolution.getLiteral("publicationDate").getString();
//				int bookCount = querySolution.getLiteral("bookCount").getInt();
//	            System.out.println(querySolution.getLiteral("isbn"));
//				System.out.println(title + "    " + isbn+"    "  +  " Date  :  " + "   adet: " ) ;
				
				
			}
	
		
		
		
	// ilk admini ekleme	
//		String tccc="11255146493";
//		Model adminModel = IndividualCreator
//				.createAdmin("Seha", "AKYOL",Long.parseLong(tccc),"12345", "seha@gmail.com", "seho�");
//		
//		KutuphaneStore.getInstance().addResourceModel(adminModel);
//		
		
		

	
	
	
	
}
