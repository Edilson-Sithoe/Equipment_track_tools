package projecto.jhpiego.equipment_track_tools.model;

public class Assessment_model {
    private int id;
    private String txtFullName;
    private String txtOrganization;
    private String dataDates;
    private String chk_interview_type;
    private String txtOthers;
    private String txtSecInterV;
    private String txtSecInterVTwoo;

    private String nome;
    private String email;
    private String telephone;
    private String position;
    private String other;
    private String otherTwo;

    private String txtHealthFacID;
    private String txtName;
    private String txtLocation;
    private String txtDistrict;
    private String txtProvince;
    private String txtRegion;
    private String txtGpsCardinates;
    private String chkLevelHeath;
    private String chkTypeHealthFac;
    private String cboOupatient;
    private String txtTotal;
    private String txtMaternity;
    private String txtCicov;
    private String txtIcu;
    private String chkDeptAvailable;
    private String txtOther;

    private String chk_main_src_power_electricity;
    private String chk_often_power_outage;
    private String chk_last_power_outage;
    private String chk_duration_typical_power_outage;
    private String chk_schedule_power_outage;
    private String chk_secondary_src_electricty;
    private String chk_secondary_power_src_provide_Pow_entire;
    private String chk_areas_receive_power;
    private String txt_other_area_receive_power;
    private String txt_comment_power_src;
    private String txt_electricity_usage_last_month;
    private String txt_cost_electricity_bill_last_month;
    private String chk_condition_electricity_system;
    private String txt_comment_electricity_system;

    /* *************************************** */
    private String chkGene;
    private String chkSuppElect;
    private String txtOtherSuppEle;
    private String chkHoldSyste;
    private String chkGenWork;
    private String chkConditionEquip;
    private String chkATS;
    private String chkATSWorkin;
    private String chkFuelToday;
    private String txtCapacity;
    private String chkPMProgram;
    private String chkCarrBy;
    private String txtFreqPM;
    private String txtNameOfMant;
    private String chkLogBook;
    private String chkLogBoobUpd;
    private String txtComent;
    /* ****************************************/

    private String chkGeneTwoo;
    private String chkSuppElectTwoo;
    private String txtOtherSuppEleTwoo;
    private String chkHoldSysteTwoo;
    private String chkGenWorkTwoo;
    private String chkConditionEquipTwoo;
    private String chkATSTwoo;
    private String chkATSWorkinTwoo;
    private String chkFuelTodayTwoo;
    private String txtCapacityTwoo;
    private String chkPMProgramTwoo;
    private String chkCarrByTwoo;
    private String txtFreqPMTwoo;
    private String txtNameOfMantTwoo;
    private String chkLogBookTwoo;
    private String chkLogBoobUpdTwoo;
    private String txtComentTwoo;
    /* terminei aqui la no all_dta_view*/
    /*  ****************************************/

    private String chkGeneThree;
    private String chkSuppElectThree;
    private String txtOtherSuppEleThree;
    private String chkHoldSysteThree;
    private String chkGenWorkThree;
    private String chkConditionEquipThree;
    private String chkATSThree;
    private String chkATSWorkinThree;
    private String chkFuelTodayThree;
    private String txtCapacityThree;
    private String chkPMProgramThree;
    private String chkCarrByThree;
    private String txtFreqPMThree;
    private String txtNameOfMantThree;
    private String chkLogBookv;
    private String chkLogBoobUpdThree;
    private String txtComentThree;
    /* ***************************************/

    private String chkGeneFour;
    private String chkSuppElectFour;
    private String txtOtherSuppEleFour;
    private String chkHoldSysteFour;
    private String chkGenWorkFour;
    private String chkConditionEquipFour;
    private String chkATSFour;
    private String chkATSWorkinFour;
    private String chkFuelTodayFour;
    private String txtCapacityFour;
    private String chkPMProgramFour;
    private String chkCarrByFour;
    private String txtFreqPMFour;
    private String txtNameOfMantv;
    private String chkLogBookFour;
    private String chkLogBoobUpdFour;
    private String txtComentFour;
    /*   ****************************************/

    private String chkVoltaStabilizer;
    private String chkHoldSystem;
    private String chkStabWorking;
    private String chkConditionEqu;
    private String txtCapacityStab;
    private String chkPrevMain;
    private String chkActiCarries;
    private String txtFrequenPM;
    private String txtNameOfMantStab;
    private String chklogBookMaint;
    private String chkLogBookUp;
    private String txtComentStab;
    /* ****************************************/

    private String chkSupUPSS;
    private String chkProvUPS;
    private String txtOtherUPS;
    private String chkOldSystemUPS;
    private String chkWorkingUPS;
    private String chkCondEquipmUPS;
    private String txtCapacityUPS;
    private String chkPMPUPS;
    private String chkCarrByUPS;
    private String txtFreqPMUPS;
    private String txtNameOfMantUPS;
    private String chkPMCMUPS;
    private String chklogbBookUPS;
    private String txtComentUPS;
    /* ****************************************/

    private String chkSupUPSSTwhoo;
    private String chkProvUPTwhooS;
    private String txtOtherUPSTwhoo;
    private String chkOldSystemUPSTwhoo;
    private String chkWorkingUPSTwhoo;
    private String chkCondEquipmUPSTwhoo;
    private String txtCapacityUPSv;
    private String chkPMPUPSTwhoo;
    private String chkCarrByUPSTwhoo;
    private String txtFreqPMUPSTwhoo;
    private String txtNameOfMantUPSv;
    private String chkPMCMUPSTwhoo;
    private String chklogbBookUPSTwhoo;
    private String txtComentUPSTwhoo;
    /* ************************************************************/

    private String txtSolarP;
    private String txtAreaProv;
    private String txtAreaProvOther;
    private String txtOldSysSolar;
    private String txtSolarPSysWorking;
    private String txtConditionEquipmSolar;
    private String txtCapacitySolarPower;
    private String txtbatterieInstalled;
    private String txtActivePM_solar;
    private String txtCarriesSolarBy;
    private String txtFrequencyPM;
    private String txtNameMainSolar;
    private String txtLogbbook_pmSolar;
    private String txtLogbbook_updateSolar;
    private String txtCommentsSolar;
    /* *****************************************************************/

    private String txtAverageConsOx;
    private String txtSystem_usePrimarySupply;
    private String txtSystem_use_secondary_supply;
    private String txtSystem_use_emergency_supply;
    private String txtComments_supply;
    /* ************************************************************/

    private String sign_presence_gas;
    private String sign_emergency_contact;
    private String fire_extinguishers;
    private String type_extinguishers;
    private String type_extinguishers_other;
    private String last_maintenance_fone;
    private String sensor_fire_alarme_system;
    private String system_working_sensor;
    private String last_maintanance_done_sensor;
    private String hydrate_system_hose;
    private String system_working_hose;
    private String last_maintenance_done_hose;
    private String sprinkler_system;
    private String system_working_sprinkler;
    private String last_maintebance_done_sprinlker;
    private String emergency_water_tank_full;
    private String comments_sprinkler;

    private String use_ward_room;
    private String average_number;
    private String average_month;
    private String type_cylinders;
    private String common_model_cylinder;
    private String common_model_cylinder_other;
    private String type_conection_cylinder;
    private String name_supplier;
    private String health_facility_receive;
    private String health_facility_suffered;
    private String comments_cylinders;

    private String concentrator_in_health_fac;
    private String number_concentrator;
    private String concentrator_broken;
    private String active_pm_program_conc;
    private String active_carrie_by;
    private String frequency_conce;
    private String name_maintenance_company;
    private String average_cost_per_year;
    private String budgbet_maitanance_progra;
    private String logbbook_maintenance_conc;
    private String logbbook_update_cenc;
    private String comments_conc;

    private String manifold_in_health;
    private String type_supply_used_manifold;
    private String areas_does_supply;
    private String areas_does_supply_other;
    private String areas_does_supply_otherTwoo;
    private String old_system_manifold;
    private String kind_manifold;
    private String capacity_manifold;
    private String diameter_system;
    private String how_many_cylinder_conect_rs;
    private String how_many_cylinder_conect_ls;
    private String how_many_cylinder_conect_total;
    private String average_per_month;
    private String most_common_model_cylinder;
    private String most_common_model_cylinder_other;
    private String type_conection_cylinder_maniFold;
    private String manifold_working;
    private String condition_system;
    private String active_pm_program_manif;
    private String frequency_pm_mani;
    private String activities_by;
    private String name_maintenance_maniFold;
    private String average_cost_per_year_maniFold;
    private String bugdet_maitenance_program;
    private String logbbook_maintenance;
    private String logbbook_update_manifold;
    private String name_cylinder_supply;
    private String how_does_receive_cylinder;
    private String shortages_last_twoo_year;
    private String comments_manifold;

    private String manifold_in_health_twoo;
    private String type_supply_used_manifold_twoo;
    private String areas_does_supply_twoo;
    private String areas_does_supply_other_twoo;
    private String areas_does_supply_otherTwoo_twoo;
    private String old_system_manifold_twoo;
    private String kind_manifold_twoo;
    private String capacity_manifold_twoo;
    private String diameter_system_twoo;
    private String how_many_cylinder_conect_rs_twoo;
    private String how_many_cylinder_conect_ls_twoo;
    private String how_many_cylinder_conect_total_twoo;
    private String average_per_month_twoo;
    private String most_common_model_cylinder_twoo;
    private String most_common_model_cylinder_other_twoo;
    private String type_conection_cylinder_twoo;
    private String manifold_working_twoo;
    private String condition_system_twoo;
    private String active_pm_program_manif_twoo;
    private String frequency_pm_mani_twoo;
    private String activities_by_twoo;
    private String name_maintenance_maniFold_twoo;
    private String average_cost_per_year_twoo;
    private String bugdet_maitenance_program_twoo;
    private String logbbook_maintenance_twoo;
    private String logbbook_update_manifold_twoo;
    private String name_cylinder_supply_twoo;
    private String how_does_receive_cylinder_twoo;
    private String shortages_last_twoo_year_twoo;
    private String comments_manifold_twoo;

    private String manifold_in_health_emerg;
    private String type_supply_used_manifold_emerg;
    private String old_system_manifold_emerg;
    private String kind_manifold_emerg;
    private String capacity_manifold_emerg;
    private String diameter_system_emerg;
    private String how_many_cylinder_conect_total_emerg;
    private String average_per_month_emerg;
    private String most_common_model_cylinder_emerg;
    private String most_common_model_cylinder_other_emerg;
    private String type_conection_cylinder_mani_emerg;
    private String manifold_working_emerg;
    private String condition_system_emerg;
    private String active_pm_program_manif_emerg;
    private String frequency_pm_mani_emerg;
    private String activities_by_emerg;
    private String name_maintenance_maniFold_emerg;
    private String average_cost_per_year_emerg;
    private String bugdet_maitenance_program_emerg;
    private String logbbook_maintena_emerg;
    private String logbbook_update_manifold_emerg;
    private String name_cylinder_supply_emerg;
    private String how_does_receive_cylinder_emerg;
    private String comments_manifold_emerg;

    private String liquid_oxygen;
    private String average_consuming_oxygen;
    private String last_month_consuminh;
    private String tank_owner;
    private String tank_owner_other;
    private String old_system_oxygen;
    private String capacity_lox_tank_m3;
    private String capacity_lox_tank_ton;
    private String system_working_ox_tank;
    private String condition_system_ox_tank;
    private String active_pm_program;
    private String activie_carrie_by_ox_tank;
    private String frequency_ox_tank;
    private String name_maintenance_company_ox_tank;
    private String average_cost_ox_tank;
    private String budget_lox_tank;
    private String logbook_mainte_tank;
    private String logbook_update_ox_tank;
    private String name_supply_ox_tank;
    private String health_receive_lox;
    private String shortages_lox;
    private String specialized_internal;
    private String how_many_tecn_available;
    private String comment_ox_tank;

    private String liquid_oxygen_twoo;
    private String average_consuming_oxygen_twoo;
    private String last_month_consuminh_twoo;
    private String tank_owner_twoo;
    private String tank_owner_other_twhoo;
    private String old_system_oxygen_twoo;
    private String capacity_lox_tank_m3_twoo;
    private String capacity_lox_tank_ton_twoo;
    private String system_working_ox_tank_twoo;
    private String condition_system_ox_tank_twoo;
    private String active_pm_program_twoo;
    private String activie_carrie_by_ox_tank_twoo;
    private String frequency_ox_tank_twoo;
    private String name_maintenance_company_ox_tank_twoo;
    private String average_cost_ox_tank_twoo;
    private String budget_lox_tank_twoo;
    private String logbbook_maintenance_twoo_mani;
    private String logbook_update_ox_tank_twoo;
    private String name_supply_ox_tank_twoo;
    private String health_receive_lox_twoo;
    private String shortages_lox_twoo;
    private String specialized_internal_twoo;
    private String how_many_tecn_available_twoo;
    private String comment_ox_tank_twoo;

    private String oxygen_ox2_plant;
    private String old_system_ox2;
    private String capacity_factory_ox2;
    private String diemeter_ox2;
    private String tota_production;
    private String system_working_ox2;
    private String condition_ox2;
    private String specific_transformer_ox2;
    private String specific_generator_ox2;
    private String specific_ups_ox2;
    private String specific_stablilizer_ox2;
    private String manifolf_fill_cylinder;
    private String cap_fill_system_ox_cylinder;
    private String cap_ox_tank_fill_system;
    private String most_common_ox2;
    private String system_working_ox2_ox;
    private String supply_cylinder_ox2;
    private String which_supply_cylinder_ox2;
    private String health_supply_cyclinder;
    private String active_pm_program_ox2;
    private String frequency_pm_ox2;
    private String activities_carried_by_ox2;
    private String name_maintenance_ox2;
    private String average_cost_year_ox2;
    private String budget_ox2;
    private String specilized_tecn_internal_ox2;
    private String how_many_tecn_available_ox2;
    private String any_shortage_two_last_ox2;
    private String comments_ox2;

    private String suction_system;
    private String olde_system_ss;
    private String capacity_system_ss;
    private String suction_system_working;
    private String condiction_system_ss;
    private String active_pm_program_ss;
    private String frequency_pm_month_ss;
    private String activities_carried_by_ss;
    private String name_maintenance_ss;
    private String average_pm_suction_ss;
    private String budget_suction_ss;
    private String comment_suction;

    private String medical_air_mas;
    private String old_system_mas;
    private String system_capacity_mas;
    private String system_working_mmas;
    private String condition_system_mas;
    private String active_pm_mas;
    private String frequency_system_mas;
    private String activies_carries_by_mas;
    private String name_maintenance_mas;
    private String average_mas;
    private String budget_mas;
    private String comments_mas;

    private String piping_network;
    private String old_sysem_pp;
    private String system_working_pp;
    private String valves_for_each_area;
    private String staff_know_where_shut_off;
    private String staff_know_wher_close;
    private String high_low_pressure_alarm;
    private String centralized_alarm;
    private String condition_system_pp;
    private String type_plug_outlet;
    private String other_type_plug_outlet;
    private String active_pm_program_pp;
    private String frequency_system_pp;
    private String pm_actives_carried_pp;
    private String name_maintanance_pp;
    private String average_cost_piping;
    private String budget_program_pp;
    private String comments_pp;

