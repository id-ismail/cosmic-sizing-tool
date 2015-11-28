package models;

import java.util.*;
import javax.persistence.*;
import java.util.ArrayList;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;

public class ModelGlossary extends Model{
    private String language;
    public final static String pathGlossary = System.getProperty("user.dir")+"/"+"Glossary.txt";
    ArrayList gloss = new ArrayList();

	public String ReadFile (){
		String chaine="";
		String fichier ="Glossary.txt";
		
		//lecture du fichier texte	
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				System.out.println(ligne);
				chaine+=ligne+"\n";
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	return chaine;
	}

	
	
    public HashMap<String, String> getGlossary() {
		String chaine = ReadFile();
		String ligne = "" ;
		String part [] = null ;
		HashMap<String, String> H = new HashMap();
		while (chaine.hasNextLigne()){
			ligne = chaine.readLine();
			part = ligne.split(":");
			H[part[1]]=part[2];
			
		}
        return H;
    }

    public String getLang() {
		HttpRequest langue = new HttpRequest();
		return langue("content-Language");
    }

    public HashMap<String, String> getGlossaryWithFilters(String filter1, String filter2, String filter3, boolean andSlashOr) {
        return new HashMap();
    }
}
