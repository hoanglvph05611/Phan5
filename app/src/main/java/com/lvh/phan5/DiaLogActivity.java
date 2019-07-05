package com.lvh.phan5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.BatchUpdateException;
import java.util.Calendar;

public class DiaLogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_log);
    }

    public void btnCustomDialog(View view) {

        // b1: dinh nghia
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // b2: thiet lap thong tin
        builder.setTitle("Custom Dialog");

        // tao ra 1 view de hien thi tren dialog
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View dialogView = layoutInflater.inflate(R.layout.custom_dialog, null);
        builder.setView(dialogView);

        // khoi tap view
        final EditText edName = dialogView.findViewById(R.id.edName);
        final EditText edPassWord = dialogView.findViewById(R.id.edPassWord);

        builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String useName = edName.getText().toString();
                String usePassWord = edPassWord.getText().toString();
                Toast.makeText(DiaLogActivity.this, useName + " " + usePassWord + " ", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();

    }

    public void btnAlerDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Aler Dialog");
        builder.setMessage("Ban co muon dang xuat khong ? ");
        builder.setPositiveButton("Dang xuat", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("Khong ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }

    public void btnAlerListDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final String[] lop = {"PT13351", "PT13352", "PT13353", "PT13354"};
        builder.setTitle("Chon lop ");
        builder.setItems(lop, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DiaLogActivity.this, "Lop " + lop[i], Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    public void btnAlerSimpleDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final String[] lop = {"PT13351", "PT13352", "PT13353", "PT13354"};
        builder.setTitle("Chon lop ");
        builder.setSingleChoiceItems(lop, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DiaLogActivity.this, "Lop " + lop[i], Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    public void btnAlerMultichoiceDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final String[] lop = {"PT13351", "PT13352", "PT13353", "PT13354"};
        boolean[] chon = {false, true, false, false};
        builder.setTitle("Chon lop ");
        builder.setMultiChoiceItems(lop, chon, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                Toast.makeText(DiaLogActivity.this, "Lop " + lop[i], Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    public void btnAlerDatePickerDialog(View view) {
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog date = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                Toast.makeText(DiaLogActivity.this, year + "/" + month + "/" + day, Toast.LENGTH_SHORT).show();
            }
        }, year, month, day);
        // hien thi
        date.show();
    }

    public void btnAlerShowTimeStickerDialog(View view) {
        Calendar calendar = Calendar.getInstance();
        final int gio = calendar.get(Calendar.HOUR_OF_DAY);
        final int phut = calendar.get(Calendar.MONTH);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                Toast.makeText(DiaLogActivity.this, gio + ": " + phut + ": ", Toast.LENGTH_SHORT).show();
            }
        }, gio, phut, true);
        timePickerDialog.show();
    }

    public void btnAlerProgressDialog(View view) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading...");
        progressDialog.setMessage("Ban co muon thoat khong ? ");
        progressDialog.setButton(ProgressDialog.BUTTON_POSITIVE, "Co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                progressDialog.dismiss();
            }
        });
        progressDialog.setButton(ProgressDialog.BUTTON_NEGATIVE, "Khong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                progressDialog.dismiss();
            }
        });
        // hien thi dang nam ngang
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        // SHOW
        progressDialog.show();
        // thiet lap trang thai
        progressDialog.setProgress(75);
    }
}
