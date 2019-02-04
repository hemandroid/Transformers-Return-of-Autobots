package github.hemandroid.transformerswar.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import github.hemandroid.transformerswar.MainActivity;
import github.hemandroid.transformerswar.R;
import github.hemandroid.transformerswar.TransformerModelData.transformersList.TransformerData;
import github.hemandroid.transformerswar.databinding.ItemTransformerdataBinding;

public class TransformersRecyclerListAdapter extends RecyclerView.Adapter
        <TransformersRecyclerListAdapter.TransformerDataHolder> {

    private List<TransformerData> loadTransformerData;
    private Context mContext;

    public TransformersRecyclerListAdapter(MainActivity mainActivity, List<TransformerData> loadTransformerData) {
        this.mContext = mainActivity;
        this.loadTransformerData = loadTransformerData;
    }


    @NonNull
    @Override
    public TransformerDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTransformerdataBinding itemTransformerdataBinding = DataBindingUtil.inflate(LayoutInflater.from(
                parent.getContext()), R.layout.item_transformerdata, parent, false);
        return new TransformerDataHolder(itemTransformerdataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TransformerDataHolder holder, int position) {
        String team_icon = loadTransformerData.get(position).getTeamIcon();
        if (team_icon != null) {
            Glide.with(mContext).load(team_icon).diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .into(holder.itemTransformerdataBinding.transformerIcon);
        }
        if (loadTransformerData != null) {
            holder.itemTransformerdataBinding.transformerName.setText(loadTransformerData.get(position).getName());
            holder.itemTransformerdataBinding.intelligenceValue.setText(
                    String.valueOf(loadTransformerData.get(position).getIntelligence()));
            holder.itemTransformerdataBinding.firepowerValue.setText(
                    String.valueOf(loadTransformerData.get(position).getFirepower()));
            holder.itemTransformerdataBinding.strengthValue.setText(
                    String.valueOf(loadTransformerData.get(position).getStrength()));
            holder.itemTransformerdataBinding.rankNumber.setText(
                    String.valueOf(loadTransformerData.get(position).getRank()));
            holder.itemTransformerdataBinding.speedValue.setText(
                    String.valueOf(loadTransformerData.get(position).getSpeed()));
            holder.itemTransformerdataBinding.skillValue.setText(
                    String.valueOf(loadTransformerData.get(position).getSkill()));
            holder.itemTransformerdataBinding.teamValue.setText(
                    loadTransformerData.get(position).getTeam());
            holder.itemTransformerdataBinding.courageValue.setText(
                    String.valueOf(loadTransformerData.get(position).getCourage()));
            holder.itemTransformerdataBinding.enduranceValue.setText(
                    String.valueOf(loadTransformerData.get(position).getEndurance()));
        }

    }

    @Override
    public int getItemCount() {
        return loadTransformerData.size();
    }

    public class TransformerDataHolder extends RecyclerView.ViewHolder {

        ItemTransformerdataBinding itemTransformerdataBinding;

        public TransformerDataHolder(@NonNull ItemTransformerdataBinding itemView) {
            super(itemView.getRoot());
            this.itemTransformerdataBinding = itemView;
        }
    }
}
