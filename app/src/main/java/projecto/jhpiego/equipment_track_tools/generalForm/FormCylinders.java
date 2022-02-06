package projecto.jhpiego.equipment_track_tools.generalForm;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;
import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Assessment;


public class FormCylinders extends AppCompatActivity {

    private Button btnBack, btnNExt;
    private TextView txtAVGC,txtAVGMC,txtTypeC,txtOtherC,txtNameSuppC, txtComment;
    String [] mensagens = {"Preencha todos os campos","Falha ao registar","Registado com sucesso"};
    String cbo_cylinder_ward,cbo_most_common,cbo_connection_cylinder,cbo_health_fac_receive,cbo_shortages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cylinders);

     //   getSupportActionBar().hide();
        InicializarComponentes();

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
                String name_supplier =  txtNameSuppC.getText().toString();
                String health_facility_receive = cbo_health_fac_receive;
                String health_facility_suffered = cbo_shortages;
                String comments_cylinders = txtComment.getText().toString();

                if (TextUtils.isEmpty(average_number) ||TextUtils.isEmpty(average_month)||TextUtils.isEmpty(type_cylinders)||TextUtils.isEmpty(name_supplier)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178,34,34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Assessment.assessment_model.setUse_ward_room(use_ward_room);
                    Assessment.assessment_model.setAverage_number(txtAVGC.getText().toString());
                    Assessment.assessment_model.setAverage_month(txtAVGMC.getText().toString());
                    Assessment.assessment_model.setType_cylinders(txtTypeC.getText().toString());
                    Assessment.assessment_model.setCommon_model_cylinder(common_model_cylinder);
                    Assessment.assessment_model.setCommon_model_cylinder_other(common_model_cylinder_other);
                    Assessment.assessment_model.setType_conection_cylinder(type_conection_cylinder);
                    Assessment.assessment_model.setName_supplier(txtNameSuppC.getText().toString());
                    Assessment.assessment_model.setHealth_facility_receive(health_facility_receive);
                    Assessment.assessment_model.setHealth_facility_suffered(health_facility_suffered);
                    Assessment.assessment_model.setComments_cylinders(txtComment.getText().toString());

                    Intent i = new Intent(FormCylinders.this, FormConcentrator.class);
                    startActivity(i);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iBack = new Intent(FormCylinders.this, FormFreePrevFFS.class);
                startActivity(iBack);
            }
        });

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
            case R.id.idChkNoC:
                if (checked)
                    cbo_most_common = "G (3.5m3/3400L)\"";
                break;
            case R.id.idChkGC:
                if (checked)
                    cbo_most_common = "J (7.5m3/7800L)";
                break;
            case R.id.idChkJC:
                if (checked)
                    cbo_most_common = "Don't know";
                break;
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



    public void InicializarComponentes(){
        btnBack = findViewById(R.id.btn_backC);
        btnNExt = findViewById(R.id.btn_next);

        txtAVGC = findViewById(R.id.idTxtAVGC);
        txtAVGMC = findViewById(R.id.idTxtAVGMC);
        txtTypeC = findViewById(R.id.idTxtTypeC);

        txtOtherC = findViewById(R.id.idTxtOtherC);

        txtNameSuppC = findViewById(R.id.idTxtNameSuppC);

        txtComment = findViewById(R.id.idTxtComment);
    }

    public void LimparCampos(){
        txtComment.setText("");
        txtNameSuppC.setText("");
        txtTypeC.setText("");
        txtAVGC.setText("");
        txtOtherC.setText("");
        txtAVGMC.setText("");
    }

}