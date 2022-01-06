package projecto.jhpiego.equipment_track_tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import projecto.jhpiego.equipment_track_tools.generalForm.FormInterviewID;
import projecto.jhpiego.equipment_track_tools.generalForm.Form_all_data_view;
import projecto.jhpiego.equipment_track_tools.login.FormLogin;
import projecto.jhpiego.equipment_track_tools.view.inventory.Form_inventory_view;

public class TelaPrincipal extends AppCompatActivity {

    private Button btnLogout, btn_identInter, btn_identiHFa;
    private Button btn_interview, btn_fomr, idBtnMedGasSystem ,idBtnLogistic,idBtnMedEquipem,idBtnSupervisory,idBtnTrainProg,idBtnEquip_inv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

//        getSupportActionBar().hide();
        InitializerComponents();

     /*   btn_interview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent interviw = new Intent(TelaPrincipal.this, FormInterviewMenu.class);
                startActivity(interviw);
            }
        });*/

        btn_fomr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent identInter = new Intent(TelaPrincipal.this, Form_all_data_view.class);
                startActivity(identInter);
             //   Toast.makeText(TelaPrincipal.this, "Formulario geral", Toast.LENGTH_SHORT).show();
            }
        });

     /*   idBtnMedGasSystem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent identInter = new Intent(TelaPrincipal.this, FormMedGasSystemMenu.class);
                startActivity(identInter);
            }
        });

        idBtnLogistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent identInter = new Intent(TelaPrincipal.this, FormLogisticMenu.class);
                startActivity(identInter);
            }
        });

        idBtnMedEquipem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent identInter = new Intent(TelaPrincipal.this, FormMaintenanceMedEquip.class);
                startActivity(identInter);
            }
        });

        idBtnSupervisory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent identInter = new Intent(TelaPrincipal.this, FormSupervisoryMenu.class);
                startActivity(identInter);
            }
        });*/

      /*  btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent identInter = new Intent(TelaPrincipal.this, FormLogin.class);
                startActivity(identInter);
            }
        });*/

        idBtnEquip_inv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent equipIvent = new Intent(TelaPrincipal.this, Form_inventory_view.class);
                startActivity(equipIvent);
            }
        });

      /*  btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iclose = new Intent(TelaPrincipal.this, FormLogin.class);
                startActivity(iclose);
                finish();
            }
        });*/
    }

    private void InitializerComponents(){
    //    btnLogout = findViewById(R.id.idBtn_logout);
        idBtnEquip_inv = findViewById(R.id.idBtnEquip_inv);
        btn_fomr = findViewById(R.id.idBtnForm);
        btnLogout = findViewById(R.id.id_close);
        /*   btn_interview = findViewById(R.id.idBtnInterview);
        idBtnMedGasSystem = findViewById(R.id.idBtnMedGasSystem);
        idBtnLogistic = findViewById(R.id.idBtnLogistic);
        idBtnMedEquipem = findViewById(R.id.idBtnMedEquipem);
        idBtnSupervisory = findViewById(R.id.idBtnSupervisory);
        idBtnTrainProg = findViewById(R.id.idBtnTrainProg);*/
    }
}