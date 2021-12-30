package projecto.jhpiego.equipment_track_tools.view.inventory;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.adapter.Equipment_inventory_adapter;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Database_connection;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class Form_inventory_view extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;

    Database_connection database_connection;
    ArrayList<String> id, txtDept, txtTypeEquip, txtInvent_number, txtMake, txtModel, txtSerialNumber;
    ArrayList<String> txtEquipCondition, txtYearInstall, txtContract_man, txtData_last_man, txtComment;
    Equipment_inventory_adapter equipment_inventory_adapter;

    ImageView imageView;
    TextView textView;

    String[] mensagens = {"Sem dados para mostrar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_inventory_view);

        Init_components();

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Form_inventory_view.this, FormEquipInventory.class);
                startActivity(intent);
            }
        });

        database_connection = new Database_connection(Form_inventory_view.this);
        id = new ArrayList<>();
        txtDept = new ArrayList<>();
        txtTypeEquip = new ArrayList<>();
        txtInvent_number = new ArrayList<>();
        txtMake = new ArrayList<>();
        txtModel = new ArrayList<>();
        txtSerialNumber = new ArrayList<>();
        txtEquipCondition = new ArrayList<>();
        txtYearInstall = new ArrayList<>();
        txtContract_man = new ArrayList<>();
        txtData_last_man = new ArrayList<>();
        txtComment = new ArrayList<>();

        Display_inventory();

        equipment_inventory_adapter = new Equipment_inventory_adapter(Form_inventory_view.this, this, id, txtDept, txtTypeEquip, txtInvent_number,
                txtMake, txtModel, txtSerialNumber, txtEquipCondition, txtYearInstall, txtContract_man, txtData_last_man, txtComment);
        recyclerView.setAdapter(equipment_inventory_adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Form_inventory_view.this));
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
                id.add(cursor.getString(0));
                txtDept.add(cursor.getString(1));
                txtTypeEquip.add(cursor.getString(2));
                txtInvent_number.add(cursor.getString(3));
                txtMake.add(cursor.getString(4));
                txtModel.add(cursor.getString(5));
                txtSerialNumber.add(cursor.getString(6));
                txtEquipCondition.add(cursor.getString(7));
                txtYearInstall.add(cursor.getString(8));
                txtContract_man.add(cursor.getString(9));
                txtData_last_man.add(cursor.getString(10));
                txtComment.add(cursor.getString(11));
            }
            imageView.setVisibility(View.GONE);
            textView.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.delete_all) {
            confirmDialog();

        }
        return super.onOptionsItemSelected(item);
    }

    void confirmDialog() {
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
     //   recyclerView = findViewById(R.id.recycle_view_invent);
     //   add_button = findViewById(R.id.add_button);
        imageView = findViewById(R.id.id_image);
        textView = findViewById(R.id.id_no_data);
    }
}