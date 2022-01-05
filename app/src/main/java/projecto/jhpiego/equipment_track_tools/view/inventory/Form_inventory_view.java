package projecto.jhpiego.equipment_track_tools.view.inventory;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import projecto.jhpiego.equipment_track_tools.R;

import projecto.jhpiego.equipment_track_tools.adapter.Equipment_inventory_custom_adapter;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Database_connection;
import projecto.jhpiego.equipment_track_tools.model.Equipment_inventory;
import projecto.jhpiego.equipment_track_tools.variaveis.Variaveis;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class Form_inventory_view extends AppCompatActivity {


    ListView listView;
    FloatingActionButton add_button;

    Database_connection database_connection;
    ArrayList<Equipment_inventory> equipment_inventoryArrayList;
    private static Equipment_inventory_custom_adapter equipment_inventory_adapter;

    ImageView imageView;
    TextView textView;

    String[] mensagens = {"Sem dados para mostrar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_equipment);
        Init_components();

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Form_inventory_view.this, FormEquipInventory.class);
                startActivity(intent);
            }
        });

        equipment_inventoryArrayList = new ArrayList<>();
        database_connection = new Database_connection(Form_inventory_view.this);

        Display_inventory();

        equipment_inventory_adapter = new Equipment_inventory_custom_adapter(equipment_inventoryArrayList, getApplicationContext());
        listView.setAdapter(equipment_inventory_adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Equipment_inventory dataModel = equipment_inventoryArrayList.get(position);
                Variaveis.equipment_inventory = equipment_inventoryArrayList.get(position);
                Intent i = new Intent(Form_inventory_view.this, Update_equipm_inventory.class);
                startActivity(i);

              /*  Snackbar.make(view, dataModel.getId() + dataModel.getDepartment() + dataModel.getTypeEquipment() + dataModel.getInventory_number()
                        + dataModel.getMake() + dataModel.getModel() + dataModel.getSerial_number() + dataModel.getYear_install()
                        + dataModel.getData_last_main() + dataModel.getEquipment_condition(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();*/

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            recreate();
        }
    }

    void Display_inventory() {
        Cursor cursor = database_connection.readAllData();
        if (cursor.getCount() == 0) {
            imageView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.VISIBLE);
        } else {
            while (cursor.moveToNext()) {
                Equipment_inventory equipment_inventory = new Equipment_inventory();
                equipment_inventory.setId(cursor.getInt(0));
                equipment_inventory.setDepartmenty(cursor.getString(1));
                equipment_inventory.setTypeEquipment(cursor.getString(2));
                equipment_inventory.setInventory_number(cursor.getString(3));
                equipment_inventory.setMake(cursor.getString(4));
                equipment_inventory.setModel(cursor.getString(5));
                equipment_inventory.setSerial_number(cursor.getString(6));
                equipment_inventory.setEquipment_condition(cursor.getString(7));
                equipment_inventory.setYear_install(cursor.getString(8));
                equipment_inventory.setMain_contract(cursor.getString(9));
                equipment_inventory.setData_last_main(cursor.getString(10));
                equipment_inventory.setComments(cursor.getString(11));
                equipment_inventoryArrayList.add(equipment_inventory);
            }
            imageView.setVisibility(View.GONE);
            textView.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.delete_all) {
            confirmDialog();
        }

        return super.onOptionsItemSelected(item);
    }

    private void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Remover todos registos?");
        builder.setMessage("Pretende apagar todos registos?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Database_connection database_connection = new Database_connection(Form_inventory_view.this);
                database_connection.deleteAllData();
                Intent intent = new Intent(Form_inventory_view.this, Form_inventory_view.class);
                startActivity(intent);
                finish();
            }
        });

        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }

    private void Init_components() {
        listView = (ListView) findViewById(R.id.list_view);
        add_button = findViewById(R.id.add_button);
        imageView = findViewById(R.id.id_image);
        textView = findViewById(R.id.id_no_data);
    }
}