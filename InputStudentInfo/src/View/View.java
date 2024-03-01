/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Student;
import java.util.ArrayList;
/**
 *
 * @author ROG
 */
public class View {
    StudentRepositoy program;
    ArrayList<Student> lt;

    public View() {
        program = new StudentRepositoy();
        lt = new ArrayList<>();
    }

    public void run() {
        System.out.println("\nCollection Sort Program");
        program.display(lt);
    }
}