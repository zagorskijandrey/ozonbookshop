package com.zagorskij.ozonebookshop.unmarshal;

import org.springframework.oxm.Unmarshaller;

import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by andrey on 14.06.2015.
 */
public class ProcessUnmarshaller {
    private Unmarshaller unmarshaller;

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }
    public Object xmlToObject(String url) throws IOException {
        InputStream input = null;
        try {
            input = new URL(url).openStream();
            return unmarshaller.unmarshal(new StreamSource(input));
        } finally {
            input.close();
        }
    }
}
