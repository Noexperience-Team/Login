package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Second extends AppCompatActivity {
TextView wel,res;
RadioGroup Rg;
RadioButton Rb1,Rb2;
Button Calc;
EditText Value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        wel=(TextView) findViewById(R.id.welcome);
        Intent i=getIntent();
        String name=i.getStringExtra("name");
        wel.setText("welcome I will convert money for you MR "+name);
        Rg=(RadioGroup)findViewById(R.id.radioGroup);
        Rb1=(RadioButton)findViewById(R.id.con1);
        Rb2=(RadioButton)findViewById(R.id.con2);
        Calc=(Button)findViewById(R.id.Cal);
        Value=(EditText)findViewById(R.id.Money);
        res=(TextView)findViewById(R.id.Res);
        Rb1.setChecked(true);
        Calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Value.getText().toString().equals("")||Integer.parseInt(Value.getText().toString())<=0){
                    AlertDialog alert;
                    Context context;
                    alert=new AlertDialog.Builder(Second.this).create();
                    alert.setTitle("Type a positive number");
                    alert.setMessage("Insert a value to convert");
                    alert.setButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    alert.show();}
                    else{
                        if (Rb1.isChecked()){
                            System.out.println("hiii");
                            convertEuroToDinar(Float.parseFloat(Value.getText().toString()));
                        }else{
                           convertDinarToEuro(Float.parseFloat(Value.getText().toString()));
                        }
                    }
                             }



        });
        Rb1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                v.showContextMenu();
                return true;
            }
        });
        Rb1.setOnCreateContextMenuListener(this);



}
public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        menu.add(0,1,0,"conversion euro --> Dinar");
        menu.add(0,2,0,"convertion dinar-->euro");
        menu.add(0,3,0,"convertion c<->F");
        menu.add(0,4,0,"conversion F<->C");
        menu.add(0,5,0,"quitter");

}
public boolean onContextItemSelected(MenuItem item){
    Intent i;
        switch (item.getItemId()){
            case 1:
                convertEuroToDinar(Float.parseFloat(Value.getText().toString()));
                break;
            case 2:
                convertDinarToEuro(Float.parseFloat(Value.getText().toString()));
                break;
            case 3:
                i=new Intent(Second.this,Temperature.class);
                i.putExtra("temp",Float.parseFloat(Value.getText().toString()));
                i.putExtra("c",false);
                startActivity(i);
                break;
            case 4:
                float temp=Float.parseFloat(Value.getText().toString());
                i=new Intent(Second.this,Temperature.class);
                i.putExtra("temp",temp);
                i.putExtra("c",true);
                startActivity(i);
                break;
            case 5:
                this.finish();

        }
        return super.onContextItemSelected(item);
}
    public void convertDinarToEuro(float val) {
        val=val/3;
        Toast.makeText(Second.this,String.valueOf(val)+" Euro",Toast.LENGTH_LONG).show();
        res.setText(String.valueOf(val)+" Euro");
    }

    public void convertEuroToDinar(float val) {
        val=val*3;
        Toast.makeText(Second.this,String.valueOf(val)+" Dinar",Toast.LENGTH_LONG).show();
        res.setText(String.valueOf(val)+" Euro");
    }


}