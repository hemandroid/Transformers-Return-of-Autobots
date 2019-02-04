
package github.hemandroid.transformerswar.TransformerModelData.transformersList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TransformersListResponse {

    @SerializedName("transformers")
    @Expose
    private List<TransformerData> transformers = null;

    public List<TransformerData> getTransformers() {
        return transformers;
    }

    public void setTransformers(List<TransformerData> transformers) {
        this.transformers = transformers;
    }

}
