package projecto.jhpiego.equipment_track_tools.generalForm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.adapter.All_data_adapter;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Database_connection;
import projecto.jhpiego.equipment_track_tools.generalUpdateForm.Update_interview_id;
import projecto.jhpiego.equipment_track_tools.model.Assessment_model;
import projecto.jhpiego.equipment_track_tools.variaveis.Variaveis;

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
import com.google.android.material.floatingactionbutton.FloatingActionButton;

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
                assessment_model.setTxtFullName(cursor.getString(1));
                assessment_model.setTxtOrganization(cursor.getString(2));
                assessment_model.setDataDates(cursor.getString(3));
                assessment_model.setChk_interview_type(cursor.getString(4));
                assessment_model.setTxtOthers(cursor.getString(5));
                assessment_model.setTxtSecInterV(cursor.getString(6));
                assessment_model.setTxtSecInterVTwoo(cursor.getString(7));

                assessment_model.setNome(cursor.getString(8));
                assessment_model.setEmail(cursor.getString(9));
                assessment_model.setTelephone(cursor.getString(10));
                assessment_model.setPosition(cursor.getString(11));
                assessment_model.setOther(cursor.getString(12));
                assessment_model.setOtherTwo(cursor.getString(13));

                assessment_model.setTxtHealthFacID(cursor.getString(14));
                assessment_model.setTxtName(cursor.getString(15));
                assessment_model.setTxtLocation(cursor.getString(16));
                assessment_model.setTxtDistrict(cursor.getString(17));
                assessment_model.setTxtProvince(cursor.getString(18));
                assessment_model.setTxtRegion(cursor.getString(19));
                assessment_model.setTxtGpsCardinates(cursor.getString(20));
                assessment_model.setChkLevelHeath(cursor.getString(21));
                assessment_model.setChkTypeHealthFac(cursor.getString(22));
                assessment_model.setCboOupatient(cursor.getString(23));
                assessment_model.setTxtTotal(cursor.getString(24));
                assessment_model.setTxtMaternity(cursor.getString(25));
                assessment_model.setTxtCicov(cursor.getString(26));
                assessment_model.setTxtIcu(cursor.getString(27));
                assessment_model.setChkDeptAvailable(cursor.getString(28));
                assessment_model.setTxtOther(cursor.getString(29));

                assessment_model.setChk_main_src_power_electricity(cursor.getString(30));
                assessment_model.setChk_often_power_outage(cursor.getString(31));
                assessment_model.setChk_last_power_outage(cursor.getString(32));
                assessment_model.setChk_duration_typical_power_outage(cursor.getString(33));
                assessment_model.setChk_schedule_power_outage(cursor.getString(34));
                assessment_model.setChk_secondary_src_electricty(cursor.getString(35));
                assessment_model.setChk_secondary_power_src_provide_Pow_entire(cursor.getString(36));
                assessment_model.setChk_areas_receive_power(cursor.getString(37));
                assessment_model.setTxt_other_area_receive_power(cursor.getString(38));
                assessment_model.setTxt_comment_power_src(cursor.getString(39));
                assessment_model.setTxt_electricity_usage_last_month(cursor.getString(40));
                assessment_model.setTxt_cost_electricity_bill_last_month(cursor.getString(41));
                assessment_model.setChk_condition_electricity_system(cursor.getString(42));
                assessment_model.setTxt_comment_electricity_system(cursor.getString(43));

                assessment_model.setChkGene(cursor.getString(44));
                assessment_model.setChkSuppElect(cursor.getString(45));
                assessment_model.setTxtOtherSuppEle(cursor.getString(46));
                assessment_model.setChkHoldSyste(cursor.getString(47));
                assessment_model.setChkGenWork(cursor.getString(48));
                assessment_model.setChkConditionEqu(cursor.getString(49));
                assessment_model.setChkATS(cursor.getString(50));
                assessment_model.setChkATSWorkin(cursor.getString(51));
                assessment_model.setChkFuelToday(cursor.getString(52));
                assessment_model.setTxtCapacity(cursor.getString(53));
                assessment_model.setChkPMProgram(cursor.getString(54));
                assessment_model.setChkCarrBy(cursor.getString(55));
                assessment_model.setTxtFreqPM(cursor.getString(56));
                assessment_model.setTxtNameOfMant(cursor.getString(57));
                assessment_model.setChkLogBook(cursor.getString(58));
                assessment_model.setChkLogBoobUpd(cursor.getString(59));
                assessment_model.setTxtComent(cursor.getString(60));

                assessment_model.setChkGeneTwoo(cursor.getString(61));
                assessment_model.setChkSuppElectTwoo(cursor.getString(62));
                assessment_model.setTxtOtherSuppEleTwoo(cursor.getString(63));
                assessment_model.setChkHoldSysteTwoo(cursor.getString(64));
                assessment_model.setChkGenWorkTwoo(cursor.getString(65));
                assessment_model.setChkConditionEquipTwoo(cursor.getString(66));
                assessment_model.setChkATSTwoo(cursor.getString(67));
                assessment_model.setChkATSWorkinTwoo(cursor.getString(68));
                assessment_model.setChkFuelTodayTwoo(cursor.getString(69));
                assessment_model.setTxtCapacityTwoo(cursor.getString(70));
                assessment_model.setChkPMProgramTwoo(cursor.getString(71));
                assessment_model.setChkCarrByTwoo(cursor.getString(72));
                assessment_model.setTxtFreqPMTwoo(cursor.getString(73));
                assessment_model.setTxtNameOfMantTwoo(cursor.getString(74));
                assessment_model.setChkLogBookTwoo(cursor.getString(75));
                assessment_model.setChkLogBoobUpdTwoo(cursor.getString(76));
                assessment_model.setTxtComentTwoo(cursor.getString(77));
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