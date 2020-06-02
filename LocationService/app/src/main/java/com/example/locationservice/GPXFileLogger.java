package com.example.locationservice;

import android.content.Context;
import android.location.Location;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class GPXFileLogger {

    public static GPXFileLogger gpxFileLogger = null;
    File logFile = null;
    FileOutputStream fOut = null;
    DocumentBuilderFactory domFactory = null;
    DocumentBuilder builder = null;
    Document document = null;
    Element gpx = null;
    Element trk = null;
    Element trkseg = null;
    public static Context context;

    public GPXFileLogger() throws ParserConfigurationException, FileNotFoundException {
            logFile = new File(context.getExternalFilesDir(null), "log.gpx");
            fOut = new FileOutputStream(logFile);
            domFactory = DocumentBuilderFactory.newInstance();
            builder = domFactory.newDocumentBuilder();

            document = builder.newDocument();
            gpx = document.createElement("gpx");
            document.appendChild(gpx);

            trk = document.createElement("trk");
            gpx.appendChild(trk);

            trkseg = document.createElement("trkseg");
            trk.appendChild(trkseg);
    }

    public static GPXFileLogger getInstance() throws FileNotFoundException, ParserConfigurationException {
        if(gpxFileLogger == null) {
            gpxFileLogger = new GPXFileLogger();
        }
        return gpxFileLogger;
    }

    public void log(Location location) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

        Element trkpt = document.createElement("trkpt");
        Element time = document.createElement("time");
        trkpt.setAttribute("lat", String.valueOf(location.getLatitude()));
        trkpt.setAttribute("lon", String.valueOf(location.getLongitude()));


        Date date = new Date(location.getTime());
        time.setTextContent(format.format(date));

        trkseg.appendChild(trkpt);
        trkpt.appendChild(time);
    }

    public void closeWriter() {
        try {

            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(logFile);
            transformer.transform(source, result);

            fOut.flush();
            fOut.close();
        }
        catch (IOException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
