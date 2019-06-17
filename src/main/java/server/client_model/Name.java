package server.client_model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Name {
    @JacksonXmlProperty(isAttribute = true)
    private String lang;
    private String content;

    public String getLang ()
    {
        return lang;
    }

    public void setLang (String lang)
    {
        this.lang = lang;
    }

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [lang = "+lang+", content = "+content+"]";
    }
}
