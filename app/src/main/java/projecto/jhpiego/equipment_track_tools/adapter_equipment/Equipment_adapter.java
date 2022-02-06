package projecto.jhpiego.equipment_track_tools.adapter_equipment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.model.Department;
import projecto.jhpiego.equipment_track_tools.model.Equipment;

public class Equipment_adapter extends ArrayAdapter<Equipment> {
    private Context context;
    private int layout;
    private List<Equipment> equipments;

//    public Department_adapter(ArrayList<Department> data, Context context) {
//        super(context, R.layout.department, data);
//        this.dados = data;
//        this.context = context;
//    }


    //   private int lastPos = -1;

    public Equipment_adapter(@NonNull Context context, int resource, @NonNull List<Equipment> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layout = resource;
        this.equipments = objects;
    }

//    @Override
//    public View getView(int position, View row, ViewGroup parent) {
//        LayoutInflater inflater = LayoutInflater.from(getContext());
//        row = inflater.inflate(R.layout.department, parent, false);
//
//        TextView dept_id = row.findViewById(R.id.department_id);
//        dept_id.setText(dados.get(position).getId()+"");
//
//        TextView nome = row.findViewById(R.id.txt_dept);
//        nome.setText(dados.get(position).getNome_department());
//        return row;
//    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Equipment equipment = equipments.get(position);
        View view = LayoutInflater.from(context).inflate(layout, null);
        TextView equip_nome = view.findViewById(R.id.id_equip_layout);
        equip_nome.setText(equipment.getNome_equipment());
        return view;
    }
}