package projecto.jhpiego.equipment_track_tools.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import projecto.jhpiego.equipment_track_tools.R;

import java.util.ArrayList;

import projecto.jhpiego.equipment_track_tools.model.Equipment_inventory;

public class Equipment_inventory_custom_adapter extends ArrayAdapter<Equipment_inventory> {

    private ArrayList<Equipment_inventory> dataSet;
    Context mContext;

    private static class ViewHolder {

    }

    public Equipment_inventory_custom_adapter(ArrayList<Equipment_inventory> data, Context context) {
        super(context, R.layout.inventory, data);
        this.dataSet = data;
        this.mContext = context;

    }

    private int lastPosition = -1;

  @Override
  public View getView(int position, View row, ViewGroup parent) {
   //   row = getLayoutInflater().inflate(R.layout.inventory, null);
      LayoutInflater inflater = LayoutInflater.from(getContext());
      row = inflater.inflate(R.layout.inventory, parent, false);

   /*   TextView dept_id = row.findViewById(R.id.invent_id);
      dept_id.setText(dataSet.get(position).getId());*/

      TextView department = row.findViewById(R.id.txt_dept);
      department.setText(dataSet.get(position).getDepartment());

   /*   TextView type = row.findViewById(R.id.txt_type);
      type.setText(dataSet.get(position).getTypeEquipment());*/
      return row;
  }
}

