package dev.entites;

public enum GradeNutrition {
    A,B,C,D,E;
    public String getGrade() {
        switch (this){
            case A -> {
                return "A";
            }
            case B -> {
                return "B";
            }
            case C -> {
                return "C";
            }
            case D -> {
                return "D";
            }
            case E -> {
                return "E";
            }
        }
        return null;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GradeNutrition{");
        sb.append('}');
        return sb.toString();
    }
}
