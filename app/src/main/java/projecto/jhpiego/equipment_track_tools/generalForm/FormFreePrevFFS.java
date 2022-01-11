package projecto.jhpiego.equipment_track_tools.generalForm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatActivity;
import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment;

public class FormFreePrevFFS extends AppCompatActivity {

    private Button btnBack, btnNExt;
    private EditText txtCommnts, txtOther;
    private String cbo_any_ox_gas,cbo_display_emerg_contac,cbo_exting_near,cbo_type_exting;
    private String cbo_last_main_done,cbo_fire_alarm,cbo_sys_working,cbo_last_time_main, cbo_hydrant_system;
    private String cbo_sys_work,cbo_when_was_last,cbo_sprinkler,cbo_does_sys_work, cbo_when_last_time_done, cbo_if_sys_work;

    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_free_prev_ffs);

     //   getSupportActionBar().hide();
        IniciarComponentes();

        btnNExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sign_presence_gas = cbo_any_ox_gas;
                String sign_emerg_contact = cbo_display_emerg_contac;
                String fire_extinguishers = cbo_exting_near;
                String type_extinguishers = cbo_type_exting;
                String type_extinguishers_other = txtOther.getText().toString();
                String last_maintenance_fone = cbo_last_main_done;
                String sensor_fire_alarme_system = cbo_fire_alarm;
                String system_working_sensor = cbo_sys_working;
                String last_maintanance_done_sensor = cbo_last_time_main;
                String hydrate_system_hose = cbo_hydrant_system;
                String system_working_hose = cbo_sys_work;
                String last_maintenance_done_hose = cbo_when_was_last;
                String sprinkler_system = cbo_sprinkler;
                String system_working_sprinkler = cbo_does_sys_work;
                String last_maintebance_done_sprinlker = cbo_when_last_time_done;
                String emergency_water_tank_full = cbo_if_sys_work;
                String comments_sprinkler = txtCommnts.getText().toString();

                Assessment.assessment_model.setSign_presence_gas(sign_presence_gas);
                Assessment.assessment_model.setSign_emergency_contact(sign_emerg_contact);
                Assessment.assessment_model.setFire_extinguishers(fire_extinguishers);
                Assessment.assessment_model.setType_extinguishers(type_extinguishers);
                Assessment.assessment_model.setType_extinguishers_other(type_extinguishers_other);
                Assessment.assessment_model.setLast_maintenance_fone(last_maintenance_fone);
                Assessment.assessment_model.setSensor_fire_alarme_system(sensor_fire_alarme_system);
                Assessment.assessment_model.setSystem_working_sensor(system_working_sensor);
                Assessment.assessment_model.setLast_maintanance_done_sensor(last_maintanance_done_sensor);
                Assessment.assessment_model.setHydrate_system_hose(hydrate_system_hose);
                Assessment.assessment_model.setSystem_working_hose(system_working_hose);
                Assessment.assessment_model.setLast_maintenance_done_hose(last_maintenance_done_hose);
                Assessment.assessment_model.setSprinkler_system(sprinkler_system);
                Assessment.assessment_model.setSystem_working_sprinkler(system_working_sprinkler);
                Assessment.assessment_model.setLast_maintebance_done_sprinlker(last_maintebance_done_sprinlker);
                Assessment.assessment_model.setEmergency_water_tank_full(emergency_water_tank_full);
                Assessment.assessment_model.setComments_sprinkler(comments_sprinkler);

                    Intent i = new Intent(FormFreePrevFFS.this, FormCylinders.class);
                    startActivity(i);

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iback = new Intent(FormFreePrevFFS.this, FormOxigenSystem.class);
                startActivity(iback);
            }
        });


    }

    public void onRadioButtonClicked_fpf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkYesFFSPO:
                if (checked)
                    cbo_any_ox_gas = "Yes";
                break;
            case R.id.idChkNoFFSPO:
                if (checked)
                    cbo_any_ox_gas = "No";
                break;
        }
    }

    public void onRadioButtonClicked1_fpf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkYesFFSEC:
                if (checked)
                    cbo_display_emerg_contac = "Yes";
                break;
            case R.id.idChkNoFFSEC:
                if (checked)
                    cbo_display_emerg_contac = "No";
                break;
        }
    }

    public void onRadioButtonClicked2_fpf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkYesFFSFE:
                if (checked)
                    cbo_exting_near = "Yes";
                break;
            case R.id.idChkNoFFSFE:
                if (checked)
                    cbo_exting_near = "No";
                break;
        }
    }

    public void onRadioButtonClicked3_fpf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.idChkLGE:
                if (checked)
                    cbo_type_exting = "LGE - Mechanical";
                break;
            case R.id.idChkBC:
                if (checked)
                    cbo_type_exting = "BC - Chemical powder";
                break;
            case R.id.idChkABC:
                if (checked)
                    cbo_type_exting = "ABC - Chemical";
                break;
            case R.id.idChkCO:
                if (checked)
                    cbo_type_exting = "CO2 - Carbon dioxide";
                break;
            case R.id.idChkD:
                if (checked)
                    cbo_type_exting = "D - Sodium cholride";
                break;
            case R.id.idChkK:
                if (checked)
                    cbo_type_exting = "K - Alkaline Base";
                break;
            case R.id.idChkDontNFE:
                if (checked)
                    cbo_type_exting = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked4_fpf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkLessMD:
                if (checked)
                    cbo_last_main_done = "Less than year";
                break;
            case R.id.idChkMorThanMD:
                if (checked)
                    cbo_last_main_done = "More than one year";
                break;
            case R.id.idChkMorThanTMD:
                if (checked)
                    cbo_last_main_done = "More than 2 years";
                break;
            case R.id.idChkDontNMD:
                if (checked)
                    cbo_last_main_done = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked5_fpf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkYesAS:
                if (checked)
                    cbo_fire_alarm = "Yes";
                break;
            case R.id.idChkNoAS:
                if (checked)
                    cbo_fire_alarm = "No";
                break;
        }
    }

    public void onRadioButtonClicked6_fpf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChYesSW:
                if (checked)
                    cbo_sys_working = "Yes";
                break;
            case R.id.idChkNoSW:
                if (checked)
                    cbo_sys_working = "No";
                break;
            case R.id.idChkDontNoSW:
                if (checked)
                    cbo_sys_working = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked7_fpf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkLessLMD:
                if (checked)
                    cbo_last_time_main = "Less than year";
                break;
            case R.id.idChkMorThanLMD:
                if (checked)
                    cbo_last_time_main = "More than one year";
                break;
            case R.id.idChkMorThanTLMD:
                if (checked)
                    cbo_last_time_main = "More than 2 years";
                break;
            case R.id.idChkDontNLMD:
                if (checked)
                    cbo_last_time_main = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked8_fpf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkYesFFSHS:
                if (checked)
                    cbo_hydrant_system = "Yes";
                break;
            case R.id.idChkNoFFSHS:
                if (checked)
                    cbo_hydrant_system = "No";
                break;
        }
    }

    public void onRadioButtonClicked9_fpf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChYesSWT:
                if (checked)
                    cbo_sys_work = "Yes";
                break;
            case R.id.idChkNoSWT:
                if (checked)
                    cbo_sys_work = "No";
                break;
            case R.id.idChkDontNoSWT:
                if (checked)
                    cbo_sys_work = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked10_fpf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkLessLMDT:
                if (checked)
                    cbo_when_was_last = "Less than year";
                break;
            case R.id.idChkMorThanLMDT:
                if (checked)
                    cbo_when_was_last = "More than one year";
                break;
            case R.id.idChkMorThanTLMDT:
                if (checked)
                    cbo_when_was_last = "More than 2 years";
                break;
            case R.id.idChkDontNLMDT:
                if (checked)
                    cbo_when_was_last = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked11_fpf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkYesFFSCS:
                if (checked)
                    cbo_sprinkler = "Yes";
                break;
            case R.id.idChkNoFFSCS:
                if (checked)
                    cbo_sprinkler = "No";
                break;
        }
    }

    public void onRadioButtonClicked12_fpf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChYesSWTH:
                if (checked)
                    cbo_does_sys_work = "Yes";
                break;
            case R.id.idChkNoSWTH:
                if (checked)
                    cbo_does_sys_work = "No";
                break;
            case R.id.idChkDontNoSWTH:
                if (checked)
                    cbo_does_sys_work = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked13_fpf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkLessLMDTH:
                if (checked)
                    cbo_when_last_time_done = "Less than year";
                break;
            case R.id.idChkMorThanLMDTH:
                if (checked)
                    cbo_when_last_time_done = "More than one year";
                break;
            case R.id.idChkMorThanTLMDTH:
                if (checked)
                    cbo_when_last_time_done = "More than 2 years";
                break;
            case R.id.idChkDontNLMDTH:
                if (checked)
                    cbo_when_last_time_done = "Don't know";
                break;
        }
    }

    public void onRadioButtonClicked14_fpf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChYesWTF:
                if (checked)
                    cbo_if_sys_work = "Yes";
                break;
            case R.id.idChkNoWTF:
                if (checked)
                    cbo_if_sys_work = "No";
                break;
            case R.id.idChkDontNoWTF:
                if (checked)
                    cbo_if_sys_work = "Don't know";
                break;
        }
    }

    public void IniciarComponentes(){
        btnBack = findViewById(R.id.btn_backFPA);
        btnNExt = findViewById(R.id.btn_next);

        txtOther = findViewById(R.id.idTxtOther);
        txtCommnts = findViewById(R.id.idTxtComentUPS);
    }

    public void LimparCampos() {
        txtCommnts.setText("");
    }
}