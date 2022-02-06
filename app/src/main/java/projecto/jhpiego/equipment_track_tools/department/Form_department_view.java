package projecto.jhpiego.equipment_track_tools.department;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.adapter_dept.Department_adapter;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Database_connection;
import projecto.jhpiego.equipment_track_tools.model.Department;
import projecto.jhpiego.equipment_track_tools.variaveis.Variaveis;

public class Form_department_view extends AppCompatActivity {

    ListView listView;
    FloatingActionButton add_button;

    Database_connection database_connection;
    ArrayList<Department> departmentArrayList;
    private static Department_adapter department_adapter;

    ImageView imageView;
    TextView textView;

    String[] mensagens = {"Sem dados para mostrar"};

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_departament_view);
        Init_components();

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Form_department_view.this, Form_department.class);
                startActivity(intent);
            }
        });

        departmentArrayList = new ArrayList<>();
        database_connection = new Database_connection(Form_department_view.this);

        Display_department();

      //  department_adapter = new Department_adapter(departmentArrayList, getApplicationContext());
      //  listView.setAdapter(department_adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Department department = departmentArrayList.get(position);
                Variaveis.department = departmentArrayList.get(position);
                Intent intent = new Intent(Form_department_view.this, Update_department.class);
                startActivity(intent);

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

    private void Display_department() {
        Cursor cursor = database_connection.readAllData();
        if (cursor.getCount() == 0) {
            imageView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.VISIBLE);
        } else {
            while (cursor.moveToNext()) {
                Department department = new Department();
                department.setId(cursor.getInt(0));
                department.setNome_department(cursor.getString(1));
                departmentArrayList.add(department);
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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
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
                Database_connection database_connection = new Database_connection(Form_department_view.this);
                database_connection.deleteAllData();
                Intent intent = new Intent(Form_department_view.this, Form_department_view.class);
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
        listView = findViewById(R.id.list_view_dept);
        add_button = findViewById(R.id.add_button_dept);
        imageView = findViewById(R.id.id_image_dept);
        textView = findViewById(R.id.id_no_data_dept);
    }
}
