package com.ss.saga.employeemanagement.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;

/**
 * @author pradeshp
 *
 */
public class XMLConverter {

  private Marshaller marshaller;

  private Unmarshaller unMarshaller;

  /**
   * @return marshaller
   */
  public Marshaller getMarshaller() {

    return this.marshaller;
  }

  /**
   * @param marshaller new value of {@link #getmarshaller}.
   */
  public void setMarshaller(Marshaller marshaller) {

    this.marshaller = marshaller;
  }

  /**
   * @return unMarshaller
   */
  public Unmarshaller getUnMarshaller() {

    return this.unMarshaller;
  }

  /**
   * @param unMarshaller new value of {@link #getunMarshaller}.
   */
  public void setUnMarshaller(Unmarshaller unMarshaller) {

    this.unMarshaller = unMarshaller;
  }

  public void converObJectToXml(Object entityObj, String xmlFilePath) throws XmlMappingException, IOException {

    FileOutputStream fos = null;
    try {
      fos = new FileOutputStream(xmlFilePath);
      getMarshaller().marshal(entityObj, new StreamResult(fos));
    } finally {
      if (fos != null) {

        fos.close();
      }
    }
  }

  public Object convertXmlToObject(String xmlFilePath) throws FileNotFoundException, IOException, XmlMappingException {

    FileInputStream fis = null;
    try {
      fis = new FileInputStream(xmlFilePath);
      return getUnMarshaller().unmarshal(new StreamSource(fis));
    } finally {
      if (fis != null) {
        fis.close();
      }
    }
  }
}
