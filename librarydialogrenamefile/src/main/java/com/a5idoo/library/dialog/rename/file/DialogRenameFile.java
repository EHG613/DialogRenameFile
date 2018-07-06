package com.a5idoo.library.dialog.rename.file;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;

public class DialogRenameFile extends AppCompatActivity {
    private NoMenuEditText mEtContent;
    public static final String EXTRA_ID = "com.a5idoo.library.dialog.rename.file.ID";
    public static final String EXTRA_FILENAME = "com.a5idoo.library.dialog.rename.file.FILENAME";
    public static final String EXTRA_MAX_LENGTH = "com.a5idoo.library.dialog.rename.file.MAX_LENGTH";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_rename_file);
        mEtContent = findViewById(R.id.et_dialog_content);
        mEtContent.addTextChangedListener(new EditChangedListener());
        if(TextUtils.isEmpty(getIntent().getStringExtra(EXTRA_FILENAME))){
            mEtContent.setText(null);
        }else if(getIntent().getStringExtra(EXTRA_FILENAME).lastIndexOf(".")<0) {
            mEtContent.setText(getIntent().getStringExtra(EXTRA_FILENAME));
            mEtContent.setSelection(TextUtils.isEmpty(mEtContent.getText())?0:mEtContent.getText().length());
        }else{
            mEtContent.setText(getIntent().getStringExtra(EXTRA_FILENAME).substring(0,getIntent().getStringExtra(EXTRA_FILENAME).lastIndexOf(".")));
            mEtContent.setSelection(TextUtils.isEmpty(mEtContent.getText())?0:mEtContent.getText().length());
        }
    }

    private class EditChangedListener implements TextWatcher {
        private CharSequence temp = "";//监听前的文本

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            temp = charSequence;
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (temp.length() > getIntent().getIntExtra(EXTRA_MAX_LENGTH,50)) {
                RenameFileEventManager.onMax(getIntent().getIntExtra(EXTRA_MAX_LENGTH,50));
                mEtContent.setText(editable.subSequence(0, getIntent().getIntExtra(EXTRA_MAX_LENGTH,50)));
                mEtContent.setSelection(TextUtils.isEmpty(mEtContent.getText())?0:mEtContent.getText().length());
            }
        }
    }

    public void onCancel(View view) {
        finish();
    }

    public void onConfirm(View view) {
        if (TextUtils.isEmpty(mEtContent.getText())) {
            RenameFileEventManager.onEmpty();
        } else {
            if (TextUtils.isEmpty(getIntent().getStringExtra(EXTRA_ID))) {
                RenameFileEventManager.onRename(mEtContent.getText().toString() + (getIntent().getStringExtra(EXTRA_FILENAME).lastIndexOf(".") < 0 ? "" : getIntent().getStringExtra(EXTRA_FILENAME).substring(getIntent().getStringExtra(EXTRA_FILENAME).lastIndexOf("."))));
            } else {
                RenameFileEventManager.onRename(mEtContent.getText().toString() + (getIntent().getStringExtra(EXTRA_FILENAME).lastIndexOf(".") < 0 ? "" : getIntent().getStringExtra(EXTRA_FILENAME).substring(getIntent().getStringExtra(EXTRA_FILENAME).lastIndexOf("."))), getIntent().getStringExtra(EXTRA_ID));
            }
            finish();
        }
    }
}
