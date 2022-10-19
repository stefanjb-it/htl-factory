package fsst.htlklu.htl_factory.Objects;

public class Order {

    private int id;
    private String student;
    private String s_class;
    private String project;
    private String comment;
    private Category category;

    public Order(String student, String s_class, String project, String comment, Category category) {
        this.student = student;
        this.s_class = s_class;
        this.project = project;
        this.comment = comment;
        this.category = category;
    }
    public Order(int id, String student, String s_class, String project, String comment, Category category) {
        this.id = id;
        this.student = student;
        this.s_class = s_class;
        this.project = project;
        this.comment = comment;
        this.category = category;
    }

    public Order(int id){
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getStudent() {
        return student;
    }

    public String getS_class() {
        return s_class;
    }

    public String getProject() {
        return project;
    }

    public String getComment() {
        return comment;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
