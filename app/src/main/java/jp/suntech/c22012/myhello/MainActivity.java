package jp.suntech.c22012.myhello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ボタン・オブジェクトの用意
        Button btClick = findViewById(R.id.btClick);
        //リスナ・オブジェクトの用意
        HelloListener listener = new HelloListener();
        //ボタンにリスナを設定
        btClick.setOnClickListener(listener);

        //クリアボタンであるButtonオブジェクトを取得。
        Button btClear = findViewById(R.id.btClear);
        //クリアボタンにリスナを設定
        btClear.setOnClickListener(listener);
    }



    //ボタンをクリックした時のリスナクラス
    private class HelloListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //名前入力欄であるEditTextオブジェクトを取得。
            EditText input = findViewById(R.id.etName);
            //メッセージを表示するTextViewオブジェクトを取得。
            TextView output = findViewById(R.id.tvOutput);

            //タップされた画面部品をidのR値を取得。
            int id = (int)view.getId();
            //idのR値に応じて処理を分岐

            if(id==R.id.btClick){
                String inputStr = input.getText().toString();
                output.setText(inputStr);
            }else if(id == R.id.btClear){
                input.setText("");
                output.setText("");
            }

        }
    }

}