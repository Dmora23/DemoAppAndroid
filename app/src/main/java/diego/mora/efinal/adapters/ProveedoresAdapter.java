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

public class ProveedoresAdapter extends RecyclerView.Adapter<ProveedoresAdapter.ViewHolder> {
    ArrayList<HashMap<String,String>> arrayList;

    public ProveedoresAdapter(ArrayList<HashMap<String, String>> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_categoria,parent, false);
        return new ProveedoresAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HashMap<String,String> map = arrayList.get(position);

        holder.mtvProveedorId.setText(map.get("idcliente"));
        holder.mtvProvNombreEmp.setText(map.get("empresa"));
        holder.mtvProvCargo.setText(map.get("cargo"));
        holder.mtvProvNombreContac.setText(map.get("nombres"));
        holder.mtvProvPais.setText(map.get("pais"));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView mtvProveedorId, mtvProvNombreEmp, mtvProvCargo, mtvProvNombreContac, mtvProvPais;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mtvProveedorId = itemView.findViewById(R.id.tvProveedorid);
            mtvProvNombreEmp = itemView.findViewById(R.id.tvProveedorempresa);
            mtvProvCargo = itemView.findViewById(R.id.tvProveedorcargo);
            mtvProvNombreContac = itemView.findViewById(R.id.tvProvNomreContac);
            mtvProvPais = itemView.findViewById(R.id.tvProvpais);
        }
    }
}
