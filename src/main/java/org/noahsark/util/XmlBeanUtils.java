package org.noahsark.util;

import com.sun.org.apache.xml.internal.serialize.LineSeparator;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.sax.SAXResult;
import java.io.ByteArrayOutputStream;

public class XmlBeanUtils {

    /**
     * 将javaBean转换为xml对象
     *
     * @param clazz
     * @param bean
     * @return
     */
    public static String parseBean2Xml(Class<?> clazz, Object bean) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Marshaller marshaller = jaxbContext.createMarshaller();

            // configure an OutputFormat to handle CDATA
            OutputFormat of = new OutputFormat();
            of.setCDataElements(
                    new String[] { "^trans",
                            "^phonetic"
                    }); //

            // set any other options you'd like
            of.setPreserveSpace(true);
            of.setIndenting(true);
            of.setOmitXMLDeclaration(true);
            // create the serializer
            ByteArrayOutputStream op = new ByteArrayOutputStream();
            XMLSerializer serializer = new XMLSerializer(op, of);
            SAXResult result = new SAXResult(serializer.asContentHandler());

            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(bean, result);

            return op.toString("utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }
}