    private String receive_ox_cylinder_log;
    private String receive_ox_cyl_other;
    private String comments_rece_log;
    private String logbook_cylinder_log;
    private String comments_logbook_log;
    private String use_logb_lox_tank;
    private String comments_lox_tank;
    private String supply_consuminh;
    private String comments_sup_consum;

    private String inventory_med_equip;
    private String format_med_equip;
    private String show_status_equip;
    private String how_the_repair;
    private String level_contract_pm;
    private String level_contract_pm_ot;
    private String active_pm_mme;
    private String protocol_follow_fill_in;
    private String recorder_specific_way;
    private String control_cost_assoc;

    private String last_time_rec_super;
    private String last_time_rec_sup_training;

    private String tecn_specil_available;
    private String total_number_tecni;
    private String number_tec_specia_health;
    private String number_biomedical;
    private String safety_program_ox2;
    private String responsable_savefy_program;
    private String national_sec_system;

    private String end_users;
    private String how_often_end_user_train;
    private String how_many_users_trained;
    private String tecn_formed_aspect;
    private String how_often_train_users;
    private String tecnic_trained;
    private String comments_train_cylinder;

    private String end_users_conc;
    private String frequency_training;
    private String how_many_users_formed;
    private String tecn_formed_aspect_conc;
    private String frequency_training_conc_twoo;
    private String how_many_tecnic_trained;
    private String comments_train_conc;

    private String tecni_traine_related_manifolf;
    private String frequency_trainig_manifold;
    private String how_many_techn_trained_man_out;
    private String comments_train_man_out;

    private String tecni_train_lox;
    private String frequency_trainnOT;
    private String how_many_tech_trained_lox;
    private String comments_train_lox;

    private String train_matter_related_fact;
    private String frequency_trainig_fact;
    private String techi_trained_handling;
    private String comments_factory;

    private String end_users_gas_outlets;
    private String frequency_trainig_gas_out;
    private String how_many_end_users;
    private String comments_med_gas_outlets;

    public Assessment_model() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTxtFullName() {
        return txtFullName;
    }

    public void setTxtFullName(String txtFullName) {
        this.txtFullName = txtFullName;
    }

    public String getTxtOrganization() {
        return txtOrganization;
    }

    public void setTxtOrganization(String txtOrganization) {
        this.txtOrganization = txtOrganization;
    }

    public String getDataDates() {
        return dataDates;
    }

    public void setDataDates(String dataDates) {
        this.dataDates = dataDates;
    }

    public String getChk_interview_type() {
        return chk_interview_type;
    }

    public void setChk_interview_type(String chk_interview_type) {
        this.chk_interview_type = chk_interview_type;
    }

    public String getTxtOthers() {
        return txtOthers;
    }

    public void setTxtOthers(String txtOthers) {
        this.txtOthers = txtOthers;
    }

    public String getTxtSecInterV() {
        return txtSecInterV;
    }

    public void setTxtSecInterV(String txtSecInterV) {
        this.txtSecInterV = txtSecInterV;
    }

    public String getTxtSecInterVTwoo() {
        return txtSecInterVTwoo;
    }

