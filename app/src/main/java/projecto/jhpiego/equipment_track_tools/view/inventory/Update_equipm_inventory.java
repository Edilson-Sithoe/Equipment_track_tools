package projecto.jhpiego.equipment_track_tools.view.inventory;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Database_connection;
import projecto.jhpiego.equipment_track_tools.variaveis.Variaveis;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Update_equipm_inventory extends AppCompatActivity {

    private Button btn_update, btn_back, btn_delete;
    private EditText txtDept, txtTypeEquip, txtInvent_number, txtMake, txtModel, txtSerialNumber;
    private EditText txtEquipCondition, txtYearInstall, txtDataMaint, txtMain_contract, txtComment;
    private String cboMain_contract_edit;

    int id;
    String dept, typeEquip, invent_number, make, model, serialNumber;
    String equipCondition, yearInstall, dataMaint, main_contract, comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_equipm_inventory);
        InitComponents();

        getAndSetIntentData();

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(dept);
        }

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingData();
                Database_connection database_connection = new Database_connection(Update_equipm_inventory.this);
                if (database_connection.updateData(id, dept, typeEquip, invent_number, make, model, serialNumber, equipCondition, yearInstall, main_contract, dataMaint, comment)) {
                    Toast.makeText(Update_equipm_inventory.this, "Atualizado", Toast.LENGTH_LONG).show();
                } else
                    Toast.makeText(Update_equipm_inventory.this, "Falha ao atualizar os dados", Toast.LENGTH_LONG).show();
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
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
                new DatePickerDialog(Update_equipm_inventory.this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    private void settingData() {
        id = Variaveis.equipment_inventory.getId();
        dept = txtDept.getText().toString().trim();
        typeEquip = txtTypeEquip.getText().toString().trim();
        invent_number = txtInvent_number.getText().toString().trim();
        make = txtMake.getText().toString().trim();
        model = txtModel.getText().toString().trim();
        serialNumber = txtSerialNumber.getText().toString().trim();
        equipCondition = txtEquipCondition.getText().toString().trim();
        yearInstall = txtYearInstall.getText().toString().trim();
        main_contract = cboMain_contract_edit;
//        dataMaint = txtMain_contract.getText().toString();
        comment = txtComment.getText().toString().trim();
    }

    void getAndSetIntentData() {
        if (getIntent().hasExtra("id") && getIntent().hasExtra("department") && getIntent().hasExtra("type_equipment") &&
                getIntent().hasExtra("invent_number") && getIntent().hasExtra("make") && getIntent().hasExtra("model") &&
                getIntent().hasExtra("serial_number") && getIntent().hasExtra("equipment_condition") && getIntent().hasExtra("year_install") &&
                getIntent().hasExtra("data_maintenance") && getIntent().hasExtra("comment")) {
            Toast.makeText(this, "Sem dados para mostrar", Toast.LENGTH_SHORT).show();
        } else {

            txtDept.setText(Variaveis.equipment_inventory.getDepartment());
            txtTypeEquip.setText(Variaveis.equipment_inventory.getTypeEquipment());
            txtInvent_number.setText(Variaveis.equipment_inventory.getInventory_number());
            txtMake.setText(Variaveis.equipment_inventory.getMake());
            txtModel.setText(Variaveis.equipment_inventory.getModel());
            txtSerialNumber.setText(Variaveis.equipment_inventory.getSerial_number());
            txtEquipCondition.setText(Variaveis.equipment_inventory.getEquipment_condition());
            txtYearInstall.setText(Variaveis.equipment_inventory.getYear_install());
            txtDataMaint.setText(Variaveis.equipment_inventory.getData_last_main());
//          txtMain_contract.setText(Variaveis.equipment_inventory.getMain_contract());
            txtComment.setText(Variaveis.equipment_inventory.getComments());
        }

//        if (getIntent().hasExtra("id") && getIntent().hasExtra("department") && getIntent().hasExtra("type_equipment") &&
//        getIntent().hasExtra("invent_number") && getIntent().hasExtra("make") && getIntent().hasExtra("model") &&
//                getIntent().hasExtra("serial_number") && getIntent().hasExtra("equipment_condition") && getIntent().hasExtra("year_install") &&
//        getIntent().hasExtra("data_maintenance") && getIntent().hasExtra("comment")) {
//
//            // Getting Data from Intent
//            id = getIntent().getStringExtra("id");
//            dept = getIntent().getStringExtra("dept");
//            typeEquip = getIntent().getStringExtra("typeEquip");
//            invent_number = getIntent().getStringExtra("invent_number");
//            make = getIntent().getStringExtra("make");
//            model = getIntent().getStringExtra("model");
//            serialNumber = getIntent().getStringExtra("serialNumber");
//            equipCondition = getIntent().getStringExtra("equipCondition");
//            yearInstall = getIntent().getStringExtra("yearInstall");
//            main_contract = getIntent().getStringExtra("main_contract");
//            dataMaint = getIntent().getStringExtra("dataMaint");
//            comment = getIntent().getStringExtra("comment");
//
//            // Setting Intent Data
//            txtDept.setText(dept);
//            txtTypeEquip.setText(typeEquip);
//            txtInvent_number.setText(invent_number);
//            txtMake.setText(make);
//            txtModel.setText(model);
//            txtSerialNumber.setText(serialNumber);
//            txtEquipCondition.setText(equipCondition);
//            txtYearInstall.setText(yearInstall);
//            txtMain_contract.setText(main_contract);
//            txtDataMaint.setText(dataMaint);
//            txtComment.setText(comment);*/
//        } else {
//            Toast.makeText(this, "Sem dados para mostrar", Toast.LENGTH_SHORT).show();
//        }
    }

    void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Remover " + dept + " ?");
        builder.setMessage("Pretende apagar " + dept + " ?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Database_connection database_connection = new Database_connection(Update_equipm_inventory.this);
                database_connection.deleteOneRow(id);
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

    public void onRadioButtonClicked_edit(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radio_yes_edit:
                if (checked)
                    cboMain_contract_edit = "Sim";
                break;
            case R.id.radio_no_edit:
                if (checked)
                    cboMain_contract_edit = "Não";
                break;
        }
    }

    public void InitComponents() {
        btn_back = findViewById(R.id.btn_backInvent);
        btn_update = findViewById(R.id.btn_update);
        btn_delete = findViewById(R.id.btn_delete);

        txtDept = findViewById(R.id.txtDept_edit);
        txtTypeEquip = findViewById(R.id.txtTypeEquip_edit);
        txtInvent_number = findViewById(R.id.txtIventNumber_edit);
        txtMake = findViewById(R.id.txtMake_edit);
        txtModel = findViewById(R.id.txtModel_edit);
        txtSerialNumber = findViewById(R.id.txtSerialNumber_edit);
        txtEquipCondition = findViewById(R.id.txtEquipCond_edit);
        txtYearInstall = findViewById(R.id.txtYearInstall_edit);
        txtDataMaint = findViewById(R.id.txtDataMaintenance_edit);
        txtComment = findViewById(R.id.txtComment_edit);
    }

}