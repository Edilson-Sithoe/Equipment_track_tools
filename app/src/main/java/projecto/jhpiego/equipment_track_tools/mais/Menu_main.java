package projecto.jhpiego.equipment_track_tools.mais;

import androidx.appcompat.app.AppCompatActivity;
import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.TelaPrincipal;
import projecto.jhpiego.equipment_track_tools.department.Form_department;
import projecto.jhpiego.equipment_track_tools.department.Form_department_view;
import projecto.jhpiego.equipment_track_tools.equipment.Form_equipment;
import projecto.jhpiego.equipment_track_tools.equipment.Form_equipment_view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu_main extends AppCompatActivity {
    private Button btn_voltar, btn_dept, btn_invent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_main);
        InitializerComponents();

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu_main.this, TelaPrincipal.class);
                startActivity(intent);
            }
        });

        btn_dept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_dept = new Intent(Menu_main.this, Form_department_view.class);
                startActivity(intent_dept);
            }
        });

        btn_invent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu_main.this, Form_equipment_view.class);
                startActivity(intent);
            }
        });
    }

    private void InitializerComponents() {
        btn_voltar = findViewById(R.id.id_voltar);
        btn_dept = findViewById(R.id.id_btn_dept);
        btn_invent = findViewById(R.id.id_btn_equipm);
    }
}