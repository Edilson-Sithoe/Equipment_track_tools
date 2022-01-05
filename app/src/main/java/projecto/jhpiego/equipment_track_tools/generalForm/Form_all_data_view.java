package projecto.jhpiego.equipment_track_tools.generalForm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.adapter.All_data_adapter;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment_aux;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Database_connection;
import projecto.jhpiego.equipment_track_tools.model.Assessment_model;
import projecto.jhpiego.equipment_track_tools.variaveis.Variaveis;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class Form_all_data_view extends AppCompatActivity {

    ListView listView;
    FloatingActionButton add_button;

    Database_connection database_connection;
    ArrayList<Assessment_model> assessment_modelArrayList;
    private static All_data_adapter all_data_adapter;

    ImageView imageView;
    TextView textView;

    String[] mensagens = {"Sem dados para mostrar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_all_data_view);
        Init_components();

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Form_all_data_view.this, FormInterviewID.class);
                startActivity(intent);
            }
        });

        assessment_modelArrayList = new ArrayList<>();
        database_connection = new Database_connection(Form_all_data_view.this);

        Display_data();

        all_data_adapter = new All_data_adapter(assessment_modelArrayList, getApplicationContext());
        listView.setAdapter(all_data_adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Assessment_model data_model_assess = assessment_modelArrayList.get(position);
                Variaveis.assessment_model = assessment_modelArrayList.get(position);
                Intent i = new Intent(Form_all_data_view.this, Update_interview_id.class);
                startActivity(i);

              /*  Snackbar.make(view, data_model_assess.getTxtHealthFacID() + data_model_assess.getTxtName(), Snackbar.LENGTH_SHORT)
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

    void Display_data() {
        Cursor cursor = database_connection.readAllData_form();
        if (cursor.getCount() == 0) {
            imageView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.VISIBLE);
        } else {
            while (cursor.moveToNext()) {
                Assessment_model assessment_model = new Assessment_model();
                assessment_model.setId(cursor.getInt(0));
                assessment_model.setTxtName(cursor.getString(1));
              //  assessment_model.setId(cursor.getInt(0));
                assessment_modelArrayList.add(assessment_model);
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

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Remover todos registos?");
        builder.setMessage("Pretende apagar todos registos?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Database_connection database_connection = new Database_connection(Form_all_data_view.this);
                database_connection.deleteAllData_form();
                Intent intent = new Intent(Form_all_data_view.this, Form_all_data_view.class);
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
        listView = findViewById(R.id.list_view_all_data);
        add_button = findViewById(R.id.add_btn_data);
        imageView = findViewById(R.id.id_image);
        textView = findViewById(R.id.id_no_data);
    }

}