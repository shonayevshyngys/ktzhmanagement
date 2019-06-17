package server.client_model;



import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;

public class Vagon_type_desc { @JacksonXmlElementWrapper(useWrapping=false)
    private List<String> name;

    private Common_type common_type;

    private String type_code;

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public Common_type getCommon_type ()
    {
        return common_type;
    }

    public void setCommon_type (Common_type common_type)
    {
        this.common_type = common_type;
    }

    public String getType_code ()
    {
        return type_code;
    }

    public void setType_code (String type_code)
    {
        this.type_code = type_code;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+", common_type = "+common_type+", type_code = "+type_code+"]";
    }
}
