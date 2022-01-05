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

    // View lookup cache
    private static class ViewHolder {

    }

    public Equipment_inventory_custom_adapter(ArrayList<Equipment_inventory> data, Context context) {
        super(context, R.layout.inventory, data);
        this.dataSet = data;
        this.mContext = context;

    }

 /*   @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Equipment_inventory equipment_inventory=(Equipment_inventory)object;

        switch (v.getId())
        {
            case R.id.item_info:
                Snackbar.make(v, "Release date " +equipment_inventory.getFeature(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                break;
        }
    }*/

    private int lastPosition = -1;

  /*  @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Equipment_inventory equipment_inventory = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.inventory, parent, false);
            viewHolder.id = (TextView) convertView.findViewById(R.id.invent_id);
            viewHolder.txtDept = (TextView) convertView.findViewById(R.id.txt_dept);
            viewHolder.txtTypeEquip = (TextView) convertView.findViewById(R.id.txt_type);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        //     Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        // result.startAnimation(animation);
        lastPosition = position;

        viewHolder.id.setText(equipment_inventory.getId());
        viewHolder.txtDept.setText(equipment_inventory.getDepartment());
        viewHolder.txtTypeEquip.setText(equipment_inventory.getTypeEquipment());
        //   viewHolder.info.setOnClickListener(this);
        //  viewHolder.info.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }*/
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

