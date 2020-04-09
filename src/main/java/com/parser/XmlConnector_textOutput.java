package com.parser;

import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;  
import org.w3c.dom.Node;  
import org.w3c.dom.Element;  
import java.io.File;
import java.io.FileWriter;  
public class XmlConnector_textOutput 
{  
	public static void main(String argv[])   
	{  
		try   
		{  

			FileWriter fw=new FileWriter(".\\testout.txt");    
			//creating a constructor of file class and parsing an XML file  
			File file = new File(".\\TestFile.xml");  
			//an instance of factory that gives a document builder  
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
			//an instance of builder to parse the specified xml file  
			DocumentBuilder db = dbf.newDocumentBuilder();  
			Document doc = db.parse(file);  
			doc.getDocumentElement().normalize();  
			/*System.out.println("Root element: " + doc.getDocumentElement().getNodeName()); */ 
			NodeList nodeList = doc.getElementsByTagName("student");  
			// nodeList is not iterable, so we are using for loop  
			for (int itr = 0; itr < nodeList.getLength(); itr++)   
			{  
				Node node = nodeList.item(itr);  
				/*System.out.println("\nNode Name :" + node.getNodeName());  */
				if (node.getNodeType() == Node.ELEMENT_NODE)   
				{  
					Element eElement = (Element) node;  
					/*System.out.println("Student id: "+ eElement.getElementsByTagName("id").item(0).getTextContent()); */
					String id =eElement.getElementsByTagName("id").item(0).getTextContent().toString();
					String FirstName = eElement.getElementsByTagName("firstname").item(0).getTextContent().toString();
					String LastName =  eElement.getElementsByTagName("lastname").item(0).getTextContent().toString();
					String subject =   eElement.getElementsByTagName("subject").item(0).getTextContent().toString();
					String Marks = eElement.getElementsByTagName("marks").item(0).getTextContent().toString();
					String Consolidated =id+" "+FirstName+" "+LastName+" "+subject+" "+Marks;
					System.out.println(Consolidated);

					fw.write("Student  " +Consolidated);
					fw.write("\n");

					/*System.out.println("First Name: "+ eElement.getElementsByTagName("firstname").item(0).getTextContent());  
System.out.println("Last Name: "+ eElement.getElementsByTagName("lastname").item(0).getTextContent());  
System.out.println("Subject: "+ eElement.getElementsByTagName("subject").item(0).getTextContent());  
System.out.println("Marks: "+ eElement.getElementsByTagName("marks").item(0).getTextContent()); */ 
				}  
			}  
			fw.close();
		}   
		catch (Exception e)   
		{  
			e.printStackTrace();  
		}  
	}  
}  