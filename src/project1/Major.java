package project1;

public enum Major {

    CS("SAS", "01:198"),
    MATH("SAS", "01:640"),
    EE("SOE", "14:332"),
    ITI("SC&I", "04:547"),
    BAIT("RBS", "33:136"),
    UNKNOWN(null, null);
    private final String school;
    private final String code;

    Major(String school, String code)
    {
        this.school = school;
        this.code = code;
    }

    public String getSchool() {
        return school;
    }

    public String getCode() {
        return code;
    }

}
