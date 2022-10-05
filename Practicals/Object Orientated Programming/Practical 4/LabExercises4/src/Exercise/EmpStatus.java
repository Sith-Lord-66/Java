package Exercise;

public enum EmpStatus {
    FULL_TIME("Full Time Employment"), // to define full-time employment status
    PART_TIME("Part Time Employment"), // to define part-time employment status
    LEFT("No Longer Employed");  // no longer employee status

    private String value;

    private EmpStatus(String value){
        this.value = value;
    }
    public String getStatus(){
        return value;
    }


}

