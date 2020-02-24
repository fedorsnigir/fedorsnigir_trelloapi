
package beans;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Prefs {

    @SerializedName("permissionLevel")
    @Expose
    public String permissionLevel;
    @SerializedName("voting")
    @Expose
    public String voting;
    @SerializedName("comments")
    @Expose
    public String comments;
    @SerializedName("invitations")
    @Expose
    public String invitations;
    @SerializedName("selfJoin")
    @Expose
    public Boolean selfJoin;
    @SerializedName("cardCovers")
    @Expose
    public Boolean cardCovers;
    @SerializedName("cardAging")
    @Expose
    public String cardAging;
    @SerializedName("calendarFeedEnabled")
    @Expose
    public Boolean calendarFeedEnabled;
    @SerializedName("background")
    @Expose
    public String background;
    @SerializedName("backgroundImage")
    @Expose
    public String backgroundImage;
    @SerializedName("backgroundImageScaled")
    @Expose
    public List<BackgroundImageScaled> backgroundImageScaled = new ArrayList<BackgroundImageScaled>();
    @SerializedName("backgroundTile")
    @Expose
    public Boolean backgroundTile;
    @SerializedName("backgroundBrightness")
    @Expose
    public String backgroundBrightness;
    @SerializedName("backgroundBottomColor")
    @Expose
    public String backgroundBottomColor;
    @SerializedName("backgroundTopColor")
    @Expose
    public String backgroundTopColor;
    @SerializedName("canBePublic")
    @Expose
    public Boolean canBePublic;
    @SerializedName("canBeOrg")
    @Expose
    public Boolean canBeOrg;
    @SerializedName("canBePrivate")
    @Expose
    public Boolean canBePrivate;
    @SerializedName("canInvite")
    @Expose
    public Boolean canInvite;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("permissionLevel", permissionLevel).append("voting", voting).append("comments", comments).append("invitations", invitations).append("selfJoin", selfJoin).append("cardCovers", cardCovers).append("cardAging", cardAging).append("calendarFeedEnabled", calendarFeedEnabled).append("background", background).append("backgroundImage", backgroundImage).append("backgroundImageScaled", backgroundImageScaled).append("backgroundTile", backgroundTile).append("backgroundBrightness", backgroundBrightness).append("backgroundBottomColor", backgroundBottomColor).append("backgroundTopColor", backgroundTopColor).append("canBePublic", canBePublic).append("canBeOrg", canBeOrg).append("canBePrivate", canBePrivate).append("canInvite", canInvite).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(backgroundBrightness).append(comments).append(backgroundTopColor).append(backgroundImage).append(canBeOrg).append(backgroundBottomColor).append(voting).append(calendarFeedEnabled).append(backgroundTile).append(canBePublic).append(canBePrivate).append(backgroundImageScaled).append(permissionLevel).append(cardAging).append(canInvite).append(invitations).append(background).append(cardCovers).append(selfJoin).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Prefs) == false) {
            return false;
        }
        Prefs rhs = ((Prefs) other);
        return new EqualsBuilder().append(backgroundBrightness, rhs.backgroundBrightness).append(comments, rhs.comments).append(backgroundTopColor, rhs.backgroundTopColor).append(backgroundImage, rhs.backgroundImage).append(canBeOrg, rhs.canBeOrg).append(backgroundBottomColor, rhs.backgroundBottomColor).append(voting, rhs.voting).append(calendarFeedEnabled, rhs.calendarFeedEnabled).append(backgroundTile, rhs.backgroundTile).append(canBePublic, rhs.canBePublic).append(canBePrivate, rhs.canBePrivate).append(backgroundImageScaled, rhs.backgroundImageScaled).append(permissionLevel, rhs.permissionLevel).append(cardAging, rhs.cardAging).append(canInvite, rhs.canInvite).append(invitations, rhs.invitations).append(background, rhs.background).append(cardCovers, rhs.cardCovers).append(selfJoin, rhs.selfJoin).isEquals();
    }

}
