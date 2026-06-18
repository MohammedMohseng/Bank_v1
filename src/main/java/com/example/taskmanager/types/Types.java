package com.example.taskmanager.types;

public class Types {
    public enum Gender {
        MALE("man"),
        FEMALE("woman");

        final private String displayName;

        Gender(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return this.displayName;
        }

    }

    public enum Code {
        ok(200),
        bad(400);

        final private int code;

        Code(int code) {
            this.code = code;
        }

        public int getCodeNumber() {
            return this.code;
        }

    }
}
