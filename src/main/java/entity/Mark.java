package entity;

public class Mark {
    private int id;
    private Student student;
    private Semestr semestr;
    private Discipline discipline;
    private String mark;

    public Mark() {
    }

    public Mark(int id, Student student, Semestr semestr, Discipline discipline, String mark) {
        this.id = id;
        this.student = student;
        this.semestr = semestr;
        this.discipline = discipline;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Semestr getSemestr() {
        return semestr;
    }

    public void setSemestr(Semestr semestr) {
        this.semestr = semestr;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mark mark1 = (Mark) o;

        if (id != mark1.id) return false;
        if (student != null ? !student.equals(mark1.student) : mark1.student != null) return false;
        if (semestr != null ? !semestr.equals(mark1.semestr) : mark1.semestr != null) return false;
        if (discipline != null ? !discipline.equals(mark1.discipline) : mark1.discipline != null) return false;
        return mark != null ? mark.equals(mark1.mark) : mark1.mark == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (student != null ? student.hashCode() : 0);
        result = 31 * result + (semestr != null ? semestr.hashCode() : 0);
        result = 31 * result + (discipline != null ? discipline.hashCode() : 0);
        result = 31 * result + (mark != null ? mark.hashCode() : 0);
        return result;
    }

    @Override
    public String  toString() {
        return "Mark{" +
                "id=" + id +
                ", student=" + student +
                ", semestr=" + semestr +
                ", discipline=" + discipline +
                ", mark='" + mark + '\'' +
                '}';
    }
}
