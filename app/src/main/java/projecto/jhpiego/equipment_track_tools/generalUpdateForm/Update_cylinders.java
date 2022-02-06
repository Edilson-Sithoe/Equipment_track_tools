package projecto.jhpiego.equipment_track_tools.generalUpdateForm;

import androidx.appcompat.app.AppCompatActivity;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment;
import projecto.jhpiego.equipment_track_tools.generalForm.FormConcentrator;
import projecto.jhpiego.equipment_track_tools.generalForm.FormCylinders;
import projecto.jhpiego.equipment_track_tools.generalForm.FormFreePrevFFS;
import projecto.jhpiego.equipment_track_tools.variaveis.Variaveis;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Update_cylinders extends AppCompatActivity {
    private Button btnBack, btnNExt;
    private TextView txtAVGC, txtAVGMC, txtTypeC, txtOtherC, txtNameSuppC, txtComment;
    private RadioButton idChkYesC, idChkNoC;
    private RadioButton idChkEC, idChkFC, idChkGC, idChkJC, idChkDontNoC;
    private RadioButton idChkPINC, idChkPINSC, idChkBullnoseC, idChkHandwheelC;
    private RadioButton idChkDailyC, idChkWeeklyC, idChkFortnightlyC, idChkMonthlyC, idChkOnrequestC;
    private RadioButton idChkYESSUC, idChkNOSC;
    String[] mensagens = {"Preencha todos os campos", "Falha ao registar", "Registado com sucesso"};
    String cbo_cylinder_ward, cbo_most_common, cbo_connection_cylinder, cbo_health_fac_receive, cbo_shortages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_cylinders);

        //   getSupportActionBar().hide();
        InicializarComponentes();

        getAndSetIntentData();
        setRB_cylinder_ward();
        setRB_most_common();
        setRB_type_connection();
        setRB_facil_receive();
        setRB_facility_suffered();

        btnNExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String use_ward_room = cbo_cylinder_ward;
                String average_number = txtAVGC.getText().toString();
                String average_month = txtAVGMC.getText().toString();
                String type_cylinders = txtTypeC.getText().toString();
                String common_model_cylinder = cbo_most_common;
                String common_model_cylinder_other = txtOtherC.getText().toString();
                String type_conection_cylinder = cbo_connection_cylinder;
                String name_supplier = txtNameSuppC.getText().toString();
                String health_facility_receive = cbo_health_fac_receive;
                String health_facility_suffered = cbo_shortages;
                String comments_cylinders = txtComment.getText().toString();

                if (idChkYesC.isChecked())
                    Variaveis.assessment_model.setUse_ward_room("Yes");
                else if (idChkNoC.isChecked())
                    Variaveis.assessment_model.setUse_ward_room("No");

                if (idChkEC.isChecked())
                    Variaveis.assessment_model.setCommon_model_cylinder("E (1m3/680L)");
                else if (idChkFC.isChecked())
                    Variaveis.assessment_model.setCommon_model_cylinder("F (1.5/1360L)");
                else if (idChkNoC.isChecked())
                    Variaveis.assessment_model.setCommon_model_cylinder("G (3.5m3/3400L)");
                else if (idChkGC.isChecked())
                    Variaveis.assessment_model.setCommon_model_cylinder("J (7.5m3/7800L)");
                else if (idChkJC.isChecked())
                    Variaveis.assessment_model.setCommon_model_cylinder("Don't know");

                if (idChkPINC.isChecked())
                    Variaveis.assessment_model.setType_conection_cylinder("Pin index");
                else if (idChkPINSC.isChecked())
                    Variaveis.assessment_model.setType_conection_cylinder("Pin-index side spindle valve");
                else if (idChkBullnoseC.isChecked())
                    Variaveis.assessment_model.setType_conection_cylinder("Bullnose valve");
                else if (idChkHandwheelC.isChecked())
                    Variaveis.assessment_model.setType_conection_cylinder("Handwheel side outlet");

                if (idChkDailyC.isChecked())
                    Variaveis.assessment_model.setHealth_facility_receive("Daily");
                else if (idChkWeeklyC.isChecked())
                    Variaveis.assessment_model.setHealth_facility_receive("Weekly");
                else if (idChkFortnightlyC.isChecked())
                    Variaveis.assessment_model.setHealth_facility_receive("Fortnightly");
                else if (idChkMonthlyC.isChecked())
                    Variaveis.assessment_model.setHealth_facility_receive("Monthly");
                else if (idChkOnrequestC.isChecked())
                    Variaveis.assessment_model.setHealth_facility_receive("On request");

                if (idChkYESSUC.isChecked())
                    Variaveis.assessment_model.setHealth_facility_suffered("Yes");
                else if (idChkNOSC.isChecked())
                    Variaveis.assessment_model.setHealth_facility_suffered("No");

                if (TextUtils.isEmpty(average_number) || TextUtils.isEmpty(average_month) || TextUtils.isEmpty(type_cylinders) || TextUtils.isEmpty(name_supplier)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setUse_ward_room(use_ward_room);
                    Assessment.assessment_model.setAverage_number(average_number);
                    Assessment.assessment_model.setAverage_month(average_month);
                    Assessment.assessment_model.setType_cylinders(type_cylinders);
                    Assessment.assessment_model.setCommon_model_cylinder(common_model_cylinder);
                    Assessment.assessment_model.setCommon_model_cylinder_other(common_model_cylinder_other);
                    Assessment.assessment_model.setType_conection_cylinder(type_conection_cylinder);
                    Assessment.assessment_model.setName_supplier(name_supplier);
                    Assessment.assessment_model.setHealth_facility_receive(health_facility_receive);
                    Assessment.assessment_model.setHealth_facility_suffered(health_facility_suffered);
                    Assessment.assessment_model.setComments_cylinders(comments_cylinders);

                    Intent i = new Intent(Update_cylinders.this, Update_concentrator.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iBack = new Intent(Update_cylinders.this, Update_free_prev_ffs.class);
                startActivity(iBack);
            }
        });
    }

    private void getAndSetIntentData() {
        if (getIntent().hasExtra("txtNameSuppC")) {
            Toast.makeText(this, "Sem dados para mostrar", Toast.LENGTH_SHORT).show();
        } else {
            txtAVGC.setText(Variaveis.assessment_model.getAverage_number());
            txtAVGMC.setText(Variaveis.assessment_model.getAverage_month());
            txtTypeC.setText(Variaveis.assessment_model.getType_cylinders());
            txtOtherC.setText(Variaveis.assessment_model.getCommon_model_cylinder_other());
            txtNameSuppC.setText(Variaveis.assessment_model.getName_supplier());
            txtComment.setText(Variaveis.assessment_model.getComments_cylinders());
        }
    }


    public void setRB_cylinder_ward() {
        idChkYesC = findViewById(R.id.idChkYesC);
        idChkNoC = findViewById(R.id.idChkNoC);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getUse_ward_room())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getUse_ward_room().equalsIgnoreCase("Yes")) {
                idChkYesC.setChecked(true);
            } else if (Variaveis.assessment_model.getUse_ward_room().equalsIgnoreCase("No")) {
                idChkNoC.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked_cy(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkYesC:
                if (checked)
                    cbo_cylinder_ward = "Yes";
                break;
            case R.id.idChkNoC:
                if (checked)
                    cbo_cylinder_ward = "No";
                break;
        }
    }

    public void setRB_most_common() {
        idChkEC = findViewById(R.id.idChkEC);
        idChkFC = findViewById(R.id.idChkFC);
        idChkGC = findViewById(R.id.idChkGC);
        idChkJC = findViewById(R.id.idChkJC);
        idChkDontNoC = findViewById(R.id.idChkDontNoC);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getUse_ward_room())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getUse_ward_room().equalsIgnoreCase("E (1m3/680L)")) {
                idChkEC.setChecked(true);
            } else if (Variaveis.assessment_model.getUse_ward_room().equalsIgnoreCase("F (1.5/1360L)")) {
                idChkFC.setChecked(true);
            } else if (Variaveis.assessment_model.getUse_ward_room().equalsIgnoreCase("G (3.5m3/3400L)")) {
                idChkGC.setChecked(true);
            } else if (Variaveis.assessment_model.getUse_ward_room().equalsIgnoreCase("J (7.5m3/7800L)")) {
                idChkJC.setChecked(true);
            } else if (Variaveis.assessment_model.getUse_ward_room().equalsIgnoreCase("Don't know")) {
                idChkDontNoC.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked1_cy(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkEC:
                if (checked)
                    cbo_most_common = "E (1m3/680L)";
                break;
            case R.id.idChkFC:
                if (checked)
                    cbo_most_common = "F (1.5/1360L)";
                break;
            case R.id.idChkGC:
                if (checked)
                    cbo_most_common = "G (3.5m3/3400L)";
                break;
            case R.id.idChkJC:
                if (checked)
                    cbo_most_common = "J (7.5m3/7800L)";
                break;
            case R.id.idChkDontNoC:
                if (checked)
                    cbo_most_common = "Don't know";
                break;
        }
    }

    public void setRB_type_connection() {
        idChkPINC = findViewById(R.id.idChkPINC);
        idChkPINSC = findViewById(R.id.idChkPINSC);
        idChkBullnoseC = findViewById(R.id.idChkBullnoseC);
        idChkHandwheelC = findViewById(R.id.idChkHandwheelC);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getUse_ward_room())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getUse_ward_room().equalsIgnoreCase("Pin index")) {
                idChkPINC.setChecked(true);
            } else if (Variaveis.assessment_model.getUse_ward_room().equalsIgnoreCase("Pin-index side spindle valve")) {
                idChkPINSC.setChecked(true);
            } else if (Variaveis.assessment_model.getUse_ward_room().equalsIgnoreCase("Bullnose valve")) {
                idChkBullnoseC.setChecked(true);
            } else if (Variaveis.assessment_model.getUse_ward_room().equalsIgnoreCase("Handwheel side outlet")) {
                idChkHandwheelC.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked2_cy(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkPINC:
                if (checked)
                    cbo_connection_cylinder = "Pin index";
                break;
            case R.id.idChkPINSC:
                if (checked)
                    cbo_connection_cylinder = "Pin-index side spindle valve";
                break;
            case R.id.idChkBullnoseC:
                if (checked)
                    cbo_connection_cylinder = "Bullnose valve";
                break;
            case R.id.idChkHandwheelC:
                if (checked)
                    cbo_connection_cylinder = "Handwheel side outlet";
                break;
        }
    }

    public void setRB_facil_receive() {
        idChkDailyC = findViewById(R.id.idChkDailyC);
        idChkWeeklyC = findViewById(R.id.idChkWeeklyC);
        idChkFortnightlyC = findViewById(R.id.idChkFortnightlyC);
        idChkMonthlyC = findViewById(R.id.idChkMonthlyC);
        idChkOnrequestC = findViewById(R.id.idChkOnrequestC);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getUse_ward_room())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getUse_ward_room().equalsIgnoreCase("Daily")) {
                idChkDailyC.setChecked(true);
            } else if (Variaveis.assessment_model.getUse_ward_room().equalsIgnoreCase("Weekly")) {
                idChkWeeklyC.setChecked(true);
            } else if (Variaveis.assessment_model.getUse_ward_room().equalsIgnoreCase("Fortnightly")) {
                idChkFortnightlyC.setChecked(true);
            } else if (Variaveis.assessment_model.getUse_ward_room().equalsIgnoreCase("Monthly")) {
                idChkMonthlyC.setChecked(true);
            } else if (Variaveis.assessment_model.getUse_ward_room().equalsIgnoreCase("On request")) {
                idChkOnrequestC.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked3_cy(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkDailyC:
                if (checked)
                    cbo_health_fac_receive = "Daily";
                break;
            case R.id.idChkWeeklyC:
                if (checked)
                    cbo_health_fac_receive = "Weekly";
                break;
            case R.id.idChkFortnightlyC:
                if (checked)
                    cbo_health_fac_receive = "Fortnightly";
                break;
            case R.id.idChkMonthlyC:
                if (checked)
                    cbo_health_fac_receive = "Monthly";
                break;
            case R.id.idChkOnrequestC:
                if (checked)
                    cbo_health_fac_receive = "On request";
                break;
        }
    }

    public void setRB_facility_suffered() {
        idChkYESSUC = findViewById(R.id.idChkYESSUC);
        idChkNOSC = findViewById(R.id.idChkNOSC);

        if (TextUtils.isEmpty(Variaveis.assessment_model.getUse_ward_room())) {
            Toast.makeText(this, "Sem dado", Toast.LENGTH_SHORT).show();
        } else {
            if (Variaveis.assessment_model.getUse_ward_room().equalsIgnoreCase("Yes")) {
                idChkYESSUC.setChecked(true);
            } else if (Variaveis.assessment_model.getUse_ward_room().equalsIgnoreCase("No")) {
                idChkNOSC.setChecked(true);
            }
        }
    }

    public void onRadioButtonClicked4_cy(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.idChkYESSUC:
                if (checked)
                    cbo_shortages = "Yes";
                break;
            case R.id.idChkNOSC:
                if (checked)
                    cbo_shortages = "No";
                break;
        }
    }


    public void InicializarComponentes() {
        btnBack = findViewById(R.id.btn_backC);
        btnNExt = findViewById(R.id.btn_next);

        txtAVGC = findViewById(R.id.idTxtAVGC);
        txtAVGMC = findViewById(R.id.idTxtAVGMC);
        txtTypeC = findViewById(R.id.idTxtTypeC);

        txtOtherC = findViewById(R.id.idTxtOtherC);

        txtNameSuppC = findViewById(R.id.idTxtNameSuppC);

        txtComment = findViewById(R.id.idTxtComment);
    }

    public void LimparCampos() {
        txtComment.setText("");
        txtNameSuppC.setText("");
        txtTypeC.setText("");
        txtAVGC.setText("");
        txtOtherC.setText("");
        txtAVGMC.setText("");
    }
}