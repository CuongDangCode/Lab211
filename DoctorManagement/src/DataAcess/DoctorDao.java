/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAcess;

import Common.Common;
import Common.Vadilation;
import Model.Doctor;
import java.util.ArrayList;
/**
 *
 * @author ROG
 */
public class DoctorDao {
    private static DoctorDao instance = null;
    Common c;
    Vadilation val;

    ArrayList<Doctor> list;

    public DoctorDao() {
        c = new Common();
        val = new Vadilation();

        list = new ArrayList<>();
    }

    public static DoctorDao Instance() {
        if (instance == null) {
            synchronized (DoctorDao.class) {
                if (instance == null) {
                    instance = new DoctorDao();
                }
            }
        }
        return instance;
    }

    public void addDoctor(ArrayList<Doctor> ld) {
        System.out.println("\nAdd Doctor");        
        String code = c.inputString("Enter code: ");
        if (!val.checkCodeExist(ld, code)) {
        System.out.println("Code exist...");
        code = c.inputString("Enter code again: ");
    }
        String name = c.inputString("Enter name: ");
        String specialization = c.inputString("Enter specialization: ");
        int availability = c.getIntNoLimit("Enter availability");

        if (!val.checkDuplicate(ld, name, specialization, availability)) {
            System.out.println("Duplicate.");
            return;
        }
        ld.add(new Doctor(code, name, specialization, availability));
        System.out.println("Add successful!!!");
    }
    
    public void updateDoctor(ArrayList<Doctor> ld) {
        System.out.println("\nUpdate Doctor");
        if (ld.isEmpty()) {
            System.out.println("There are no doctor in the list!!!");
            return;
        }
        String code = c.inputString("Enter code: ");
        if (val.checkCodeExist(ld, code)) {
            System.out.println("Cann't found doctor!!!");
            code = c.inputString("Enter code again: ");
        }
        String codeUpdate = c.inputString("Enter update code: ");
        Doctor doctor = getDoctorByCode(ld, code);
        String name = c.inputString("Enter update name: ");
        String specialization = c.inputString("Enter update specialization: ");
        int availability = c.getIntNoLimit("Enter availability: ");
        
        if (!val.checkDuplicate(ld, name, specialization, availability)) {
            System.out.println("Duplicate doctor information!!!");
            return;
        }
        doctor.setCode(codeUpdate);
        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setAvailability(availability);
        System.out.println("Update successful!!!");
    }
    

    public void deleteDoctor(ArrayList<Doctor> ld) {
        System.out.println("\nDelete Doctor");
        if (ld.isEmpty()) {
            System.out.println("There are no doctor in the list!!!");
            return;
        }
        String code = c.inputString("Enter code: ");
        if (val.checkCodeExist(ld, code)) {
            System.out.println("Not found doctor");
            return;
        }
        Doctor doctor = getDoctorByCode(ld, code);
        if (doctor == null) {
            System.out.println("Cann't found doctor!!!");
            return;
        } else {
            ld.remove(doctor);
        }
        System.out.println("Delete successful!!!");
    }

    public void searchDoctor(ArrayList<Doctor> ld) {
        System.out.println("\nSearch Doctor");
        if (ld.isEmpty()) {
            System.out.println("There are no doctor in the list!!!");
            return;
        }
        String searchString = c.inputString("Enter text: ");
        ArrayList<Doctor> listFoundByString = getListDoctorByString(ld, searchString);
        if (listFoundByString.isEmpty()) {
            System.out.println("Cann't found any result!!!");
        } else {
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");
            for (Doctor doctor : listFoundByString) {
                System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(),
                        doctor.getName(), doctor.getSpecialization(),
                        doctor.getAvailability());
            }
        }
    }

    public Doctor getDoctorByCode(ArrayList<Doctor> ld, String code) {
        for (Doctor doctor : ld) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }

    public ArrayList<Doctor> getListDoctorByString(ArrayList<Doctor> ld, String searchString) {
        ArrayList<Doctor> list = new ArrayList<>();
        for (Doctor doctor : ld) {
            if (doctor.getCode().contains(searchString) || doctor.getName().contains(searchString) || doctor.getSpecialization().contains(searchString)) {
                list.add(doctor);
            }
        }
        return list;
    }
}
