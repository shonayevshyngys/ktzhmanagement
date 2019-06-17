package server.client_model;

public class Additional_group_ids {
    private String group_id;

    public String getGroup_id ()
    {
        return group_id;
    }

    public void setGroup_id (String group_id)
    {
        this.group_id = group_id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [group_id = "+group_id+"]";
    }
}
