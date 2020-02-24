
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class LabelNames {

    @SerializedName("green")
    @Expose
    public String green;
    @SerializedName("yellow")
    @Expose
    public String yellow;
    @SerializedName("orange")
    @Expose
    public String orange;
    @SerializedName("red")
    @Expose
    public String red;
    @SerializedName("purple")
    @Expose
    public String purple;
    @SerializedName("blue")
    @Expose
    public String blue;
    @SerializedName("sky")
    @Expose
    public String sky;
    @SerializedName("lime")
    @Expose
    public String lime;
    @SerializedName("pink")
    @Expose
    public String pink;
    @SerializedName("black")
    @Expose
    public String black;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("green", green).append("yellow", yellow).append("orange", orange).append("red", red).append("purple", purple).append("blue", blue).append("sky", sky).append("lime", lime).append("pink", pink).append("black", black).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(orange).append(red).append(sky).append(pink).append(green).append(blue).append(lime).append(yellow).append(black).append(purple).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LabelNames) == false) {
            return false;
        }
        LabelNames rhs = ((LabelNames) other);
        return new EqualsBuilder().append(orange, rhs.orange).append(red, rhs.red).append(sky, rhs.sky).append(pink, rhs.pink).append(green, rhs.green).append(blue, rhs.blue).append(lime, rhs.lime).append(yellow, rhs.yellow).append(black, rhs.black).append(purple, rhs.purple).isEquals();
    }

}
