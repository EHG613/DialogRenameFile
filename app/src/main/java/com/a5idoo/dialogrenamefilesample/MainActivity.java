package com.a5idoo.dialogrenamefilesample;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.a5idoo.library.dialog.rename.file.DialogRenameFile;
import com.a5idoo.library.dialog.rename.file.RenameFileEventManager;
import com.a5idoo.library.dialog.rename.file.SimpleRenameFileEvent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RenameFileEventManager.setEventListener(new SimpleRenameFileEvent() {
            @Override
            public void onEmpty() {
                Toast.makeText(getApplicationContext(), "请输入文件名", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMax(int maxLength) {
                Toast.makeText(getApplicationContext(), "最大长度为" + maxLength + "个字", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRename(String str) {
                Toast.makeText(getApplicationContext(), "重命名为:" + str, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRename(String str, String id) {
                Toast.makeText(getApplicationContext(), "重命名为:" + str + ";ID:" + id, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void openDialog(View view) {
        Intent intent = new Intent(this, DialogRenameFile.class);
        intent.putExtra(DialogRenameFile.EXTRA_FILENAME, "123.txt");
        intent.putExtra(DialogRenameFile.EXTRA_ID, "adbcdef");
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RenameFileEventManager.unbind();
    }
}
