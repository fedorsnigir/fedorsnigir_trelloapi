
package beans;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Board {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("desc")
    @Expose
    public String desc;
    @SerializedName("descData")
    @Expose
    public Object descData;
    @SerializedName("closed")
    @Expose
    public Boolean closed;
    @SerializedName("idOrganization")
    @Expose
    public String idOrganization;
    @SerializedName("invited")
    @Expose
    public Boolean invited;
    @SerializedName("memberships")
    @Expose
    public List<Membership> memberships = new ArrayList<Membership>();
    @SerializedName("pinned")
    @Expose
    public Boolean pinned;
    @SerializedName("starred")
    @Expose
    public Boolean starred;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("prefs")
    @Expose
    public Prefs prefs;
    @SerializedName("invitations")
    @Expose
    public List<Object> invitations = new ArrayList<Object>();
    @SerializedName("shortLink")
    @Expose
    public String shortLink;
    @SerializedName("subscribed")
    @Expose
    public Boolean subscribed;
    @SerializedName("labelNames")
    @Expose
    public LabelNames labelNames;
    @SerializedName("powerUps")
    @Expose
    public List<Object> powerUps = new ArrayList<Object>();
    @SerializedName("dateLastActivity")
    @Expose
    public String dateLastActivity;
    @SerializedName("dateLastView")
    @Expose
    public String dateLastView;
    @SerializedName("shortUrl")
    @Expose
    public String shortUrl;
    @SerializedName("idTags")
    @Expose
    public List<Object> idTags = new ArrayList<Object>();
    @SerializedName("datePluginDisable")
    @Expose
    public Object datePluginDisable;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("desc", desc).append("descData", descData).append("closed", closed).append("idOrganization", idOrganization).append("invited", invited).append("memberships", memberships).append("pinned", pinned).append("starred", starred).append("url", url).append("prefs", prefs).append("invitations", invitations).append("shortLink", shortLink).append("subscribed", subscribed).append("labelNames", labelNames).append("powerUps", powerUps).append("dateLastActivity", dateLastActivity).append("dateLastView", dateLastView).append("shortUrl", shortUrl).append("idTags", idTags).append("datePluginDisable", datePluginDisable).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(descData).append(idTags).append(pinned).append(labelNames).append(shortUrl).append(invited).append(dateLastActivity).append(datePluginDisable).append(shortLink).append(memberships).append(url).append(prefs).append(subscribed).append(starred).append(invitations).append(name).append(idOrganization).append(dateLastView).append(closed).append(id).append(desc).append(powerUps).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Board) == false) {
            return false;
        }
        Board rhs = ((Board) other);
        return new EqualsBuilder().append(descData, rhs.descData).append(idTags, rhs.idTags).append(pinned, rhs.pinned).append(labelNames, rhs.labelNames).append(shortUrl, rhs.shortUrl).append(invited, rhs.invited).append(dateLastActivity, rhs.dateLastActivity).append(datePluginDisable, rhs.datePluginDisable).append(shortLink, rhs.shortLink).append(memberships, rhs.memberships).append(url, rhs.url).append(prefs, rhs.prefs).append(subscribed, rhs.subscribed).append(starred, rhs.starred).append(invitations, rhs.invitations).append(name, rhs.name).append(idOrganization, rhs.idOrganization).append(dateLastView, rhs.dateLastView).append(closed, rhs.closed).append(id, rhs.id).append(desc, rhs.desc).append(powerUps, rhs.powerUps).isEquals();
    }

}
