package com.a5idoo.library.dialog.rename.file;

public interface RenameFileEvent {
    void onEmpty();

    void onMax(int maxLength);

    void onRename(String str);

    void onRename(String str, String id);
}
