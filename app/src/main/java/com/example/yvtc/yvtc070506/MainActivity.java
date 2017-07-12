package com.example.yvtc.yvtc070506;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int choice = -1;
    int tmp;
    boolean chks[] = new boolean[4];
    boolean tmpchks[] = new boolean[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click1(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("第一個對話框");
        builder.setTitle("對話框標題");
        builder.setCancelable(false);
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "按下確定", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "按下取消", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("略過", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "按下略過", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    public void click2(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("輸入用對話框");
        builder.setMessage("請輸入訊息");
        final EditText ed = new EditText(MainActivity.this);
        builder.setView(ed);

        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = ed.getText().toString();
                TextView tv = (TextView) findViewById(R.id.textView);
                tv.setText(str);
            }
        });

        builder.show();
    }

    public void click3(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("單選項對話框");
        final String str[] = {"可樂", "紅茶", "汽水", "果汁"};
        tmp = choice;
        builder.setSingleChoiceItems(str, choice, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tmp = which;
            }
        });
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                choice = tmp;
                if (choice >= 0)
                {
                    TextView tv2 = (TextView) findViewById(R.id.textView2);
                    tv2.setText(str[choice]);
                }

            }
        });


        builder.show();
    }

    public void click4(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("列表型對話框");
        final String str[] = {"可樂", "紅茶", "汽水", "果汁"};
        builder.setItems(str, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }
    public void click5(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("多選項對話框");
        final String str[] = {"可樂", "紅茶", "汽水", "果汁"};
        int i;
        for (i=0;i<chks.length;i++)
        {
            tmpchks[i] = chks[i];
        }
        builder.setMultiChoiceItems(str, tmpchks, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        });
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TextView tv3 = (TextView) findViewById(R.id.textView3);
                String showStr = "";
                int i;
                for (i=0;i<chks.length;i++)
                {
                    chks[i] = tmpchks[i];
                }
                for (i=0;i<chks.length;i++)
                {
                    if (chks[i]) {
                        showStr += str[i] + ",";
                    }
                }
                tv3.setText(showStr);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

    public void click6(View v)
    {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("自訂對話框");

        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        View diagView = inflater.inflate(R.layout.diag_layout, null);

        final EditText ed = (EditText)  diagView.findViewById(R.id.editText);
        Button btn6 = (Button) diagView.findViewById(R.id.button6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, ed.getText().toString(), Toast.LENGTH_SHORT).show();
                // ((AlertDialog) v.getParent().getParent().getParent()).dismiss();
            }
        });

        builder.setView(diagView);


        builder.show();
    }
}