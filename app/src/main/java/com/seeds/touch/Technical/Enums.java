package com.seeds.touch.Technical;

public final class Enums {
    public static enum Gender {
        NONE(-1),MALE(1),FEMALE(0);
        public int value;
        Gender(int value) {
            this.value = value;
        }
    };
    public static enum MealMode {
        BREAKFAST,LUNCH,DINNER,EVENING_MEAL
    }

    public static enum Status
    {
        SHOWN,HIDE
    }
    public static enum AccessType
    {
        PUBLIC,FRIENDS
    }
    public static enum LoginStatus {
        NEW,USER
    }
    public static enum ActivityRepository
    {
        MAIN_ACTIVITY, SETTING,LOG_IN,ADD_CINEMA_ITEM, ADD_TRAVEL_ITEM, COMPLETE_USER_PROFILE, ADD_RESTAURANT_ITEM
    }

    public enum EventTypes {
        HOME,WORLD
    }
    public static enum Tabs {
        FIRST,SECOND,THIRD,FORTH,FIFTH
    }

    public enum DisplayMode {
        SHOW,HIDE
    }
    public enum LoginResult
    {
        SUCCESSFUL_COMPLETED,
        SUCCESSFUL_NOT_COMPLETED,
        NOT_EXIST,
        WRONG_PASSWORD,
        ERROR;
    }
    public enum RegisterResult
    {
        SUCCESSFUL,
        EXIST_ID,
        ERROR
    }
    public enum UpdateUserResult
    {
        SUCCESSFUL,FAILED,ID_EXIST
    }
    public enum UpdateItemResult
    {
        SUCCESSFUL,FAILED
    }
    public enum SendNotificationResult
    {
        SUCCESSFUL,FAILURE
    }


}
