package projecto.jhpiego.equipment_track_tools.databaseConnection;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import projecto.jhpiego.equipment_track_tools.model.Assessment_model;
import projecto.jhpiego.equipment_track_tools.model.Equipment_inventory;


public class Database_connection extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "equipment_track_tool.db";
    public static final int DATABASE_VERSION = 1;
    private static final String TABLE_USERS = "users";
    int id = 0;

    private Context context;
    private static final String TABLE_INVENTORY = "inventory";
    private static final String TABLE_ASSESSMENT = "tabela_geral";

    public Database_connection(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String users = "CREATE TABLE " + TABLE_USERS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "username TEXT, " +
                "password TEXT)";

        String inventory = "CREATE TABLE " + TABLE_INVENTORY + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "department TEXT," +
                "type_equipment TEXT," +
                "inventory_number NUMBER," +
                "make TEXT," +
                "model TEXT," +
                "serial_number TEXT," +
                "equip_condition TEXT," +
                "year_install TEXT," +
                "main_contract TEXT," +
                "data_last_main TEXT," +
                "comment TEXT)";

        String tabela_geral = "CREATE TABLE " + TABLE_ASSESSMENT + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "fistName_lastName TEXT," +
                "organization TEXT," +
                "date_interview TEXT," +
                "type_interview TEXT," +
                "other TEXT," +
                "second_inter TEXT," +
                "second_interOther TEXT," +

                "name TEXT," +
                "email TEXT," +
                "telephone INTEGER," +
                "position TEXT, " +
                "secondary_interview TEXT, " +
                "secondary_interviewOther TEXT," +

                "health_facility_id TEXT, " +
                "health_facility_name TEXT, " +
                "location TEXT, " +
                "district TEXT, " +
                "province TEXT, " +
                "region TEXT, " +
                "gps_coordinates TEXT, " +
                "level_facility TEXT, " +
                "type_health_facility TEXT, " +
                "outpatient_health_facility TEXT, " +
                "number_bed_hospitalized_patient_total INTEGER, " +
                "number_bed_hospitalized_patient_maternity INTEGER, " +
                "number_bed_hospitalized_patient_cicov INTEGER, " +
                "number_bed_hospitalized_patient_icu INTEGER, " +
                "dept_available_facility TEXT, " +
                "dept_available_facility_other TEXT," +

                "main_source_power_electricity TEXT, " +
                "power_outage TEXT, " +
                "when_was_last_power_outage TEXT, " +
                "duration_typical_power TEXT, " +
                "scheduler_power TEXT, " +
                "secondary_source_electricity TEXT, " +
                "secondary_power_provide TEXT, " +
                "fallowing_receive_power TEXT, " +
                "fallowing_receive_power_other TEXT, " +
                "comments_secondary_power TEXT, " +
                "electricity_usage TEXT, " +
                "cost_electricity_last_month TEXT, " +
                "condition_electrical_system TEXT," +
                "comment_electrical_system TEXT, " +

                "generator_in_health_facility TEXT, " +
                "area_supply_electricity TEXT, " +
                "area_supply_electricity_other TEXT, " +
                "old_system TEXT, " +
                "generator_working TEXT, " +
                "condition_equipment TEXT, " +
                "automatic_transfer_switch TEXT, " +
                "ats_working TEXT, " +
                "fuel_available_today TEXT, " +
                "capacity_generator TEXT, " +
                "preventive_maintenance_program TEXT, " +
                "pm_caries_by TEXT, " +
                "frequency_pm_every_month TEXT, " +
                "name_maintenance TEXT, " +
                "logbook_maintenance TEXT, " +
                "logbook_update TEXT, " +
                "generator_comments TEXT, " +

                "generator_in_health_facility_two TEXT, " +
                "area_supply_electricity_two TEXT, " +
                "area_supply_electricity_other_two TEXT, " +
                "old_system_two TEXT, " +
                "generator_working_two TEXT, " +
                "condition_equipment_two TEXT, " +
                "automatic_transfer_switch_two TEXT, " +
                "ats_working_two TEXT, " +
                "fuel_available_today_two TEXT, " +
                "capacity_generator_two TEXT, " +
                "preventive_maintenance_program_two TEXT, " +
                "pm_caries_by_two TEXT, " +
                "frequency_pm_every_month_two TEXT, " +
                "name_maintenance_two TEXT, " +
                "logbook_maintenance_two TEXT, " +
                "logbook_update_two TEXT, " +
                "generator_comments_two TEXT, " +

                "generator_in_health_facility_three TEXT, " +
                "area_supply_electricity_three TEXT, " +
                "area_supply_electricity_other_three TEXT, " +
                "old_system_three TEXT, " +
                "generator_working_three TEXT, " +
                "condition_equipment_three TEXT, " +
                "automatic_transfer_switch_three TEXT, " +
                "ats_working_three TEXT, " +
                "fuel_available_today_three TEXT, " +
                "capacity_generator_three TEXT, " +
                "preventive_maintenance_program_three TEXT, " +
                "pm_caries_by_three TEXT, " +
                "frequency_pm_every_month_three TEXT, " +
                "name_maintenance_three TEXT, " +
                "logbook_maintenance_three TEXT, " +
                "logbook_update_three TEXT, " +
                "generator_comments_three TEXT, " +

                "generator_in_health_facility_four TEXT, " +
                "area_supply_electricity_four TEXT, " +
                "area_supply_electricity_other_four TEXT, " +
                "old_system_four TEXT, " +
                "generator_working_four TEXT, " +
                "condition_equipment_four TEXT, " +
                "automatic_transfer_switch_four TEXT, " +
                "ats_working_four TEXT, " +
                "fuel_available_today_four TEXT, " +
                "capacity_generator_four TEXT, " +
                "preventive_maintenance_program_four TEXT, " +
                "pm_caries_by_four TEXT, " +
                "frequency_pm_every_month_four TEXT, " +
                "name_maintenance_four TEXT, " +
                "logbook_maintenance_four TEXT, " +
                "logbook_update_four TEXT, " +
                "generator_comments_four TEXT, " +

                "generator_voltage_stabilizer TEXT, " +
                "old_system_stabilizer TEXT, " +
                "stabilizer_working TEXT, " +
                "condition_equip_stabilizer TEXT, " +
                "capacity_stabilizer TEXT, " +
                "active_pm_stabilizer TEXT, " +
                "active_pm_carrie TEXT, " +
                "frequency_pm_stabilizer TEXT, " +
                "name_maintenance_stabilizer TEXT, " +
                "logbook_maintenance_stabilizer TEXT, " +
                "logbook_update_stabilizer TEXT, " +
                "comments_stabilizer TEXT," +

                "support_ups_area TEXT, " +
                "areas_provides_electricity TEXT, " +
                "areas_provides_electricity_other TEXT, " +
                "old_system_ups TEXT, " +
                "ups_working TEXT, " +
                "condition_equipment_ups TEXT, " +
                "capacity_ups TEXT, " +
                "active_pm_ups TEXT, " +
                "activies_by TEXT, " +
                "frequency_ups TEXT, " +
                "name_maintenance_ups TEXT, " +
                "ups_logbook_pm TEXT, " +
                "logbook_update_ups TEXT, " +
                "comments_ups TEXT, " +

                "support_ups_area_two TEXT, " +
                "areas_provides_electricity_two TEXT, " +
                "areas_provides_electricity_other_two TEXT, " +
                "old_system_two_ups TEXT, " +
                "ups_working_two TEXT, " +
                "condition_equipment_ups_two TEXT, " +
                "capacity_ups_two TEXT, " +
                "active_pm_ups_two TEXT, " +
                "activities_by_two_ups TEXT, " +
                "frequency_ups_two TEXT, " +
                "name_maintenance_ups_two TEXT, " +
                "ups_logbook_pm_two TEXT, " +
                "logbook_update_ups_two TEXT, " +
                "comments_ups_two TEXT, " +

                "solar_power TEXT, " +
                "areas_provides_solar TEXT, " +
                "areas_provides_solar_other TEXT, " +
                "old_system_solar TEXT, " +
                "solar_power_system_working TEXT, " +
                "condition_equipment_solar TEXT, " +
                "capacity_solar_power TEXT, " +
                "batteries_installed TEXT, " +
                "active_pm_solar TEXT, " +
                "carries_solar_by TEXT, " +
                "frequency_pm TEXT, " +
                "name_maintenance_solar TEXT, " +
                "logbook_pm_solar TEXT, " +
                "logbook_update_solar TEXT, " +
                "comments_solar TEXT," +

                "average_consuming_oxygen TEXT, " +
                "system_use_primary_supply TEXT, " +
                "system_use_secondary_supply TEXT, " +
                "system_use_emergency_supply TEXT, " +
                "comments_supply TEXT," +

                "sign_presence_gas TEXT, " +
                "sign_emergency_contact TEXT, " +
                "fire_extinguishers TEXT, " +
                "type_extinguishers TEXT, " +
                "type_extinguishers_other TEXT, " +
                "last_maintenance_phone TEXT, " +
                "sensor_fire_alarm_system TEXT, " +
                "system_working_sensor TEXT, " +
                "last_maintenance_done_sensor TEXT, " +
                "hydrate_system_hose TEXT, " +
                "system_working_hose TEXT, " +
                "last_maintenance_done_hose TEXT, " +
                "sprinkler_system  TEXT, " +
                "system_working_sprinkler TEXT, " +
                "last_maintenance_done_sprinkler TEXT, " +
                "emergency_water_tank_full TEXT, " +
                "comments_sprinkler TEXT," +

                "use_ward_room TEXT, " +
                "average_number TEXT, " +
                "average_month TEXT, " +
                "type_cylinders TEXT, " +
                "common_model_cylinder TEXT, " +
                "common_model_cylinder_other TEXT, " +
                "type_connection_cylinder TEXT, " +
                "name_supplier TEXT, " +
                "health_facility_receive TEXT, " +
                "health_facility_suffered TEXT, " +
                "comments_cylinders TEXT, " +

                "concentrator_in_health_fac TEXT, " +
                "number_concentrator TEXT, " +
                "concentrator_broken TEXT, " +
                "active_pm_program_concentrator TEXT, " +
                "active_carrie_by TEXT, " +
                "frequency_concentrator TEXT, " +
                "name_maintenance_company TEXT, " +
                "average_cost_per_year TEXT, " +
                "budget_maintenance_program TEXT, " +
                "logbook_maintenance_concentrator TEXT, " +
                "logbook_update_concentrator TEXT, " +
                "comments_concentrator TEXT, " +

                "manifold_in_health TEXT, " +
                "type_supply_used_manifold TEXT, " +
                "areas_does_supply TEXT, " +
                "areas_does_supply_other TEXT, " +
                "areas_does_supply_otherTwo TEXT, " +
                "old_system_manifold TEXT, " +
                "kind_manifold TEXT, " +
                "capacity_manifold TEXT, " +
                "diameter_system TEXT, " +
                "how_many_cylinder_concentrator_rs TEXT, " +
                "how_many_cylinder_concentrator_ls TEXT, " +
                "how_many_cylinder_concentrator_total TEXT, " +
                "average_per_month TEXT, " +
                "most_common_model_cylinder TEXT, " +
                "most_common_model_cylinder_other TEXT, " +
                "type_connection_cylinder_manifold TEXT, " +
                "manifold_working TEXT, " +
                "condition_system TEXT, " +
                "active_pm_program_manifold TEXT, " +
                "frequency_pm_manifold TEXT, " +
                "activities_by TEXT, " +
                "name_maintenance_manifold TEXT, " +
                "average_cost_per_year_manifold TEXT, " +
                "budget_maintenance_program_manifold TEXT, " +
                "logbook_maintenance_manifold TEXT, " +
                "logbook_update_manifold TEXT,  " +
                "name_cylinder_supply TEXT, " +
                "how_does_receive_cylinder TEXT, " +
                "shortages_last_two_year TEXT, " +
                "comments_manifold TEXT, " +

                "manifold_in_health_two TEXT, " +
                "type_supply_used_manifold_two TEXT, " +
                "areas_does_supply_two TEXT, " +
                "areas_does_supply_other_two TEXT, " +
                "areas_does_supply_otherTwo_two TEXT, " +
                "old_system_manifold_two TEXT, " +
                "kind_manifold_two TEXT, " +
                "capacity_manifold_two TEXT, " +
                "diameter_system_two TEXT, " +
                "how_many_cylinder_concentrator_rs_two TEXT, " +
                "how_many_cylinder_concentrator_ls_two TEXT, " +
                "how_many_cylinder_concentrator_total_two TEXT, " +
                "average_per_month_two TEXT, " +
                "most_common_model_cylinder_two TEXT, " +
                "most_common_model_cylinder_other_two TEXT, " +
                "type_connection_cylinder_two TEXT, " +
                "manifold_working_two TEXT, " +
                "condition_system_two TEXT, " +
                "active_pm_program_manifold_two TEXT, " +
                "frequency_pm_manifold_two TEXT, " +
                "activities_by_two TEXT, " +
                "name_maintenance_manifold_two TEXT, " +
                "average_cost_per_year_two TEXT, " +
                "budget_maintenance_program_two TEXT, " +
                "logbook_maintenance_two_manifold TEXT, " +
                "logbook_update_manifold_two TEXT,  " +
                "name_cylinder_supply_two TEXT, " +
                "how_does_receive_cylinder_two TEXT, " +
                "shortages_last_two_year_two TEXT, " +
                "comments_manifold_two TEXT, " +

                "manifold_in_health_emergency TEXT, " +
                "type_supply_used_manifold_emergency TEXT, " +
                "old_system_manifold_emergency TEXT, " +
                "kind_manifold_emergency TEXT, " +
                "capacity_manifold_emergency TEXT, " +
                "diameter_system_emergency TEXT, " +
                "how_many_cylinder_connection_total_emergency TEXT, " +
                "average_per_month_emergency TEXT, " +
                "most_common_model_cylinder_emergency TEXT, " +
                "most_common_model_cylinder_other_emergency TEXT, " +
                "type_connection_cylinder_mani_emergency TEXT, " +
                "manifold_working_emergency TEXT, " +
                "condition_system_emergency TEXT, " +
                "active_pm_program_manifold_emergency TEXT, " +
                "frequency_pm_mani_emergency TEXT, " +
                "activities_by_emergency TEXT, " +
                "name_maintenance_manifold_emergency TEXT, " +
                "average_cost_per_year_emergency TEXT, " +
                "budget_maintenance_program_emergency TEXT, " +
                "logbook_maintenance_emergency TEXT, " +
                "logbook_update_manifold_emergency TEXT, " +
                "name_cylinder_supply_emergency TEXT, " +
                "how_does_receive_cylinder_emergency TEXT, " +
                "comments_manifold_emergency TEXT, " +

                "liquid_oxygen TEXT, " +
                "average_consuming_oxygen_liquid  TEXT, " +
                "last_month_consuming  TEXT, " +
                "tank_owner  TEXT, " +
                "tank_owner_other  TEXT, " +
                "old_system_oxygen TEXT, " +
                "capacity_lox_tank_m3 TEXT, " +
                "capacity_lox_tank_ton TEXT, " +
                "system_working_ox_tank TEXT, " +
                "condition_system_ox_tank TEXT, " +
                "active_pm_program TEXT, " +
                "activities_carrie_by_ox_tank TEXT, " +
                "frequency_ox_tank TEXT, " +
                "name_maintenance_company_ox_tank TEXT, " +
                "average_cost_ox_tank TEXT, " +
                "budget_lox_tank TEXT, " +
                "logbook_maintenance_tank TEXT, " +
                "logbook_update_ox_tank TEXT, " +
                "name_supply_ox_tank TEXT, " +
                "health_receive_lox TEXT, " +
                "shortages_lox TEXT, " +
                "specialized_internal TEXT, " +
                "how_many_technical_available TEXT, " +
                "comment_ox_tank TEXT, " +

                "liquid_oxygen_two TEXT, " +
                "average_consuming_oxygen_two  TEXT, " +
                "last_month_consuming_two  TEXT, " +
                "tank_owner_two  TEXT, " +
                "tank_owner_other_two  TEXT, " +
                "old_system_oxygen_two TEXT, " +
                "capacity_lox_tank_m3_two TEXT, " +
                "capacity_lox_tank_ton_two TEXT, " +
                "system_working_ox_tank_two TEXT, " +
                "condition_system_ox_tank_two TEXT, " +
                "active_pm_program_two TEXT, " +
                "activities_carrie_by_ox_tank_two TEXT, " +
                "frequency_ox_tank_two TEXT, " +
                "name_maintenance_company_ox_tank_two TEXT, " +
                "average_cost_ox_tank_two TEXT, " +
                "budget_lox_tank_two TEXT, " +
                "logbook_maintenance_tank_two TEXT, " +
                "logbook_update_ox_tank_two TEXT, " +
                "name_supply_ox_tank_two TEXT, " +
                "health_receive_lox_two TEXT, " +
                "shortages_lox_two TEXT, " +
                "specialized_internal_two TEXT, " +
                "how_many_technical_available_two TEXT, " +
                "comment_ox_tank_two TEXT, " +

                "oxygen_ox2_plant TEXT, " +
                "old_system_ox2 TEXT, " +
                "capacity_factory_ox2 TEXT, " +
                "diameter_ox2 TEXT, " +
                "total_production TEXT, " +
                "system_working_ox2 TEXT, " +
                "condition_ox2 TEXT, " +
                "specific_transformer_ox2 TEXT, " +
                "specific_generator_ox2 TEXT, " +
                "specific_ups_ox2 TEXT, " +
                "specific_stabilizer_ox2 TEXT, " +
                "manifold_fill_cylinder TEXT, " +
                "cap_fill_system_ox_cylinder TEXT," +
                "cap_ox_tank_fill_system TEXT," +
                "most_common_ox2 TEXT," +
                "is_the_system_working_ox2 TEXT," +
                "supply_cylinder_ox2 TEXT," +
                "which_supply_cylinder_ox2 TEXT," +
                "health_supply_cylinder TEXT," +
                "active_pm_program_ox2 TEXT," +
                "frequency_pm_ox2 TEXT," +
                "activities_carried_by_ox2 TEXT," +
                "name_maintenance_ox2 TEXT," +
                "average_cost_year_ox2 TEXT," +
                "budget_ox2 TEXT," +
                "specialized_technical_internal_ox2 TEXT," +
                "how_many_technical_available_ox2 TEXT," +
                "any_shortage_two_last_ox2 TEXT," +
                "comments_ox2 TEXT," +

                "suction_system TEXT," +
                "old_system_ss TEXT," +
                "capacity_system_ss TEXT," +
                "suction_system_working TEXT," +
                "condition_system_ss TEXT," +
                "active_pm_program_ss TEXT," +
                "frequency_pm_month_ss TEXT," +
                "activities_carried_by_ss TEXT," +
                "name_maintenance_ss TEXT," +
                "average_pm_suction_ss TEXT," +
                "budget_suction_ss TEXT," +
                "comment_suction TEXT," +
                "medical_air_mas TEXT," +
                "old_system_mas TEXT," +
                "system_capacity_mas TEXT," +
                "system_working_mmas TEXT," +
                "condition_system_mas TEXT," +
                "active_pm_mas TEXT," +
                "frequency_system_mas TEXT," +
                "activities_carries_by_mas TEXT," +
                "name_maintenance_mas TEXT," +
                "average_mas TEXT," +
                "budget_mas TEXT," +
                "comments_mas TEXT," +

                "piping_network TEXT," +
                "old_system_pp TEXT," +
                "system_working_pp TEXT," +
                "valves_for_each_area TEXT," +
                "staff_know_where_shut_off TEXT," +
                "staff_know_where_close TEXT," +
                "high_low_pressure_alarm TEXT," +
                "centralized_alarm TEXT," +
                "condition_system_pp TEXT," +
                "type_plug_outlet TEXT," +
                "active_pm_program_piping TEXT," +
                "frequency_system_pp TEXT," +
                "pm_actives_carried_pp TEXT," +
                "name_maintenance_pp TEXT," +
                "average_cost_piping TEXT," +
                "budget_program_pp TEXT," +
                "comments_pp TEXT," +

                "receive_ox_cylinder_log TEXT," +
                "receive_ox_cyl_other TEXT," +
                "comments_receive_log TEXT," +
                "logbook_cylinder_log TEXT," +
                "comments_logbook_log TEXT," +
                "use_logbook_lox_tank TEXT," +
                "comments_lox_tank TEXT," +
                "supply_consuming TEXT," +
                "comments_sup_consuming TEXT," +

                "inventory_med_equipment TEXT," +
                "format_med_equipment TEXT," +
                "show_status_equipment TEXT," +
                "how_the_repair TEXT," +
                "level_contract_pm TEXT," +
                "level_contract_pm_ot TEXT," +
                "active_pm_mme TEXT," +
                "protocol_follow_fill_in TEXT," +
                "recorder_specific_way TEXT," +
                "control_cost_assoc TEXT," +

                "last_time_receive_supervisory TEXT, " +
                "last_time_receive_supply_training TEXT," +

                "technical_special_available TEXT," +
                "total_number_technical TEXT," +
                "number_technical_special_health TEXT," +
                "number_biomedical TEXT," +
                "safety_program_ox2 TEXT," +
                "responsible_safety_program TEXT," +
                "national_sec_system TEXT," +

                "end_users TEXT," +
                "how_often_end_user_train TEXT," +
                "how_many_users_trained TEXT," +
                "technical_formed_aspect TEXT," +
                "how_often_train_users TEXT," +
                "technical_trained TEXT," +
                "comments_train_cylinder TEXT," +

                "end_users_concentrator TEXT," +
                "frequency_training TEXT," +
                "how_many_users_formed TEXT," +
                "technical_formed_aspect_concentrator TEXT," +
                "frequency_training_concentrator_two TEXT," +
                "how_many_technical_trained TEXT," +
                "comments_train_concentrator TEXT," +

                "technical_trained_related_manifold TEXT," +
                "frequency_training_manifold TEXT," +
                "how_many_technical_trained_man_out TEXT," +
                "comments_training_man_out TEXT," +

                "technical_train_lox TEXT," +
                "frequency_training_lox TEXT," +
                "how_many_tech_trained_lox TEXT," +
                "comments_train_lox TEXT," +

                "train_matter_related_fact TEXT," +
                "frequency_training_fact TEXT," +
                "technical_trained_handling TEXT," +
                "comments_factory TEXT," +

                "end_users_gas_outlets TEXT," +
                "frequency_training_gas_out TEXT," +
                "how_many_end_users TEXT," +
                "comments_med_gas_outlets TEXT)";

        db.execSQL(users);
        db.execSQL(inventory);
        db.execSQL(tabela_geral);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_INVENTORY);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_ASSESSMENT);
        onCreate(db);
    }

    public Boolean users(String name, String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("name", name);
        cv.put("username", username);
        cv.put("password", password);

        long resultInsert = db.insert(TABLE_USERS, null, cv);
        if (resultInsert == -1) {
            return false;
        } else
            return true;
    }

    public Boolean checkUsername(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE username = ?", new String[]{username});
        if (cursor.getCount() > 0) {
            return true;
        } else
            return false;
    }

    public Boolean checkUsernamePass(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE username = ? and password = ?", new String[]{username, password});
        if (cursor.getCount() > 0) {
            return true;
        } else
            return false;
    }

    /* ******************************************************************************************************************/

    public Boolean inventory(String department, String type_equipment, String inventory_number,
                             String make, String model, String serial_number, String equip_condition,
                             String year_install, String main_contract, String data_last_main, String comment) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("department", department);
        cv.put("type_equipment", type_equipment);
        cv.put("inventory_number", inventory_number);
        cv.put("make", make);
        cv.put("model", model);
        cv.put("serial_number", serial_number);
        cv.put("equip_condition", equip_condition);
        cv.put("year_install", year_install);
        cv.put("main_contract", main_contract);
        cv.put("data_last_main", data_last_main);
        cv.put("comment", comment);

        long result = db.insert(TABLE_INVENTORY, null, cv);
        if (result == -1) {
            return false;
        } else
            return true;
    }

  /*  public Boolean update_inventory(String department, String type_equipment, String inventory_number,
                             String make, String model, String serial_number, String equip_condition,
                             String year_install, String main_contract, String data_last_main, String comment) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("department", department);
        cv.put("type_equipment", type_equipment);
        cv.put("inventory_number", inventory_number);
        cv.put("make", make);
        cv.put("model", model);
        cv.put("serial_number", serial_number);
        cv.put("equip_condition", equip_condition);
        cv.put("year_install", year_install);
        cv.put("main_contract", main_contract);
        cv.put("data_last_main", data_last_main);
        cv.put("comment", comment);

        long result = db.update(TABLE_INVENTORY, cv,"id="+id, null);
        if (result == -1) {
            return false;
        } else
            return true;
    }*/

    public Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_INVENTORY + " ORDER BY id";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }


    public boolean updateData(int row_id, String department, String type_equipment, String inventory_number,
                              String make, String model, String serial_number, String equip_condition,
                              String year_install, String main_contract, String data_last_main, String comment) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("department", department);
        cv.put("type_equipment", type_equipment);
        cv.put("inventory_number", inventory_number);
        cv.put("make", make);
        cv.put("model", model);
        cv.put("serial_number", serial_number);
        cv.put("equip_condition", equip_condition);
        cv.put("year_install", year_install);
        cv.put("main_contract", main_contract);
        cv.put("data_last_main", data_last_main);
        cv.put("comment", comment);

        long result = db.update(TABLE_INVENTORY, cv, "id=?", new String[]{String.valueOf(row_id)});
        if (result == -1) {
            //   Toast.makeText(context, "Falha ao atualizar os dados", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            // Toast.makeText(context, "Atualizado com sucesso", Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    //    public void deleteOneRow(int row_id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        long result = db.delete(TABLE_INVENTORY, "id=?", new String[]{String.valueOf(row_id)});
//        if (result == -1) {
//            Toast.makeText(context, "Ocorreu um erro, tenta novamente", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(context, "O ficheiro foi eliminado", Toast.LENGTH_SHORT).show();
//        }
//    }
    public boolean deleteOneRow(int row_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_INVENTORY, "id=?", new String[]{String.valueOf(row_id)});
        if (result == -1) {
          //  Toast.makeText(context, "Ocorreu um erro, tenta novamente", Toast.LENGTH_SHORT).show();
            return false;
        } else {
           // Toast.makeText(context, "O ficheiro foi eliminado", Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    public void deleteAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_INVENTORY);
    }

    /* ******************************************************************************************************************************/
    public Boolean assessment() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        try {
            onCreate(db);
            Log.w("criacao de tabela", "criada com sucesso");
        } catch (Exception e) {
            Log.e("tentando criar tabela", e.getMessage());
        }


        cv.put(Assessment.DadosTabela.COLUMN_NAME_FN, Assessment.assessment_model.getTxtFullName());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ORG, Assessment.assessment_model.getTxtOrganization());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_DT, Assessment.assessment_model.getDataDates());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_TYP, Assessment.assessment_model.getChk_interview_type());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_OTH, Assessment.assessment_model.getOther());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SI, Assessment.assessment_model.getTxtSecInterV());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SIO, Assessment.assessment_model.getTxtSecInterVTwoo());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_N, Assessment.assessment_model.getNome());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_E, Assessment.assessment_model.getEmail());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_T, Assessment.assessment_model.getTelephone());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_P, Assessment.assessment_model.getPosition());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SEI, Assessment.assessment_model.getOther());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SEIO, Assessment.assessment_model.getOtherTwo());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_HFID, Assessment.assessment_model.getTxtHealthFacID());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HFN, Assessment.assessment_model.getTxtName());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_L, Assessment.assessment_model.getTxtLocation());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_D, Assessment.assessment_model.getTxtDistrict());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_PROV, Assessment.assessment_model.getTxtProvince());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_R, Assessment.assessment_model.getTxtRegion());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_GPS, Assessment.assessment_model.getTxtGpsCardinates());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LF, Assessment.assessment_model.getChkLevelHeath());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_TYF, Assessment.assessment_model.getChkTypeHealthFac());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_OUT, Assessment.assessment_model.getCboOupatient());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NBED, Assessment.assessment_model.getTxtTotal());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NBEDM, Assessment.assessment_model.getTxtMaternity());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NBEDCICOV, Assessment.assessment_model.getTxtCicov());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NBEDICU, Assessment.assessment_model.getTxtIcu());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_DEPT, Assessment.assessment_model.getChkDeptAvailable());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_DEPTO, Assessment.assessment_model.getTxtOther());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_MAIN, Assessment.assessment_model.getChk_main_src_power_electricity());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_POW, Assessment.assessment_model.getChk_often_power_outage());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LASTPO, Assessment.assessment_model.getChk_last_power_outage());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_TYPPOW, Assessment.assessment_model.getChk_duration_typical_power_outage());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SHPOW, Assessment.assessment_model.getChk_schedule_power_outage());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SECOSE, Assessment.assessment_model.getChk_secondary_src_electricty());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SECPPRVI, Assessment.assessment_model.getChk_secondary_power_src_provide_Pow_entire());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_RECEPOW, Assessment.assessment_model.getChk_areas_receive_power());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_RECEPOWO, Assessment.assessment_model.getTxt_other_area_receive_power());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_COMMSPOW, Assessment.assessment_model.getTxt_comment_power_src());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ELCUS, Assessment.assessment_model.getTxt_electricity_usage_last_month());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_COSTEL, Assessment.assessment_model.getTxt_cost_electricity_bill_last_month());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CONDELESYS, Assessment.assessment_model.getChk_condition_electricity_system());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ELECSYS, Assessment.assessment_model.getTxt_comment_electricity_system());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_GENHFAC, Assessment.assessment_model.getChkGene());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SUPPELEC, Assessment.assessment_model.getChkSuppElect());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SUPPELECO, Assessment.assessment_model.getTxtOtherSuppEle());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_OLDSYS, Assessment.assessment_model.getChkHoldSyste());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_GENWOR, Assessment.assessment_model.getChkGenWork());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CONDEQUIP, Assessment.assessment_model.getChkConditionEquip());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_AUTTRASNSWIT, Assessment.assessment_model.getChkATS());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ATS_WORK, Assessment.assessment_model.getChkATSWorkin());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FUEL_AVAIL, Assessment.assessment_model.getChkFuelToday());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CAP_GENE, Assessment.assessment_model.getTxtCapacity());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_PREV_MAIN_PRO, Assessment.assessment_model.getChkPMProgram());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_PM_CARR, Assessment.assessment_model.getChkCarrBy());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FREQU_PM, Assessment.assessment_model.getTxtFreqPM());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NAME_MAIN, Assessment.assessment_model.getTxtNameOfMant());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LOGBOOK, Assessment.assessment_model.getChkLogBook());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LOGBUPDT, Assessment.assessment_model.getChkLogBoobUpd());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_GENE_COMM, Assessment.assessment_model.getTxtComent());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_GENE_FACT, Assessment.assessment_model.getChkGeneTwoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SUPP_ELET, Assessment.assessment_model.getChkSuppElectTwoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SUPP_ELETO, Assessment.assessment_model.getTxtOtherSuppEleTwoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_OLDSYST, Assessment.assessment_model.getChkHoldSysteTwoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_GENE_WORKT, Assessment.assessment_model.getChkGenWorkTwoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_COND_EQUIP, Assessment.assessment_model.getChkConditionEquipTwoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ATST, Assessment.assessment_model.getChkATSTwoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ATS_WORKT, Assessment.assessment_model.getChkATSWorkinTwoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FUEL_AVAI, Assessment.assessment_model.getChkFuelTodayTwoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CAP_GENET, Assessment.assessment_model.getTxtCapacityTwoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_PREVE_MAIN, Assessment.assessment_model.getChkPMProgramTwoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_PM_CARRT, Assessment.assessment_model.getChkCarrByTwoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FREQ_PM, Assessment.assessment_model.getTxtFreqPMTwoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NAME_MAINT, Assessment.assessment_model.getTxtNameOfMantTwoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LOGBOOKMAINT, Assessment.assessment_model.getChkLogBookTwoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LOGBOOKT, Assessment.assessment_model.getChkLogBoobUpdTwoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_GENE_COMMT, Assessment.assessment_model.getTxtComentTwoo());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_GENE_FACTH, Assessment.assessment_model.getChkGeneThree());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SUPP_ELETH, Assessment.assessment_model.getChkSuppElectThree());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SUPP_ELETHO, Assessment.assessment_model.getTxtOtherSuppEleThree());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_OLDSYSTH, Assessment.assessment_model.getChkHoldSysteThree());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_GENE_WORKTH, Assessment.assessment_model.getChkGenWorkThree());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_COND_EQUIPH, Assessment.assessment_model.getChkConditionEquipThree());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ATSTH, Assessment.assessment_model.getChkATSThree());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ATS_WORKTH, Assessment.assessment_model.getChkATSWorkinThree());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FUEL_AVAIH, Assessment.assessment_model.getChkFuelTodayThree());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CAP_GENETH, Assessment.assessment_model.getTxtCapacityThree());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_PREVE_MAINH, Assessment.assessment_model.getChkPMProgramThree());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_PM_CARRTH, Assessment.assessment_model.getChkCarrByThree());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FREQ_PMH, Assessment.assessment_model.getTxtFreqPMThree());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NAME_MAINTH, Assessment.assessment_model.getTxtNameOfMantThree());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LOGBOOKMAINTH, Assessment.assessment_model.getChkLogBookv());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LOGBOOKTH, Assessment.assessment_model.getChkLogBoobUpdThree());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_GENE_COMMTH, Assessment.assessment_model.getTxtComentThree());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_GENHFACF, Assessment.assessment_model.getChkGeneFour());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SUPPELECF, Assessment.assessment_model.getChkSuppElectFour());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SUPPELECFO, Assessment.assessment_model.getTxtOtherSuppEleFour());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_OLDSYSF, Assessment.assessment_model.getChkHoldSysteFour());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_GENWORF, Assessment.assessment_model.getChkGenWorkFour());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CONDEQUIPF, Assessment.assessment_model.getChkConditionEquipFour());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_AUTTRASNSWITF, Assessment.assessment_model.getChkATSFour());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ATS_WORKF, Assessment.assessment_model.getChkATSWorkinFour());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FUEL_AVAILF, Assessment.assessment_model.getChkFuelTodayFour());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CAP_GENEF, Assessment.assessment_model.getTxtCapacityFour());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_PREV_MAIN_PROF, Assessment.assessment_model.getChkPMProgramFour());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_PM_CARRF, Assessment.assessment_model.getChkCarrByFour());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FREQU_PMF, Assessment.assessment_model.getTxtFreqPMFour());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NAME_MAINF, Assessment.assessment_model.getTxtNameOfMantv());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LOGBOOKF, Assessment.assessment_model.getChkLogBookFour());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LOGBUPDTF, Assessment.assessment_model.getChkLogBoobUpdFour());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_GENE_COMMF, Assessment.assessment_model.getTxtComentFour());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_STAB, Assessment.assessment_model.getChkVoltaStabilizer());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_OLD_STAB, Assessment.assessment_model.getChkHoldSystem());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_STAB_WORK, Assessment.assessment_model.getChkStabWorking());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_COND_EQUI_STAB, Assessment.assessment_model.getChkConditionEqu());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CAPC_STAB, Assessment.assessment_model.getTxtCapacityStab());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ACTIV, Assessment.assessment_model.getChkPrevMain());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ACTIVCARR, Assessment.assessment_model.getChkActiCarries());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FREQ_STAB, Assessment.assessment_model.getTxtFrequenPM());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NAME_MAIN_STAB, Assessment.assessment_model.getTxtNameOfMantStab());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LOGBOOK_MAIN_STAB, Assessment.assessment_model.getChklogBookMaint());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LOGBOOK_STAB, Assessment.assessment_model.getChkLogBookUp());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_COMMENT_STAB, Assessment.assessment_model.getTxtComentStab());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_SUPP_UPS, Assessment.assessment_model.getChkSupUPSS());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_AR_PROV, Assessment.assessment_model.getChkProvUPS());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_AR_PROVO, Assessment.assessment_model.getTxtOtherUPS());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_OLD_SYS_STAB, Assessment.assessment_model.getChkOldSystemUPS());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_UPS_WOR, Assessment.assessment_model.getChkWorkingUPS());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_COND_EQ_UPS, Assessment.assessment_model.getChkCondEquipmUPS());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CAP_UPS, Assessment.assessment_model.getTxtCapacityUPS());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ACTI_UPS, Assessment.assessment_model.getChkPMPUPS());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ACTIV_BY, Assessment.assessment_model.getChkCarrByUPS());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FREQ_UPS, Assessment.assessment_model.getTxtFreqPMUPS());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NAME_MAIN_UPS, Assessment.assessment_model.getTxtNameOfMantUPS());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LOGBOOK_UPS, Assessment.assessment_model.getChkPMCMUPS());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LOGBOOK_UPD_UPS, Assessment.assessment_model.getChklogbBookUPS());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_COMM_UPS, Assessment.assessment_model.getTxtComentUPS());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_SUPP_UPST, Assessment.assessment_model.getChkSupUPSSTwhoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_AR_PROVT, Assessment.assessment_model.getChkProvUPTwhooS());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_AR_PROVTO, Assessment.assessment_model.getTxtOtherUPSTwhoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_OLD_SYS_STABT, Assessment.assessment_model.getChkOldSystemUPSTwhoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_UPS_WORT, Assessment.assessment_model.getChkWorkingUPSTwhoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_COND_EQ_UPST, Assessment.assessment_model.getChkCondEquipmUPSTwhoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CAP_UPST, Assessment.assessment_model.getChkPMPUPSTwhoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ACTI_UPST, Assessment.assessment_model.getTxtCapacityUPSv());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ACTIV_BYT, Assessment.assessment_model.getChkCarrByUPSTwhoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FREQ_UPST, Assessment.assessment_model.getTxtFreqPMUPSTwhoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NAME_MAIN_UPST, Assessment.assessment_model.getTxtNameOfMantUPSv());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LOGBOOK_UPST, Assessment.assessment_model.getChkPMCMUPSTwhoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LOGBOOK_UPD_UPST, Assessment.assessment_model.getChklogbBookUPSTwhoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_COMM_UPST, Assessment.assessment_model.getTxtComentUPSTwhoo());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_SPOW, Assessment.assessment_model.getTxtSolarP());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_AR_PROV_SOL, Assessment.assessment_model.getTxtAreaProv());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_AR_PROV_SOLO, Assessment.assessment_model.getTxtAreaProvOther());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_OLD_SYS_SOL, Assessment.assessment_model.getTxtOldSysSolar());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SOL_POW_WORK, Assessment.assessment_model.getTxtSolarPSysWorking());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CES, Assessment.assessment_model.getTxtConditionEquipmSolar());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CSP, Assessment.assessment_model.getTxtCapacitySolarPower());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_BI, Assessment.assessment_model.getTxtbatterieInstalled());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_APMS, Assessment.assessment_model.getTxtActivePM_solar());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CSB, Assessment.assessment_model.getTxtCarriesSolarBy());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FPMS, Assessment.assessment_model.getTxtFrequencyPM());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NMS, Assessment.assessment_model.getTxtNameMainSolar());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LBPM, Assessment.assessment_model.getTxtLogbbook_pmSolar());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LBUS, Assessment.assessment_model.getTxtLogbbook_updateSolar());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CS, Assessment.assessment_model.getTxtCommentsSolar());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_ACO, Assessment.assessment_model.getTxtAverageConsOx());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SUPS, Assessment.assessment_model.getTxtSystem_usePrimarySupply());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SUSS, Assessment.assessment_model.getTxtSystem_use_secondary_supply());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SSES, Assessment.assessment_model.getTxtSystem_use_emergency_supply());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CSUPP, Assessment.assessment_model.getTxtComments_supply());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_SPG, Assessment.assessment_model.getSign_presence_gas());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SEC, Assessment.assessment_model.getSign_emergency_contact());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FE, Assessment.assessment_model.getFire_extinguishers());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_TE, Assessment.assessment_model.getType_extinguishers());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_TEO, Assessment.assessment_model.getType_extinguishers_other());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LMF, Assessment.assessment_model.getLast_maintenance_fone());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SFAS, Assessment.assessment_model.getSensor_fire_alarme_system());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SWS, Assessment.assessment_model.getSystem_working_sensor());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LMDS, Assessment.assessment_model.getLast_maintanance_done_sensor());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HSH, Assessment.assessment_model.getHydrate_system_hose());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SWH, Assessment.assessment_model.getSystem_working_hose());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LMDH, Assessment.assessment_model.getLast_maintenance_done_hose());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SS, Assessment.assessment_model.getSprinkler_system());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SWSPRINKLER, Assessment.assessment_model.getSystem_working_sprinkler());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LMDSPRINKLER, Assessment.assessment_model.getLast_maintebance_done_sprinlker());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_EWTF, Assessment.assessment_model.getEmergency_water_tank_full());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CSPRINKLER, Assessment.assessment_model.getComments_sprinkler());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_SWR, Assessment.assessment_model.getUse_ward_room());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_AN, Assessment.assessment_model.getAverage_number());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_AM, Assessment.assessment_model.getAverage_month());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_TS, Assessment.assessment_model.getType_cylinders());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CMC, Assessment.assessment_model.getCommon_model_cylinder());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CMCO, Assessment.assessment_model.getCommon_model_cylinder_other());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_TCC, Assessment.assessment_model.getType_conection_cylinder());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NS, Assessment.assessment_model.getName_supplier());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HFR, Assessment.assessment_model.getHealth_facility_receive());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HFS, Assessment.assessment_model.getHealth_facility_suffered());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CC, Assessment.assessment_model.getComments_cylinders());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_CIHF, Assessment.assessment_model.getConcentrator_in_health_fac());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NC, Assessment.assessment_model.getNumber_concentrator());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CB, Assessment.assessment_model.getConcentrator_broken());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_APMPC, Assessment.assessment_model.getActive_pm_program_conc());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ACB, Assessment.assessment_model.getActive_carrie_by());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FC, Assessment.assessment_model.getFrequency_conce());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NMC, Assessment.assessment_model.getName_maintenance_company());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ACPY, Assessment.assessment_model.getAverage_cost_per_year());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_BMP, Assessment.assessment_model.getBudgbet_maitanance_progra());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LBMC, Assessment.assessment_model.getLogbbook_maintenance_conc());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LUC, Assessment.assessment_model.getLogbbook_update_cenc());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CCONC, Assessment.assessment_model.getComments_conc());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_MIH, Assessment.assessment_model.getManifold_in_health());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_TSUM, Assessment.assessment_model.getType_supply_used_manifold());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ADS, Assessment.assessment_model.getAreas_does_supply());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ADSO, Assessment.assessment_model.getAreas_does_supply_other());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ADSOT, Assessment.assessment_model.getAreas_does_supply_otherTwoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_OSM, Assessment.assessment_model.getOld_system_manifold());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_KM, Assessment.assessment_model.getKind_manifold());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CM, Assessment.assessment_model.getCapacity_manifold());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_DS, Assessment.assessment_model.getDiameter_system());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HMCCRS, Assessment.assessment_model.getHow_many_cylinder_conect_rs());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HMCCLS, Assessment.assessment_model.getHow_many_cylinder_conect_ls());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HMCCTOTAL, Assessment.assessment_model.getHow_many_cylinder_conect_total());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_APM, Assessment.assessment_model.getAverage_per_month());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_MCMC, Assessment.assessment_model.getMost_common_model_cylinder());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_MCMCO, Assessment.assessment_model.getMost_common_model_cylinder_other());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_TCCYLIN, Assessment.assessment_model.getType_conection_cylinder_maniFold());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_MW, Assessment.assessment_model.getManifold_working());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CSYS, Assessment.assessment_model.getCondition_system());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_APMPM, Assessment.assessment_model.getActive_pm_program_manif());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FPMM, Assessment.assessment_model.getFrequency_pm_mani());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_AB, Assessment.assessment_model.getActivities_by());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NMM, Assessment.assessment_model.getName_maintenance_maniFold());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ACPYYEAR, Assessment.assessment_model.getAverage_cost_per_year_maniFold());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_BMPROGRAM, Assessment.assessment_model.getBugdet_maitenance_program());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LM, Assessment.assessment_model.getLogbbook_maintenance());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LUM, Assessment.assessment_model.getLogbbook_update_manifold());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_MCS, Assessment.assessment_model.getName_cylinder_supply());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HDRC, Assessment.assessment_model.getHow_does_receive_cylinder());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SLTY, Assessment.assessment_model.getShortages_last_twoo_year());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CMANI, Assessment.assessment_model.getComments_manifold());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_MIHT, Assessment.assessment_model.getManifold_in_health_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_TSUMT, Assessment.assessment_model.getType_supply_used_manifold_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ADST, Assessment.assessment_model.getAreas_does_supply_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ADSOTT, Assessment.assessment_model.getAreas_does_supply_otherTwoo_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ADSOTTT, Assessment.assessment_model.getAreas_does_supply_other_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_OSMT, Assessment.assessment_model.getOld_system_manifold_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_KMT, Assessment.assessment_model.getKind_manifold_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CMT, Assessment.assessment_model.getCapacity_manifold_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_DST, Assessment.assessment_model.getDiameter_system_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HMCCRST, Assessment.assessment_model.getHow_many_cylinder_conect_rs_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HMCCLST, Assessment.assessment_model.getHow_many_cylinder_conect_ls_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HMCCTOTALT, Assessment.assessment_model.getHow_many_cylinder_conect_total_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_APMT, Assessment.assessment_model.getAverage_per_month_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_MCMCT, Assessment.assessment_model.getMost_common_model_cylinder_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_MCMCOT, Assessment.assessment_model.getMost_common_model_cylinder_other_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_TCCYLINT, Assessment.assessment_model.getType_conection_cylinder_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_MWT, Assessment.assessment_model.getManifold_working_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CSYST, Assessment.assessment_model.getCondition_system_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_APMPMT, Assessment.assessment_model.getActive_pm_program_manif_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FPMMT, Assessment.assessment_model.getFrequency_pm_mani_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ABT, Assessment.assessment_model.getActivities_by_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NMMT, Assessment.assessment_model.getName_maintenance_maniFold_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ACPYYEART, Assessment.assessment_model.getAverage_cost_per_year_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_BMPROGRAMT, Assessment.assessment_model.getBugdet_maitenance_program_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LMT, Assessment.assessment_model.getLogbbook_maintenance_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LUMT, Assessment.assessment_model.getLogbbook_update_manifold_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_MCST, Assessment.assessment_model.getName_cylinder_supply_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HDRCT, Assessment.assessment_model.getHow_does_receive_cylinder_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SLTYT, Assessment.assessment_model.getShortages_last_twoo_year_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CMANIT, Assessment.assessment_model.getComments_manifold_twoo());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_MIHE, Assessment.assessment_model.getManifold_in_health_emerg());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_TSUME, Assessment.assessment_model.getType_supply_used_manifold_emerg());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_OSME, Assessment.assessment_model.getOld_system_manifold_emerg());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_KME, Assessment.assessment_model.getKind_manifold_emerg());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CME, Assessment.assessment_model.getCapacity_manifold_emerg());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_DSE, Assessment.assessment_model.getDiameter_system_emerg());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HMCCE, Assessment.assessment_model.getHow_many_cylinder_conect_total_emerg());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_APME, Assessment.assessment_model.getAverage_per_month_emerg());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_MCMCE, Assessment.assessment_model.getMost_common_model_cylinder_emerg());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_MCMCET, Assessment.assessment_model.getMost_common_model_cylinder_other_emerg());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_TCCE, Assessment.assessment_model.getType_conection_cylinder_mani_emerg());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_MWE, Assessment.assessment_model.getManifold_working_emerg());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CSE, Assessment.assessment_model.getCondition_system_emerg());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_APMPME, Assessment.assessment_model.getActive_pm_program_manif_emerg());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FPMME, Assessment.assessment_model.getFrequency_pm_mani_emerg());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ABE, Assessment.assessment_model.getActivities_by_emerg());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NMME, Assessment.assessment_model.getName_maintenance_maniFold_emerg());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ACPYE, Assessment.assessment_model.getAverage_cost_per_year_emerg());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_BMOE, Assessment.assessment_model.getBugdet_maitenance_program_emerg());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LME, Assessment.assessment_model.getLogbbook_maintena_emerg());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LUME, Assessment.assessment_model.getLogbbook_update_manifold_emerg());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NCSE, Assessment.assessment_model.getName_cylinder_supply_emerg());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HRCE, Assessment.assessment_model.getHow_does_receive_cylinder_emerg());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CMEM, Assessment.assessment_model.getComments_manifold_emerg());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_LO, Assessment.assessment_model.getLiquid_oxygen());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ACOXY, Assessment.assessment_model.getAverage_consuming_oxygen());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LMC, Assessment.assessment_model.getLast_month_consuminh());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_TO, Assessment.assessment_model.getTank_owner());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_TOOTHER, Assessment.assessment_model.getTank_owner_other());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_OSOX, Assessment.assessment_model.getOld_system_oxygen());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CLTM, Assessment.assessment_model.getCapacity_lox_tank_m3());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CLTT, Assessment.assessment_model.getCapacity_lox_tank_ton());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SWOT, Assessment.assessment_model.getSystem_working_ox_tank());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CSOT, Assessment.assessment_model.getCondition_system_ox_tank());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_APMP, Assessment.assessment_model.getActive_pm_program());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ACBOT, Assessment.assessment_model.getActivie_carrie_by_ox_tank());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FOT, Assessment.assessment_model.getFrequency_ox_tank());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NMCOT, Assessment.assessment_model.getName_maintenance_company_ox_tank());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ACOT, Assessment.assessment_model.getAverage_cost_ox_tank());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_BLT, Assessment.assessment_model.getBudget_lox_tank());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LMOX, Assessment.assessment_model.getLogbook_mainte_tank());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LUOT, Assessment.assessment_model.getLogbook_update_ox_tank());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NSOT, Assessment.assessment_model.getName_supply_ox_tank());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HRL, Assessment.assessment_model.getHealth_receive_lox());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SL, Assessment.assessment_model.getShortages_lox());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SIOX, Assessment.assessment_model.getSpecialized_internal());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HMTA, Assessment.assessment_model.getHow_many_tecn_available());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_COT, Assessment.assessment_model.getComment_ox_tank());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_LOT, Assessment.assessment_model.getLiquid_oxygen_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ACOXYT, Assessment.assessment_model.getAverage_consuming_oxygen_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LMCT, Assessment.assessment_model.getLast_month_consuminh_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_TOT, Assessment.assessment_model.getTank_owner_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_TOOTHERT, Assessment.assessment_model.getTank_owner_other_twhoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_OSOXT, Assessment.assessment_model.getOld_system_oxygen_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CLTMT, Assessment.assessment_model.getCapacity_lox_tank_m3_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CLTTT, Assessment.assessment_model.getCapacity_lox_tank_ton_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SWOTT, Assessment.assessment_model.getSystem_working_ox_tank_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CSOTT, Assessment.assessment_model.getCondition_system_ox_tank_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_APMPT, Assessment.assessment_model.getActive_pm_program_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ACBOTT, Assessment.assessment_model.getActivie_carrie_by_ox_tank_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FOTT, Assessment.assessment_model.getFrequency_ox_tank_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NMCOTT, Assessment.assessment_model.getName_maintenance_company_ox_tank_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ACOTT, Assessment.assessment_model.getAverage_cost_ox_tank_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_BLTT, Assessment.assessment_model.getBudget_lox_tank_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LMOXT, Assessment.assessment_model.getLogbbook_maintenance_twoo_mani());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LUOTT, Assessment.assessment_model.getLogbook_update_ox_tank_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NSOTT, Assessment.assessment_model.getName_supply_ox_tank_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HRLT, Assessment.assessment_model.getHealth_receive_lox_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SLT, Assessment.assessment_model.getShortages_lox_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SIOXT, Assessment.assessment_model.getSpecialized_internal_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HMTAT, Assessment.assessment_model.getHow_many_tecn_available_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_COTT, Assessment.assessment_model.getComment_ox_tank_twoo());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_O, Assessment.assessment_model.getOxygen_ox2_plant());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_OSO, Assessment.assessment_model.getOld_system_ox2());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CFO, Assessment.assessment_model.getCapacity_factory_ox2());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_DO, Assessment.assessment_model.getDiemeter_ox2());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_TPO, Assessment.assessment_model.getTota_production());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SWO, Assessment.assessment_model.getSystem_working_ox2());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CO, Assessment.assessment_model.getCondition_ox2());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_STO, Assessment.assessment_model.getSpecific_transformer_ox2());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SGO, Assessment.assessment_model.getSpecific_generator_ox2());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SUO, Assessment.assessment_model.getSpecific_ups_ox2());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SSO, Assessment.assessment_model.getSpecific_stablilizer_ox2());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_MFCO, Assessment.assessment_model.getManifolf_fill_cylinder());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CFSOC, Assessment.assessment_model.getCap_fill_system_ox_cylinder());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_COTFS, Assessment.assessment_model.getCap_ox_tank_fill_system());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_MMO, Assessment.assessment_model.getMost_common_ox2());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SWO2, Assessment.assessment_model.getSystem_working_ox2_ox());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SCO, Assessment.assessment_model.getSupply_cylinder_ox2());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_WSCO, Assessment.assessment_model.getWhich_supply_cylinder_ox2());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HSC, Assessment.assessment_model.getHealth_supply_cyclinder());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_APPO, Assessment.assessment_model.getActive_pm_program_ox2());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FPO, Assessment.assessment_model.getFrequency_pm_ox2());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ACBO, Assessment.assessment_model.getActivities_carried_by_ox2());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NMO, Assessment.assessment_model.getName_maintenance_ox2());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ACYO, Assessment.assessment_model.getAverage_cost_year_ox2());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_BO, Assessment.assessment_model.getBudget_ox2());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_STIO, Assessment.assessment_model.getSpecilized_tecn_internal_ox2());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HMTAO, Assessment.assessment_model.getHow_many_tecn_available_ox2());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ASTLO, Assessment.assessment_model.getAny_shortage_two_last_ox2());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CO2, Assessment.assessment_model.getComments_ox2());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_SUS, Assessment.assessment_model.getSuction_system());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_OSSU, Assessment.assessment_model.getOlde_system_ss());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CSSU, Assessment.assessment_model.getCapacity_system_ss());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SUSW, Assessment.assessment_model.getSuction_system_working());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CSSUC, Assessment.assessment_model.getCondiction_system_ss());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_APMPRS, Assessment.assessment_model.getActive_pm_program_ss());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FPMSS, Assessment.assessment_model.getFrequency_pm_month_ss());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ACBSS, Assessment.assessment_model.getActivities_carried_by_ss());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NMSS, Assessment.assessment_model.getName_maintenance_ss());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_APMSS, Assessment.assessment_model.getAverage_pm_suction_ss());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_BSS, Assessment.assessment_model.getBudget_suction_ss());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CSS, Assessment.assessment_model.getComment_suction());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_MAMS, Assessment.assessment_model.getMedical_air_mas());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_OSMS, Assessment.assessment_model.getOld_system_mas());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SCMS, Assessment.assessment_model.getSystem_capacity_mas());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SWM, Assessment.assessment_model.getSystem_working_mmas());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CSM, Assessment.assessment_model.getCondition_system_mas());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_APMM, Assessment.assessment_model.getActive_pm_mas());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FSM, Assessment.assessment_model.getFrequency_system_mas());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ACBYM, Assessment.assessment_model.getActivies_carries_by_mas());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NMMAS, Assessment.assessment_model.getName_maintenance_mas());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_AMAS, Assessment.assessment_model.getAverage_mas());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_BMAS, Assessment.assessment_model.getBudget_mas());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CMAS, Assessment.assessment_model.getComments_mas());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_PN, Assessment.assessment_model.getPiping_network());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_OS, Assessment.assessment_model.getOld_sysem_pp());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SWPP, Assessment.assessment_model.getSystem_working_pp());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_VFEA, Assessment.assessment_model.getValves_for_each_area());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SKWSO, Assessment.assessment_model.getStaff_know_where_shut_off());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SKWC, Assessment.assessment_model.getStaff_know_wher_close());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HLPA, Assessment.assessment_model.getHigh_low_pressure_alarm());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CA, Assessment.assessment_model.getCentralized_alarm());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CSPP, Assessment.assessment_model.getCondition_system_pp());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_TPOU, Assessment.assessment_model.getType_plug_outlet());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_TPOU, Assessment.assessment_model.getOther_type_plug_outlet());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_APMPRO, Assessment.assessment_model.getActive_pm_program_pp());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FSPP, Assessment.assessment_model.getFrequency_system_pp());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_PACPP, Assessment.assessment_model.getPm_actives_carried_pp());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NMPP, Assessment.assessment_model.getName_maintanance_pp());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ACPP, Assessment.assessment_model.getAverage_cost_piping());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_BPPP, Assessment.assessment_model.getBudget_program_pp());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CPP, Assessment.assessment_model.getComments_pp());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_ROCL, Assessment.assessment_model.getReceive_ox_cylinder_log());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ROCL_OTHER, Assessment.assessment_model.getReceive_ox_cyl_other());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CRL, Assessment.assessment_model.getComments_rece_log());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LCL, Assessment.assessment_model.getLogbook_cylinder_log());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CLL, Assessment.assessment_model.getComments_logbook_log());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_ULLT, Assessment.assessment_model.getUse_logb_lox_tank());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CLT, Assessment.assessment_model.getComments_lox_tank());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SC, Assessment.assessment_model.getSupply_consuminh());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CSC, Assessment.assessment_model.getComments_sup_consum());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_IME, Assessment.assessment_model.getInventory_med_equip());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FME, Assessment.assessment_model.getFormat_med_equip());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SSE, Assessment.assessment_model.getShow_status_equip());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HTR, Assessment.assessment_model.getHow_the_repair());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LCPM, Assessment.assessment_model.getLevel_contract_pm());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LCPM_OT, Assessment.assessment_model.getLevel_contract_pm_ot());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_APMMME, Assessment.assessment_model.getActive_pm_mme());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_PFFI, Assessment.assessment_model.getProtocol_follow_fill_in());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_RSW, Assessment.assessment_model.getRecorder_specific_way());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CCA, Assessment.assessment_model.getControl_cost_assoc());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_LTRS, Assessment.assessment_model.getLast_time_rec_super());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_LTRST, Assessment.assessment_model.getLast_time_rec_sup_training());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_TSA, Assessment.assessment_model.getTecn_specil_available());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_TNT, Assessment.assessment_model.getTotal_number_tecni());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NTSH, Assessment.assessment_model.getNumber_tec_specia_health());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NB, Assessment.assessment_model.getNumber_biomedical());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_SPO2, Assessment.assessment_model.getSafety_program_ox2());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_RSP, Assessment.assessment_model.getResponsable_savefy_program());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_NSS, Assessment.assessment_model.getNational_sec_system());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_EU, Assessment.assessment_model.getEnd_users());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HOEUT, Assessment.assessment_model.getHow_often_end_user_train());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HMUT, Assessment.assessment_model.getHow_many_users_trained());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_TFA, Assessment.assessment_model.getTecn_formed_aspect());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HOTU, Assessment.assessment_model.getHow_often_train_users());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_TT, Assessment.assessment_model.getTecnic_trained());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CTC, Assessment.assessment_model.getComments_train_cylinder());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_EUC, Assessment.assessment_model.getEnd_users_conc());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FT, Assessment.assessment_model.getFrequency_training());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HMUF, Assessment.assessment_model.getHow_many_users_formed());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_TFAC, Assessment.assessment_model.getTecn_formed_aspect_conc());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FTCT, Assessment.assessment_model.getFrequency_training_conc_twoo());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HMTT, Assessment.assessment_model.getHow_many_tecnic_trained());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CTCONC, Assessment.assessment_model.getComments_train_conc());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_TTRM, Assessment.assessment_model.getTecni_traine_related_manifolf());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FTM, Assessment.assessment_model.getFrequency_trainig_manifold());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HMTTMO, Assessment.assessment_model.getHow_many_techn_trained_man_out());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CTMO, Assessment.assessment_model.getComments_train_man_out());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_TTL, Assessment.assessment_model.getTecni_train_lox());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FTOT, Assessment.assessment_model.getFrequency_trainnOT());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HMTTLOX, Assessment.assessment_model.getHow_many_tech_trained_lox());
        cv.put(Assessment.DadosTabela.COLUMN_NAME__CTLOX, Assessment.assessment_model.getComments_train_lox());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_TMRF, Assessment.assessment_model.getTrain_matter_related_fact());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FTF, Assessment.assessment_model.getFrequency_trainig_fact());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_TTH, Assessment.assessment_model.getTechi_trained_handling());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CF, Assessment.assessment_model.getComments_factory());

        cv.put(Assessment.DadosTabela.COLUMN_NAME_EUGO, Assessment.assessment_model.getEnd_users_gas_outlets());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_FTGO, Assessment.assessment_model.getFrequency_trainig_gas_out());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_HMEU, Assessment.assessment_model.getHow_many_end_users());
        cv.put(Assessment.DadosTabela.COLUMN_NAME_CMGOU, Assessment.assessment_model.getComments_med_gas_outlets());

        long newRowId = db.insert(Assessment.DadosTabela.TABLE_ASSESSMENT, null, cv);
        if (newRowId == -1) {
            return false;
        } else
            return true;
    }

    public Cursor readAllData_form() {
        String query = "SELECT * FROM " + TABLE_ASSESSMENT + " ORDER BY id DESC";
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

  /*  public ArrayList<Assessment_model> getAllData() {
        ArrayList<Assessment_model> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_ASSESSMENT + "", null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String health_fac_id = cursor.getString(14);
            String health_fac = cursor.getString(15);
            String province = cursor.getString(18);

            Assessment_model assessment_model = new Assessment_model(health_fac_id, health_fac, province);
            arrayList.add(assessment_model);
        }
        return arrayList;
    }*/

    public void deleteOneRow_form(String row_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_ASSESSMENT, "id=?", new String[]{row_id});
        if (result == -1) {
            Toast.makeText(context, "Something went wrong, please try again", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Data deleted", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteAllData_form() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_ASSESSMENT);
    }
  /*  public ArrayList<Equipment_inventory> getAllData() {
        ArrayList<Equipment_inventory> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_INVENTORY + " ", null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String department = cursor.getString(1);
            String type_equipment = cursor.getString(2);
            String inventory_number = cursor.getString(3);
            String make = cursor.getString(4);
            String model = cursor.getString(5);
            String serial_number = cursor.getString(6);
            String equip_condition = cursor.getString(7);
            String year_install = cursor.getString(8);
            String main_contract = cursor.getString(9);
            String data_last_main = cursor.getString(10);
            String comment = cursor.getString(11);

            Equipment_inventory equipment_inventory = new Equipment_inventory(department, type_equipment, inventory_number, make, model, serial_number, equip_condition, year_install, main_contract, data_last_main, comment);

            arrayList.add(equipment_inventory);
        }
        return arrayList;
    }*/
}
