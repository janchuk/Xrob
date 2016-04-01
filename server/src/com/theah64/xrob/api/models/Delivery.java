package com.theah64.xrob.api.models;

import javax.servlet.ServletContext;
import java.io.File;

/**
 * Created by theapache64 on 11/29/2015.
 */
public class Delivery {

    private static final String TYPE_MESSAGE = "message";
    private static final String TYPE_CALL_LOG = "call_log";
    private static final String TYPE_CONTACTS = "contacts";
    private static final String TYPE_FILES = "files";
    private static final String TYPE_MEDIA_SCREEN_SHOT = "media_screen_shot";
    private static final String TYPE_MEDIA_VOICE = "media_voice";
    private static final String TYPE_MEDIA_SELFIE = "media_selfie";

    private final String id, userId, message, createdAt;
    private String dataType;
    private final boolean hasError;

    private Delivery(String userId, boolean hasError, String message, String dataType, String id, String createdAt) {
        this.id = id;
        this.userId = userId;
        this.dataType = dataType;
        this.message = message;
        this.hasError = hasError;
        this.createdAt = createdAt;
    }

    public Delivery(String userId, boolean hasError, String message) {
        this(userId, hasError, message, null, null, null);
    }

    public String getUserId() {
        return this.userId;
    }

    public String getDataType() {
        return this.dataType;
    }

    public boolean hasError() {
        return this.hasError;
    }

    public String getMessage() {
        return this.message;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }


    public static class Type {

        private static final String BASE_FILE_STORAGE_FOLDER_NAME = "uploads";
        private static final String FILE_STORAGE_FOLDER_NAME = "files";
        private static String FILES_STORAGE_PATH;
        private static String baseFileStoragePath;

        private final String dataType;

        public Type(final ServletContext context, String dataType) {

            this.dataType = dataType;

            //Initializing base file storage path for the first time.
            if (baseFileStoragePath == null) {
                baseFileStoragePath = context.getRealPath(BASE_FILE_STORAGE_FOLDER_NAME);

                initOtherStoragePaths(baseFileStoragePath);
            }
        }

        private static void initOtherStoragePaths(String baseFileStoragePath) {
            FILES_STORAGE_PATH = baseFileStoragePath + File.separator + FILE_STORAGE_FOLDER_NAME;
            //TODO: Add other storage folder paths here.
        }


        public boolean isValid() {

            switch (this.dataType) {

                case TYPE_MESSAGE:
                case TYPE_CALL_LOG:
                case TYPE_CONTACTS:
                case TYPE_FILES:
                case TYPE_MEDIA_SCREEN_SHOT:
                case TYPE_MEDIA_VOICE:
                case TYPE_MEDIA_SELFIE:
                    return true;

                default:
                    //Undefined data type
                    return false;
            }

        }

        public String getStoragePath() {
            switch (this.dataType) {

                case TYPE_FILES:
                    return FILES_STORAGE_PATH;

                default:
                    throw new IllegalArgumentException("No storage path set for " + this.dataType);
            }
        }

    }
}
