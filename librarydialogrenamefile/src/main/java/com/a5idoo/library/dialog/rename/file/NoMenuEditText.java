/*
 * 阔地教育科技有限公司版权所有(codyy.com/codyy.cn)
 * Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */

package com.a5idoo.library.dialog.rename.file;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

/**
 * NoMenuEditText 取消EditText粘贴功能
 * Created by lijian on 2016/7/27.
 */
public class NoMenuEditText extends androidx.appcompat.widget.AppCompatEditText {
    private final Context context;


    /**
     * This is a replacement method for the base TextView class' method of the
     * same name. This method is used in hidden class android.widget.Editor to
     * determine whether the PASTE/REPLACE popup appears when triggered from the
     * text insertion handle. Returning false forces this window to never
     * appear.
     *
     * @return false
     */
    boolean canPaste() {
        return false;
    }


    /**
     * This is a replacement method for the base TextView class' method of the
     * same name. This method is used in hidden class android.widget.Editor to
     * determine whether the PASTE/REPLACE popup appears when triggered from the
     * text insertion handle. Returning false forces this window to never
     * appear.
     *
     * @return false
     */
    @Override
    public boolean isSuggestionsEnabled() {
        return false;
    }


    public NoMenuEditText(Context context) {
        super(context);
        this.context = context;
        init();
    }


    public NoMenuEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }


    public NoMenuEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        init();
    }


    private void init() {
        this.setCustomSelectionActionModeCallback(new ActionModeCallbackInterceptor());
        this.setLongClickable(false);
    }

    @Override
    public boolean onTextContextMenuItem(int id) {
        if (android.R.id.paste == id)
            return false;
        return super.onTextContextMenuItem(id);
    }

    /**
     * Prevents the action bar (top horizontal bar with cut, copy, paste, etc.)
     * from appearing by intercepting the callback that would cause it to be
     * created, and returning false.
     */
    private class ActionModeCallbackInterceptor implements ActionMode.Callback {


        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            return false;
        }


        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }


        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return false;
        }


        public void onDestroyActionMode(ActionMode mode) {
        }
    }
}
