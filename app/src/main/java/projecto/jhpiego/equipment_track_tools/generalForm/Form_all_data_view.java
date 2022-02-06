package projecto.jhpiego.equipment_track_tools.generalForm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import projecto.jhpiego.equipment_track_tools.R;
import projecto.jhpiego.equipment_track_tools.adapter.All_data_adapter;
import projecto.jhpiego.equipment_track_tools.databaseConnection.Database_connection;
import projecto.jhpiego.equipment_track_tools.generalUpdateForm.Update_liquid_ox_too;
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
                //     Intent intent = new Intent(Form_all_data_view.this, FormLiquidOxTwoo.class);
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
                Intent i = new Intent(Form_all_data_view.this, Update_liquid_ox_too.class);
                startActivity(i);

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
                assessment_model.setChkConditionEquip(cursor.getString(49));
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

                assessment_model.setChkGeneThree(cursor.getString(78));
                assessment_model.setChkSuppElectThree(cursor.getString(79));
                assessment_model.setTxtOtherSuppEleThree(cursor.getString(80));
                assessment_model.setChkHoldSysteThree(cursor.getString(81));
                assessment_model.setChkGenWorkThree(cursor.getString(82));
                assessment_model.setChkConditionEquipThree(cursor.getString(83));
                assessment_model.setChkATSThree(cursor.getString(84));
                assessment_model.setChkATSWorkinThree(cursor.getString(85));
                assessment_model.setChkFuelTodayThree(cursor.getString(86));
                assessment_model.setTxtCapacityThree(cursor.getString(87));
                assessment_model.setChkPMProgramThree(cursor.getString(88));
                assessment_model.setChkCarrByThree(cursor.getString(89));
                assessment_model.setTxtFreqPMThree(cursor.getString(90));
                assessment_model.setTxtNameOfMantThree(cursor.getString(91));
                assessment_model.setChkLogBookv(cursor.getString(92));
                assessment_model.setChkLogBoobUpdThree(cursor.getString(93));
                assessment_model.setTxtComentThree(cursor.getString(94));

                assessment_model.setChkGeneFour(cursor.getString(95));
                assessment_model.setChkSuppElectFour(cursor.getString(96));
                assessment_model.setTxtOtherSuppEleFour(cursor.getString(97));
                assessment_model.setChkHoldSysteFour(cursor.getString(98));
                assessment_model.setChkGenWorkFour(cursor.getString(99));
                assessment_model.setChkConditionEquipFour(cursor.getString(100));
                assessment_model.setChkATSFour(cursor.getString(101));
                assessment_model.setChkATSWorkinFour(cursor.getString(102));
                assessment_model.setChkFuelTodayFour(cursor.getString(103));
                assessment_model.setTxtCapacityFour(cursor.getString(104));
                assessment_model.setChkPMProgramFour(cursor.getString(105));
                assessment_model.setChkCarrByFour(cursor.getString(106));
                assessment_model.setTxtFreqPMFour(cursor.getString(107));
                assessment_model.setTxtNameOfMantv(cursor.getString(108));
                assessment_model.setChkLogBookFour(cursor.getString(109));
                assessment_model.setChkLogBoobUpdFour(cursor.getString(110));
                assessment_model.setTxtComentFour(cursor.getString(111));

                assessment_model.setChkVoltaStabilizer(cursor.getString(112));
                assessment_model.setChkHoldSystem(cursor.getString(113));
                assessment_model.setChkStabWorking(cursor.getString(114));
                assessment_model.setChkConditionEqu(cursor.getString(115));
                assessment_model.setTxtCapacityStab(cursor.getString(116));
                assessment_model.setChkPrevMain(cursor.getString(117));
                assessment_model.setChkActiCarries(cursor.getString(118));
                assessment_model.setTxtFrequenPM(cursor.getString(119));
                assessment_model.setTxtNameOfMantStab(cursor.getString(120));
                assessment_model.setChklogBookMaint(cursor.getString(121));
                assessment_model.setChkLogBookUp(cursor.getString(122));
                assessment_model.setTxtComentStab(cursor.getString(123));

                assessment_model.setChkSupUPSS(cursor.getString(124));
                assessment_model.setChkProvUPS(cursor.getString(125));
                assessment_model.setTxtOtherUPS(cursor.getString(126));
                assessment_model.setChkOldSystemUPS(cursor.getString(127));
                assessment_model.setChkWorkingUPS(cursor.getString(128));
                assessment_model.setChkCondEquipmUPS(cursor.getString(129));
                assessment_model.setTxtCapacityUPS(cursor.getString(130));
                assessment_model.setChkPMPUPS(cursor.getString(131));
                assessment_model.setChkCarrByUPS(cursor.getString(132));
                assessment_model.setTxtFreqPMUPS(cursor.getString(133));
                assessment_model.setTxtNameOfMantUPS(cursor.getString(134));
                assessment_model.setChkPMCMUPS(cursor.getString(135));
                assessment_model.setChklogbBookUPS(cursor.getString(136));
                assessment_model.setTxtComentUPS(cursor.getString(137));

                assessment_model.setChkSupUPSSTwhoo(cursor.getString(138));
                assessment_model.setChkProvUPTwhooS(cursor.getString(139));
                assessment_model.setTxtOtherUPSTwhoo(cursor.getString(140));
                assessment_model.setChkOldSystemUPSTwhoo(cursor.getString(141));
                assessment_model.setChkWorkingUPSTwhoo(cursor.getString(142));
                assessment_model.setChkCondEquipmUPSTwhoo(cursor.getString(143));
                assessment_model.setTxtCapacityUPSv(cursor.getString(144));
                assessment_model.setChkPMPUPSTwhoo(cursor.getString(145));
                assessment_model.setChkCarrByUPSTwhoo(cursor.getString(146));
                assessment_model.setTxtFreqPMUPSTwhoo(cursor.getString(147));
                assessment_model.setTxtNameOfMantUPSv(cursor.getString(148));
                assessment_model.setChkPMCMUPSTwhoo(cursor.getString(149));
                assessment_model.setChklogbBookUPSTwhoo(cursor.getString(150));
                assessment_model.setTxtComentUPSTwhoo(cursor.getString(151));

                assessment_model.setCboSolarP(cursor.getString(152));
                assessment_model.setCboAreaProv(cursor.getString(153));
                assessment_model.setCboOldSysSolar(cursor.getString(154));
                assessment_model.setCboSolarPSysWorking(cursor.getString(155));
                assessment_model.setCboConditionEquipmSolar(cursor.getString(156));
                assessment_model.setTxtCapacitySolarPower(cursor.getString(157));
                assessment_model.setCbobatterieInstalled(cursor.getString(158));
                assessment_model.setCboActivePM_solar(cursor.getString(159));
                assessment_model.setCboCarriesSolarBy(cursor.getString(160));
                assessment_model.setTxtFrequencyPM(cursor.getString(161));
                assessment_model.setTxtNameMainSolar(cursor.getString(162));
                assessment_model.setCboLogbbook_pmSolar(cursor.getString(163));
                assessment_model.setCboLogbbook_updateSolar(cursor.getString(164));
                assessment_model.setTxtCommentsSolar(cursor.getString(165));

                assessment_model.setTxtAverageConsOx(cursor.getString(166));
                assessment_model.setTxtSystem_usePrimarySupply(cursor.getString(167));
                assessment_model.setTxtSystem_use_secondary_supply(cursor.getString(168));
                assessment_model.setTxtSystem_use_emergency_supply(cursor.getString(169));
                assessment_model.setTxtComments_supply(cursor.getString(170));

                assessment_model.setSign_presence_gas(cursor.getString(171));
                assessment_model.setSign_emergency_contact(cursor.getString(172));
                assessment_model.setFire_extinguishers(cursor.getString(173));
                assessment_model.setType_extinguishers(cursor.getString(174));
                assessment_model.setType_extinguishers_other(cursor.getString(175));
                assessment_model.setLast_maintenance_fone(cursor.getString(176));
                assessment_model.setSensor_fire_alarme_system(cursor.getString(177));
                assessment_model.setSystem_working_sensor(cursor.getString(178));
                assessment_model.setLast_maintanance_done_sensor(cursor.getString(179));
                assessment_model.setHydrate_system_hose(cursor.getString(180));
                assessment_model.setSystem_working_hose(cursor.getString(181));
                assessment_model.setLast_maintenance_done_hose(cursor.getString(182));
                assessment_model.setSprinkler_system(cursor.getString(183));
                assessment_model.setSystem_working_sprinkler(cursor.getString(184));
                assessment_model.setLast_maintebance_done_sprinlker(cursor.getString(185));
                assessment_model.setEmergency_water_tank_full(cursor.getString(186));
                assessment_model.setComments_sprinkler(cursor.getString(187));

                assessment_model.setUse_ward_room(cursor.getString(188));
                assessment_model.setAverage_number(cursor.getString(189));
                assessment_model.setAverage_month(cursor.getString(190));
                assessment_model.setType_cylinders(cursor.getString(191));
                assessment_model.setCommon_model_cylinder(cursor.getString(192));
                assessment_model.setCommon_model_cylinder_other(cursor.getString(193));
                assessment_model.setType_conection_cylinder(cursor.getString(194));
                assessment_model.setName_supplier(cursor.getString(195));
                assessment_model.setHealth_facility_receive(cursor.getString(196));
                assessment_model.setHealth_facility_suffered(cursor.getString(197));
                assessment_model.setComments_cylinders(cursor.getString(198));

                assessment_model.setConcentrator_in_health_fac(cursor.getString(199));
                assessment_model.setNumber_concentrator(cursor.getString(200));
                assessment_model.setConcentrator_broken(cursor.getString(201));
                assessment_model.setActive_pm_program_conc(cursor.getString(202));
                assessment_model.setActive_carrie_by(cursor.getString(203));
                assessment_model.setFrequency_conce(cursor.getString(204));
                assessment_model.setName_maintenance_company(cursor.getString(205));
                assessment_model.setAverage_cost_per_year(cursor.getString(206));
                assessment_model.setBudgbet_maitanance_progra(cursor.getString(207));
                assessment_model.setLogbbook_maintenance_conc(cursor.getString(208));
                assessment_model.setLogbbook_update_cenc(cursor.getString(209));
                assessment_model.setComments_conc(cursor.getString(300));

                assessment_model.setManifold_in_health(cursor.getString(211));
                assessment_model.setType_supply_used_manifold(cursor.getString(212));
                assessment_model.setAreas_does_supply(cursor.getString(213));
                assessment_model.setAreas_does_supply_other(cursor.getString(214));
                assessment_model.setAreas_does_supply_otherTwoo(cursor.getString(215));
                assessment_model.setOld_system_manifold(cursor.getString(216));
                assessment_model.setKind_manifold(cursor.getString(217));
                assessment_model.setCapacity_manifold(cursor.getString(218));
                assessment_model.setDiameter_system(cursor.getString(219));
                assessment_model.setHow_many_cylinder_conect_rs(cursor.getString(220));
                assessment_model.setHow_many_cylinder_conect_ls(cursor.getString(221));
                assessment_model.setHow_many_cylinder_conect_total(cursor.getString(222));
                assessment_model.setAverage_per_month(cursor.getString(223));
                assessment_model.setMost_common_model_cylinder(cursor.getString(224));
                assessment_model.setMost_common_model_cylinder_other(cursor.getString(225));
                assessment_model.setType_conection_cylinder_maniFold(cursor.getString(226));
                assessment_model.setManifold_working(cursor.getString(227));
                assessment_model.setCondition_system(cursor.getString(228));
                assessment_model.setActive_pm_program_manif(cursor.getString(229));
                assessment_model.setFrequency_pm_mani(cursor.getString(230));
                assessment_model.setActivities_by(cursor.getString(231));
                assessment_model.setName_maintenance_maniFold(cursor.getString(232));
                assessment_model.setAverage_cost_per_year_maniFold(cursor.getString(233));
                assessment_model.setBugdet_maitenance_program(cursor.getString(234));
                assessment_model.setLogbbook_maintenance(cursor.getString(235));
                assessment_model.setLogbbook_update_manifold(cursor.getString(236));
                assessment_model.setName_cylinder_supply(cursor.getString(237));
                assessment_model.setHow_does_receive_cylinder(cursor.getString(238));
                assessment_model.setShortages_last_twoo_year(cursor.getString(239));
                assessment_model.setComments_manifold(cursor.getString(240));

                assessment_model.setManifold_in_health_twoo(cursor.getString(241));
                assessment_model.setType_supply_used_manifold_twoo(cursor.getString(242));
                assessment_model.setAreas_does_supply_twoo(cursor.getString(243));
                assessment_model.setAreas_does_supply_other_twoo(cursor.getString(244));
                assessment_model.setAreas_does_supply_otherTwoo_twoo(cursor.getString(245));
                assessment_model.setOld_system_manifold_twoo(cursor.getString(246));
                assessment_model.setKind_manifold_twoo(cursor.getString(247));
                assessment_model.setCapacity_manifold_twoo(cursor.getString(248));
                assessment_model.setDiameter_system_twoo(cursor.getString(249));
                assessment_model.setHow_many_cylinder_conect_rs_twoo(cursor.getString(250));
                assessment_model.setHow_many_cylinder_conect_ls_twoo(cursor.getString(251));
                assessment_model.setHow_many_cylinder_conect_total_twoo(cursor.getString(252));
                assessment_model.setAverage_per_month_twoo(cursor.getString(253));
                assessment_model.setMost_common_model_cylinder_twoo(cursor.getString(254));
                assessment_model.setMost_common_model_cylinder_other_twoo(cursor.getString(255));
                assessment_model.setType_conection_cylinder_twoo(cursor.getString(256));
                assessment_model.setManifold_working_twoo(cursor.getString(257));
                assessment_model.setCondition_system_twoo(cursor.getString(258));
                assessment_model.setActive_pm_program_manif_twoo(cursor.getString(259));
                assessment_model.setFrequency_pm_mani_twoo(cursor.getString(260));
                assessment_model.setActivities_by_twoo(cursor.getString(261));
                assessment_model.setName_maintenance_maniFold_twoo(cursor.getString(262));
                assessment_model.setAverage_cost_per_year_twoo(cursor.getString(263));
                assessment_model.setBugdet_maitenance_program_twoo(cursor.getString(264));
                assessment_model.setLogbbook_maintenance_twoo(cursor.getString(265));
                assessment_model.setLogbbook_update_manifold_twoo(cursor.getString(266));
                assessment_model.setName_cylinder_supply_twoo(cursor.getString(267));
                assessment_model.setHow_does_receive_cylinder_twoo(cursor.getString(268));
                assessment_model.setShortages_last_twoo_year_twoo(cursor.getString(269));
                assessment_model.setComments_manifold_twoo(cursor.getString(270));

                assessment_model.setManifold_in_health_emerg(cursor.getString(271));
                assessment_model.setType_supply_used_manifold_emerg(cursor.getString(272));
                assessment_model.setOld_system_manifold_emerg(cursor.getString(273));
                assessment_model.setKind_manifold_emerg(cursor.getString(274));
                assessment_model.setCapacity_manifold_emerg(cursor.getString(275));
                assessment_model.setDiameter_system_emerg(cursor.getString(276));
                assessment_model.setHow_many_cylinder_conect_total_emerg(cursor.getString(277));
                assessment_model.setAverage_per_month_emerg(cursor.getString(278));
                assessment_model.setMost_common_model_cylinder_emerg(cursor.getString(279));
                assessment_model.setMost_common_model_cylinder_other_emerg(cursor.getString(280));
                assessment_model.setType_conection_cylinder_mani_emerg(cursor.getString(281));
                assessment_model.setManifold_working_emerg(cursor.getString(282));
                assessment_model.setCondition_system_emerg(cursor.getString(283));
                assessment_model.setActive_pm_program_manif_emerg(cursor.getString(284));
                assessment_model.setFrequency_pm_mani_emerg(cursor.getString(285));
                assessment_model.setActivities_by_emerg(cursor.getString(286));
                assessment_model.setName_maintenance_maniFold_emerg(cursor.getString(287));
                assessment_model.setAverage_cost_per_year_emerg(cursor.getString(288));
                assessment_model.setBugdet_maitenance_program_emerg(cursor.getString(289));
                assessment_model.setLogbbook_maintena_emerg(cursor.getString(290));
                assessment_model.setLogbbook_update_manifold_emerg(cursor.getString(291));
                assessment_model.setName_cylinder_supply_emerg(cursor.getString(292));
                assessment_model.setHow_does_receive_cylinder_emerg(cursor.getString(293));
                assessment_model.setComments_manifold_emerg(cursor.getString(294));

                assessment_model.setLiquid_oxygen(cursor.getString(295));
                assessment_model.setAverage_consuming_oxygen(cursor.getString(296));
                assessment_model.setLast_month_consuminh(cursor.getString(297));
                assessment_model.setTank_owner(cursor.getString(298));
                assessment_model.setTank_owner_other(cursor.getString(299));
                assessment_model.setOld_system_oxygen(cursor.getString(300));
                assessment_model.setCapacity_lox_tank_m3(cursor.getString(301));
                assessment_model.setCapacity_lox_tank_ton(cursor.getString(302));
                assessment_model.setSystem_working_ox_tank(cursor.getString(303));
                assessment_model.setCondition_system_ox_tank(cursor.getString(304));
                assessment_model.setActive_pm_program(cursor.getString(305));
                assessment_model.setActivie_carrie_by_ox_tank(cursor.getString(306));
                assessment_model.setFrequency_ox_tank(cursor.getString(307));
                assessment_model.setName_maintenance_company_ox_tank(cursor.getString(308));
                assessment_model.setAverage_cost_ox_tank(cursor.getString(309));
                assessment_model.setBudget_lox_tank(cursor.getString(310));
                assessment_model.setLogbook_mainte_tank(cursor.getString(311));
                assessment_model.setLogbook_update_ox_tank(cursor.getString(312));
                assessment_model.setName_supply_ox_tank(cursor.getString(313));
                assessment_model.setHealth_receive_lox(cursor.getString(314));
                assessment_model.setShortages_lox(cursor.getString(315));
                assessment_model.setSpecialized_internal(cursor.getString(316));
                assessment_model.setHow_many_tecn_available(cursor.getString(317));
                assessment_model.setComment_ox_tank(cursor.getString(318));

                assessment_model.setLiquid_oxygen_twoo(cursor.getString(319));
                assessment_model.setAverage_consuming_oxygen_twoo(cursor.getString(320));
                assessment_model.setLast_month_consuminh_twoo(cursor.getString(321));
                assessment_model.setTank_owner_twoo(cursor.getString(322));
                assessment_model.setTank_owner_other_twhoo(cursor.getString(323));
                assessment_model.setOld_system_oxygen_twoo(cursor.getString(324));
                assessment_model.setCapacity_lox_tank_m3_twoo(cursor.getString(325));
                assessment_model.setCapacity_lox_tank_ton_twoo(cursor.getString(326));
                assessment_model.setSystem_working_ox_tank_twoo(cursor.getString(327));
                assessment_model.setCondition_system_ox_tank_twoo(cursor.getString(328));
                assessment_model.setActive_pm_program_twoo(cursor.getString(329));
                assessment_model.setActivie_carrie_by_ox_tank_twoo(cursor.getString(330));
                assessment_model.setFrequency_ox_tank_twoo(cursor.getString(331));
                assessment_model.setName_maintenance_company_ox_tank_twoo(cursor.getString(332));
                assessment_model.setAverage_cost_ox_tank_twoo(cursor.getString(333));
                assessment_model.setBudget_lox_tank_twoo(cursor.getString(334));
                assessment_model.setLogbook_maintenance_tank_two(cursor.getString(335));
                assessment_model.setLogbook_update_ox_tank_twoo(cursor.getString(336));
                assessment_model.setName_supply_ox_tank_twoo(cursor.getString(337));
                assessment_model.setHealth_receive_lox_twoo(cursor.getString(338));
                assessment_model.setShortages_lox_twoo(cursor.getString(339));
                assessment_model.setSpecialized_internal_twoo(cursor.getString(340));
                assessment_model.setHow_many_tecn_available_twoo(cursor.getString(341));
                assessment_model.setComment_ox_tank_twoo(cursor.getString(342));

                assessment_model.setOxygen_ox2_plant(cursor.getString(343));
                assessment_model.setOld_system_ox2(cursor.getString(344));
                assessment_model.setCapacity_factory_ox2(cursor.getString(345));
                assessment_model.setDiemeter_ox2(cursor.getString(346));
                assessment_model.setTota_production(cursor.getString(347));
                assessment_model.setSystem_working_ox2(cursor.getString(348));
                assessment_model.setCondition_ox2(cursor.getString(349));
                assessment_model.setSpecific_transformer_ox2(cursor.getString(350));
                assessment_model.setSpecific_generator_ox2(cursor.getString(351));
                assessment_model.setSpecific_ups_ox2(cursor.getString(352));
                assessment_model.setSpecific_stablilizer_ox2(cursor.getString(353));
                assessment_model.setManifolf_fill_cylinder(cursor.getString(354));
                assessment_model.setCap_fill_system_ox_cylinder(cursor.getString(355));
                assessment_model.setCap_ox_tank_fill_system(cursor.getString(356));
                assessment_model.setMost_common_ox2(cursor.getString(357));
                assessment_model.setSystem_working_ox2_ox(cursor.getString(358));
                assessment_model.setSupply_cylinder_ox2(cursor.getString(359));
                assessment_model.setWhich_supply_cylinder_ox2(cursor.getString(360));
                assessment_model.setHealth_supply_cyclinder(cursor.getString(361));
                assessment_model.setActive_pm_program_ox2(cursor.getString(362));
                assessment_model.setFrequency_pm_ox2(cursor.getString(363));
                assessment_model.setActivities_carried_by_ox2(cursor.getString(364));
                assessment_model.setName_maintenance_ox2(cursor.getString(365));
                assessment_model.setAverage_cost_year_ox2(cursor.getString(366));
                assessment_model.setBudget_ox2(cursor.getString(367));
                assessment_model.setSpecilized_tecn_internal_ox2(cursor.getString(368));
                assessment_model.setHow_many_tecn_available_ox2(cursor.getString(369));
                assessment_model.setAny_shortage_two_last_ox2(cursor.getString(370));
                assessment_model.setComments_ox2(cursor.getString(371));

                assessment_model.setSuction_system(cursor.getString(372));
                assessment_model.setOlde_system_ss(cursor.getString(373));
                assessment_model.setCapacity_system_ss(cursor.getString(374));
                assessment_model.setSuction_system_working(cursor.getString(375));
                assessment_model.setCondiction_system_ss(cursor.getString(376));
                assessment_model.setActive_pm_program(cursor.getString(377));
                assessment_model.setFrequency_pm_month_ss(cursor.getString(378));
                assessment_model.setActivities_carried_by_ss(cursor.getString(379));
                assessment_model.setName_maintenance_ss(cursor.getString(380));
                assessment_model.setAverage_pm_suction_ss(cursor.getString(381));
                assessment_model.setBudget_suction_ss(cursor.getString(382));
                assessment_model.setComment_suction(cursor.getString(383));

                assessment_model.setMedical_air_mas(cursor.getString(384));
                assessment_model.setOld_system_mas(cursor.getString(385));
                assessment_model.setSystem_capacity_mas(cursor.getString(386));
                assessment_model.setSystem_working_mmas(cursor.getString(387));
                assessment_model.setCondition_system_mas(cursor.getString(388));
                assessment_model.setActivies_carries_by_mas(cursor.getString(389));
                assessment_model.setFrequency_system_mas(cursor.getString(390));
                assessment_model.setActivies_carries_by_mas(cursor.getString(391));
                assessment_model.setName_maintenance_mas(cursor.getString(392));
                assessment_model.setAverage_mas(cursor.getString(393));
                assessment_model.setBudget_mas(cursor.getString(394));
                assessment_model.setComments_mas(cursor.getString(395));

                assessment_model.setPiping_network(cursor.getString(396));
                assessment_model.setOld_sysem_pp(cursor.getString(397));
                assessment_model.setSystem_working_pp(cursor.getString(398));
                assessment_model.setValves_for_each_area(cursor.getString(399));
                assessment_model.setStaff_know_where_shut_off(cursor.getString(400));
                assessment_model.setStaff_know_wher_close(cursor.getString(401));
                assessment_model.setHigh_low_pressure_alarm(cursor.getString(402));
                assessment_model.setCentralized_alarm(cursor.getString(403));
                assessment_model.setCondition_system_pp(cursor.getString(404));
                assessment_model.setType_plug_outlet(cursor.getString(405));
                assessment_model.setOther_type_plug_outlet(cursor.getString(406));
                assessment_model.setActive_pm_program(cursor.getString(407));
                assessment_model.setFrequency_system_pp(cursor.getString(408));
                assessment_model.setPm_actives_carried_pp(cursor.getString(409));
                assessment_model.setName_maintanance_pp(cursor.getString(410));
                assessment_model.setAverage_cost_piping(cursor.getString(411));
                assessment_model.setBudget_program_pp(cursor.getString(412));
                assessment_model.setComments_pp(cursor.getString(413));

                assessment_model.setReceive_ox_cylinder_log(cursor.getString(414));
                assessment_model.setReceive_ox_cyl_other(cursor.getString(415));
                assessment_model.setComments_rece_log(cursor.getString(416));
                assessment_model.setLogbook_cylinder_log(cursor.getString(417));
                assessment_model.setComments_logbook_log(cursor.getString(418));
                assessment_model.setUse_logb_lox_tank(cursor.getString(419));
                assessment_model.setComments_lox_tank(cursor.getString(420));
                assessment_model.setSupply_consuminh(cursor.getString(421));
                assessment_model.setComments_sup_consum(cursor.getString(422));

                assessment_model.setInventory_med_equip(cursor.getString(423));
                assessment_model.setFormat_med_equip(cursor.getString(424));
                assessment_model.setShow_status_equip(cursor.getString(425));
                assessment_model.setHow_the_repair(cursor.getString(426));
                assessment_model.setLevel_contract_pm(cursor.getString(427));
                assessment_model.setLevel_contract_pm_ot(cursor.getString(428));
                assessment_model.setActive_pm_mme(cursor.getString(429));
                assessment_model.setProtocol_follow_fill_in(cursor.getString(430));
                assessment_model.setRecorder_specific_way(cursor.getString(431));
                assessment_model.setControl_cost_assoc(cursor.getString(432));

                assessment_model.setLast_time_rec_super(cursor.getString(433));
                assessment_model.setLast_time_rec_sup_training(cursor.getString(434));

                assessment_model.setTecn_specil_available(cursor.getString(435));
                assessment_model.setTotal_number_tecni(cursor.getString(436));
                assessment_model.setNumber_tec_specia_health(cursor.getString(437));
                assessment_model.setNumber_biomedical(cursor.getString(438));
                assessment_model.setSafety_program_ox2(cursor.getString(439));
                assessment_model.setResponsable_savefy_program(cursor.getString(440));
                assessment_model.setNational_sec_system(cursor.getString(441));

                assessment_model.setEnd_users(cursor.getString(442));
                assessment_model.setHow_often_end_user_train(cursor.getString(443));
                assessment_model.setHow_many_users_trained(cursor.getString(444));
                assessment_model.setTecn_formed_aspect(cursor.getString(445));
                assessment_model.setHow_often_train_users(cursor.getString(446));
                assessment_model.setTecnic_trained(cursor.getString(447));
                assessment_model.setComments_train_cylinder(cursor.getString(448));

                assessment_model.setEnd_users_conc(cursor.getString(449));
                assessment_model.setFrequency_training(cursor.getString(450));
                assessment_model.setHow_many_users_formed(cursor.getString(451));
                assessment_model.setTecn_formed_aspect_conc(cursor.getString(452));
                assessment_model.setFrequency_training_conc_twoo(cursor.getString(453));
                assessment_model.setHow_many_tecnic_trained(cursor.getString(454));
                assessment_model.setComments_train_conc(cursor.getString(455));

                assessment_model.setTecni_train_lox(cursor.getString(456));
                assessment_model.setFrequency_trainnOT(cursor.getString(457));
                assessment_model.setHow_many_tecnic_trained(cursor.getString(458));
                assessment_model.setComments_train_lox(cursor.getString(459));

                assessment_model.setTecni_traine_related_manifolf(cursor.getString(460));
                assessment_model.setFrequency_trainig_manifold(cursor.getString(461));
                assessment_model.setHow_many_techn_trained_man_out(cursor.getString(462));
                assessment_model.setComments_train_man_out(cursor.getString(463));

                assessment_model.setTrain_matter_related_fact(cursor.getString(464));
                assessment_model.setFrequency_trainig_fact(cursor.getString(465));
                assessment_model.setTechi_trained_handling(cursor.getString(466));
                assessment_model.setComments_factory(cursor.getString(467));

                assessment_model.setEnd_users_gas_outlets(cursor.getString(468));
                assessment_model.setFrequency_trainig_gas_out(cursor.getString(469));
                assessment_model.setHow_many_end_users(cursor.getString(470));
                assessment_model.setComments_med_gas_outlets(cursor.getString(471));

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

    void confirmDialog() {
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