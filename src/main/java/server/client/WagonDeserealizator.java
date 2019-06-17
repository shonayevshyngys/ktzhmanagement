package server.client;

import server.client_model.Data;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class WagonDeserealizator {
    public static Data getData(String xmlString) throws JAXBException {
        JAXBContext jc = null;
        try {
            jc = JAXBContext.newInstance(Data.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        Unmarshaller unmarshaller = null;
        if (jc != null) {
            unmarshaller = jc.createUnmarshaller();
        } else {
            System.out.println("Unmarhsaller error!");
        }

        if (unmarshaller != null) {
            return (Data) unmarshaller.unmarshal(new StringReader(xmlString));
        } else {
            System.out.println("Unmarshaller error No2!");
            return new Data();
        }
    }
}
