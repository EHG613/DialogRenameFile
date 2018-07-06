package com.a5idoo.library.dialog.rename.file;

public class RenameFileEventManager {
    private static RenameFileEvent sEvent;

    public static void setEventListener(RenameFileEvent event) {
        sEvent = event;
    }

    public static void onEmpty() {
        if (sEvent != null) {
            sEvent.onEmpty();
        }
    }

    public static void onMax(int maxLength) {
        if (sEvent != null) {
            sEvent.onMax(maxLength);
        }
    }

    public static void onRename(String filename) {
        if (sEvent != null) {
            sEvent.onRename(filename);
        }
    }

    public static void onRename(String filename, String id) {
        if (sEvent != null) {
            sEvent.onRename(filename, id);
        }
    }

    public static void unbind() {
        sEvent = null;
    }
}
