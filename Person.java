
package library;


    public class Person {
    private String name;
    private String surname;
    private String email;
    private int id;

    
    public Person( int id,String name, String surname,String email){
        this.id=id;
        this.name=name;
        this.surname=surname;
        this.email=email;
    }
    
   
    
    
    public String getName(){
        return this.name;
    }
    public void SetName(String name){
        this.name=name;
    }
    public String getSurname(){
        return this.surname;
    }
    public void setSurname(String surname){
        this.surname=surname;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }
    
    
}
