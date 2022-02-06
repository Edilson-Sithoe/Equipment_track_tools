package projecto.jhpiego.equipment_track_tools.generalUpdateForm;

import androidx.appcompat.app.AppCompatActivity;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment;
import projecto.jhpiego.equipment_track_tools.generalForm.FormCylinders;
import projecto.jhpiego.equipment_track_tools.generalForm.FormFreePrevFFS;
import projecto.jhpiego.equipment_track_tools.generalForm.FormOxigenSystem;
import projecto.jhpiego.equipment_track_tools.variaveis.Variaveis;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Update_free_prev_ffs extends AppCompatActivity {

    private Button btnBack, btnNExt;
    private EditText txtCommnts, txtOther;
    private RadioButton idChkYesFFSPO, idChkNoFFSPO;
    private RadioButton idChkYesFFSEC, idChkNoFFSEC;
    private RadioButton idChkYesFFSFE, idChkNoFFSFE;
    private RadioButton idChkLGE, idChkBC,idChkABC,idChkCO,idChkD,idChkK,idChkDontNFE;
    private RadioButton idChkLessMD, idChkMorThanMD,idChkMorThanTMD,idChkDontNMD;
    private RadioButton idChkYesAS, idChkNoAS;
    private RadioButton idChYesSW, idChkNoSW,idChkDontNoSW;
    private RadioButton idChkLessLMD, idChkMorThanLMD,idChkMorThanTLMD, idChkDontNLMD;
    private RadioButton idChkYesFFSHS, idChkNoFFSHS;
    private RadioButton idChYesSWT, idChkNoSWT,idChkDontNoSWT;
    private RadioButton idChkLessLMDT, idChkMorThanLMDT,idChkMorThanTLMDT,idChkDontNLMDT;
    private RadioButton idChkYesFFSCS, idChkNoFFSCS;
    private RadioButton idChYesSWTH, idChkNoSWTH,idChkDontNoSWTH;
    private RadioButton idChkLessLMDTH, idChkMorThanLMDTH,idChkMorThanTLMDTH,idChkDontNLMDTH;
    private RadioButton idChYesWTF, idChkNoWTF,idChkDontNoWTF;
    private String cbo_any_ox_gas, cbo_display_emerg_contac, cbo_exting_near, cbo_type_exting;
    private String cbo_last_main_done, cbo_fire_alarm, cbo_sys_working, cbo_last_time_main, cbo_hydrant_system;
    private String cbo_sys_work, cbo_when_was_last, cbo_sprinkler, cbo_does_sys_work, cbo_when_last_time_done, cbo_if_sys_work;

    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_free_prev_ffs);

        IniciarComponentes();
        getAndSetIntentData();
        setRB_sign_presenc();
        setRB_display_emergency();
        setRB_extinguishers();
        setRB_type_extinguishers();
        setRB_maintenance_done();
        setRB_sensor_fire_alarm();
        setRB_system_working_too();
        setRB_last_maintenance_done_too();
        setRB_hose_too();
        setRB_system_working_three();
        setRB_last_maintenance_done_three();
        setRB_hose();
        setRB_system_working_four();
        setRB_last_maintenance_done();
        setRB_system_working();

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

                if (idChkYesFFSPO.isChecked())
                    Variaveis.assessment_model.setSign_presence_gas("Yes");
                else if (idChkNoFFSPO.isChecked())
                    Variaveis.assessment_model.setSign_presence_gas("No");

                if (idChkYesFFSEC.isChecked())
                    Variaveis.assessment_model.setSign_emergency_contact("Yes");
                else if (idChkNoFFSEC.isChecked())
                    Variaveis.assessment_model.setSign_emergency_contact("No");

                if (idChkYesFFSFE.isChecked())
                    Variaveis.assessment_model.setFire_extinguishers("Yes");
                else if (idChkNoFFSFE.isChecked())
                    Variaveis.assessment_model.setFire_extinguishers("No");

                if (idChkLGE.isChecked())
                    Variaveis.assessment_model.setType_extinguishers("LGE - Mechanical");
                else if (idChkBC.isChecked())
                    Variaveis.assessment_model.setType_extinguishers("BC - Chemical powder");
                else if (idChkABC.isChecked())
                    Variaveis.assessment_model.setType_extinguishers("ABC - Chemical");
                else if (idChkCO.isChecked())
                    Variaveis.assessment_model.setType_extinguishers("CO2 - Carbon dioxide");
                else if (idChkD.isChecked())
                    Variaveis.assessment_model.setType_extinguishers("D - Sodium cholride");
                else if (idChkK.isChecked())
                    Variaveis.assessment_model.setType_extinguishers("K - Alkaline Base");
                else if (idChkDontNFE.isChecked())
                    Variaveis.assessment_model.setType_extinguishers("Don't know");

                if (idChkLessMD.isChecked())
                    Variaveis.assessment_model.setLast_maintenance_fone("Less than year");
                else if (idChkMorThanMD.isChecked())
                    Variaveis.assessment_model.setLast_maintenance_fone("More than one year");
                else if (idChkMorThanTMD.isChecked())
                    Variaveis.assessment_model.setLast_maintenance_fone("More than 2 years");
                else if (idChkDontNMD.isChecked())
                    Variaveis.assessment_model.setLast_maintenance_fone("Don't know");

                if (idChkYesAS.isChecked())
                    Variaveis.assessment_model.setSensor_fire_alarme_system("Yes");
                else if (idChkNoAS.isChecked())
                    Variaveis.assessment_model.setSensor_fire_alarme_system("No");

                if (idChYesSW.isChecked())
                    Variaveis.assessment_model.setSystem_working_sensor("Yes");
                else if (idChkNoSW.isChecked())
                    Variaveis.assessment_model.setSystem_working_sensor("No");
                else if (idChkDontNoSW.isChecked())
                    Variaveis.assessment_model.setSystem_working_sensor("Don't know");

                if (idChkLessLMD.isChecked())
                    Variaveis.assessment_model.setLast_maintanance_done_sensor("Less than year");
                else if (idChkMorThanLMD.isChecked())
                    Variaveis.assessment_model.setLast_maintanance_done_sensor("More than one year");
                else if (idChkMorThanTLMD.isChecked())
                    Variaveis.assessment_model.setLast_maintanance_done_sensor("More than 2 years");
                else if (idChkDontNLMD.isChecked())
                    Variaveis.assessment_model.setLast_maintanance_done_sensor("Don't know");

                if (idChkYesFFSHS.isChecked())
                    Variaveis.assessment_model.setHydrate_system_hose("Yes");
                else if (idChkNoFFSHS.isChecked())
                    Variaveis.assessment_model.setHydrate_system_hose("No");

                if (idChYesSWT.isChecked())
                    Variaveis.assessment_model.setSystem_working_hose("Yes");
                else if (idChkNoSWT.isChecked())
                    Variaveis.assessment_model.setSystem_working_hose("No");
                else if (idChkDontNoSWT.isChecked())
                    Variaveis.assessment_model.setSystem_working_hose("Don't know");

                if (idChkLessLMDT.isChecked())
                    Variaveis.assessment_model.setLast_maintenance_done_hose("Less than year");
                else if (idChkMorThanLMDT.isChecked())
                    Variaveis.assessment_model.setLast_maintenance_done_hose("More than one year");
                else if (idChkMorThanTLMDT.isChecked())
                    Variaveis.assessment_model.setLast_maintenance_done_hose("More than 2 years");
                else if (idChkDontNLMDT.isChecked())
                    Variaveis.assessment_model.setLast_maintenance_done_hose("Don't know");

                if (idChkYesFFSCS.isChecked())
                    Variaveis.assessment_model.setSprinkler_system("Yes");
                else if (idChkNoFFSCS.isChecked())
                    Variaveis.assessment_model.setSprinkler_system("No");

                if (idChYesSWTH.isChecked())
                    Variaveis.assessment_model.setSystem_working_sprinkler("Yes");
                else if (idChkNoSWTH.isChecked())
                    Variaveis.assessment_model.setSystem_working_sprinkler("No");
                else if (idChkDontNoSWTH.isChecked())
                    Variaveis.assessment_model.setSystem_working_sprinkler("Don't know");

                if (idChkLessLMDTH.isChecked())
                    Variaveis.assessment_model.setLast_maintebance_done_sprinlker("Less than year");
                else if (idChkMorThanLMDTH.isChecked())
                    Variaveis.assessment_model.setLast_maintebance_done_sprinlker("More than one year");
                else if (idChkMorThanTLMDTH.isChecked())
                    Variaveis.assessment_model.setLast_maintebance_done_sprinlker("More than 2 years");
                else if (idChkDontNLMDTH.isChecked())
                    Variaveis.assessment_model.setLast_maintebance_done_sprinlker("Don't know");

                if (idChYesWTF.isChecked())
                    Variaveis.assessment_model.setEmergency_water_tank_full("Yes");
                else if (idChkNoWTF.isChecked())
                    Variaveis.assessment_model.setEmergency_water_tank_full("No");
                else if (idChkDontNoWTF.isChecked())
                    Variaveis.assessment_model.setEmergency_water_tank_full("Don't know");

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

                Intent i = new Intent(Update_free_prev_ffs.this, Update_cylinders.class);
                startActivity(i);

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iback = new Intent(Update_free_prev_ffs.this, Update_oxigen_system.class);
                startActivity(iback);
            }
        });

    }

    private void getAndSetIntentData() {
        if (getIntent().hasExtra("txtOther")) {
            Toast.makeText(this, "Sem dados para mostrar", Toast.LENGTH_SHORT).show();
        } else {
            txtOther.setText(Variaveis.assessment_model.getType_extinguishers_other());
            txtCommnts.setText(Variaveis.assessment_model.getComments_sprinkler());
        }
    }

    public void setRB_sign_presenc() {
        idChkYesFFSPO = findViewById(R.id.idChkYesFFSPO);
        idChkNoFFSPO = findViewById(R.id.idChkNoFFSPO);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getSign_presence_gas())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getSign_presence_gas().equalsIgnoreCase("Yes")) {
                idChkYesFFSPO.setChecked(true);
            } else if (Variaveis.assessment_model.getSign_presence_gas().equalsIgnoreCase("No")) {
                idChkNoFFSPO.setChecked(true);
            }
        }
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

    public void setRB_display_emergency() {
        idChkYesFFSEC = findViewById(R.id.idChkYesFFSEC);
        idChkNoFFSEC = findViewById(R.id.idChkNoFFSEC);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getSign_emergency_contact())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getSign_emergency_contact().equalsIgnoreCase("Yes")) {
                idChkYesFFSEC.setChecked(true);
            } else if (Variaveis.assessment_model.getSign_emergency_contact().equalsIgnoreCase("No")) {
                idChkNoFFSEC.setChecked(true);
            }
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

    public void setRB_extinguishers() {
        idChkYesFFSFE = findViewById(R.id.idChkYesFFSFE);
        idChkNoFFSFE = findViewById(R.id.idChkNoFFSFE);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getFire_extinguishers())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getFire_extinguishers().equalsIgnoreCase("Yes")) {
                idChkYesFFSFE.setChecked(true);
            } else if (Variaveis.assessment_model.getFire_extinguishers().equalsIgnoreCase("No")) {
                idChkNoFFSFE.setChecked(true);
            }
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

    public void setRB_type_extinguishers() {
        idChkLGE = findViewById(R.id.idChkLGE);
        idChkBC = findViewById(R.id.idChkBC);
        idChkABC = findViewById(R.id.idChkABC);
        idChkCO = findViewById(R.id.idChkCO);
        idChkD = findViewById(R.id.idChkD);
        idChkK = findViewById(R.id.idChkK);
        idChkDontNFE = findViewById(R.id.idChkDontNFE);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getType_extinguishers())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getType_extinguishers().equalsIgnoreCase("LGE - Mechanical")) {
                idChkLGE.setChecked(true);
            } else if (Variaveis.assessment_model.getType_extinguishers().equalsIgnoreCase("BC - Chemical powder")) {
                idChkBC.setChecked(true);
            } else if (Variaveis.assessment_model.getType_extinguishers().equalsIgnoreCase("ABC - Chemical")) {
                idChkABC.setChecked(true);
            } else if (Variaveis.assessment_model.getType_extinguishers().equalsIgnoreCase("CO2 - Carbon dioxide")) {
                idChkCO.setChecked(true);
            } else if (Variaveis.assessment_model.getType_extinguishers().equalsIgnoreCase("D - Sodium cholride")) {
                idChkD.setChecked(true);
            } else if (Variaveis.assessment_model.getType_extinguishers().equalsIgnoreCase("K - Alkaline Base")) {
                idChkK.setChecked(true);
            } else if (Variaveis.assessment_model.getType_extinguishers().equalsIgnoreCase("Don't know")) {
                idChkDontNFE.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked3_fpf(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
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

    public void setRB_maintenance_done() {
        idChkLessMD = findViewById(R.id.idChkLessMD);
        idChkMorThanMD = findViewById(R.id.idChkMorThanMD);
        idChkMorThanTMD = findViewById(R.id.idChkMorThanTMD);
        idChkDontNMD = findViewById(R.id.idChkDontNMD);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getLast_maintenance_fone())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getLast_maintenance_fone().equalsIgnoreCase("Less than year")) {
                idChkLessMD.setChecked(true);
            } else if (Variaveis.assessment_model.getLast_maintenance_fone().equalsIgnoreCase("More than one year")) {
                idChkMorThanMD.setChecked(true);
            } else if (Variaveis.assessment_model.getLast_maintenance_fone().equalsIgnoreCase("More than 2 years")) {
                idChkMorThanTMD.setChecked(true);
            } else if (Variaveis.assessment_model.getLast_maintenance_fone().equalsIgnoreCase("Don't know")) {
                idChkDontNMD.setChecked(true);
            }
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

    public void setRB_sensor_fire_alarm() {
        idChkYesAS = findViewById(R.id.idChkYesAS);
        idChkNoAS = findViewById(R.id.idChkNoAS);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getSensor_fire_alarme_system())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getSensor_fire_alarme_system().equalsIgnoreCase("Yes")) {
                idChkYesAS.setChecked(true);
            } else if (Variaveis.assessment_model.getSensor_fire_alarme_system().equalsIgnoreCase("No")) {
                idChkNoAS.setChecked(true);
            }
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

    public void setRB_system_working_too() {
        idChYesSW = findViewById(R.id.idChYesSW);
        idChkNoSW = findViewById(R.id.idChkNoSW);
        idChkDontNoSW = findViewById(R.id.idChkDontNoSW);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getSystem_working_sensor())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getSystem_working_sensor().equalsIgnoreCase("Yes")) {
                idChYesSW.setChecked(true);
            } else if (Variaveis.assessment_model.getSystem_working_sensor().equalsIgnoreCase("No")) {
                idChkNoSW.setChecked(true);
            } else if (Variaveis.assessment_model.getSystem_working_sensor().equalsIgnoreCase("Don't know")) {
                idChkDontNoSW.setChecked(true);
            }
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

    public void setRB_last_maintenance_done_too() {
        idChkLessLMD = findViewById(R.id.idChkLessLMD);
        idChkMorThanLMD = findViewById(R.id.idChkMorThanLMD);
        idChkMorThanTLMD = findViewById(R.id.idChkMorThanTLMD);
        idChkDontNLMD = findViewById(R.id.idChkDontNLMD);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getLast_maintanance_done_sensor())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getLast_maintanance_done_sensor().equalsIgnoreCase("Less than year")) {
                idChkLessLMD.setChecked(true);
            } else if (Variaveis.assessment_model.getLast_maintanance_done_sensor().equalsIgnoreCase("More than one year")) {
                idChkMorThanLMD.setChecked(true);
            } else if (Variaveis.assessment_model.getLast_maintanance_done_sensor().equalsIgnoreCase("More than 2 years")) {
                idChkMorThanTLMD.setChecked(true);
            } else if (Variaveis.assessment_model.getLast_maintanance_done_sensor().equalsIgnoreCase("Don't know")) {
                idChkDontNLMD.setChecked(true);
            }
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

    public void setRB_hose_too() {
        idChkYesFFSHS = findViewById(R.id.idChkYesFFSHS);
        idChkNoFFSHS = findViewById(R.id.idChkNoFFSHS);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getHydrate_system_hose())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getHydrate_system_hose().equalsIgnoreCase("Yes")) {
                idChkYesFFSHS.setChecked(true);
            } else if (Variaveis.assessment_model.getHydrate_system_hose().equalsIgnoreCase("No")) {
                idChkNoFFSHS.setChecked(true);
            }
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

    public void setRB_system_working_three() {
        idChYesSWT = findViewById(R.id.idChYesSWT);
        idChkNoSWT = findViewById(R.id.idChkNoSWT);
        idChkDontNoSWT = findViewById(R.id.idChkDontNoSWT);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getSystem_working_hose())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getSystem_working_hose().equalsIgnoreCase("Yes")) {
                idChYesSWT.setChecked(true);
            } else if (Variaveis.assessment_model.getSystem_working_hose().equalsIgnoreCase("No")) {
                idChkNoSWT.setChecked(true);
            } else if (Variaveis.assessment_model.getSystem_working_hose().equalsIgnoreCase("Don't know")) {
                idChkDontNoSWT.setChecked(true);
            }
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

    public void setRB_last_maintenance_done_three() {
        idChkLessLMDT = findViewById(R.id.idChkLessLMDT);
        idChkMorThanLMDT = findViewById(R.id.idChkMorThanLMDT);
        idChkMorThanTLMDT = findViewById(R.id.idChkMorThanTLMDT);
        idChkDontNLMDT = findViewById(R.id.idChkDontNLMDT);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getLast_maintenance_done_hose())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getLast_maintenance_done_hose().equalsIgnoreCase("Less than year")) {
                idChkLessLMDT.setChecked(true);
            } else if (Variaveis.assessment_model.getLast_maintenance_done_hose().equalsIgnoreCase("More than one year")) {
                idChkMorThanLMDT.setChecked(true);
            } else if (Variaveis.assessment_model.getLast_maintenance_done_hose().equalsIgnoreCase("More than 2 years")) {
                idChkMorThanTLMDT.setChecked(true);
            } else if (Variaveis.assessment_model.getLast_maintenance_done_hose().equalsIgnoreCase("Don't know")) {
                idChkDontNLMDT.setChecked(true);
            }
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

    public void setRB_hose() {
        idChkYesFFSCS = findViewById(R.id.idChkYesFFSCS);
        idChkNoFFSCS = findViewById(R.id.idChkNoFFSCS);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getSprinkler_system())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getSprinkler_system().equalsIgnoreCase("Yes")) {
                idChkYesFFSCS.setChecked(true);
            } else if (Variaveis.assessment_model.getSprinkler_system().equalsIgnoreCase("No")) {
                idChkNoFFSCS.setChecked(true);
            }
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

    public void setRB_system_working_four() {
        idChYesSWTH = findViewById(R.id.idChYesSWTH);
        idChkNoSWTH = findViewById(R.id.idChkNoSWTH);
        idChkDontNoSWTH = findViewById(R.id.idChkDontNoSWTH);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getSystem_working_sprinkler())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getSystem_working_sprinkler().equalsIgnoreCase("Yes")) {
                idChYesSWTH.setChecked(true);
            } else if (Variaveis.assessment_model.getSystem_working_sprinkler().equalsIgnoreCase("No")) {
                idChkNoSWTH.setChecked(true);
            } else if (Variaveis.assessment_model.getSystem_working_sprinkler().equalsIgnoreCase("Don't know")) {
                idChkDontNoSWTH.setChecked(true);
            }
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

    public void setRB_last_maintenance_done() {
        idChkLessLMDTH = findViewById(R.id.idChkLessLMDTH);
        idChkMorThanLMDTH = findViewById(R.id.idChkMorThanLMDTH);
        idChkMorThanTLMDTH = findViewById(R.id.idChkMorThanTLMDTH);
        idChkDontNLMDTH = findViewById(R.id.idChkDontNLMDTH);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getLast_maintebance_done_sprinlker())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getLast_maintebance_done_sprinlker().equalsIgnoreCase("Less than year")) {
                idChkLessLMDTH.setChecked(true);
            } else if (Variaveis.assessment_model.getLast_maintebance_done_sprinlker().equalsIgnoreCase("More than one year")) {
                idChkMorThanLMDTH.setChecked(true);
            } else if (Variaveis.assessment_model.getLast_maintebance_done_sprinlker().equalsIgnoreCase("More than 2 years")) {
                idChkMorThanTLMDTH.setChecked(true);
            } else if (Variaveis.assessment_model.getLast_maintebance_done_sprinlker().equalsIgnoreCase("Don't know")) {
                idChkDontNLMDTH.setChecked(true);
            }
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

    public void setRB_system_working() {
        idChYesWTF = findViewById(R.id.idChYesWTF);
        idChkNoWTF = findViewById(R.id.idChkNoWTF);
        idChkDontNoWTF = findViewById(R.id.idChkDontNoWTF);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getEmergency_water_tank_full())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getEmergency_water_tank_full().equalsIgnoreCase("Yes")) {
                idChYesWTF.setChecked(true);
            } else if (Variaveis.assessment_model.getEmergency_water_tank_full().equalsIgnoreCase("No")) {
                idChkNoWTF.setChecked(true);
            } else if (Variaveis.assessment_model.getEmergency_water_tank_full().equalsIgnoreCase("Don't know")) {
                idChkDontNoWTF.setChecked(true);
            }
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

    public void IniciarComponentes() {
        btnBack = findViewById(R.id.btn_backFPA);
        btnNExt = findViewById(R.id.btn_next);

        txtOther = findViewById(R.id.idTxtOther);
        txtCommnts = findViewById(R.id.idTxtComentUPS);
    }

    public void LimparCampos() {
        txtCommnts.setText("");
    }
}