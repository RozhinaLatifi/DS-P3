public class Book {
    String name;
    String writer ="";

    Book(String name){
        this.name = name;
        this.writer = writer;
    }
    public boolean equals(Object obj) {
        if (obj instanceof String){
            return name.equals(obj);
        } else if (obj instanceof Book) {
            return name.equals(((Book)obj).name);
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return ("Book{" +
                "name=" + name + ",writer="+writer+
                '}');
    }
}
