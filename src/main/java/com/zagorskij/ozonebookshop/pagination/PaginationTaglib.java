package com.zagorskij.ozonebookshop.pagination;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by andrey on 21.07.2015.
 */
public class PaginationTaglib extends SimpleTagSupport{
    private String uri;
    private int offset;
    private int count;
    private int max=10;
    private int steps=10;
    private String previous="Previous";
    private String next="Next";

    private Writer getWriter(){
        JspWriter out= getJspContext().getOut();
        return out;
    }

    @Override
    public void doTag()throws JspException{
        Writer out = getWriter();
        try{
            out.write("<nav>");
            out.write("<ul class=\"pagination\">");

            if(offset<steps)
                out.write(constructLink() );
        } catch (){

        }
    }

    private String constructLink() {
    }
}
