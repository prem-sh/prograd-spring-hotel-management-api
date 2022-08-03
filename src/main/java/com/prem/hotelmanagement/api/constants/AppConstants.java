package com.prem.hotelmanagement.api.constants;

public class AppConstants {
    public enum RoomStatus {
        OCCUPIED, AVAILABLE, UNDER_MAINTENANCE;
        public int id(){
            return this.ordinal()+1;
        }
        public static boolean validate(String status){
            for(RoomStatus s : RoomStatus.values()){
                if(s.toString().equalsIgnoreCase(status)) return true;
            }
            return false;
        }
        public static RoomStatus get(String val){
            return RoomStatus.valueOf(val.toUpperCase());
        }
    }
    public enum RoomTypes {
        SINGLE, DOUBLE, TWIN, KING;
        public int id(){
            return this.ordinal()+1;
        }
        public static boolean validate(String type){
            for(RoomTypes s : RoomTypes.values()){
                if(s.toString().equalsIgnoreCase(type)) return true;
            }
            return false;
        }
        public static RoomTypes get(String val){
            return RoomTypes.valueOf(val.toUpperCase());
        }
    }
    public enum BookingStatus {
        ACTIVE, CANCELLED, COMPLETED;
        public int id(){
            return this.ordinal()+1;
        }
        public static boolean validate(String status){
            for(BookingStatus s : BookingStatus.values()){
                if(s.toString().equalsIgnoreCase(status)) return true;
            }
            return false;
        }
        public static BookingStatus get(String val){
            return BookingStatus.valueOf(val.toUpperCase());
        }
    }
}
