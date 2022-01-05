package projecto.jhpiego.equipment_track_tools.view.inventory;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.TelaPrincipal;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Database_connection;

public class FormEquipInventory extends AppCompatActivity {
    //    public ActivityDetailBinding binding;
    private Button btn_save, btn_back, btn_display, btn_edit;
    private TextView txtDept, txtTypeEquip, txtInvent_number, txtMake, txtModel, txtSerialNumber;
    private TextView txtEquipCondition, txtYearInstall, txtDataMaint, txtComment;
    Calendar calendar;
    ProgressBar progressBar;
    int id = 0;

    private String cboMain_contract;

    String[] mensagens = {"Preencha todos os campos", "Registado com sucesso", "Ocorreu algum erro inesperado, tenta novamente"};
    Database_connection DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_equip_inventory);
//        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        InitComponents();

        DB = new Database_connection(this);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String department = txtDept.getText().toString();
                String type_equipment = txtTypeEquip.getText().toString();
                String inventory_number = txtInvent_number.getText().toString();
                String make = txtMake.getText().toString();
                String model = txtModel.getText().toString();
                String serial_number = txtSerialNumber.getText().toString();
                String equip_condition = txtEquipCondition.getText().toString();
                String year_install = txtYearInstall.getText().toString();
                String main_contra = cboMain_contract;
                String data_last_main = txtDataMaint.getText().toString();
                String comment = txtComment.getText().toString();

                if (TextUtils.isEmpty(department) || TextUtils.isEmpty(type_equipment) || TextUtils.isEmpty(inventory_number) ||
                        TextUtils.isEmpty(make) || TextUtils.isEmpty(model) ||
                        TextUtils.isEmpty(serial_number) || TextUtils.isEmpty(equip_condition) || TextUtils.isEmpty(year_install) || TextUtils.isEmpty(data_last_main) || TextUtils.isEmpty(main_contra)) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(178, 34, 34));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    Boolean insert = DB.inventory(department, type_equipment, inventory_number, make, model, serial_number, equip_condition, year_install, main_contra, data_last_main, comment);
                    if (insert == true) {
                        Snackbar snackbar = Snackbar.make(v, mensagens[1], Snackbar.LENGTH_SHORT);
                        snackbar.setBackgroundTint(Color.rgb(176, 224, 230));
                        snackbar.setTextColor(Color.WHITE);
                        snackbar.show();
                        LimparCampo();
                        Intent intent = new Intent(FormEquipInventory.this, Form_inventory_view.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Snackbar snackbar = Snackbar.make(v, mensagens[2], Snackbar.LENGTH_SHORT);
                        snackbar.setBackgroundTint(Color.rgb(216, 191, 216));
                        snackbar.setTextColor(Color.WHITE);
                        snackbar.show();
                    }
                }
            }
        });


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iback = new Intent(FormEquipInventory.this, TelaPrincipal.class);
                startActivity(iback);
            }
        });

        Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                updateCalendar();
            }

            private void updateCalendar() {
                String format = "dd/MM/yyyy";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.US);

                txtDataMaint.setText(simpleDateFormat.format(calendar.getTime()));
            }
        };

        txtDataMaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(FormEquipInventory.this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radio_yes:
                if (checked)
                    cboMain_contract = "Sim";
                break;
            case R.id.radio_no:
                if (checked)
                    cboMain_contract = "Não";
                break;
        }
    }

    private void LimparCampo() {
        txtDept.setText("");
        txtTypeEquip.setText("");
        txtInvent_number.setText("");
        txtMake.setText("");
        txtModel.setText("");
        txtSerialNumber.setText("");
        txtEquipCondition.setText("");
        txtYearInstall.setText("");
        txtDataMaint.setText("");
        txtComment.setText("");
    }

    public void InitComponents() {
        btn_back = findViewById(R.id.btn_backInvent);
        btn_save = findViewById(R.id.btn_saveInvent);

        txtDept = findViewById(R.id.txtDept);
        txtTypeEquip = findViewById(R.id.txtTypeEquip);
        txtInvent_number = findViewById(R.id.txtIventNumber);
        txtMake = findViewById(R.id.txtMake);
        txtModel = findViewById(R.id.txtModel);
        txtSerialNumber = findViewById(R.id.txtSerialNumber);
        txtEquipCondition = findViewById(R.id.txtEquipCond);
        txtYearInstall = findViewById(R.id.txtYearInstall);
        txtDataMaint = findViewById(R.id.txtDataMaintenance);
        txtComment = findViewById(R.id.txtComment);

        progressBar = findViewById(R.id.progressbar);
    }
}