package diego.mora.efinal.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

import diego.mora.efinal.R;

public class SueldosAdapter extends RecyclerView.Adapter<SueldosAdapter.ViewHolder> {
    ArrayList<HashMap<String,String>> arrayList;

    public SueldosAdapter(ArrayList<HashMap<String,String>> arrayList){
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sueldos,parent, false);
        return new SueldosAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HashMap<String,String> map = arrayList.get(position);

        holder.mtvSueldosId.setText(map.get("idsueldos"));
        holder.mtvSueldosbasico.setText(map.get("Sueldobasico"));
        holder.mtvSueldosboni.setText(map.get("Bonificacion"));
        holder.mtvSueldostotal.setText(map.get("Sueldototal"));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mtvSueldosId, mtvSueldosbasico, mtvSueldosboni, mtvSueldostotal;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mtvSueldosId = itemView.findViewById(R.id.tvSueldoid);
            mtvSueldosbasico = itemView.findViewById(R.id.tvSueldobasico);
            mtvSueldosboni = itemView.findViewById(R.id.tvSueldoboni);
            mtvSueldostotal = itemView.findViewById(R.id.tvSueldoTotal);
        }
    }
}
