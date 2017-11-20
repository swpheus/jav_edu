import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Set;

public class PropertiesSample {
	public static void main(String[] args) {
		PropertiesSample sample = new PropertiesSample();
		sample.checkProperties();
		sample.saveAndLoadProperties();
		sample.saveAndLoadPropertiesXML();
	}

	public void checkProperties() {
		// TODO Auto-generated method stub
		Properties prop = System.getProperties();
		Set<Object> keySet =prop.keySet();
		for(Object tempObject:keySet) {
			System.out.println(tempObject+"="+prop.get(tempObject));
		}
	}
	public void saveAndLoadProperties() {
		try {
			String fileName="test.properties";
			File propertiesFile =new File(fileName);
			FileOutputStream fos =new FileOutputStream(propertiesFile);
			Properties prop= new Properties();
			prop.setProperty("writer", "sangmin, Lee");
			prop.setProperty("writerHome", "Http://www.GodogJava.com");
			prop.store(fos, "Basic properties File.");
			fos.close();
			FileInputStream fis = new FileInputStream(propertiesFile);
			Properties propLoaded = new Properties();
			propLoaded.load(fis);
			fis.close();
			System.out.println(propLoaded);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void saveAndLoadPropertiesXML() {
		try {
			String filename="text.xml";
			File propertiesFile = new File(filename);
			FileOutputStream fos = new FileOutputStream(propertiesFile);
			Properties prop = new Properties();
			prop.setProperty("Writer", "sungwoo,woo");
			prop.setProperty("WriterHome","Http://www.GodOfJava.com");
			prop.storeToXML(fos, "Basic XML Property File.");
			fos.close();
			
			FileInputStream fis = new FileInputStream(propertiesFile);
			Properties propLoaded = new Properties();
			propLoaded.loadFromXML(fis);
			System.out.println(propLoaded);
			fis.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
