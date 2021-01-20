/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author Alpgiray ACAR
 */
public class Book {
    private String Id;
    private String Name;
    private String Writer;

    public Book(String id, String Name, String Writer) {
        this.Id = Id;
        this.Name = Name;
        this.Writer = Writer;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getWriter() {
        return Writer;
    }

    public void setWriter(String Writer) {
        this.Writer = Writer;
    }
    
}