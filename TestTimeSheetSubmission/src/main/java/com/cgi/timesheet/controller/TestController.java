package com.cgi.timesheet.controller;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.timesheet.models.entity.FileTableType;
import com.cgi.timesheet.models.entity.ParaType;

/**
 * @author HDMI
 *
 */
@SuppressWarnings("unused")
@CrossOrigin(origins = "http://localhost:4200")
@ComponentScan(basePackages = "com")
@RestController
public class TestController {
	
	
	public static String convertObjectToXML(Object object) throws Exception {
		System.out.println("convertObjectToXML");
		StringWriter stringWriter = new StringWriter();
		JAXBContext jc = JAXBContext.newInstance(
				new Class[] { FileTableType.class, ParaType.class });
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(object, stringWriter);
		System.out.println(stringWriter.toString());
		return stringWriter.toString();
	}

	public static String marshal(Object object) throws JAXBException {
		System.out.println("marshal");
		StringWriter stringWriter = new StringWriter();
		JAXBContext jc = JAXBContext.newInstance(object.getClass());
		Marshaller m = jc.createMarshaller();
		m.marshal(object, stringWriter);
		System.out.println(stringWriter.toString());
		return stringWriter.toString();
	}

	public static <E> ArrayList<E> toList(Iterable<E> iterable) {
		System.out.println("toList");
		if (iterable instanceof List) {
			return (ArrayList<E>) iterable;
		}
		ArrayList<E> list = new ArrayList<E>();
		if (iterable != null) {
			for (E e : iterable) {
				list.add(e);
			}
		}
		return list;
	}

	public static String marshalToJson(Object o) throws Exception {
		System.out.println("marshalToJson");
		ObjectMapper mapper = new ObjectMapper();
		String jsonVal = "";
		jsonVal = mapper.writeValueAsString(o);
		return jsonVal;
	}

	/*
	 * public static void listFilesForFolder(final File folder) { for (final File
	 * fileEntry : folder.listFiles()) { if (fileEntry.isDirectory())
	 * listFilesForFolder(fileEntry); else if (fileEntry.isFile())
	 * filesInDir.add(folder.getAbsolutePath() + "\\" + fileEntry.getName()); } }
	 */

}