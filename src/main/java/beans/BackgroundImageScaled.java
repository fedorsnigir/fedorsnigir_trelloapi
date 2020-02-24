
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class BackgroundImageScaled {

    @SerializedName("width")
    @Expose
    public Integer width;
    @SerializedName("height")
    @Expose
    public Integer height;
    @SerializedName("url")
    @Expose
    public String url;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("width", width).append("height", height).append("url", url).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(width).append(url).append(height).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BackgroundImageScaled) == false) {
            return false;
        }
        BackgroundImageScaled rhs = ((BackgroundImageScaled) other);
        return new EqualsBuilder().append(width, rhs.width).append(url, rhs.url).append(height, rhs.height).isEquals();
    }

}
