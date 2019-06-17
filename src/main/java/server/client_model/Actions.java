package server.client_model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Actions {

    private long id;
    private Timestamp actionTime;
    private String actionType;
    private Long companyId;

    @Id
    @Basic
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "action_time", nullable = true)
    public Timestamp getActionTime() {
        return actionTime;
    }

    public void setActionTime(Timestamp actionTime) {
        this.actionTime = actionTime;
    }

    @Basic
    @Column(name = "action_type", nullable = true)
    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    @Basic
    @Column(name = "company_id", nullable = true)
    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actions actions = (Actions) o;
        return id == actions.id &&
                Objects.equals(actionTime, actions.actionTime) &&
                Objects.equals(actionType, actions.actionType) &&
                Objects.equals(companyId, actions.companyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, actionTime, actionType, companyId);
    }
}
