package server.client_model;

public class User {
    private String funds;

    private String currency;

    private String login;

    public String getFunds ()
    {
        return funds;
    }

    public void setFunds (String funds)
    {
        this.funds = funds;
    }

    public String getCurrency ()
    {
        return currency;
    }

    public void setCurrency (String currency)
    {
        this.currency = currency;
    }

    public String getLogin ()
    {
        return login;
    }

    public void setLogin (String login)
    {
        this.login = login;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [funds = "+funds+", currency = "+currency+", login = "+login+"]";
    }
}
