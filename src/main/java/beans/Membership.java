
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Membership {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("idMember")
    @Expose
    public String idMember;
    @SerializedName("memberType")
    @Expose
    public String memberType;
    @SerializedName("unconfirmed")
    @Expose
    public Boolean unconfirmed;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("idMember", idMember).append("memberType", memberType).append("unconfirmed", unconfirmed).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(unconfirmed).append(id).append(memberType).append(idMember).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Membership) == false) {
            return false;
        }
        Membership rhs = ((Membership) other);
        return new EqualsBuilder().append(unconfirmed, rhs.unconfirmed).append(id, rhs.id).append(memberType, rhs.memberType).append(idMember, rhs.idMember).isEquals();
    }

}