    public void setTxtSecInterVTwoo(String txtSecInterVTwoo) {
        this.txtSecInterVTwoo = txtSecInterVTwoo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getOtherTwo() {
        return otherTwo;
    }

    public void setOtherTwo(String otherTwo) {
        this.otherTwo = otherTwo;
    }

    public String getTxtHealthFacID() {
        return txtHealthFacID;
    }

    public void setTxtHealthFacID(String txtHealthFacID) {
        this.txtHealthFacID = txtHealthFacID;
    }

    public String getTxtName() {
        return txtName;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public String getTxtLocation() {
        return txtLocation;
    }

    public void setTxtLocation(String txtLocation) {
        this.txtLocation = txtLocation;
    }

    public String getTxtDistrict() {
        return txtDistrict;
    }

    public void setTxtDistrict(String txtDistrict) {
        this.txtDistrict = txtDistrict;
    }

    public String getTxtProvince() {
        return txtProvince;
    }

    public void setTxtProvince(String txtProvince) {
        this.txtProvince = txtProvince;
    }

    public String getTxtRegion() {
        return txtRegion;
    }

    public void setTxtRegion(String txtRegion) {
        this.txtRegion = txtRegion;
    }

    public String getTxtGpsCardinates() {
        return txtGpsCardinates;
    }

    public void setTxtGpsCardinates(String txtGpsCardinates) {
        this.txtGpsCardinates = txtGpsCardinates;
    }

    public String getChkLevelHeath() {
        return chkLevelHeath;
    }

    public void setChkLevelHeath(String chkLevelHeath) {
        this.chkLevelHeath = chkLevelHeath;
    }

    public String getChkTypeHealthFac() {
        return chkTypeHealthFac;
    }

    public void setChkTypeHealthFac(String chkTypeHealthFac) {
        this.chkTypeHealthFac = chkTypeHealthFac;
    }

    public String getCboOupatient() {
        return cboOupatient;
    }

    public void setCboOupatient(String cboOupatient) {
        this.cboOupatient = cboOupatient;
    }

    public String getTxtTotal() {
        return txtTotal;
    }

    public void setTxtTotal(String txtTotal) {
        this.txtTotal = txtTotal;
    }

    public String getTxtMaternity() {
        return txtMaternity;
    }

    public void setTxtMaternity(String txtMaternity) {
        this.txtMaternity = txtMaternity;
    }

    public String getTxtCicov() {
        return txtCicov;
    }

    public void setTxtCicov(String txtCicov) {
        this.txtCicov = txtCicov;
    }

    public String getTxtIcu() {
        return txtIcu;
    }

    public void setTxtIcu(String txtIcu) {
        this.txtIcu = txtIcu;
    }

    public String getChkDeptAvailable() {
        return chkDeptAvailable;
    }

    public void setChkDeptAvailable(String chkDeptAvailable) {
        this.chkDeptAvailable = chkDeptAvailable;
    }

    public String getTxtOther() {
        return txtOther;
    }

    public void setTxtOther(String txtOther) {
        this.txtOther = txtOther;
    }

    public String getChk_main_src_power_electricity() {
        return chk_main_src_power_electricity;
    }

    public void setChk_main_src_power_electricity(String chk_main_src_power_electricity) {
        this.chk_main_src_power_electricity = chk_main_src_power_electricity;
    }

    public String getChk_often_power_outage() {
        return chk_often_power_outage;
    }

    public void setChk_often_power_outage(String chk_often_power_outage) {
        this.chk_often_power_outage = chk_often_power_outage;
    }

    public String getChk_last_power_outage() {
        return chk_last_power_outage;
    }

    public void setChk_last_power_outage(String chk_last_power_outage) {
        this.chk_last_power_outage = chk_last_power_outage;
    }

    public String getChk_duration_typical_power_outage() {
        return chk_duration_typical_power_outage;
    }

    public void setChk_duration_typical_power_outage(String chk_duration_typical_power_outage) {
        this.chk_duration_typical_power_outage = chk_duration_typical_power_outage;
    }

    public String getChk_schedule_power_outage() {
        return chk_schedule_power_outage;
    }

    public void setChk_schedule_power_outage(String chk_schedule_power_outage) {
        this.chk_schedule_power_outage = chk_schedule_power_outage;
    }

    public String getChk_secondary_src_electricty() {
        return chk_secondary_src_electricty;
    }

    public void setChk_secondary_src_electricty(String chk_secondary_src_electricty) {
        this.chk_secondary_src_electricty = chk_secondary_src_electricty;
    }

    public String getChk_secondary_power_src_provide_Pow_entire() {
        return chk_secondary_power_src_provide_Pow_entire;
    }

    public void setChk_secondary_power_src_provide_Pow_entire(String chk_secondary_power_src_provide_Pow_entire) {
        this.chk_secondary_power_src_provide_Pow_entire = chk_secondary_power_src_provide_Pow_entire;
    }

    public String getChk_areas_receive_power() {
        return chk_areas_receive_power;
    }

    public void setChk_areas_receive_power(String chk_areas_receive_power) {
        this.chk_areas_receive_power = chk_areas_receive_power;
    }

    public String getTxt_other_area_receive_power() {
        return txt_other_area_receive_power;
    }

    public void setTxt_other_area_receive_power(String txt_other_area_receive_power) {
        this.txt_other_area_receive_power = txt_other_area_receive_power;
    }

    public String getTxt_comment_power_src() {
        return txt_comment_power_src;
    }

    public void setTxt_comment_power_src(String txt_comment_power_src) {
        this.txt_comment_power_src = txt_comment_power_src;
    }

    public String getTxt_electricity_usage_last_month() {
        return txt_electricity_usage_last_month;
    }

    public void setTxt_electricity_usage_last_month(String txt_electricity_usage_last_month) {
        this.txt_electricity_usage_last_month = txt_electricity_usage_last_month;
    }

    public String getTxt_cost_electricity_bill_last_month() {
        return txt_cost_electricity_bill_last_month;
    }

    public void setTxt_cost_electricity_bill_last_month(String txt_cost_electricity_bill_last_month) {
        this.txt_cost_electricity_bill_last_month = txt_cost_electricity_bill_last_month;
    }

    public String getChk_condition_electricity_system() {
        return chk_condition_electricity_system;
    }

    public void setChk_condition_electricity_system(String chk_condition_electricity_system) {
        this.chk_condition_electricity_system = chk_condition_electricity_system;
    }

    public String getTxt_comment_electricity_system() {
        return txt_comment_electricity_system;
    }

    public void setTxt_comment_electricity_system(String txt_comment_electricity_system) {
        this.txt_comment_electricity_system = txt_comment_electricity_system;
    }

    public String getChkGene() {
        return chkGene;
    }

    public void setChkGene(String chkGene) {
        this.chkGene = chkGene;
    }

    public String getChkSuppElect() {
        return chkSuppElect;
    }

    public void setChkSuppElect(String chkSuppElect) {
        this.chkSuppElect = chkSuppElect;
    }

    public String getTxtOtherSuppEle() {
        return txtOtherSuppEle;
    }

    public void setTxtOtherSuppEle(String txtOtherSuppEle) {
        this.txtOtherSuppEle = txtOtherSuppEle;
    }

    public String getChkHoldSyste() {
        return chkHoldSyste;
    }

    public void setChkHoldSyste(String chkHoldSyste) {
        this.chkHoldSyste = chkHoldSyste;
    }

    public String getChkGenWork() {
        return chkGenWork;
    }

    public void setChkGenWork(String chkGenWork) {
        this.chkGenWork = chkGenWork;
    }

    public String getChkConditionEquip() {
        return chkConditionEquip;
    }

    public void setChkConditionEquip(String chkConditionEquip) {
        this.chkConditionEquip = chkConditionEquip;
    }

    public String getChkATS() {
        return chkATS;
    }

    public void setChkATS(String chkATS) {
        this.chkATS = chkATS;
    }

    public String getChkATSWorkin() {
        return chkATSWorkin;
    }

    public void setChkATSWorkin(String chkATSWorkin) {
        this.chkATSWorkin = chkATSWorkin;
    }

    public String getChkFuelToday() {
        return chkFuelToday;
    }

    public void setChkFuelToday(String chkFuelToday) {
        this.chkFuelToday = chkFuelToday;
    }

    public String getTxtCapacity() {
        return txtCapacity;
    }

    public void setTxtCapacity(String txtCapacity) {
        this.txtCapacity = txtCapacity;
    }

    public String getChkPMProgram() {
        return chkPMProgram;
    }

    public void setChkPMProgram(String chkPMProgram) {
        this.chkPMProgram = chkPMProgram;
    }

    public String getChkCarrBy() {
        return chkCarrBy;
    }

    public void setChkCarrBy(String chkCarrBy) {
        this.chkCarrBy = chkCarrBy;
    }

    public String getTxtFreqPM() {
        return txtFreqPM;
    }

    public void setTxtFreqPM(String txtFreqPM) {
        this.txtFreqPM = txtFreqPM;
    }

    public String getTxtNameOfMant() {
        return txtNameOfMant;
    }

    public void setTxtNameOfMant(String txtNameOfMant) {
        this.txtNameOfMant = txtNameOfMant;
    }

    public String getChkLogBook() {
        return chkLogBook;
    }

    public void setChkLogBook(String chkLogBook) {
        this.chkLogBook = chkLogBook;
    }

    public String getChkLogBoobUpd() {
        return chkLogBoobUpd;
    }

    public void setChkLogBoobUpd(String chkLogBoobUpd) {
        this.chkLogBoobUpd = chkLogBoobUpd;
    }

    public String getTxtComent() {
        return txtComent;
    }

    public void setTxtComent(String txtComent) {
        this.txtComent = txtComent;
    }

    public String getChkGeneTwoo() {
        return chkGeneTwoo;
    }

    public void setChkGeneTwoo(String chkGeneTwoo) {
        this.chkGeneTwoo = chkGeneTwoo;
    }

    public String getChkSuppElectTwoo() {
        return chkSuppElectTwoo;
    }

    public void setChkSuppElectTwoo(String chkSuppElectTwoo) {
        this.chkSuppElectTwoo = chkSuppElectTwoo;
    }

    public String getTxtOtherSuppEleTwoo() {
        return txtOtherSuppEleTwoo;
    }

    public void setTxtOtherSuppEleTwoo(String txtOtherSuppEleTwoo) {
        this.txtOtherSuppEleTwoo = txtOtherSuppEleTwoo;
    }

    public String getChkHoldSysteTwoo() {
        return chkHoldSysteTwoo;
    }

    public void setChkHoldSysteTwoo(String chkHoldSysteTwoo) {
        this.chkHoldSysteTwoo = chkHoldSysteTwoo;
    }

    public String getChkGenWorkTwoo() {
        return chkGenWorkTwoo;
    }

    public void setChkGenWorkTwoo(String chkGenWorkTwoo) {
        this.chkGenWorkTwoo = chkGenWorkTwoo;
    }

    public String getChkConditionEquipTwoo() {
        return chkConditionEquipTwoo;
    }

    public void setChkConditionEquipTwoo(String chkConditionEquipTwoo) {
        this.chkConditionEquipTwoo = chkConditionEquipTwoo;
    }

    public String getChkATSTwoo() {
        return chkATSTwoo;
    }

    public void setChkATSTwoo(String chkATSTwoo) {
        this.chkATSTwoo = chkATSTwoo;
    }

    public String getChkATSWorkinTwoo() {
        return chkATSWorkinTwoo;
    }

    public void setChkATSWorkinTwoo(String chkATSWorkinTwoo) {
        this.chkATSWorkinTwoo = chkATSWorkinTwoo;
    }

    public String getChkFuelTodayTwoo() {
        return chkFuelTodayTwoo;
    }

    public void setChkFuelTodayTwoo(String chkFuelTodayTwoo) {
        this.chkFuelTodayTwoo = chkFuelTodayTwoo;
    }

    public String getTxtCapacityTwoo() {
        return txtCapacityTwoo;
    }

    public void setTxtCapacityTwoo(String txtCapacityTwoo) {
        this.txtCapacityTwoo = txtCapacityTwoo;
    }

    public String getChkPMProgramTwoo() {
        return chkPMProgramTwoo;
    }

    public void setChkPMProgramTwoo(String chkPMProgramTwoo) {
        this.chkPMProgramTwoo = chkPMProgramTwoo;
    }

    public String getChkCarrByTwoo() {
        return chkCarrByTwoo;
    }

    public void setChkCarrByTwoo(String chkCarrByTwoo) {
        this.chkCarrByTwoo = chkCarrByTwoo;
    }

    public String getTxtFreqPMTwoo() {
        return txtFreqPMTwoo;
    }

    public void setTxtFreqPMTwoo(String txtFreqPMTwoo) {
        this.txtFreqPMTwoo = txtFreqPMTwoo;
    }

    public String getTxtNameOfMantTwoo() {
        return txtNameOfMantTwoo;
    }

    public void setTxtNameOfMantTwoo(String txtNameOfMantTwoo) {
        this.txtNameOfMantTwoo = txtNameOfMantTwoo;
    }

    public String getChkLogBookTwoo() {
        return chkLogBookTwoo;
    }

    public void setChkLogBookTwoo(String chkLogBookTwoo) {
        this.chkLogBookTwoo = chkLogBookTwoo;
    }

    public String getChkLogBoobUpdTwoo() {
        return chkLogBoobUpdTwoo;
    }

    public void setChkLogBoobUpdTwoo(String chkLogBoobUpdTwoo) {
        this.chkLogBoobUpdTwoo = chkLogBoobUpdTwoo;
    }

    public String getTxtComentTwoo() {
        return txtComentTwoo;
    }

    public void setTxtComentTwoo(String txtComentTwoo) {
        this.txtComentTwoo = txtComentTwoo;
    }

    public String getChkGeneThree() {
        return chkGeneThree;
    }

    public void setChkGeneThree(String chkGeneThree) {
        this.chkGeneThree = chkGeneThree;
    }

    public String getChkSuppElectThree() {
        return chkSuppElectThree;
    }

    public void setChkSuppElectThree(String chkSuppElectThree) {
        this.chkSuppElectThree = chkSuppElectThree;
    }

    public String getTxtOtherSuppEleThree() {
        return txtOtherSuppEleThree;
    }

    public void setTxtOtherSuppEleThree(String txtOtherSuppEleThree) {
        this.txtOtherSuppEleThree = txtOtherSuppEleThree;
    }

    public String getChkHoldSysteThree() {
        return chkHoldSysteThree;
    }

    public void setChkHoldSysteThree(String chkHoldSysteThree) {
        this.chkHoldSysteThree = chkHoldSysteThree;
    }

    public String getChkGenWorkThree() {
        return chkGenWorkThree;
    }

    public void setChkGenWorkThree(String chkGenWorkThree) {
        this.chkGenWorkThree = chkGenWorkThree;
    }

    public String getChkConditionEquipThree() {
        return chkConditionEquipThree;
    }

    public void setChkConditionEquipThree(String chkConditionEquipThree) {
        this.chkConditionEquipThree = chkConditionEquipThree;
    }

    public String getChkATSThree() {
        return chkATSThree;
    }

    public void setChkATSThree(String chkATSThree) {
        this.chkATSThree = chkATSThree;
    }

    public String getChkATSWorkinThree() {
        return chkATSWorkinThree;
    }

    public void setChkATSWorkinThree(String chkATSWorkinThree) {
        this.chkATSWorkinThree = chkATSWorkinThree;
    }

    public String getChkFuelTodayThree() {
        return chkFuelTodayThree;
    }

    public void setChkFuelTodayThree(String chkFuelTodayThree) {
        this.chkFuelTodayThree = chkFuelTodayThree;
    }

    public String getTxtCapacityThree() {
        return txtCapacityThree;
    }

    public void setTxtCapacityThree(String txtCapacityThree) {
        this.txtCapacityThree = txtCapacityThree;
    }

    public String getChkPMProgramThree() {
        return chkPMProgramThree;
    }

    public void setChkPMProgramThree(String chkPMProgramThree) {
        this.chkPMProgramThree = chkPMProgramThree;
    }

    public String getChkCarrByThree() {
        return chkCarrByThree;
    }

    public void setChkCarrByThree(String chkCarrByThree) {
        this.chkCarrByThree = chkCarrByThree;
    }

    public String getTxtFreqPMThree() {
        return txtFreqPMThree;
    }

    public void setTxtFreqPMThree(String txtFreqPMThree) {
        this.txtFreqPMThree = txtFreqPMThree;
    }

    public String getTxtNameOfMantThree() {
        return txtNameOfMantThree;
    }

    public void setTxtNameOfMantThree(String txtNameOfMantThree) {
        this.txtNameOfMantThree = txtNameOfMantThree;
    }

    public String getChkLogBookv() {
        return chkLogBookv;
    }

    public void setChkLogBookv(String chkLogBookv) {
        this.chkLogBookv = chkLogBookv;
    }

    public String getChkLogBoobUpdThree() {
        return chkLogBoobUpdThree;
    }

    public void setChkLogBoobUpdThree(String chkLogBoobUpdThree) {
        this.chkLogBoobUpdThree = chkLogBoobUpdThree;
    }

    public String getTxtComentThree() {
        return txtComentThree;
    }

    public void setTxtComentThree(String txtComentThree) {
        this.txtComentThree = txtComentThree;
    }

    public String getChkGeneFour() {
        return chkGeneFour;
    }

    public void setChkGeneFour(String chkGeneFour) {
        this.chkGeneFour = chkGeneFour;
    }

    public String getChkSuppElectFour() {
        return chkSuppElectFour;
    }

    public void setChkSuppElectFour(String chkSuppElectFour) {
        this.chkSuppElectFour = chkSuppElectFour;
    }

    public String getTxtOtherSuppEleFour() {
        return txtOtherSuppEleFour;
    }

    public void setTxtOtherSuppEleFour(String txtOtherSuppEleFour) {
        this.txtOtherSuppEleFour = txtOtherSuppEleFour;
    }

    public String getChkHoldSysteFour() {
        return chkHoldSysteFour;
    }

    public void setChkHoldSysteFour(String chkHoldSysteFour) {
        this.chkHoldSysteFour = chkHoldSysteFour;
    }

    public String getChkGenWorkFour() {
        return chkGenWorkFour;
    }

    public void setChkGenWorkFour(String chkGenWorkFour) {
        this.chkGenWorkFour = chkGenWorkFour;
    }

    public String getChkConditionEquipFour() {
        return chkConditionEquipFour;
    }

    public void setChkConditionEquipFour(String chkConditionEquipFour) {
        this.chkConditionEquipFour = chkConditionEquipFour;
    }

    public String getChkATSFour() {
        return chkATSFour;
    }

    public void setChkATSFour(String chkATSFour) {
        this.chkATSFour = chkATSFour;
    }

    public String getChkATSWorkinFour() {
        return chkATSWorkinFour;
    }

    public void setChkATSWorkinFour(String chkATSWorkinFour) {
        this.chkATSWorkinFour = chkATSWorkinFour;
    }

    public String getChkFuelTodayFour() {
        return chkFuelTodayFour;
    }

    public void setChkFuelTodayFour(String chkFuelTodayFour) {
        this.chkFuelTodayFour = chkFuelTodayFour;
    }

    public String getTxtCapacityFour() {
        return txtCapacityFour;
    }

    public void setTxtCapacityFour(String txtCapacityFour) {
        this.txtCapacityFour = txtCapacityFour;
    }

    public String getChkPMProgramFour() {
        return chkPMProgramFour;
    }

    public void setChkPMProgramFour(String chkPMProgramFour) {
        this.chkPMProgramFour = chkPMProgramFour;
    }

    public String getChkCarrByFour() {
        return chkCarrByFour;
    }

    public void setChkCarrByFour(String chkCarrByFour) {
        this.chkCarrByFour = chkCarrByFour;
    }

    public String getTxtFreqPMFour() {
        return txtFreqPMFour;
    }

    public void setTxtFreqPMFour(String txtFreqPMFour) {
        this.txtFreqPMFour = txtFreqPMFour;
    }

    public String getTxtNameOfMantv() {
        return txtNameOfMantv;
    }

    public void setTxtNameOfMantv(String txtNameOfMantv) {
        this.txtNameOfMantv = txtNameOfMantv;
    }

    public String getChkLogBookFour() {
        return chkLogBookFour;
    }

    public void setChkLogBookFour(String chkLogBookFour) {
        this.chkLogBookFour = chkLogBookFour;
    }

    public String getChkLogBoobUpdFour() {
        return chkLogBoobUpdFour;
    }

    public void setChkLogBoobUpdFour(String chkLogBoobUpdFour) {
        this.chkLogBoobUpdFour = chkLogBoobUpdFour;
    }

    public String getTxtComentFour() {
        return txtComentFour;
    }

    public void setTxtComentFour(String txtComentFour) {
        this.txtComentFour = txtComentFour;
    }

    public String getChkVoltaStabilizer() {
        return chkVoltaStabilizer;
    }

    public void setChkVoltaStabilizer(String chkVoltaStabilizer) {
        this.chkVoltaStabilizer = chkVoltaStabilizer;
    }

    public String getChkHoldSystem() {
        return chkHoldSystem;
    }

    public void setChkHoldSystem(String chkHoldSystem) {
        this.chkHoldSystem = chkHoldSystem;
    }

    public String getChkStabWorking() {
        return chkStabWorking;
    }

    public void setChkStabWorking(String chkStabWorking) {
        this.chkStabWorking = chkStabWorking;
    }

    public String getChkConditionEqu() {
        return chkConditionEqu;
    }

    public void setChkConditionEqu(String chkConditionEqu) {
        this.chkConditionEqu = chkConditionEqu;
    }

    public String getTxtCapacityStab() {
        return txtCapacityStab;
    }

    public void setTxtCapacityStab(String txtCapacityStab) {
        this.txtCapacityStab = txtCapacityStab;
    }

    public String getChkPrevMain() {
        return chkPrevMain;
    }

    public void setChkPrevMain(String chkPrevMain) {
        this.chkPrevMain = chkPrevMain;
    }

    public String getChkActiCarries() {
        return chkActiCarries;
    }

    public void setChkActiCarries(String chkActiCarries) {
        this.chkActiCarries = chkActiCarries;
    }

    public String getTxtFrequenPM() {
        return txtFrequenPM;
    }

    public void setTxtFrequenPM(String txtFrequenPM) {
        this.txtFrequenPM = txtFrequenPM;
    }

    public String getTxtNameOfMantStab() {
        return txtNameOfMantStab;
    }

    public void setTxtNameOfMantStab(String txtNameOfMantStab) {
        this.txtNameOfMantStab = txtNameOfMantStab;
    }

    public String getChklogBookMaint() {
        return chklogBookMaint;
    }

    public void setChklogBookMaint(String chklogBookMaint) {
        this.chklogBookMaint = chklogBookMaint;
    }

    public String getChkLogBookUp() {
        return chkLogBookUp;
    }

    public void setChkLogBookUp(String chkLogBookUp) {
        this.chkLogBookUp = chkLogBookUp;
    }

    public String getTxtComentStab() {
        return txtComentStab;
    }

    public void setTxtComentStab(String txtComentStab) {
        this.txtComentStab = txtComentStab;
    }

    public String getChkSupUPSS() {
        return chkSupUPSS;
    }

    public void setChkSupUPSS(String chkSupUPSS) {
        this.chkSupUPSS = chkSupUPSS;
    }

    public String getChkProvUPS() {
        return chkProvUPS;
    }

    public void setChkProvUPS(String chkProvUPS) {
        this.chkProvUPS = chkProvUPS;
    }

    public String getTxtOtherUPS() {
        return txtOtherUPS;
    }

    public void setTxtOtherUPS(String txtOtherUPS) {
        this.txtOtherUPS = txtOtherUPS;
    }

    public String getChkOldSystemUPS() {
        return chkOldSystemUPS;
    }

    public void setChkOldSystemUPS(String chkOldSystemUPS) {
        this.chkOldSystemUPS = chkOldSystemUPS;
    }

    public String getChkWorkingUPS() {
        return chkWorkingUPS;
    }

    public void setChkWorkingUPS(String chkWorkingUPS) {
        this.chkWorkingUPS = chkWorkingUPS;
    }

    public String getChkCondEquipmUPS() {
        return chkCondEquipmUPS;
    }

    public void setChkCondEquipmUPS(String chkCondEquipmUPS) {
        this.chkCondEquipmUPS = chkCondEquipmUPS;
    }

    public String getTxtCapacityUPS() {
        return txtCapacityUPS;
    }

    public void setTxtCapacityUPS(String txtCapacityUPS) {
        this.txtCapacityUPS = txtCapacityUPS;
    }

    public String getChkPMPUPS() {
        return chkPMPUPS;
    }

    public void setChkPMPUPS(String chkPMPUPS) {
        this.chkPMPUPS = chkPMPUPS;
    }

    public String getChkCarrByUPS() {
        return chkCarrByUPS;
    }

    public void setChkCarrByUPS(String chkCarrByUPS) {
        this.chkCarrByUPS = chkCarrByUPS;
    }

    public String getTxtFreqPMUPS() {
        return txtFreqPMUPS;
    }

    public void setTxtFreqPMUPS(String txtFreqPMUPS) {
        this.txtFreqPMUPS = txtFreqPMUPS;
    }

    public String getTxtNameOfMantUPS() {
        return txtNameOfMantUPS;
    }

    public void setTxtNameOfMantUPS(String txtNameOfMantUPS) {
        this.txtNameOfMantUPS = txtNameOfMantUPS;
    }

    public String getChkPMCMUPS() {
        return chkPMCMUPS;
    }

    public void setChkPMCMUPS(String chkPMCMUPS) {
        this.chkPMCMUPS = chkPMCMUPS;
    }

    public String getChklogbBookUPS() {
        return chklogbBookUPS;
    }

    public void setChklogbBookUPS(String chklogbBookUPS) {
        this.chklogbBookUPS = chklogbBookUPS;
    }

    public String getTxtComentUPS() {
        return txtComentUPS;
    }

    public void setTxtComentUPS(String txtComentUPS) {
        this.txtComentUPS = txtComentUPS;
    }

    public String getChkSupUPSSTwhoo() {
        return chkSupUPSSTwhoo;
    }

    public void setChkSupUPSSTwhoo(String chkSupUPSSTwhoo) {
        this.chkSupUPSSTwhoo = chkSupUPSSTwhoo;
    }

    public String getChkProvUPTwhooS() {
        return chkProvUPTwhooS;
    }

    public void setChkProvUPTwhooS(String chkProvUPTwhooS) {
        this.chkProvUPTwhooS = chkProvUPTwhooS;
    }

    public String getTxtOtherUPSTwhoo() {
        return txtOtherUPSTwhoo;
    }

    public void setTxtOtherUPSTwhoo(String txtOtherUPSTwhoo) {
        this.txtOtherUPSTwhoo = txtOtherUPSTwhoo;
    }

    public String getChkOldSystemUPSTwhoo() {
        return chkOldSystemUPSTwhoo;
    }

    public void setChkOldSystemUPSTwhoo(String chkOldSystemUPSTwhoo) {
        this.chkOldSystemUPSTwhoo = chkOldSystemUPSTwhoo;
    }

    public String getChkWorkingUPSTwhoo() {
        return chkWorkingUPSTwhoo;
    }

    public void setChkWorkingUPSTwhoo(String chkWorkingUPSTwhoo) {
        this.chkWorkingUPSTwhoo = chkWorkingUPSTwhoo;
    }

    public String getChkCondEquipmUPSTwhoo() {
        return chkCondEquipmUPSTwhoo;
    }

    public void setChkCondEquipmUPSTwhoo(String chkCondEquipmUPSTwhoo) {
        this.chkCondEquipmUPSTwhoo = chkCondEquipmUPSTwhoo;
    }

    public String getTxtCapacityUPSv() {
        return txtCapacityUPSv;
    }

    public void setTxtCapacityUPSv(String txtCapacityUPSv) {
        this.txtCapacityUPSv = txtCapacityUPSv;
    }

    public String getChkPMPUPSTwhoo() {
        return chkPMPUPSTwhoo;
    }

    public void setChkPMPUPSTwhoo(String chkPMPUPSTwhoo) {
        this.chkPMPUPSTwhoo = chkPMPUPSTwhoo;
    }

    public String getChkCarrByUPSTwhoo() {
        return chkCarrByUPSTwhoo;
    }

    public void setChkCarrByUPSTwhoo(String chkCarrByUPSTwhoo) {
        this.chkCarrByUPSTwhoo = chkCarrByUPSTwhoo;
    }

    public String getTxtFreqPMUPSTwhoo() {
        return txtFreqPMUPSTwhoo;
    }

    public void setTxtFreqPMUPSTwhoo(String txtFreqPMUPSTwhoo) {
        this.txtFreqPMUPSTwhoo = txtFreqPMUPSTwhoo;
    }

    public String getTxtNameOfMantUPSv() {
        return txtNameOfMantUPSv;
    }

    public void setTxtNameOfMantUPSv(String txtNameOfMantUPSv) {
        this.txtNameOfMantUPSv = txtNameOfMantUPSv;
    }

    public String getChkPMCMUPSTwhoo() {
        return chkPMCMUPSTwhoo;
    }

    public void setChkPMCMUPSTwhoo(String chkPMCMUPSTwhoo) {
        this.chkPMCMUPSTwhoo = chkPMCMUPSTwhoo;
    }

    public String getChklogbBookUPSTwhoo() {
        return chklogbBookUPSTwhoo;
    }

    public void setChklogbBookUPSTwhoo(String chklogbBookUPSTwhoo) {
        this.chklogbBookUPSTwhoo = chklogbBookUPSTwhoo;
    }

    public String getTxtComentUPSTwhoo() {
        return txtComentUPSTwhoo;
    }

    public void setTxtComentUPSTwhoo(String txtComentUPSTwhoo) {
        this.txtComentUPSTwhoo = txtComentUPSTwhoo;
    }

    public String getTxtSolarP() {
        return txtSolarP;
    }

    public void setTxtSolarP(String txtSolarP) {
        this.txtSolarP = txtSolarP;
    }

    public String getTxtAreaProv() {
        return txtAreaProv;
    }

    public void setTxtAreaProv(String txtAreaProv) {
        this.txtAreaProv = txtAreaProv;
    }

    public String getTxtAreaProvOther() {
        return txtAreaProvOther;
    }

    public void setTxtAreaProvOther(String txtAreaProvOther) {
        this.txtAreaProvOther = txtAreaProvOther;
    }

    public String getTxtOldSysSolar() {
        return txtOldSysSolar;
    }

    public void setTxtOldSysSolar(String txtOldSysSolar) {
        this.txtOldSysSolar = txtOldSysSolar;
    }

    public String getTxtSolarPSysWorking() {
        return txtSolarPSysWorking;
    }

    public void setTxtSolarPSysWorking(String txtSolarPSysWorking) {
        this.txtSolarPSysWorking = txtSolarPSysWorking;
    }

    public String getTxtConditionEquipmSolar() {
        return txtConditionEquipmSolar;
    }

    public void setTxtConditionEquipmSolar(String txtConditionEquipmSolar) {
        this.txtConditionEquipmSolar = txtConditionEquipmSolar;
    }

    public String getTxtCapacitySolarPower() {
        return txtCapacitySolarPower;
    }

    public void setTxtCapacitySolarPower(String txtCapacitySolarPower) {
        this.txtCapacitySolarPower = txtCapacitySolarPower;
    }

    public String getTxtbatterieInstalled() {
        return txtbatterieInstalled;
    }

    public void setTxtbatterieInstalled(String txtbatterieInstalled) {
        this.txtbatterieInstalled = txtbatterieInstalled;
    }

    public String getTxtActivePM_solar() {
        return txtActivePM_solar;
    }

    public void setTxtActivePM_solar(String txtActivePM_solar) {
        this.txtActivePM_solar = txtActivePM_solar;
    }

    public String getTxtCarriesSolarBy() {
        return txtCarriesSolarBy;
    }

    public void setTxtCarriesSolarBy(String txtCarriesSolarBy) {
        this.txtCarriesSolarBy = txtCarriesSolarBy;
    }

    public String getTxtFrequencyPM() {
        return txtFrequencyPM;
    }

    public void setTxtFrequencyPM(String txtFrequencyPM) {
        this.txtFrequencyPM = txtFrequencyPM;
    }

    public String getTxtNameMainSolar() {
        return txtNameMainSolar;
    }

    public void setTxtNameMainSolar(String txtNameMainSolar) {
        this.txtNameMainSolar = txtNameMainSolar;
    }

    public String getTxtLogbbook_pmSolar() {
        return txtLogbbook_pmSolar;
    }

    public void setTxtLogbbook_pmSolar(String txtLogbbook_pmSolar) {
        this.txtLogbbook_pmSolar = txtLogbbook_pmSolar;
    }

    public String getTxtLogbbook_updateSolar() {
        return txtLogbbook_updateSolar;
    }

    public void setTxtLogbbook_updateSolar(String txtLogbbook_updateSolar) {
        this.txtLogbbook_updateSolar = txtLogbbook_updateSolar;
    }

    public String getTxtCommentsSolar() {
        return txtCommentsSolar;
    }

    public void setTxtCommentsSolar(String txtCommentsSolar) {
        this.txtCommentsSolar = txtCommentsSolar;
    }

    public String getTxtAverageConsOx() {
        return txtAverageConsOx;
    }

    public void setTxtAverageConsOx(String txtAverageConsOx) {
        this.txtAverageConsOx = txtAverageConsOx;
    }

    public String getTxtSystem_usePrimarySupply() {
        return txtSystem_usePrimarySupply;
    }

    public void setTxtSystem_usePrimarySupply(String txtSystem_usePrimarySupply) {
        this.txtSystem_usePrimarySupply = txtSystem_usePrimarySupply;
    }

    public String getTxtSystem_use_secondary_supply() {
        return txtSystem_use_secondary_supply;
    }

    public void setTxtSystem_use_secondary_supply(String txtSystem_use_secondary_supply) {
        this.txtSystem_use_secondary_supply = txtSystem_use_secondary_supply;
    }

    public String getTxtSystem_use_emergency_supply() {
        return txtSystem_use_emergency_supply;
    }

    public void setTxtSystem_use_emergency_supply(String txtSystem_use_emergency_supply) {
        this.txtSystem_use_emergency_supply = txtSystem_use_emergency_supply;
    }

    public String getTxtComments_supply() {
        return txtComments_supply;
    }

    public void setTxtComments_supply(String txtComments_supply) {
        this.txtComments_supply = txtComments_supply;
    }

    public String getSign_presence_gas() {
        return sign_presence_gas;
    }

    public void setSign_presence_gas(String sign_presence_gas) {
        this.sign_presence_gas = sign_presence_gas;
    }

    public String getSign_emergency_contact() {
        return sign_emergency_contact;
    }

    public void setSign_emergency_contact(String sign_emergency_contact) {
        this.sign_emergency_contact = sign_emergency_contact;
    }

    public String getFire_extinguishers() {
        return fire_extinguishers;
    }

    public void setFire_extinguishers(String fire_extinguishers) {
        this.fire_extinguishers = fire_extinguishers;
    }

    public String getType_extinguishers() {
        return type_extinguishers;
    }

    public void setType_extinguishers(String type_extinguishers) {
        this.type_extinguishers = type_extinguishers;
    }

    public String getType_extinguishers_other() {
        return type_extinguishers_other;
    }

    public void setType_extinguishers_other(String type_extinguishers_other) {
        this.type_extinguishers_other = type_extinguishers_other;
    }

    public String getLast_maintenance_fone() {
        return last_maintenance_fone;
    }

    public void setLast_maintenance_fone(String last_maintenance_fone) {
        this.last_maintenance_fone = last_maintenance_fone;
    }

    public String getSensor_fire_alarme_system() {
        return sensor_fire_alarme_system;
    }

    public void setSensor_fire_alarme_system(String sensor_fire_alarme_system) {
        this.sensor_fire_alarme_system = sensor_fire_alarme_system;
    }

    public String getSystem_working_sensor() {
        return system_working_sensor;
    }

    public void setSystem_working_sensor(String system_working_sensor) {
        this.system_working_sensor = system_working_sensor;
    }

    public String getLast_maintanance_done_sensor() {
        return last_maintanance_done_sensor;
    }

    public void setLast_maintanance_done_sensor(String last_maintanance_done_sensor) {
        this.last_maintanance_done_sensor = last_maintanance_done_sensor;
    }

    public String getHydrate_system_hose() {
        return hydrate_system_hose;
    }

    public void setHydrate_system_hose(String hydrate_system_hose) {
        this.hydrate_system_hose = hydrate_system_hose;
    }

    public String getSystem_working_hose() {
        return system_working_hose;
    }

    public void setSystem_working_hose(String system_working_hose) {
        this.system_working_hose = system_working_hose;
    }

    public String getLast_maintenance_done_hose() {
        return last_maintenance_done_hose;
    }

    public void setLast_maintenance_done_hose(String last_maintenance_done_hose) {
        this.last_maintenance_done_hose = last_maintenance_done_hose;
    }

    public String getSprinkler_system() {
        return sprinkler_system;
    }

    public void setSprinkler_system(String sprinkler_system) {
        this.sprinkler_system = sprinkler_system;
    }

    public String getSystem_working_sprinkler() {
        return system_working_sprinkler;
    }

    public void setSystem_working_sprinkler(String system_working_sprinkler) {
        this.system_working_sprinkler = system_working_sprinkler;
    }

    public String getLast_maintebance_done_sprinlker() {
        return last_maintebance_done_sprinlker;
    }

    public void setLast_maintebance_done_sprinlker(String last_maintebance_done_sprinlker) {
        this.last_maintebance_done_sprinlker = last_maintebance_done_sprinlker;
    }

    public String getEmergency_water_tank_full() {
        return emergency_water_tank_full;
    }

    public void setEmergency_water_tank_full(String emergency_water_tank_full) {
        this.emergency_water_tank_full = emergency_water_tank_full;
    }

    public String getComments_sprinkler() {
        return comments_sprinkler;
    }

    public void setComments_sprinkler(String comments_sprinkler) {
        this.comments_sprinkler = comments_sprinkler;
    }

    public String getUse_ward_room() {
        return use_ward_room;
    }

    public void setUse_ward_room(String use_ward_room) {
        this.use_ward_room = use_ward_room;
    }

    public String getAverage_number() {
        return average_number;
    }

    public void setAverage_number(String average_number) {
        this.average_number = average_number;
    }

    public String getAverage_month() {
        return average_month;
    }

    public void setAverage_month(String average_month) {
        this.average_month = average_month;
    }

    public String getType_cylinders() {
        return type_cylinders;
    }

    public void setType_cylinders(String type_cylinders) {
        this.type_cylinders = type_cylinders;
    }

    public String getCommon_model_cylinder() {
        return common_model_cylinder;
    }

    public void setCommon_model_cylinder(String common_model_cylinder) {
        this.common_model_cylinder = common_model_cylinder;
    }

    public String getCommon_model_cylinder_other() {
        return common_model_cylinder_other;
    }

    public void setCommon_model_cylinder_other(String common_model_cylinder_other) {
        this.common_model_cylinder_other = common_model_cylinder_other;
    }

    public String getType_conection_cylinder() {
        return type_conection_cylinder;
    }

    public void setType_conection_cylinder(String type_conection_cylinder) {
        this.type_conection_cylinder = type_conection_cylinder;
    }

    public String getName_supplier() {
        return name_supplier;
    }

    public void setName_supplier(String name_supplier) {
        this.name_supplier = name_supplier;
    }

    public String getHealth_facility_receive() {
        return health_facility_receive;
    }

    public void setHealth_facility_receive(String health_facility_receive) {
        this.health_facility_receive = health_facility_receive;
    }

    public String getHealth_facility_suffered() {
        return health_facility_suffered;
    }

    public void setHealth_facility_suffered(String health_facility_suffered) {
        this.health_facility_suffered = health_facility_suffered;
    }

    public String getComments_cylinders() {
        return comments_cylinders;
    }

    public void setComments_cylinders(String comments_cylinders) {
        this.comments_cylinders = comments_cylinders;
    }

    public String getConcentrator_in_health_fac() {
        return concentrator_in_health_fac;
    }

    public void setConcentrator_in_health_fac(String concentrator_in_health_fac) {
        this.concentrator_in_health_fac = concentrator_in_health_fac;
    }

    public String getNumber_concentrator() {
        return number_concentrator;
    }

    public void setNumber_concentrator(String number_concentrator) {
        this.number_concentrator = number_concentrator;
    }

    public String getConcentrator_broken() {
        return concentrator_broken;
    }

    public void setConcentrator_broken(String concentrator_broken) {
        this.concentrator_broken = concentrator_broken;
    }

    public String getActive_pm_program_conc() {
        return active_pm_program_conc;
    }

    public void setActive_pm_program_conc(String active_pm_program_conc) {
        this.active_pm_program_conc = active_pm_program_conc;
    }

    public String getActive_carrie_by() {
        return active_carrie_by;
    }

    public void setActive_carrie_by(String active_carrie_by) {
        this.active_carrie_by = active_carrie_by;
    }

    public String getFrequency_conce() {
        return frequency_conce;
    }

    public void setFrequency_conce(String frequency_conce) {
        this.frequency_conce = frequency_conce;
    }

    public String getName_maintenance_company() {
        return name_maintenance_company;
    }

    public void setName_maintenance_company(String name_maintenance_company) {
        this.name_maintenance_company = name_maintenance_company;
    }

    public String getAverage_cost_per_year() {
        return average_cost_per_year;
    }

    public void setAverage_cost_per_year(String average_cost_per_year) {
        this.average_cost_per_year = average_cost_per_year;
    }

    public String getBudgbet_maitanance_progra() {
        return budgbet_maitanance_progra;
    }

    public void setBudgbet_maitanance_progra(String budgbet_maitanance_progra) {
        this.budgbet_maitanance_progra = budgbet_maitanance_progra;
    }

    public String getLogbbook_maintenance_conc() {
        return logbbook_maintenance_conc;
    }

    public void setLogbbook_maintenance_conc(String logbbook_maintenance_conc) {
        this.logbbook_maintenance_conc = logbbook_maintenance_conc;
    }

    public String getLogbbook_update_cenc() {
        return logbbook_update_cenc;
    }

    public void setLogbbook_update_cenc(String logbbook_update_cenc) {
        this.logbbook_update_cenc = logbbook_update_cenc;
    }

    public String getComments_conc() {
        return comments_conc;
    }

    public void setComments_conc(String comments_conc) {
        this.comments_conc = comments_conc;
    }

    public String getManifold_in_health() {
        return manifold_in_health;
    }

    public void setManifold_in_health(String manifold_in_health) {
        this.manifold_in_health = manifold_in_health;
    }

    public String getType_supply_used_manifold() {
        return type_supply_used_manifold;
    }

    public void setType_supply_used_manifold(String type_supply_used_manifold) {
        this.type_supply_used_manifold = type_supply_used_manifold;
    }

    public String getAreas_does_supply() {
        return areas_does_supply;
    }

    public void setAreas_does_supply(String areas_does_supply) {
        this.areas_does_supply = areas_does_supply;
    }

    public String getAreas_does_supply_other() {
        return areas_does_supply_other;
    }

    public void setAreas_does_supply_other(String areas_does_supply_other) {
        this.areas_does_supply_other = areas_does_supply_other;
    }

    public String getAreas_does_supply_otherTwoo() {
        return areas_does_supply_otherTwoo;
    }

    public void setAreas_does_supply_otherTwoo(String areas_does_supply_otherTwoo) {
        this.areas_does_supply_otherTwoo = areas_does_supply_otherTwoo;
    }

    public String getOld_system_manifold() {
        return old_system_manifold;
    }

    public void setOld_system_manifold(String old_system_manifold) {
        this.old_system_manifold = old_system_manifold;
    }

    public String getKind_manifold() {
        return kind_manifold;
    }

    public void setKind_manifold(String kind_manifold) {
        this.kind_manifold = kind_manifold;
    }

    public String getCapacity_manifold() {
        return capacity_manifold;
    }

    public void setCapacity_manifold(String capacity_manifold) {
        this.capacity_manifold = capacity_manifold;
    }

    public String getDiameter_system() {
        return diameter_system;
    }

    public void setDiameter_system(String diameter_system) {
        this.diameter_system = diameter_system;
    }

    public String getHow_many_cylinder_conect_rs() {
        return how_many_cylinder_conect_rs;
    }

    public void setHow_many_cylinder_conect_rs(String how_many_cylinder_conect_rs) {
        this.how_many_cylinder_conect_rs = how_many_cylinder_conect_rs;
    }

    public String getHow_many_cylinder_conect_ls() {
        return how_many_cylinder_conect_ls;
    }

    public void setHow_many_cylinder_conect_ls(String how_many_cylinder_conect_ls) {
        this.how_many_cylinder_conect_ls = how_many_cylinder_conect_ls;
    }

    public String getHow_many_cylinder_conect_total() {
        return how_many_cylinder_conect_total;
    }

    public void setHow_many_cylinder_conect_total(String how_many_cylinder_conect_total) {
        this.how_many_cylinder_conect_total = how_many_cylinder_conect_total;
    }

    public String getAverage_per_month() {
        return average_per_month;
    }

    public void setAverage_per_month(String average_per_month) {
        this.average_per_month = average_per_month;
    }

    public String getMost_common_model_cylinder() {
        return most_common_model_cylinder;
    }

    public void setMost_common_model_cylinder(String most_common_model_cylinder) {
        this.most_common_model_cylinder = most_common_model_cylinder;
    }

    public String getMost_common_model_cylinder_other() {
        return most_common_model_cylinder_other;
    }

    public void setMost_common_model_cylinder_other(String most_common_model_cylinder_other) {
        this.most_common_model_cylinder_other = most_common_model_cylinder_other;
    }

    public String getType_conection_cylinder_maniFold() {
        return type_conection_cylinder_maniFold;
    }

    public void setType_conection_cylinder_maniFold(String type_conection_cylinder_maniFold) {
        this.type_conection_cylinder_maniFold = type_conection_cylinder_maniFold;
    }

    public String getManifold_working() {
        return manifold_working;
    }

    public void setManifold_working(String manifold_working) {
        this.manifold_working = manifold_working;
    }

    public String getCondition_system() {
        return condition_system;
    }

    public void setCondition_system(String condition_system) {
        this.condition_system = condition_system;
    }

    public String getActive_pm_program_manif() {
        return active_pm_program_manif;
    }

    public void setActive_pm_program_manif(String active_pm_program_manif) {
        this.active_pm_program_manif = active_pm_program_manif;
    }

    public String getFrequency_pm_mani() {
        return frequency_pm_mani;
    }

    public void setFrequency_pm_mani(String frequency_pm_mani) {
        this.frequency_pm_mani = frequency_pm_mani;
    }

    public String getActivities_by() {
        return activities_by;
    }

    public void setActivities_by(String activities_by) {
        this.activities_by = activities_by;
    }

    public String getName_maintenance_maniFold() {
        return name_maintenance_maniFold;
    }

    public void setName_maintenance_maniFold(String name_maintenance_maniFold) {
        this.name_maintenance_maniFold = name_maintenance_maniFold;
    }

    public String getAverage_cost_per_year_maniFold() {
        return average_cost_per_year_maniFold;
    }

    public void setAverage_cost_per_year_maniFold(String average_cost_per_year_maniFold) {
        this.average_cost_per_year_maniFold = average_cost_per_year_maniFold;
    }

    public String getBugdet_maitenance_program() {
        return bugdet_maitenance_program;
    }

    public void setBugdet_maitenance_program(String bugdet_maitenance_program) {
        this.bugdet_maitenance_program = bugdet_maitenance_program;
    }

    public String getLogbbook_maintenance() {
        return logbbook_maintenance;
    }

    public void setLogbbook_maintenance(String logbbook_maintenance) {
        this.logbbook_maintenance = logbbook_maintenance;
    }

    public String getLogbbook_update_manifold() {
        return logbbook_update_manifold;
    }

    public void setLogbbook_update_manifold(String logbbook_update_manifold) {
        this.logbbook_update_manifold = logbbook_update_manifold;
    }

    public String getName_cylinder_supply() {
        return name_cylinder_supply;
    }

    public void setName_cylinder_supply(String name_cylinder_supply) {
        this.name_cylinder_supply = name_cylinder_supply;
    }

    public String getHow_does_receive_cylinder() {
        return how_does_receive_cylinder;
    }

    public void setHow_does_receive_cylinder(String how_does_receive_cylinder) {
        this.how_does_receive_cylinder = how_does_receive_cylinder;
    }

    public String getShortages_last_twoo_year() {
        return shortages_last_twoo_year;
    }

    public void setShortages_last_twoo_year(String shortages_last_twoo_year) {
        this.shortages_last_twoo_year = shortages_last_twoo_year;
    }

    public String getComments_manifold() {
        return comments_manifold;
    }

    public void setComments_manifold(String comments_manifold) {
        this.comments_manifold = comments_manifold;
    }

    public String getManifold_in_health_twoo() {
        return manifold_in_health_twoo;
    }

    public void setManifold_in_health_twoo(String manifold_in_health_twoo) {
        this.manifold_in_health_twoo = manifold_in_health_twoo;
    }

    public String getType_supply_used_manifold_twoo() {
        return type_supply_used_manifold_twoo;
    }

    public void setType_supply_used_manifold_twoo(String type_supply_used_manifold_twoo) {
        this.type_supply_used_manifold_twoo = type_supply_used_manifold_twoo;
    }

    public String getAreas_does_supply_twoo() {
        return areas_does_supply_twoo;
    }

    public void setAreas_does_supply_twoo(String areas_does_supply_twoo) {
        this.areas_does_supply_twoo = areas_does_supply_twoo;
    }

    public String getAreas_does_supply_other_twoo() {
        return areas_does_supply_other_twoo;
    }

    public void setAreas_does_supply_other_twoo(String areas_does_supply_other_twoo) {
        this.areas_does_supply_other_twoo = areas_does_supply_other_twoo;
    }

    public String getAreas_does_supply_otherTwoo_twoo() {
        return areas_does_supply_otherTwoo_twoo;
    }

    public void setAreas_does_supply_otherTwoo_twoo(String areas_does_supply_otherTwoo_twoo) {
        this.areas_does_supply_otherTwoo_twoo = areas_does_supply_otherTwoo_twoo;
    }

    public String getOld_system_manifold_twoo() {
        return old_system_manifold_twoo;
    }

    public void setOld_system_manifold_twoo(String old_system_manifold_twoo) {
        this.old_system_manifold_twoo = old_system_manifold_twoo;
    }

    public String getKind_manifold_twoo() {
        return kind_manifold_twoo;
    }

    public void setKind_manifold_twoo(String kind_manifold_twoo) {
        this.kind_manifold_twoo = kind_manifold_twoo;
    }

    public String getCapacity_manifold_twoo() {
        return capacity_manifold_twoo;
    }

    public void setCapacity_manifold_twoo(String capacity_manifold_twoo) {
        this.capacity_manifold_twoo = capacity_manifold_twoo;
    }

    public String getDiameter_system_twoo() {
        return diameter_system_twoo;
    }

    public void setDiameter_system_twoo(String diameter_system_twoo) {
        this.diameter_system_twoo = diameter_system_twoo;
    }

    public String getHow_many_cylinder_conect_rs_twoo() {
        return how_many_cylinder_conect_rs_twoo;
    }

    public void setHow_many_cylinder_conect_rs_twoo(String how_many_cylinder_conect_rs_twoo) {
        this.how_many_cylinder_conect_rs_twoo = how_many_cylinder_conect_rs_twoo;
    }

    public String getHow_many_cylinder_conect_ls_twoo() {
        return how_many_cylinder_conect_ls_twoo;
    }

    public void setHow_many_cylinder_conect_ls_twoo(String how_many_cylinder_conect_ls_twoo) {
        this.how_many_cylinder_conect_ls_twoo = how_many_cylinder_conect_ls_twoo;
    }

    public String getHow_many_cylinder_conect_total_twoo() {
        return how_many_cylinder_conect_total_twoo;
    }

    public void setHow_many_cylinder_conect_total_twoo(String how_many_cylinder_conect_total_twoo) {
        this.how_many_cylinder_conect_total_twoo = how_many_cylinder_conect_total_twoo;
    }

    public String getAverage_per_month_twoo() {
        return average_per_month_twoo;
    }

    public void setAverage_per_month_twoo(String average_per_month_twoo) {
        this.average_per_month_twoo = average_per_month_twoo;
    }

    public String getMost_common_model_cylinder_twoo() {
        return most_common_model_cylinder_twoo;
    }

    public void setMost_common_model_cylinder_twoo(String most_common_model_cylinder_twoo) {
        this.most_common_model_cylinder_twoo = most_common_model_cylinder_twoo;
    }

    public String getMost_common_model_cylinder_other_twoo() {
        return most_common_model_cylinder_other_twoo;
    }

    public void setMost_common_model_cylinder_other_twoo(String most_common_model_cylinder_other_twoo) {
        this.most_common_model_cylinder_other_twoo = most_common_model_cylinder_other_twoo;
    }

    public String getType_conection_cylinder_twoo() {
        return type_conection_cylinder_twoo;
    }

    public void setType_conection_cylinder_twoo(String type_conection_cylinder_twoo) {
        this.type_conection_cylinder_twoo = type_conection_cylinder_twoo;
    }

    public String getManifold_working_twoo() {
        return manifold_working_twoo;
    }

    public void setManifold_working_twoo(String manifold_working_twoo) {
        this.manifold_working_twoo = manifold_working_twoo;
    }

    public String getCondition_system_twoo() {
        return condition_system_twoo;
    }

    public void setCondition_system_twoo(String condition_system_twoo) {
        this.condition_system_twoo = condition_system_twoo;
    }

    public String getActive_pm_program_manif_twoo() {
        return active_pm_program_manif_twoo;
    }

    public void setActive_pm_program_manif_twoo(String active_pm_program_manif_twoo) {
        this.active_pm_program_manif_twoo = active_pm_program_manif_twoo;
    }

    public String getFrequency_pm_mani_twoo() {
        return frequency_pm_mani_twoo;
    }

    public void setFrequency_pm_mani_twoo(String frequency_pm_mani_twoo) {
        this.frequency_pm_mani_twoo = frequency_pm_mani_twoo;
    }

    public String getActivities_by_twoo() {
        return activities_by_twoo;
    }

    public void setActivities_by_twoo(String activities_by_twoo) {
        this.activities_by_twoo = activities_by_twoo;
    }

    public String getName_maintenance_maniFold_twoo() {
        return name_maintenance_maniFold_twoo;
    }

    public void setName_maintenance_maniFold_twoo(String name_maintenance_maniFold_twoo) {
        this.name_maintenance_maniFold_twoo = name_maintenance_maniFold_twoo;
    }

    public String getAverage_cost_per_year_twoo() {
        return average_cost_per_year_twoo;
    }

    public void setAverage_cost_per_year_twoo(String average_cost_per_year_twoo) {
        this.average_cost_per_year_twoo = average_cost_per_year_twoo;
    }

    public String getBugdet_maitenance_program_twoo() {
        return bugdet_maitenance_program_twoo;
    }

    public void setBugdet_maitenance_program_twoo(String bugdet_maitenance_program_twoo) {
        this.bugdet_maitenance_program_twoo = bugdet_maitenance_program_twoo;
    }

    public String getLogbbook_maintenance_twoo() {
        return logbbook_maintenance_twoo;
    }

    public void setLogbbook_maintenance_twoo(String logbbook_maintenance_twoo) {
        this.logbbook_maintenance_twoo = logbbook_maintenance_twoo;
    }

    public String getLogbbook_update_manifold_twoo() {
        return logbbook_update_manifold_twoo;
    }

    public void setLogbbook_update_manifold_twoo(String logbbook_update_manifold_twoo) {
        this.logbbook_update_manifold_twoo = logbbook_update_manifold_twoo;
    }

    public String getName_cylinder_supply_twoo() {
        return name_cylinder_supply_twoo;
    }

    public void setName_cylinder_supply_twoo(String name_cylinder_supply_twoo) {
        this.name_cylinder_supply_twoo = name_cylinder_supply_twoo;
    }

    public String getHow_does_receive_cylinder_twoo() {
        return how_does_receive_cylinder_twoo;
    }

    public void setHow_does_receive_cylinder_twoo(String how_does_receive_cylinder_twoo) {
        this.how_does_receive_cylinder_twoo = how_does_receive_cylinder_twoo;
    }

    public String getShortages_last_twoo_year_twoo() {
        return shortages_last_twoo_year_twoo;
    }

    public void setShortages_last_twoo_year_twoo(String shortages_last_twoo_year_twoo) {
        this.shortages_last_twoo_year_twoo = shortages_last_twoo_year_twoo;
    }

    public String getComments_manifold_twoo() {
        return comments_manifold_twoo;
    }

    public void setComments_manifold_twoo(String comments_manifold_twoo) {
        this.comments_manifold_twoo = comments_manifold_twoo;
    }

    public String getManifold_in_health_emerg() {
        return manifold_in_health_emerg;
    }

    public void setManifold_in_health_emerg(String manifold_in_health_emerg) {
        this.manifold_in_health_emerg = manifold_in_health_emerg;
    }

    public String getType_supply_used_manifold_emerg() {
        return type_supply_used_manifold_emerg;
    }

    public void setType_supply_used_manifold_emerg(String type_supply_used_manifold_emerg) {
        this.type_supply_used_manifold_emerg = type_supply_used_manifold_emerg;
    }

    public String getOld_system_manifold_emerg() {
        return old_system_manifold_emerg;
    }

    public void setOld_system_manifold_emerg(String old_system_manifold_emerg) {
        this.old_system_manifold_emerg = old_system_manifold_emerg;
    }

    public String getKind_manifold_emerg() {
        return kind_manifold_emerg;
    }

    public void setKind_manifold_emerg(String kind_manifold_emerg) {
        this.kind_manifold_emerg = kind_manifold_emerg;
    }

    public String getCapacity_manifold_emerg() {
        return capacity_manifold_emerg;
    }

    public void setCapacity_manifold_emerg(String capacity_manifold_emerg) {
        this.capacity_manifold_emerg = capacity_manifold_emerg;
    }

    public String getDiameter_system_emerg() {
        return diameter_system_emerg;
    }

    public void setDiameter_system_emerg(String diameter_system_emerg) {
        this.diameter_system_emerg = diameter_system_emerg;
    }

    public String getHow_many_cylinder_conect_total_emerg() {
        return how_many_cylinder_conect_total_emerg;
    }

    public void setHow_many_cylinder_conect_total_emerg(String how_many_cylinder_conect_total_emerg) {
        this.how_many_cylinder_conect_total_emerg = how_many_cylinder_conect_total_emerg;
    }

    public String getAverage_per_month_emerg() {
        return average_per_month_emerg;
    }

    public void setAverage_per_month_emerg(String average_per_month_emerg) {
        this.average_per_month_emerg = average_per_month_emerg;
    }

    public String getMost_common_model_cylinder_emerg() {
        return most_common_model_cylinder_emerg;
    }

    public void setMost_common_model_cylinder_emerg(String most_common_model_cylinder_emerg) {
        this.most_common_model_cylinder_emerg = most_common_model_cylinder_emerg;
    }

    public String getMost_common_model_cylinder_other_emerg() {
        return most_common_model_cylinder_other_emerg;
    }

    public void setMost_common_model_cylinder_other_emerg(String most_common_model_cylinder_other_emerg) {
        this.most_common_model_cylinder_other_emerg = most_common_model_cylinder_other_emerg;
    }

    public String getType_conection_cylinder_mani_emerg() {
        return type_conection_cylinder_mani_emerg;
    }

    public void setType_conection_cylinder_mani_emerg(String type_conection_cylinder_mani_emerg) {
        this.type_conection_cylinder_mani_emerg = type_conection_cylinder_mani_emerg;
    }

    public String getManifold_working_emerg() {
        return manifold_working_emerg;
    }

    public void setManifold_working_emerg(String manifold_working_emerg) {
        this.manifold_working_emerg = manifold_working_emerg;
    }

    public String getCondition_system_emerg() {
        return condition_system_emerg;
    }

    public void setCondition_system_emerg(String condition_system_emerg) {
        this.condition_system_emerg = condition_system_emerg;
    }

    public String getActive_pm_program_manif_emerg() {
        return active_pm_program_manif_emerg;
    }

    public void setActive_pm_program_manif_emerg(String active_pm_program_manif_emerg) {
        this.active_pm_program_manif_emerg = active_pm_program_manif_emerg;
    }

    public String getFrequency_pm_mani_emerg() {
        return frequency_pm_mani_emerg;
    }

    public void setFrequency_pm_mani_emerg(String frequency_pm_mani_emerg) {
        this.frequency_pm_mani_emerg = frequency_pm_mani_emerg;
    }

    public String getActivities_by_emerg() {
        return activities_by_emerg;
    }

    public void setActivities_by_emerg(String activities_by_emerg) {
        this.activities_by_emerg = activities_by_emerg;
    }

    public String getName_maintenance_maniFold_emerg() {
        return name_maintenance_maniFold_emerg;
    }

    public void setName_maintenance_maniFold_emerg(String name_maintenance_maniFold_emerg) {
        this.name_maintenance_maniFold_emerg = name_maintenance_maniFold_emerg;
    }

    public String getAverage_cost_per_year_emerg() {
        return average_cost_per_year_emerg;
    }

    public void setAverage_cost_per_year_emerg(String average_cost_per_year_emerg) {
        this.average_cost_per_year_emerg = average_cost_per_year_emerg;
    }

    public String getBugdet_maitenance_program_emerg() {
        return bugdet_maitenance_program_emerg;
    }

    public void setBugdet_maitenance_program_emerg(String bugdet_maitenance_program_emerg) {
        this.bugdet_maitenance_program_emerg = bugdet_maitenance_program_emerg;
    }

    public String getLogbbook_maintena_emerg() {
        return logbbook_maintena_emerg;
    }

    public void setLogbbook_maintena_emerg(String logbbook_maintena_emerg) {
        this.logbbook_maintena_emerg = logbbook_maintena_emerg;
    }

    public String getLogbbook_update_manifold_emerg() {
        return logbbook_update_manifold_emerg;
    }

    public void setLogbbook_update_manifold_emerg(String logbbook_update_manifold_emerg) {
        this.logbbook_update_manifold_emerg = logbbook_update_manifold_emerg;
    }

    public String getName_cylinder_supply_emerg() {
        return name_cylinder_supply_emerg;
    }

    public void setName_cylinder_supply_emerg(String name_cylinder_supply_emerg) {
        this.name_cylinder_supply_emerg = name_cylinder_supply_emerg;
    }

    public String getHow_does_receive_cylinder_emerg() {
        return how_does_receive_cylinder_emerg;
    }

    public void setHow_does_receive_cylinder_emerg(String how_does_receive_cylinder_emerg) {
        this.how_does_receive_cylinder_emerg = how_does_receive_cylinder_emerg;
    }

    public String getComments_manifold_emerg() {
        return comments_manifold_emerg;
    }

    public void setComments_manifold_emerg(String comments_manifold_emerg) {
        this.comments_manifold_emerg = comments_manifold_emerg;
    }

    public String getLiquid_oxygen() {
        return liquid_oxygen;
    }

    public void setLiquid_oxygen(String liquid_oxygen) {
        this.liquid_oxygen = liquid_oxygen;
    }

    public String getAverage_consuming_oxygen() {
        return average_consuming_oxygen;
    }

    public void setAverage_consuming_oxygen(String average_consuming_oxygen) {
        this.average_consuming_oxygen = average_consuming_oxygen;
    }

    public String getLast_month_consuminh() {
        return last_month_consuminh;
    }

    public void setLast_month_consuminh(String last_month_consuminh) {
        this.last_month_consuminh = last_month_consuminh;
    }

    public String getTank_owner() {
        return tank_owner;
    }

    public void setTank_owner(String tank_owner) {
        this.tank_owner = tank_owner;
    }

    public String getTank_owner_other() {
        return tank_owner_other;
    }

    public void setTank_owner_other(String tank_owner_other) {
        this.tank_owner_other = tank_owner_other;
    }

    public String getOld_system_oxygen() {
        return old_system_oxygen;
    }

    public void setOld_system_oxygen(String old_system_oxygen) {
        this.old_system_oxygen = old_system_oxygen;
    }

    public String getCapacity_lox_tank_m3() {
        return capacity_lox_tank_m3;
    }

    public void setCapacity_lox_tank_m3(String capacity_lox_tank_m3) {
        this.capacity_lox_tank_m3 = capacity_lox_tank_m3;
    }

    public String getCapacity_lox_tank_ton() {
        return capacity_lox_tank_ton;
    }

    public void setCapacity_lox_tank_ton(String capacity_lox_tank_ton) {
        this.capacity_lox_tank_ton = capacity_lox_tank_ton;
    }

    public String getSystem_working_ox_tank() {
        return system_working_ox_tank;
    }

    public void setSystem_working_ox_tank(String system_working_ox_tank) {
        this.system_working_ox_tank = system_working_ox_tank;
    }

    public String getCondition_system_ox_tank() {
        return condition_system_ox_tank;
    }

    public void setCondition_system_ox_tank(String condition_system_ox_tank) {
        this.condition_system_ox_tank = condition_system_ox_tank;
    }

    public String getActive_pm_program() {
        return active_pm_program;
    }

    public void setActive_pm_program(String active_pm_program) {
        this.active_pm_program = active_pm_program;
    }

    public String getActivie_carrie_by_ox_tank() {
        return activie_carrie_by_ox_tank;
    }

    public void setActivie_carrie_by_ox_tank(String activie_carrie_by_ox_tank) {
        this.activie_carrie_by_ox_tank = activie_carrie_by_ox_tank;
    }

    public String getFrequency_ox_tank() {
        return frequency_ox_tank;
    }

    public void setFrequency_ox_tank(String frequency_ox_tank) {
        this.frequency_ox_tank = frequency_ox_tank;
    }

    public String getName_maintenance_company_ox_tank() {
        return name_maintenance_company_ox_tank;
    }

    public void setName_maintenance_company_ox_tank(String name_maintenance_company_ox_tank) {
        this.name_maintenance_company_ox_tank = name_maintenance_company_ox_tank;
    }

    public String getAverage_cost_ox_tank() {
        return average_cost_ox_tank;
    }

    public void setAverage_cost_ox_tank(String average_cost_ox_tank) {
        this.average_cost_ox_tank = average_cost_ox_tank;
    }

    public String getBudget_lox_tank() {
        return budget_lox_tank;
    }

    public void setBudget_lox_tank(String budget_lox_tank) {
        this.budget_lox_tank = budget_lox_tank;
    }

    public String getLogbook_mainte_tank() {
        return logbook_mainte_tank;
    }

    public void setLogbook_mainte_tank(String logbook_mainte_tank) {
        this.logbook_mainte_tank = logbook_mainte_tank;
    }

    public String getLogbook_update_ox_tank() {
        return logbook_update_ox_tank;
    }

    public void setLogbook_update_ox_tank(String logbook_update_ox_tank) {
        this.logbook_update_ox_tank = logbook_update_ox_tank;
    }

    public String getName_supply_ox_tank() {
        return name_supply_ox_tank;
    }

    public void setName_supply_ox_tank(String name_supply_ox_tank) {
        this.name_supply_ox_tank = name_supply_ox_tank;
    }

    public String getHealth_receive_lox() {
        return health_receive_lox;
    }

    public void setHealth_receive_lox(String health_receive_lox) {
        this.health_receive_lox = health_receive_lox;
    }

    public String getShortages_lox() {
        return shortages_lox;
    }

    public void setShortages_lox(String shortages_lox) {
        this.shortages_lox = shortages_lox;
    }

    public String getSpecialized_internal() {
        return specialized_internal;
    }

    public void setSpecialized_internal(String specialized_internal) {
        this.specialized_internal = specialized_internal;
    }

    public String getHow_many_tecn_available() {
        return how_many_tecn_available;
    }

    public void setHow_many_tecn_available(String how_many_tecn_available) {
        this.how_many_tecn_available = how_many_tecn_available;
    }

    public String getComment_ox_tank() {
        return comment_ox_tank;
    }

    public void setComment_ox_tank(String comment_ox_tank) {
        this.comment_ox_tank = comment_ox_tank;
    }

    public String getLiquid_oxygen_twoo() {
        return liquid_oxygen_twoo;
    }

    public void setLiquid_oxygen_twoo(String liquid_oxygen_twoo) {
        this.liquid_oxygen_twoo = liquid_oxygen_twoo;
    }

    public String getAverage_consuming_oxygen_twoo() {
        return average_consuming_oxygen_twoo;
    }

    public void setAverage_consuming_oxygen_twoo(String average_consuming_oxygen_twoo) {
        this.average_consuming_oxygen_twoo = average_consuming_oxygen_twoo;
    }

    public String getLast_month_consuminh_twoo() {
        return last_month_consuminh_twoo;
    }

    public void setLast_month_consuminh_twoo(String last_month_consuminh_twoo) {
        this.last_month_consuminh_twoo = last_month_consuminh_twoo;
    }

    public String getTank_owner_twoo() {
        return tank_owner_twoo;
    }

    public void setTank_owner_twoo(String tank_owner_twoo) {
        this.tank_owner_twoo = tank_owner_twoo;
    }

    public String getTank_owner_other_twhoo() {
        return tank_owner_other_twhoo;
    }

    public void setTank_owner_other_twhoo(String tank_owner_other_twhoo) {
        this.tank_owner_other_twhoo = tank_owner_other_twhoo;
    }

    public String getOld_system_oxygen_twoo() {
        return old_system_oxygen_twoo;
    }

    public void setOld_system_oxygen_twoo(String old_system_oxygen_twoo) {
        this.old_system_oxygen_twoo = old_system_oxygen_twoo;
    }

    public String getCapacity_lox_tank_m3_twoo() {
        return capacity_lox_tank_m3_twoo;
    }

    public void setCapacity_lox_tank_m3_twoo(String capacity_lox_tank_m3_twoo) {
        this.capacity_lox_tank_m3_twoo = capacity_lox_tank_m3_twoo;
    }

    public String getCapacity_lox_tank_ton_twoo() {
        return capacity_lox_tank_ton_twoo;
    }

    public void setCapacity_lox_tank_ton_twoo(String capacity_lox_tank_ton_twoo) {
        this.capacity_lox_tank_ton_twoo = capacity_lox_tank_ton_twoo;
    }

    public String getSystem_working_ox_tank_twoo() {
        return system_working_ox_tank_twoo;
    }

    public void setSystem_working_ox_tank_twoo(String system_working_ox_tank_twoo) {
        this.system_working_ox_tank_twoo = system_working_ox_tank_twoo;
    }

    public String getCondition_system_ox_tank_twoo() {
        return condition_system_ox_tank_twoo;
    }

    public void setCondition_system_ox_tank_twoo(String condition_system_ox_tank_twoo) {
        this.condition_system_ox_tank_twoo = condition_system_ox_tank_twoo;
    }

    public String getActive_pm_program_twoo() {
        return active_pm_program_twoo;
    }

    public void setActive_pm_program_twoo(String active_pm_program_twoo) {
        this.active_pm_program_twoo = active_pm_program_twoo;
    }

    public String getActivie_carrie_by_ox_tank_twoo() {
        return activie_carrie_by_ox_tank_twoo;
    }

    public void setActivie_carrie_by_ox_tank_twoo(String activie_carrie_by_ox_tank_twoo) {
        this.activie_carrie_by_ox_tank_twoo = activie_carrie_by_ox_tank_twoo;
    }

    public String getFrequency_ox_tank_twoo() {
        return frequency_ox_tank_twoo;
    }

    public void setFrequency_ox_tank_twoo(String frequency_ox_tank_twoo) {
        this.frequency_ox_tank_twoo = frequency_ox_tank_twoo;
    }

    public String getName_maintenance_company_ox_tank_twoo() {
        return name_maintenance_company_ox_tank_twoo;
    }

    public void setName_maintenance_company_ox_tank_twoo(String name_maintenance_company_ox_tank_twoo) {
        this.name_maintenance_company_ox_tank_twoo = name_maintenance_company_ox_tank_twoo;
    }

    public String getAverage_cost_ox_tank_twoo() {
        return average_cost_ox_tank_twoo;
    }

    public void setAverage_cost_ox_tank_twoo(String average_cost_ox_tank_twoo) {
        this.average_cost_ox_tank_twoo = average_cost_ox_tank_twoo;
    }

    public String getBudget_lox_tank_twoo() {
        return budget_lox_tank_twoo;
    }

    public void setBudget_lox_tank_twoo(String budget_lox_tank_twoo) {
        this.budget_lox_tank_twoo = budget_lox_tank_twoo;
    }

    public String getLogbbook_maintenance_twoo_mani() {
        return logbbook_maintenance_twoo_mani;
    }

    public void setLogbbook_maintenance_twoo_mani(String logbbook_maintenance_twoo_mani) {
        this.logbbook_maintenance_twoo_mani = logbbook_maintenance_twoo_mani;
    }

    public String getLogbook_update_ox_tank_twoo() {
        return logbook_update_ox_tank_twoo;
    }

    public void setLogbook_update_ox_tank_twoo(String logbook_update_ox_tank_twoo) {
        this.logbook_update_ox_tank_twoo = logbook_update_ox_tank_twoo;
    }

    public String getName_supply_ox_tank_twoo() {
        return name_supply_ox_tank_twoo;
    }

    public void setName_supply_ox_tank_twoo(String name_supply_ox_tank_twoo) {
        this.name_supply_ox_tank_twoo = name_supply_ox_tank_twoo;
    }

    public String getHealth_receive_lox_twoo() {
        return health_receive_lox_twoo;
    }

    public void setHealth_receive_lox_twoo(String health_receive_lox_twoo) {
        this.health_receive_lox_twoo = health_receive_lox_twoo;
    }

    public String getShortages_lox_twoo() {
        return shortages_lox_twoo;
    }

    public void setShortages_lox_twoo(String shortages_lox_twoo) {
        this.shortages_lox_twoo = shortages_lox_twoo;
    }

    public String getSpecialized_internal_twoo() {
        return specialized_internal_twoo;
    }

    public void setSpecialized_internal_twoo(String specialized_internal_twoo) {
        this.specialized_internal_twoo = specialized_internal_twoo;
    }

    public String getHow_many_tecn_available_twoo() {
        return how_many_tecn_available_twoo;
    }

    public void setHow_many_tecn_available_twoo(String how_many_tecn_available_twoo) {
        this.how_many_tecn_available_twoo = how_many_tecn_available_twoo;
    }

    public String getComment_ox_tank_twoo() {
        return comment_ox_tank_twoo;
    }

    public void setComment_ox_tank_twoo(String comment_ox_tank_twoo) {
        this.comment_ox_tank_twoo = comment_ox_tank_twoo;
    }

    public String getOxygen_ox2_plant() {
        return oxygen_ox2_plant;
    }

    public void setOxygen_ox2_plant(String oxygen_ox2_plant) {
        this.oxygen_ox2_plant = oxygen_ox2_plant;
    }

    public String getOld_system_ox2() {
        return old_system_ox2;
    }

    public void setOld_system_ox2(String old_system_ox2) {
        this.old_system_ox2 = old_system_ox2;
    }

    public String getCapacity_factory_ox2() {
        return capacity_factory_ox2;
    }

    public void setCapacity_factory_ox2(String capacity_factory_ox2) {
        this.capacity_factory_ox2 = capacity_factory_ox2;
    }

    public String getDiemeter_ox2() {
        return diemeter_ox2;
    }

    public void setDiemeter_ox2(String diemeter_ox2) {
        this.diemeter_ox2 = diemeter_ox2;
    }

    public String getTota_production() {
        return tota_production;
    }

    public void setTota_production(String tota_production) {
        this.tota_production = tota_production;
    }

    public String getSystem_working_ox2() {
        return system_working_ox2;
    }

    public void setSystem_working_ox2(String system_working_ox2) {
        this.system_working_ox2 = system_working_ox2;
    }

    public String getCondition_ox2() {
        return condition_ox2;
    }

    public void setCondition_ox2(String condition_ox2) {
        this.condition_ox2 = condition_ox2;
    }

    public String getSpecific_transformer_ox2() {
        return specific_transformer_ox2;
    }

    public void setSpecific_transformer_ox2(String specific_transformer_ox2) {
        this.specific_transformer_ox2 = specific_transformer_ox2;
    }

    public String getSpecific_generator_ox2() {
        return specific_generator_ox2;
    }

    public void setSpecific_generator_ox2(String specific_generator_ox2) {
        this.specific_generator_ox2 = specific_generator_ox2;
    }

    public String getSpecific_ups_ox2() {
        return specific_ups_ox2;
    }

    public void setSpecific_ups_ox2(String specific_ups_ox2) {
        this.specific_ups_ox2 = specific_ups_ox2;
    }

    public String getSpecific_stablilizer_ox2() {
        return specific_stablilizer_ox2;
    }

    public void setSpecific_stablilizer_ox2(String specific_stablilizer_ox2) {
        this.specific_stablilizer_ox2 = specific_stablilizer_ox2;
    }

    public String getManifolf_fill_cylinder() {
        return manifolf_fill_cylinder;
    }

    public void setManifolf_fill_cylinder(String manifolf_fill_cylinder) {
        this.manifolf_fill_cylinder = manifolf_fill_cylinder;
    }

    public String getCap_fill_system_ox_cylinder() {
        return cap_fill_system_ox_cylinder;
    }

    public void setCap_fill_system_ox_cylinder(String cap_fill_system_ox_cylinder) {
        this.cap_fill_system_ox_cylinder = cap_fill_system_ox_cylinder;
    }

    public String getCap_ox_tank_fill_system() {
        return cap_ox_tank_fill_system;
    }

    public void setCap_ox_tank_fill_system(String cap_ox_tank_fill_system) {
        this.cap_ox_tank_fill_system = cap_ox_tank_fill_system;
    }

    public String getMost_common_ox2() {
        return most_common_ox2;
    }

    public void setMost_common_ox2(String most_common_ox2) {
        this.most_common_ox2 = most_common_ox2;
    }

    public String getSystem_working_ox2_ox() {
        return system_working_ox2_ox;
    }

    public void setSystem_working_ox2_ox(String system_working_ox2_ox) {
        this.system_working_ox2_ox = system_working_ox2_ox;
    }

    public String getSupply_cylinder_ox2() {
        return supply_cylinder_ox2;
    }

    public void setSupply_cylinder_ox2(String supply_cylinder_ox2) {
        this.supply_cylinder_ox2 = supply_cylinder_ox2;
    }

    public String getWhich_supply_cylinder_ox2() {
        return which_supply_cylinder_ox2;
    }

    public void setWhich_supply_cylinder_ox2(String which_supply_cylinder_ox2) {
        this.which_supply_cylinder_ox2 = which_supply_cylinder_ox2;
    }

    public String getHealth_supply_cyclinder() {
        return health_supply_cyclinder;
    }

    public void setHealth_supply_cyclinder(String health_supply_cyclinder) {
        this.health_supply_cyclinder = health_supply_cyclinder;
    }

    public String getActive_pm_program_ox2() {
        return active_pm_program_ox2;
    }

    public void setActive_pm_program_ox2(String active_pm_program_ox2) {
        this.active_pm_program_ox2 = active_pm_program_ox2;
    }

    public String getFrequency_pm_ox2() {
        return frequency_pm_ox2;
    }

    public void setFrequency_pm_ox2(String frequency_pm_ox2) {
        this.frequency_pm_ox2 = frequency_pm_ox2;
    }

    public String getActivities_carried_by_ox2() {
        return activities_carried_by_ox2;
    }

    public void setActivities_carried_by_ox2(String activities_carried_by_ox2) {
        this.activities_carried_by_ox2 = activities_carried_by_ox2;
    }

    public String getName_maintenance_ox2() {
        return name_maintenance_ox2;
    }

    public void setName_maintenance_ox2(String name_maintenance_ox2) {
        this.name_maintenance_ox2 = name_maintenance_ox2;
    }

    public String getAverage_cost_year_ox2() {
        return average_cost_year_ox2;
    }

    public void setAverage_cost_year_ox2(String average_cost_year_ox2) {
        this.average_cost_year_ox2 = average_cost_year_ox2;
    }

    public String getBudget_ox2() {
        return budget_ox2;
    }

    public void setBudget_ox2(String budget_ox2) {
        this.budget_ox2 = budget_ox2;
    }

    public String getSpecilized_tecn_internal_ox2() {
        return specilized_tecn_internal_ox2;
    }

    public void setSpecilized_tecn_internal_ox2(String specilized_tecn_internal_ox2) {
        this.specilized_tecn_internal_ox2 = specilized_tecn_internal_ox2;
    }

    public String getHow_many_tecn_available_ox2() {
        return how_many_tecn_available_ox2;
    }

    public void setHow_many_tecn_available_ox2(String how_many_tecn_available_ox2) {
        this.how_many_tecn_available_ox2 = how_many_tecn_available_ox2;
    }

    public String getAny_shortage_two_last_ox2() {
        return any_shortage_two_last_ox2;
    }

    public void setAny_shortage_two_last_ox2(String any_shortage_two_last_ox2) {
        this.any_shortage_two_last_ox2 = any_shortage_two_last_ox2;
    }

    public String getComments_ox2() {
        return comments_ox2;
    }

    public void setComments_ox2(String comments_ox2) {
        this.comments_ox2 = comments_ox2;
    }

    public String getSuction_system() {
        return suction_system;
    }

    public void setSuction_system(String suction_system) {
        this.suction_system = suction_system;
    }

    public String getOlde_system_ss() {
        return olde_system_ss;
    }

    public void setOlde_system_ss(String olde_system_ss) {
        this.olde_system_ss = olde_system_ss;
    }

    public String getCapacity_system_ss() {
        return capacity_system_ss;
    }

    public void setCapacity_system_ss(String capacity_system_ss) {
        this.capacity_system_ss = capacity_system_ss;
    }

    public String getSuction_system_working() {
        return suction_system_working;
    }

    public void setSuction_system_working(String suction_system_working) {
        this.suction_system_working = suction_system_working;
    }

    public String getCondiction_system_ss() {
        return condiction_system_ss;
    }

    public void setCondiction_system_ss(String condiction_system_ss) {
        this.condiction_system_ss = condiction_system_ss;
    }

    public String getActive_pm_program_ss() {
        return active_pm_program_ss;
    }

    public void setActive_pm_program_ss(String active_pm_program_ss) {
        this.active_pm_program_ss = active_pm_program_ss;
    }

    public String getFrequency_pm_month_ss() {
        return frequency_pm_month_ss;
    }

    public void setFrequency_pm_month_ss(String frequency_pm_month_ss) {
        this.frequency_pm_month_ss = frequency_pm_month_ss;
    }

    public String getActivities_carried_by_ss() {
        return activities_carried_by_ss;
    }

    public void setActivities_carried_by_ss(String activities_carried_by_ss) {
        this.activities_carried_by_ss = activities_carried_by_ss;
    }

    public String getName_maintenance_ss() {
        return name_maintenance_ss;
    }

    public void setName_maintenance_ss(String name_maintenance_ss) {
        this.name_maintenance_ss = name_maintenance_ss;
    }

    public String getAverage_pm_suction_ss() {
        return average_pm_suction_ss;
    }

    public void setAverage_pm_suction_ss(String average_pm_suction_ss) {
        this.average_pm_suction_ss = average_pm_suction_ss;
    }

    public String getBudget_suction_ss() {
        return budget_suction_ss;
    }

    public void setBudget_suction_ss(String budget_suction_ss) {
        this.budget_suction_ss = budget_suction_ss;
    }

    public String getComment_suction() {
        return comment_suction;
    }

    public void setComment_suction(String comment_suction) {
        this.comment_suction = comment_suction;
    }

    public String getMedical_air_mas() {
        return medical_air_mas;
    }

    public void setMedical_air_mas(String medical_air_mas) {
        this.medical_air_mas = medical_air_mas;
    }

    public String getOld_system_mas() {
        return old_system_mas;
    }

    public void setOld_system_mas(String old_system_mas) {
        this.old_system_mas = old_system_mas;
    }

    public String getSystem_capacity_mas() {
        return system_capacity_mas;
    }

    public void setSystem_capacity_mas(String system_capacity_mas) {
        this.system_capacity_mas = system_capacity_mas;
    }

    public String getSystem_working_mmas() {
        return system_working_mmas;
    }

    public void setSystem_working_mmas(String system_working_mmas) {
        this.system_working_mmas = system_working_mmas;
    }

    public String getCondition_system_mas() {
        return condition_system_mas;
    }

    public void setCondition_system_mas(String condition_system_mas) {
        this.condition_system_mas = condition_system_mas;
    }

    public String getActive_pm_mas() {
        return active_pm_mas;
    }

    public void setActive_pm_mas(String active_pm_mas) {
        this.active_pm_mas = active_pm_mas;
    }

    public String getFrequency_system_mas() {
        return frequency_system_mas;
    }

    public void setFrequency_system_mas(String frequency_system_mas) {
        this.frequency_system_mas = frequency_system_mas;
    }

    public String getActivies_carries_by_mas() {
        return activies_carries_by_mas;
    }

    public void setActivies_carries_by_mas(String activies_carries_by_mas) {
        this.activies_carries_by_mas = activies_carries_by_mas;
    }

    public String getName_maintenance_mas() {
        return name_maintenance_mas;
    }

    public void setName_maintenance_mas(String name_maintenance_mas) {
        this.name_maintenance_mas = name_maintenance_mas;
    }

    public String getAverage_mas() {
        return average_mas;
    }

    public void setAverage_mas(String average_mas) {
        this.average_mas = average_mas;
    }

    public String getBudget_mas() {
        return budget_mas;
    }

    public void setBudget_mas(String budget_mas) {
        this.budget_mas = budget_mas;
    }

    public String getComments_mas() {
        return comments_mas;
    }

    public void setComments_mas(String comments_mas) {
        this.comments_mas = comments_mas;
    }

    public String getPiping_network() {
        return piping_network;
    }

    public void setPiping_network(String piping_network) {
        this.piping_network = piping_network;
    }

    public String getOld_sysem_pp() {
        return old_sysem_pp;
    }

    public void setOld_sysem_pp(String old_sysem_pp) {
        this.old_sysem_pp = old_sysem_pp;
    }

    public String getSystem_working_pp() {
        return system_working_pp;
    }

    public void setSystem_working_pp(String system_working_pp) {
        this.system_working_pp = system_working_pp;
    }

    public String getValves_for_each_area() {
        return valves_for_each_area;
    }

    public void setValves_for_each_area(String valves_for_each_area) {
        this.valves_for_each_area = valves_for_each_area;
    }

    public String getStaff_know_where_shut_off() {
        return staff_know_where_shut_off;
    }

    public void setStaff_know_where_shut_off(String staff_know_where_shut_off) {
        this.staff_know_where_shut_off = staff_know_where_shut_off;
    }

    public String getStaff_know_wher_close() {
        return staff_know_wher_close;
    }

    public void setStaff_know_wher_close(String staff_know_wher_close) {
        this.staff_know_wher_close = staff_know_wher_close;
    }

    public String getHigh_low_pressure_alarm() {
        return high_low_pressure_alarm;
    }

    public void setHigh_low_pressure_alarm(String high_low_pressure_alarm) {
        this.high_low_pressure_alarm = high_low_pressure_alarm;
    }

    public String getCentralized_alarm() {
        return centralized_alarm;
    }

    public void setCentralized_alarm(String centralized_alarm) {
        this.centralized_alarm = centralized_alarm;
    }

    public String getCondition_system_pp() {
        return condition_system_pp;
    }

    public void setCondition_system_pp(String condition_system_pp) {
        this.condition_system_pp = condition_system_pp;
    }

    public String getType_plug_outlet() {
        return type_plug_outlet;
    }

    public void setType_plug_outlet(String type_plug_outlet) {
        this.type_plug_outlet = type_plug_outlet;
    }

    public String getOther_type_plug_outlet() {
        return other_type_plug_outlet;
    }

    public void setOther_type_plug_outlet(String other_type_plug_outlet) {
        this.other_type_plug_outlet = other_type_plug_outlet;
    }

    public String getActive_pm_program_pp() {
        return active_pm_program_pp;
    }

    public void setActive_pm_program_pp(String active_pm_program_pp) {
        this.active_pm_program_pp = active_pm_program_pp;
    }

    public String getFrequency_system_pp() {
        return frequency_system_pp;
    }

    public void setFrequency_system_pp(String frequency_system_pp) {
        this.frequency_system_pp = frequency_system_pp;
    }

    public String getPm_actives_carried_pp() {
        return pm_actives_carried_pp;
    }

    public void setPm_actives_carried_pp(String pm_actives_carried_pp) {
        this.pm_actives_carried_pp = pm_actives_carried_pp;
    }

    public String getName_maintanance_pp() {
        return name_maintanance_pp;
    }

    public void setName_maintanance_pp(String name_maintanance_pp) {
        this.name_maintanance_pp = name_maintanance_pp;
    }

    public String getAverage_cost_piping() {
        return average_cost_piping;
    }

    public void setAverage_cost_piping(String average_cost_piping) {
        this.average_cost_piping = average_cost_piping;
    }

    public String getBudget_program_pp() {
        return budget_program_pp;
    }

    public void setBudget_program_pp(String budget_program_pp) {
        this.budget_program_pp = budget_program_pp;
    }

    public String getComments_pp() {
        return comments_pp;
    }

    public void setComments_pp(String comments_pp) {
        this.comments_pp = comments_pp;
    }

    public String getReceive_ox_cylinder_log() {
        return receive_ox_cylinder_log;
    }

    public void setReceive_ox_cylinder_log(String receive_ox_cylinder_log) {
        this.receive_ox_cylinder_log = receive_ox_cylinder_log;
    }

    public String getReceive_ox_cyl_other() {
        return receive_ox_cyl_other;
    }

    public void setReceive_ox_cyl_other(String receive_ox_cyl_other) {
        this.receive_ox_cyl_other = receive_ox_cyl_other;
    }

    public String getComments_rece_log() {
        return comments_rece_log;
    }

    public void setComments_rece_log(String comments_rece_log) {
        this.comments_rece_log = comments_rece_log;
    }

    public String getLogbook_cylinder_log() {
        return logbook_cylinder_log;
    }

    public void setLogbook_cylinder_log(String logbook_cylinder_log) {
        this.logbook_cylinder_log = logbook_cylinder_log;
    }

    public String getComments_logbook_log() {
        return comments_logbook_log;
    }

    public void setComments_logbook_log(String comments_logbook_log) {
        this.comments_logbook_log = comments_logbook_log;
    }

    public String getUse_logb_lox_tank() {
        return use_logb_lox_tank;
    }

    public void setUse_logb_lox_tank(String use_logb_lox_tank) {
        this.use_logb_lox_tank = use_logb_lox_tank;
    }

    public String getComments_lox_tank() {
        return comments_lox_tank;
    }

    public void setComments_lox_tank(String comments_lox_tank) {
        this.comments_lox_tank = comments_lox_tank;
    }

    public String getSupply_consuminh() {
        return supply_consuminh;
    }

    public void setSupply_consuminh(String supply_consuminh) {
        this.supply_consuminh = supply_consuminh;
    }

    public String getComments_sup_consum() {
        return comments_sup_consum;
    }

    public void setComments_sup_consum(String comments_sup_consum) {
        this.comments_sup_consum = comments_sup_consum;
    }

    public String getInventory_med_equip() {
        return inventory_med_equip;
    }

    public void setInventory_med_equip(String inventory_med_equip) {
        this.inventory_med_equip = inventory_med_equip;
    }

    public String getFormat_med_equip() {
        return format_med_equip;
    }

    public void setFormat_med_equip(String format_med_equip) {
        this.format_med_equip = format_med_equip;
    }

    public String getShow_status_equip() {
        return show_status_equip;
    }

    public void setShow_status_equip(String show_status_equip) {
        this.show_status_equip = show_status_equip;
    }

    public String getHow_the_repair() {
        return how_the_repair;
    }

    public void setHow_the_repair(String how_the_repair) {
        this.how_the_repair = how_the_repair;
    }

    public String getLevel_contract_pm() {
        return level_contract_pm;
    }

    public void setLevel_contract_pm(String level_contract_pm) {
        this.level_contract_pm = level_contract_pm;
    }

    public String getLevel_contract_pm_ot() {
        return level_contract_pm_ot;
    }

    public void setLevel_contract_pm_ot(String level_contract_pm_ot) {
        this.level_contract_pm_ot = level_contract_pm_ot;
    }

    public String getActive_pm_mme() {
        return active_pm_mme;
    }

    public void setActive_pm_mme(String active_pm_mme) {
        this.active_pm_mme = active_pm_mme;
    }

    public String getProtocol_follow_fill_in() {
        return protocol_follow_fill_in;
    }

    public void setProtocol_follow_fill_in(String protocol_follow_fill_in) {
        this.protocol_follow_fill_in = protocol_follow_fill_in;
    }

    public String getRecorder_specific_way() {
        return recorder_specific_way;
    }

    public void setRecorder_specific_way(String recorder_specific_way) {
        this.recorder_specific_way = recorder_specific_way;
    }

    public String getControl_cost_assoc() {
        return control_cost_assoc;
    }

    public void setControl_cost_assoc(String control_cost_assoc) {
        this.control_cost_assoc = control_cost_assoc;
    }

    public String getLast_time_rec_super() {
        return last_time_rec_super;
    }

    public void setLast_time_rec_super(String last_time_rec_super) {
        this.last_time_rec_super = last_time_rec_super;
    }

    public String getLast_time_rec_sup_training() {
        return last_time_rec_sup_training;
    }

    public void setLast_time_rec_sup_training(String last_time_rec_sup_training) {
        this.last_time_rec_sup_training = last_time_rec_sup_training;
    }

    public String getTecn_specil_available() {
        return tecn_specil_available;
    }

    public void setTecn_specil_available(String tecn_specil_available) {
        this.tecn_specil_available = tecn_specil_available;
    }

    public String getTotal_number_tecni() {
        return total_number_tecni;
    }

    public void setTotal_number_tecni(String total_number_tecni) {
        this.total_number_tecni = total_number_tecni;
    }

    public String getNumber_tec_specia_health() {
        return number_tec_specia_health;
    }

    public void setNumber_tec_specia_health(String number_tec_specia_health) {
        this.number_tec_specia_health = number_tec_specia_health;
    }

    public String getNumber_biomedical() {
        return number_biomedical;
    }

    public void setNumber_biomedical(String number_biomedical) {
        this.number_biomedical = number_biomedical;
    }

    public String getSafety_program_ox2() {
        return safety_program_ox2;
    }

    public void setSafety_program_ox2(String safety_program_ox2) {
        this.safety_program_ox2 = safety_program_ox2;
    }

    public String getResponsable_savefy_program() {
        return responsable_savefy_program;
    }

    public void setResponsable_savefy_program(String responsable_savefy_program) {
        this.responsable_savefy_program = responsable_savefy_program;
    }

    public String getNational_sec_system() {
        return national_sec_system;
    }

    public void setNational_sec_system(String national_sec_system) {
        this.national_sec_system = national_sec_system;
    }

    public String getEnd_users() {
        return end_users;
    }

    public void setEnd_users(String end_users) {
        this.end_users = end_users;
    }

    public String getHow_often_end_user_train() {
        return how_often_end_user_train;
    }

    public void setHow_often_end_user_train(String how_often_end_user_train) {
        this.how_often_end_user_train = how_often_end_user_train;
    }

    public String getHow_many_users_trained() {
        return how_many_users_trained;
    }

    public void setHow_many_users_trained(String how_many_users_trained) {
        this.how_many_users_trained = how_many_users_trained;
    }

    public String getTecn_formed_aspect() {
        return tecn_formed_aspect;
    }

    public void setTecn_formed_aspect(String tecn_formed_aspect) {
        this.tecn_formed_aspect = tecn_formed_aspect;
    }

    public String getHow_often_train_users() {
        return how_often_train_users;
    }

    public void setHow_often_train_users(String how_often_train_users) {
        this.how_often_train_users = how_often_train_users;
    }

    public String getTecnic_trained() {
        return tecnic_trained;
    }

    public void setTecnic_trained(String tecnic_trained) {
        this.tecnic_trained = tecnic_trained;
    }

    public String getComments_train_cylinder() {
        return comments_train_cylinder;
    }

    public void setComments_train_cylinder(String comments_train_cylinder) {
        this.comments_train_cylinder = comments_train_cylinder;
    }

    public String getEnd_users_conc() {
        return end_users_conc;
    }

    public void setEnd_users_conc(String end_users_conc) {
        this.end_users_conc = end_users_conc;
    }

    public String getFrequency_training() {
        return frequency_training;
    }

    public void setFrequency_training(String frequency_training) {
        this.frequency_training = frequency_training;
    }

    public String getHow_many_users_formed() {
        return how_many_users_formed;
    }

    public void setHow_many_users_formed(String how_many_users_formed) {
        this.how_many_users_formed = how_many_users_formed;
    }

    public String getTecn_formed_aspect_conc() {
        return tecn_formed_aspect_conc;
    }

    public void setTecn_formed_aspect_conc(String tecn_formed_aspect_conc) {
        this.tecn_formed_aspect_conc = tecn_formed_aspect_conc;
    }

    public String getFrequency_training_conc_twoo() {
        return frequency_training_conc_twoo;
    }

    public void setFrequency_training_conc_twoo(String frequency_training_conc_twoo) {
        this.frequency_training_conc_twoo = frequency_training_conc_twoo;
    }

    public String getHow_many_tecnic_trained() {
        return how_many_tecnic_trained;
    }

    public void setHow_many_tecnic_trained(String how_many_tecnic_trained) {
        this.how_many_tecnic_trained = how_many_tecnic_trained;
    }

    public String getComments_train_conc() {
        return comments_train_conc;
    }

    public void setComments_train_conc(String comments_train_conc) {
        this.comments_train_conc = comments_train_conc;
    }

    public String getTecni_traine_related_manifolf() {
        return tecni_traine_related_manifolf;
    }

    public void setTecni_traine_related_manifolf(String tecni_traine_related_manifolf) {
        this.tecni_traine_related_manifolf = tecni_traine_related_manifolf;
    }

    public String getFrequency_trainig_manifold() {
        return frequency_trainig_manifold;
    }

    public void setFrequency_trainig_manifold(String frequency_trainig_manifold) {
        this.frequency_trainig_manifold = frequency_trainig_manifold;
    }

    public String getHow_many_techn_trained_man_out() {
        return how_many_techn_trained_man_out;
    }

    public void setHow_many_techn_trained_man_out(String how_many_techn_trained_man_out) {
        this.how_many_techn_trained_man_out = how_many_techn_trained_man_out;
    }

    public String getComments_train_man_out() {
        return comments_train_man_out;
    }

    public void setComments_train_man_out(String comments_train_man_out) {
        this.comments_train_man_out = comments_train_man_out;
    }

    public String getTecni_train_lox() {
        return tecni_train_lox;
    }

    public void setTecni_train_lox(String tecni_train_lox) {
        this.tecni_train_lox = tecni_train_lox;
    }

    public String getFrequency_trainnOT() {
        return frequency_trainnOT;
    }

    public void setFrequency_trainnOT(String frequency_trainnOT) {
        this.frequency_trainnOT = frequency_trainnOT;
    }

    public String getHow_many_tech_trained_lox() {
        return how_many_tech_trained_lox;
    }

    public void setHow_many_tech_trained_lox(String how_many_tech_trained_lox) {
        this.how_many_tech_trained_lox = how_many_tech_trained_lox;
    }

    public String getComments_train_lox() {
        return comments_train_lox;
    }

    public void setComments_train_lox(String comments_train_lox) {
        this.comments_train_lox = comments_train_lox;
    }

    public String getTrain_matter_related_fact() {
        return train_matter_related_fact;
    }

    public void setTrain_matter_related_fact(String train_matter_related_fact) {
        this.train_matter_related_fact = train_matter_related_fact;
    }

    public String getFrequency_trainig_fact() {
        return frequency_trainig_fact;
    }

    public void setFrequency_trainig_fact(String frequency_trainig_fact) {
        this.frequency_trainig_fact = frequency_trainig_fact;
    }

    public String getTechi_trained_handling() {
        return techi_trained_handling;
    }

    public void setTechi_trained_handling(String techi_trained_handling) {
        this.techi_trained_handling = techi_trained_handling;
    }

    public String getComments_factory() {
        return comments_factory;
    }

    public void setComments_factory(String comments_factory) {
        this.comments_factory = comments_factory;
    }

    public String getEnd_users_gas_outlets() {
        return end_users_gas_outlets;
    }

    public void setEnd_users_gas_outlets(String end_users_gas_outlets) {
        this.end_users_gas_outlets = end_users_gas_outlets;
    }

    public String getFrequency_trainig_gas_out() {
        return frequency_trainig_gas_out;
    }

    public void setFrequency_trainig_gas_out(String frequency_trainig_gas_out) {
        this.frequency_trainig_gas_out = frequency_trainig_gas_out;
    }

    public String getHow_many_end_users() {
        return how_many_end_users;
    }

    public void setHow_many_end_users(String how_many_end_users) {
        this.how_many_end_users = how_many_end_users;
    }

    public String getComments_med_gas_outlets() {
        return comments_med_gas_outlets;
    }

    public void setComments_med_gas_outlets(String comments_med_gas_outlets) {
        this.comments_med_gas_outlets = comments_med_gas_outlets;
    }
}